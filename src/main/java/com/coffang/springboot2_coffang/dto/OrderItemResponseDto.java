package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Item;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
@Setter
public class OrderItemResponseDto {
    private Long id;
    private Item item;
    private Long orderPrice;
    private Long count;

    public OrderItemResponseDto(OrderItem entity) {
        this.id = entity.getId();
        this.item = entity.getItem();
        this.orderPrice = entity.getOrderPrice();
        this.count = entity.getCount();
    }
}