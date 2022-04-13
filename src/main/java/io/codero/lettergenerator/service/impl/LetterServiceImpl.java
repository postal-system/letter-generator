package io.codero.lettergenerator.service.impl;

import io.codero.lettergenerator.model.Letter;
import io.codero.lettergenerator.service.LetterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {
    @Override
    public void send(Letter letter) {
        log.info("#### <- {}", letter);
    }
}
