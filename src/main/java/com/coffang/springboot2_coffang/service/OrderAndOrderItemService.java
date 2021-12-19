package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.order.Order;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import com.coffang.springboot2_coffang.domain.user.UserRepository;
import com.coffang.springboot2_coffang.dto.OrderItemSaveRequestDto;
import com.coffang.springboot2_coffang.dto.OrderResponseDto;
import com.coffang.springboot2_coffang.dto.OrderSaveRequestDto;
import com.coffang.springboot2_coffang.dto.OrderUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class OrderAndOrderItemService {
    private final OrderService orderService;
    private final OrderItemService orderItemService;
    private final UserRepository userRepository;

    @Transactional
    public Long save(OrderSaveRequestDto orderSaveRequestDto) {
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        for (OrderItemSaveRequestDto orderItemSaveRequestDto : orderSaveRequestDto.getOrderItemSaveRequestDtos()) {
            Long orderItemId = orderItemService.save(orderItemSaveRequestDto);
            orderItems.add(orderItemService.findByOrderItemId(orderItemId));
        }
        Long userId = orderSaveRequestDto.getUserId();
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 User가 없습니다. userId=" + userId));
        Boolean isCompleted = orderSaveRequestDto.getIsCompleted();

        return orderService.save(Order.builder()
                .user(user)
                .orderItems(orderItems)
                .isCompleted(isCompleted)
                .build()
        );
    }
}
