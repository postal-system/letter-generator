package io.codero.lettergenerator;

import io.codero.lettergenerator.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Profile("!test")
@RequiredArgsConstructor
public class LetterSenderScheduler {
    private final LetterGenerator letterGenerator;
    private final LetterService letterService;

    @Scheduled(fixedDelayString = "${spring.scheduler.fixed-delay}")
    public void post() {
        letterService.send(letterGenerator.generateLetter());
    }
}