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
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.math.BigDecimal;


@Builder
@Entity
@Getter
@AllArgsConstructor
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
    @Column(name = "descricao")
    private String description;

}
