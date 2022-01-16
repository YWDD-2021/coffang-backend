package com.coffang.springboot2_coffang.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class OrderItemSaveRequestDto {
    private Long itemId;

    private Long orderPrice;

    private Long count;
}
