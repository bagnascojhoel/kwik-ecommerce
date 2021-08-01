package br.com.kwikecommerce.api.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;


@Entity
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Table(name = "pedido_status")
public class OrderStatus extends AbstractCompanyEntity {

    @ManyToMany(mappedBy = "statusHistory")
    private List<Order> order;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private OrderStatusType orderStatusType;

    @Size(max = 50)
    @Column(name = "motivo")
    private String reason;

}
