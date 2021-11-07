package com.coffang.springboot2_coffang.domain.user;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.order.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany
    @JoinColumn(name="order_id")
    private List<Order> orders;

    public void setId(Long id) {
        this.id = id;
    }
}
