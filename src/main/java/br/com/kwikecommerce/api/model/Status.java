package br.com.kwikecommerce.api.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "status")
public class Status extends AbstractCompanyEntity {

    @NotEmpty
    @Size(max = 50)
    @Column(name = "titulo")
    private String title;

    @NotNull
    @Column(name = "esta_ativo")
    private Boolean isActive;

    @ManyToMany(mappedBy = "statusHistory", fetch = FetchType.LAZY)
    private List<Order> orders;

}
