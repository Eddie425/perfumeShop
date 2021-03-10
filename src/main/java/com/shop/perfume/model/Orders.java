package com.shop.perfume.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders {

    @Id
    private Integer orderID;

    private String memberID;

    private String productID;

    private LocalDateTime orderDate;

    private LocalDateTime shipDate;

    private Integer quantity;

    private Integer amount;

    private Boolean paid;

    private Integer orderStatus;

}
