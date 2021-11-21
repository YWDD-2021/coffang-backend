package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.dto.OrderItemResponseDto;
import com.coffang.springboot2_coffang.service.OrderItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping("/api/v1/orderItems/{orderItemId}")
    public OrderItemResponseDto findByOrderItemId(@PathVariable Long orderItemId) {
        return orderItemService.findByOrderItemId(orderItemId);
    }
}