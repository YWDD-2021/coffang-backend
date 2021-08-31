package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.order.Order;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor
public class OrderResponseDto {
    private Long id;
    private User user;
    private List<OrderItem> orderItems;
    private LocalDateTime orderDateTime;
    private Boolean isCompleted;

    public OrderResponseDto(Order entity) {
        this.id = entity.getId();
        this.user = entity.getUser();
        this.orderItems = entity.getOrderItems();
        this.orderDateTime = entity.getOrderDateTime();
        this.isCompleted = entity.getIsCompleted();
    }
}
