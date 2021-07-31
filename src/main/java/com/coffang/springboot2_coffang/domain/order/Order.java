package com.coffang.springboot2_coffang.domain.order;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

enum OrderStatus { COMPLETE, CANCELED }

@Getter
@NoArgsConstructor
@Entity
@Table(name="ORDER_TABLE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "order")
    private User user;

    @OneToMany
    @JoinColumn(name="orderitem_id")
    private List<OrderItem> orderItems;

    private LocalDateTime orderDateTime;

    private OrderStatus orderStatus;
}
