package br.com.kwikecommerce.api.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "pedido")
public class Order extends AbstractCompanyEntity {

    @NotEmpty
    @Size(max = 100)
    @Column(name = "cliente_nome")
    private String customerName;

    @NotEmpty
    @Size(max = 255)
    @Column(name = "cliente_endereco")
    private String customerAddress;

    @Size(max = 14)
    @Column(name = "cliente_numero_telefone")
    private String customerPhoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "forma_pagamento")
    private PaymentMethod paymentMethod;

    @DecimalMax(value = "9999999.99")
    @Column(name = "preco_total")
    private BigDecimal totalPrice;

    @DecimalMax(value = "9999.99")
    @Column(name = "preco_frete")
    private BigDecimal freightPrice;

    @OrderBy("createdAt DESC")
    @OneToMany(mappedBy = "order")
    private List<OrderStatus> statusHistory;

}
