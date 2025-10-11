package it.pixel.handbook.service.impl;

import it.pixel.handbook.model.entity.Utente;
import it.pixel.handbook.repository.UtenteRepository;
import it.pixel.handbook.service.UtenteService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtenteServiceImpl implements UtenteService {
    private final UtenteRepository utenteRepository;

    @Override
    public void salvaUtente(OidcUser user) {
        Utente utente = utenteRepository.findBySub(user.getSubject()).orElse(new Utente());
        utente.setSub(user.getUserInfo().getSubject());
        utenteRepository.save(utente);
    }
}
