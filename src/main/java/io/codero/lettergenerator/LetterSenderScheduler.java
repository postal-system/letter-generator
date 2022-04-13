package io.codero.lettergenerator;

import io.codero.lettergenerator.service.LetterService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LetterSenderScheduler {
    private final LetterGenerator letterGenerator;
    private final LetterService letterService;

    @Scheduled(fixedDelay = 1_000)
    public void post() {
        letterService.send(letterGenerator.generateLetter());
    }
}