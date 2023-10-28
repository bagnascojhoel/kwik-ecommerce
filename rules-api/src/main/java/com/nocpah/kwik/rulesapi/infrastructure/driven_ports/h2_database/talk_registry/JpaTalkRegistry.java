package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.talk_registry;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "talk_registry")
public class JpaTalkRegistry {
    @Id
    @Column(name = "talk_registry_code")
    private String code;
    private String sayerName;
    private String sayerSpeech;
    private String worldName;
    private String worldResponse;
    private LocalDateTime talkedAt;
}
