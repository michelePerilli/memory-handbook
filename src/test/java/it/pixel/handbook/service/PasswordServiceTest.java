package it.pixel.handbook.service;

import com.google.common.io.Resources;
import com.google.gson.Gson;
import io.micrometer.core.instrument.util.IOUtils;
import it.pixel.handbook.model.dto.password.PasswordDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

/**
 * Project: memory-handbook
 * Author: Michele
 * File: PasswordServiceTest
 * Creation: 26/03/2022
 */
class PasswordServiceTest {

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
    }

    /**
     * Ricerca password.
     *
     * @throws IOException the io exception
     */
    @Test
    void ricercaPassword() throws IOException {
        String json = IOUtils.toString(
                Resources.getResource("json/password.json").openStream(),
                StandardCharsets.UTF_8);
        System.out.println(json);


        PasswordDto passwordDto = new Gson().fromJson(json, PasswordDto.class);

        System.out.println(passwordDto);

        assertThat(10).isEqualTo(10);
    }

    /**
     * Inserisci password.
     */
    @Test
    void inserisciPassword() {
    }

    /**
     * Lista password.
     */
    @Test
    void listaPassword() {
    }
}