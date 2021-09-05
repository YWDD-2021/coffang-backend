package com.coffang.springboot2_coffang.domain.user;

import com.coffang.springboot2_coffang.domain.BaseTimeEntity;
import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.order.Order;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class User extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @OneToOne
    @JoinColumn(name="cart_id")
    private Cart cart;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @OneToMany
    @JoinColumn(name="order_id")
    private List<Order> orders;

    @Builder
    public User(String name,String email, Role role){
        this.name=name;
        this.email = email;
        this.cart = new Cart();
        this.cart.setUser(this);
        this.role = role;
    }

    public User update(String name){
        this.name=name;
        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
