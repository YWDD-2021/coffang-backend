package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.cartitem.CartItemRepository;
import com.coffang.springboot2_coffang.dto.CartItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CartItemService {
    private final CartItemRepository cartItemRepository;

    @Transactional
    public Long save(CartItemDto cartItemDto) {
        return cartItemRepository.save(cartItemDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, CartItemDto cartItemDto) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. id="+ id));

        cartItem.update(cartItemDto.getCartPrice(), cartItemDto.getCount());

        return id;
    }

    public CartItemDto findById(Long id) {
        CartItem entity = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. id=" + id));

        return new CartItemDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        CartItem cartItem = cartItemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Cart가 없습니다. id=" + id));
        cartItemRepository.delete(cartItem);
    }
}
