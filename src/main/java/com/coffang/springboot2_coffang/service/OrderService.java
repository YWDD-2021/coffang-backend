package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.order.Order;
import com.coffang.springboot2_coffang.domain.order.OrderRepository;
import com.coffang.springboot2_coffang.dto.OrderResponseDto;
import com.coffang.springboot2_coffang.dto.OrderSaveRequestDto;
import com.coffang.springboot2_coffang.dto.OrderUpdateRequestDto;
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

    @Transactional
    public Long save(OrderSaveRequestDto requestDto) {
        return orderRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, OrderUpdateRequestDto requestDto) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 Order가 없습니다. id=" + id));

        order.update(requestDto.getUser(), requestDto.getOrderItems(), requestDto.getIsCompleted());
        return id;
    }

    @Transactional
    public OrderResponseDto findByOrderId(Long orderId) {
        Order entity = orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("해당 Order가 없습니다. id=" + orderId));
        return new OrderResponseDto(entity);
    }
}