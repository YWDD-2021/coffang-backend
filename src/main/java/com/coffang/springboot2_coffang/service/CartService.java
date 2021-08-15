package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.cart.CartRepository;
import com.coffang.springboot2_coffang.dto.CartResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CartService {
    public final CartRepository cartRepository;

    public CartResponseDto findByUserId(Long userId) {
        Cart entity = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. userId=" + userId));

        return new CartResponseDto(entity);
    }
}
