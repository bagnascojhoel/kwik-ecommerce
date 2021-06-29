package br.com.kwikecommerce.api.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;
import java.util.List;


@SuperBuilder
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "produto")
public final class Product extends AbstractEntity {

    @Length(min = 3, max = 100)
    @Column(name = "titulo")
    private String title;

    @Min(0)
    @Max(99999)
    @Column(name = "preco_unitario", precision = 2)
    private BigDecimal unitaryPrice;

    @Max(65535)
    @Column(name = "qtd_disponivel")
    private Integer availableQty;

    @Length(min = 3)
    @Column(name = "detalhes")
    private String details;

    @ManyToMany
    @JoinTable(
        name = "categoria_produto",
        joinColumns = @JoinColumn(name = "produto_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Category> categories;

    @ElementCollection
    @CollectionTable(name = "produto_imagem", joinColumns = @JoinColumn(name = "produto_id"))
    @Column(name = "url")
    private List<String> imagesUrls;

    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Company company;

}
