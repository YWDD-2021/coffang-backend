package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.dto.OrderResponseDto;
import com.coffang.springboot2_coffang.domain.item.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/api/v1/orders/{userId}")
    public List<OrderResponseDto> findByUserId(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }
}
