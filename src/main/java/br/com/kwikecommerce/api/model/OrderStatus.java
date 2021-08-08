package br.com.kwikecommerce.api.model;

import br.com.kwikecommerce.api.converter.OrderStatusTypeConverter;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "pedido_status")
public class OrderStatus extends AbstractEntity {

    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Order order;

    @Convert(converter = OrderStatusTypeConverter.class)
    @Column(name = "status")
    private OrderStatusType orderStatusType;

    @Size(max = 50)
    @Column(name = "motivo")
    private String reason;

}
