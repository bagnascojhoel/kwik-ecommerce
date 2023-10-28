package com.nocpah.kwik.rulesapi.infrastructure.driven_ports.h2_database.menu_item;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

// TODO This should not be exposed to outside modules
@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "menu_item")
public class JpaMenuItem {
    @Id
    @Column(name = "menu_item_code")
    String code;
    String name;
    String description;
    BigDecimal price;
    String imageUrl;
    Boolean canBeSold;
}
