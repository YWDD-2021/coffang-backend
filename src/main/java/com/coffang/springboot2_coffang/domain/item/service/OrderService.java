package com.coffang.springboot2_coffang.domain.item.service;

import com.coffang.springboot2_coffang.domain.order.Order;
import com.coffang.springboot2_coffang.domain.order.OrderRepository;
import com.coffang.springboot2_coffang.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Transactional
    public List<OrderResponseDto> findByUserId(Long userId) {
        List<Order> entities = orderRepository.findByUserId(userId);
        if (entities.isEmpty()) {
            throw new IllegalArgumentException("해당 Order가 없습니다. userId=" + userId);
        }
        return entities.stream().map(OrderResponseDto::new).collect(Collectors.toList());
    }
}
