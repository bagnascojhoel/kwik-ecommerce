package br.com.kwikecommerce.api.domain.base;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
public abstract class AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "criado_em", insertable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "alterado_em", insertable = false, updatable = false)
    private LocalDateTime updatedAt;

}
