package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.dto.OrderResponseDto;

import com.coffang.springboot2_coffang.dto.OrderSaveRequestDto;
import com.coffang.springboot2_coffang.dto.OrderUpdateRequestDto;
import com.coffang.springboot2_coffang.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/api/v1/orders")
    public Long save(@RequestBody OrderSaveRequestDto requestDto) {
        return orderService.save(requestDto);
    }

    @PutMapping("/api/v1/orders/{id}")
    public Long update(@PathVariable Long id, @RequestBody OrderUpdateRequestDto requestDto) {
        return orderService.update(id, requestDto);
    }

    @GetMapping("/api/v1/orders/{userId}")
    public List<OrderResponseDto> findByUserId(@PathVariable Long userId) {
        return orderService.findByUserId(userId);
    }

    @GetMapping("/api/v1/orders/{orderId}")
    public OrderResponseDto findByOrderId(@PathVariable Long orderId) {
        return orderService.findByOrderId(orderId);
    }
}