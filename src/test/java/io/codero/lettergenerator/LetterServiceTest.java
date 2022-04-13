package io.codero.lettergenerator;

import io.codero.lettergenerator.config.ConsumerConfigTest;
import io.codero.lettergenerator.initializer.KafkaContainers;
import io.codero.lettergenerator.model.Letter;
import io.codero.lettergenerator.service.impl.LetterServiceImpl;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.kafka.test.utils.KafkaTestUtils;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;
import java.util.Collections;

@SpringBootTest
@ActiveProfiles("test")
@Import(ConsumerConfigTest.class)
@ContextConfiguration(initializers = KafkaContainers.Initializer.class)
class LetterServiceTest {
    @Value("${spring.kafka.topic}")
    private String topic;

    @Autowired
    private LetterServiceImpl service;

    @Autowired
    private Consumer<String, Letter> consumer;

    @BeforeAll
    static void setUpKafkaContainer() {
        KafkaContainers.kafka.start();
    }

    @Test
    public void sendToKafkaLetterTest() {
        Letter letter = getLetter();
        service.send(letter);

        consumer.subscribe(Collections.singleton(topic));
        ConsumerRecord<String, Letter> record = KafkaTestUtils.getSingleRecord(consumer, topic);

        Assertions.assertEquals(letter, record.value());
        consumer.close();
    }

    private Letter getLetter() {
        return Letter.builder()
                .timestamp(Instant.now())
                .idReceiver(1000)
                .postOfficeId(1000)
                .content("testcontent")
                .sender("testsender")
                .build();
    }
}
