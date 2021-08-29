package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CartItemUpdateRequestDto {
    private Long cartPrice;
    private Long count;

    @Builder
    public CartItemUpdateRequestDto(Long cartPrice, Long count) {
        this.cartPrice = cartPrice;
        this.count = count;
    }
}
