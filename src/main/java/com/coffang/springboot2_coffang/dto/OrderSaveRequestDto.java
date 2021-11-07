package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.order.Order;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDto {
    private User user;

    private List<OrderItem> orderItems;

    private Boolean isCompleted;

    @Builder
    public OrderSaveRequestDto(User user, List<OrderItem> orderItems, Boolean isCompleted) {
        this.user = user;
        this.orderItems = orderItems;
        this.isCompleted = isCompleted;
    }

    public Order toEntity() {
        return Order.builder()
                .user(user)
                .orderItems(orderItems)
                .isCompleted(isCompleted)
                .build();
    }
}
