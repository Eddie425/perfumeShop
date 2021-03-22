package com.shop.perfume.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long orderId;

    private LocalDateTime orderDate;

    private LocalDateTime shipDate;

    private Integer quantity;

    private Integer amount;

    private Boolean paid;

    private Integer orderStatus;

    @ManyToOne
    @JoinColumn(name="memberId", nullable=false)
    private Member member;

    @ManyToOne
    @JoinColumn(name="productId", nullable=false)
    private Product product;

}
