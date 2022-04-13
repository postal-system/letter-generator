package io.codero.lettergenerator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class LetterGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(LetterGeneratorApplication.class, args);
    }
}
