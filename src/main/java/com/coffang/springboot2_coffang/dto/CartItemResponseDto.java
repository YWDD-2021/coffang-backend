package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.GenerationType;

@Getter
@Setter
public class CartItemResponseDto {
    private Long id;
    private Item item;
    private Long cartPrice;
    private Long count;

    public CartItemResponseDto(CartItem entity) {
        this.id = entity.getId();
        this.item = entity.getItem();
        this.cartPrice = entity.getCartPrice();
        this.count = entity.getCount();
    }
}
