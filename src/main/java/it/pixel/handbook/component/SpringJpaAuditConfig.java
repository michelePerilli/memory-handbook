package it.pixel.handbook.component;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing
public class SpringJpaAuditConfig {

    @Bean
    public AuditorAware<String> auditor() {
        return () -> {

            // 1. Recupera il contesto di sicurezza (utenti loggati)
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            // 2. Se l'autenticazione è nulla o l'utente è anonimo, restituisce Optional.empty()
            if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
                return Optional.of("SYSTEM"); // Utente di default o 'SYSTEM'
            }

            // 3. Restituisce il nome utente (o l'ID, a seconda di come è configurato Principal)
            return Optional.of(authentication.getName());

        };
    }


}