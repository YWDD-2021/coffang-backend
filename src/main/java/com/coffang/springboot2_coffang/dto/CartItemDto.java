package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.item.Item;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.GenerationType;

@Getter
public class CartItemDto {
    private Long id;

    private Item item;

    private Long cartPrice;

    private Long count;

    public CartItemDto(CartItem entity) {
        this.id = entity.getId();
        this.item = entity.getItem();
        this.cartPrice = entity.getCartPrice();
        this.count = entity.getCount();
    }

    public CartItem toEntity() {
        return CartItem.builder().build();
    }
}
