package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import lombok.Getter;

@Getter
public class CartResponseDto {
    private Long id;

    public CartResponseDto(Cart entity) {
        this.id = entity.getId();
    }
}
