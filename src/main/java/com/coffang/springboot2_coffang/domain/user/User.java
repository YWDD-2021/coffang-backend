package com.coffang.springboot2_coffang.domain.user;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    private String email;

    @OneToOne
    @JoinColumn(name="order_id")
    private Order order;
}
