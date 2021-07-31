package com.coffang.springboot2_coffang.domain.orderitem;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="item_id")
//    private Item item;

    private Long orderPrice;

    private Long count;
}
