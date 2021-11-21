package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItemRepository;
import com.coffang.springboot2_coffang.dto.OrderItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public OrderItemResponseDto findByOrderItemId(Long orderItemId) {
        OrderItem entity = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 OrderItem이 없습니다. id=" + orderItemId));
        return new OrderItemResponseDto(entity);
    }
}