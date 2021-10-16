package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Getter;

import java.util.List;

@Getter
public class CartResponseDto {
    private Long id;
    private User user;
    private List<CartItem> cartItems;

    public CartResponseDto(Cart entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.cartItems = entity.getCartItems();
    }
}
