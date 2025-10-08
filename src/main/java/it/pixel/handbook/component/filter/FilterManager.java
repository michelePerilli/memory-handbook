package it.pixel.handbook.component.filter;


import io.github.classgraph.ClassGraph;
import io.github.classgraph.ScanResult;
import it.pixel.handbook.component.filter.annotation.OnlyNotDeleted;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

@Slf4j
@Component
@RequiredArgsConstructor
public class FilterManager { // package-private class

    public enum Status {ENABLED, DISABLED}

    public static final String FIELD_FLAG_ELIMINATO = "FLAG_ELIMINATO";
    public static final Boolean FIELD_FLAG_ELIMINATO_VALUE = false;

    @Getter
    private Status filtersStatus = Status.DISABLED;

    public void disableFilter() {
        filtersStatus = Status.DISABLED;
    }

    public void enableFilter() {
        filtersStatus = Status.ENABLED;
    }

    private Map<String, Boolean> filterableEntity;

    @PostConstruct
    public void init() {
        filterableEntity = fetchForFilterableEntities();
    }

    public Map<String, Boolean> getFilterableEntity() {
        return new HashMap<>(filterableEntity);
    }

    private Map<String, Boolean> fetchForFilterableEntities() {

        BinaryOperator<Boolean> whatIfDuplicatedEntityNameFound = (table1, table2) -> {
            log.warn("duplicate table found");
            return table1;
        };

        try (ScanResult scanResult = new ClassGraph()
                .enableClassInfo()
                .enableAnnotationInfo()
                .scan()) {

            return scanResult.getClassesWithAnnotation(Table.class.getName())
                    .loadClasses()
                    .stream()
                    .collect(Collectors.toMap(
                            FilterManager::getTableName,
                            FilterManager::checkIfFilterable,
                            whatIfDuplicatedEntityNameFound
                    ));
        } catch (Exception e) {
            throw new RuntimeException("Errore durante la scansione del classpath", e);
        }

    }

    private static String getTableName(Class<?> entity) {
        return entity.getAnnotation(Table.class).name().toUpperCase();
    }

    private static Boolean checkIfFilterable(Class<?> entity) {

        boolean hasCorrectAnnotation = entity.isAnnotationPresent(OnlyNotDeleted.class);

        boolean hasCorrectColumn = Arrays.stream(entity.getDeclaredFields())
                .filter(x -> x.isAnnotationPresent(Column.class))
                .anyMatch(x -> Objects.equals(x.getAnnotation(Column.class).name().toUpperCase(), FIELD_FLAG_ELIMINATO));

        return hasCorrectAnnotation && hasCorrectColumn;
    }


}
