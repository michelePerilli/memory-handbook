package it.pixel.handbook.service;

import org.springframework.security.oauth2.core.oidc.user.OidcUser;

public interface UtenteService {
    void salvaUtente(OidcUser user);
}
