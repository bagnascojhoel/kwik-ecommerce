package br.com.kwikecommerce.api.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@SuperBuilder
@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "categoria")
public class Category extends AbstractEntity {

    @Size(max = 30)
    @Column(name = "titulo")
    private String title;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

}
