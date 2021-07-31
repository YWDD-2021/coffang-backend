package com.coffang.springboot2_coffang.domain.order;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

enum OrderStatus { COMPLETE, CANCELED }

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "user")
//    private User user;

    @OneToMany
    @JoinColumn(name="orderitem_id")
    private List<OrderItem> orderItems;

    private LocalDateTime orderDateTime;

    private OrderStatus orderStatus;
}
