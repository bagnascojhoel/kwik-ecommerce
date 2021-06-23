package br.com.kwikecommerce.api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.List;


@SuperBuilder
@Entity
@Getter
@NoArgsConstructor
@Table(name = "categoria")
public class Category extends AbstractEntity {

    @Length(max = 30)
    @Column(name = "titulo")
    private String title;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

    @ManyToMany(mappedBy = "categories")
    private List<Product> products;

}
