package br.com.kwikecommerce.api.domain;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Max;
import javax.validation.constraints.Size;
import java.math.BigDecimal;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "pedido_item")
public class OrderItem extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Order order;

    @Max(999999999)
    @Column(name = "quantidade")
    private Integer quantity;

    @DecimalMax("9999999.99")
    @Column(name = "preco_unitario_venda")
    private BigDecimal unitarySalePrice;

    @Size(max = 100)
    @Column(name = "descricao")
    private String description;

}
