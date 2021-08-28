package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.item.Item;
import lombok.Builder;
import lombok.Getter;

@Getter
public class CartItemSaveRequestDto {

    private Item item;

    private Long cartPrice;

    private Long count;

    @Builder
    public CartItemSaveRequestDto(Item item, Long cartPrice, Long count) {
        this.item = item;
        this.cartPrice = cartPrice;
        this.count = count;
    }

    public CartItem toEntity() {
        return CartItem.builder()
                .item(item)
                .cartPrice(cartPrice)
                .count(count)
                .build();
    }
}
