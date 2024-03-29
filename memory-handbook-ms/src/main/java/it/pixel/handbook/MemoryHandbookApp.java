package it.pixel.handbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.TimeZone;

/**
 * The type Memory handbook app.
 */
@SpringBootApplication
@ComponentScan(value = {"it.pixel"})
public class MemoryHandbookApp {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
        SpringApplication.run(MemoryHandbookApp.class, args);
    }
}
