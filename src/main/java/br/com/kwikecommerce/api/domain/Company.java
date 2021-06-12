package br.com.kwikecommerce.api.domain;

import br.com.kwikecommerce.api.domain.base.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;


@SuperBuilder
@Entity
@Getter
@NoArgsConstructor
@Table(name = "empresa")
public class Company extends AbstractEntity {

    @Length(max = 50)
    @Column(name = "nome")
    private String name;

    @Length(max = 300)
    @Column(name = "endereco")
    private String address;

    @Length(max = 100)
    @Column(name = "email")
    private String email;

    @Length(max = 9)
    @Column(name = "telefone_whatsapp")
    private String whatsappPhone;

    @Column(name = "esta_ativo")
    private Boolean isActive;

    @OneToMany(mappedBy = "company")
    private List<Category> categories;

    @OneToMany(mappedBy = "company")
    private List<Product> products;

}
