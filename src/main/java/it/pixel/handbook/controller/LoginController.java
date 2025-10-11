package it.pixel.handbook.controller;

import it.pixel.handbook.service.UtenteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class LoginController {

    private final UtenteService utenteService;

    @GetMapping("/welcome")
    public void welcome(@AuthenticationPrincipal OidcUser user) {
        utenteService.salvaUtente(user);
    }
}
