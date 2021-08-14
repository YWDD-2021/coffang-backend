package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.cartitem.CartItemRepository;
import com.coffang.springboot2_coffang.dto.CartItemResponseDto;
import com.coffang.springboot2_coffang.dto.CartItemSaveRequestDto;
import com.coffang.springboot2_coffang.dto.CartItemUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Transactional
    public Long save(CartItemSaveRequestDto requestDto) {
        return cartItemRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CartItemUpdateRequestDto requestDto) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. id="+ id));

        cartItem.update(requestDto.getCartPrice(), requestDto.getCount());

        return id;
    }

    public CartItemResponseDto findById(Long id) {
        CartItem entity = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. id=" + id));

        return new CartItemResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. id=" + id));
        cartItemRepository.delete(cartItem);
    }
}
