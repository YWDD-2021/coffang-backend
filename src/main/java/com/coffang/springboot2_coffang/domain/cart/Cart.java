package com.coffang.springboot2_coffang.domain.cart;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.user.User;
<<<<<<< HEAD
import lombok.*;
import net.minidev.json.annotate.JsonIgnore;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "cart", cascade = CascadeType.ALL)
    private User user;

    @Fetch(FetchMode.JOIN)
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="cartitem_id")
    private List<CartItem> cartItems;

    @Builder
    public Cart(User user, List<CartItem> cartItems) {
        this.user = user;
        this.cartItems = cartItems;
    }

    public void update(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }
}
