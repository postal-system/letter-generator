package io.codero.lettergenerator;

import io.codero.lettergenerator.model.Letter;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Component
public class LetterGenerator {
    private final List<String> senders = List.of(
            "Пушкин Александр Сергеевич",
            "Лермонтов Михаил Юрьевич",
            "Толстой Лев Николаевич",
            "Достоевский Федор михайлович",
            "Гоголь Николай Васильевич",
            "Тургенев Иван Сергеевич",
            "Блок Александр Александрович",
            "Маяковский Владимир Владимирович",
            "Цветаева Марина Ивановна",
            "Пастернак Борис Леонидович"
    );

    public Letter generateLetter() {
        return Letter.builder()
                .id(UUID.randomUUID())
                .timestamp(Instant.now())
                .idReceiver(2) /* this value  equals userId from ESK- system  User service */
                .postOfficeId((int) ((Math.random() * (10 - 1)) + 1))
                .content(RandomStringUtils.randomAlphabetic(10))
                .sender(senders.get((int) (Math.random() * senders.size())))
                .build();
    }
}