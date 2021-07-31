package com.coffang.springboot2_coffang.domain.cart;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(mappedBy = "user")
//    private User user;

    @OneToMany
    @JoinColumn(name="cartitem_id")
    private List<CartItem> cartItems;
}
