package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.dto.CartResponseDto;
import com.coffang.springboot2_coffang.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class CartController {
    private final CartService cartService;

    @GetMapping("/api/v1/carts/{userId}")
    public CartResponseDto findByUserId(@PathVariable Long userId) {
        return cartService.findByUserId(userId);
    }

}
