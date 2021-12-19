package com.coffang.springboot2_coffang.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderSaveRequestDto {
    private Long userId;

    private List<OrderItemSaveRequestDto> orderItemSaveRequestDtos;

    private Boolean isCompleted;

    @Builder
    public OrderSaveRequestDto(Long userId, List<OrderItemSaveRequestDto> orderItemSaveRequestDtos, Boolean isCompleted) {
        this.userId = userId;
        this.orderItemSaveRequestDtos = orderItemSaveRequestDtos;
        this.isCompleted = isCompleted;
    }
}