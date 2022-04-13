package io.codero.lettergenerator.service.impl;

import io.codero.lettergenerator.model.Letter;
import io.codero.lettergenerator.service.LetterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class LetterServiceImpl implements LetterService {
    private final KafkaTemplate<String, Letter> template;

    @Value("${spring.kafka.topic}")
    private String topic;

    @Override
    public void send(Letter letter) {
        template.send(topic, letter);
        log.info(topic + ":#### <- {}",letter);
    }
}
