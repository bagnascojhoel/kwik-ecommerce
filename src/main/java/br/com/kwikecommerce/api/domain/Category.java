package br.com.kwikecommerce.api.domain;

import br.com.kwikecommerce.api.domain.general.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Builder
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categoria")
public class Category extends AbstractEntity {

    @Length(max = 30)
    @Column(name = "nome")
    private String name;

}
