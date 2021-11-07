package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItemRepository;
import com.coffang.springboot2_coffang.dto.OrderItemResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public List<OrderItemResponseDto> findByOrderItemId(Long orderItemId) {
        List<OrderItem> entities = orderItemRepository.findByOrderItemId(orderItemId);
        if (entities.isEmpty()) {
            throw new IllegalArgumentException("해당 OrderItem이 없습니다. orderItemId=" + orderItemId);
        }
        return entities.stream().map(OrderItemResponseDto::new).collect(Collectors.toList());
    }
}
