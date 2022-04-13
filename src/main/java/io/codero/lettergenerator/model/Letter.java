package io.codero.lettergenerator.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Letter {
    private UUID id;
    private Instant timestamp;
    private Integer idReceiver;
    private Integer postOfficeId;
    private String content;
    private String sender;
}