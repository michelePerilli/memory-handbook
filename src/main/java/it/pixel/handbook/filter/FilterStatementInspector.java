package it.pixel.handbook.filter;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;
import org.hibernate.resource.jdbc.spi.StatementInspector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Component
@RequiredArgsConstructor
@ConditionalOnProperty(prefix = "it.pixel.spring", name = "enable_filter", havingValue = "true")
public class FilterStatementInspector implements StatementInspector {

    private static final Logger LOG = LoggerFactory.getLogger(FilterStatementInspector.class);
    private final FilterManager filterManager;

    @Override
    public String inspect(String sql) {
        LOG.debug("FilterStatementInspector inspect   [IN] -> {}", sql);
        try {
            sql = manageSQL(sql);
            LOG.debug("FilterStatementInspector inspect  [OUT] -> {}", sql);
        } catch (Exception e) {
            LOG.error("FilterStatementInspector -> Something gone wrong:", e);
        }
        return sql;
    }

    private String manageSQL(String sql) throws JSQLParserException {;
        if (filterManager.getFiltersStatus() == FilterManager.Status.ENABLED) {
            CCJSqlParserManager manager = new CCJSqlParserManager();
            Statement statement = manager.parse(new StringReader(sql.toUpperCase()));
            if (statement instanceof Select) {
                PlainSelect select = (PlainSelect) ((Select) statement).getSelectBody();
                sql = addConditions(select).toString();
            }
        }
        return sql;
    }

    private PlainSelect addConditions(PlainSelect select) {

        FromItem fromItem = select.getFromItem();
        if (fromItem instanceof SubSelect) {
            addConditions((PlainSelect) ((SubSelect) fromItem).getSelectBody());
        }
        String fromAlias = fromItem.getAlias() == null ? null : fromItem.getAlias().getName();
        List<String> aliases = new ArrayList<>();

        if (select.getJoins() != null) {
            for (Join join : select.getJoins()) {
                join.getOnExpressions().forEach(this::checkForSubSelect);
            }
            aliases = select.getJoins()
                    .stream()
                    .map(Join::getRightItem)
                    .filter(x -> filterManager.getFilterableEntity().get(((Table) x).getASTNode().jjtGetFirstToken().image))
                    .map(FromItem::getAlias)
                    .filter(Objects::nonNull)
                    .map(Alias::getName)
                    .collect(Collectors.toList());
        }
        Expression where = select.getWhere();

        if (where != null) {
            checkForSubSelect(where);
        }

        if (fromAlias != null && filterManager.getFilterableEntity().get(((Table) fromItem).getASTNode().jjtGetFirstToken().image)) {
            aliases.add(fromAlias);
        }

        for (String alias : aliases) {

            IsNullExpression checkIsNull = new IsNullExpression();
            checkIsNull.setLeftExpression(new Column(alias + "." + FilterManager.FIELD_FLAG_ELIMINATO));

            IsBooleanExpression rightExpression = new IsBooleanExpression();
            rightExpression.setLeftExpression(new Column(alias + "." + FilterManager.FIELD_FLAG_ELIMINATO));
            rightExpression.setIsTrue(FilterManager.FIELD_FLAG_ELIMINATO_VALUE);

            OrExpression condition = new OrExpression();
            condition.setLeftExpression(checkIsNull);
            condition.setRightExpression(rightExpression);

            Parenthesis container = new Parenthesis();
            container.setExpression(condition);

            if (where == null) {
                where = container;
            } else {
                where = new AndExpression(where, container);
            }
        }

        select.setWhere(where);

        return select;
    }

    private void checkForSubSelect(Expression expression) {
        if (expression == null) {
            return;
        }
        if (expression instanceof Parenthesis parenthesis) {
            expression = parenthesis.getExpression();
        }

        if (expression instanceof BinaryExpression binaryExpression) {
            Expression left = binaryExpression.getLeftExpression();
            Expression right = binaryExpression.getRightExpression();
            checkForSubSelect(left);
            checkForSubSelect(right);
        } else if (expression instanceof InExpression inExpression) {
            Expression left = inExpression.getLeftExpression();
            checkForSubSelect(left);
            ItemsList rightItemsList = inExpression.getRightItemsList();
            if (rightItemsList instanceof Expression rightExpression) {
                checkForSubSelect(rightExpression);
            } else if (rightItemsList instanceof ExpressionList expressionList) {
                for (Expression currentExpression : expressionList.getExpressions())
                    checkForSubSelect(currentExpression);
            } else {
                LOG.debug("unknown in-expression class type");
            }
        } else if (expression instanceof IsNullExpression isNullExpression) {
            Expression left = isNullExpression.getLeftExpression();
            checkForSubSelect(left);
        } else if (expression instanceof Function function) {
            List<Expression> left = function.getParameters().getExpressions();
            for (Expression param : left)
                checkForSubSelect(param);
        } else if (expression instanceof SubSelect) {
            addConditions((PlainSelect) ((SubSelect) expression).getSelectBody());
        }
    }


}
