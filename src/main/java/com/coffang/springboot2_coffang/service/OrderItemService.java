package com.coffang.springboot2_coffang.service;

import com.coffang.springboot2_coffang.domain.item.Item;
import com.coffang.springboot2_coffang.domain.item.ItemRepository;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItemRepository;
import com.coffang.springboot2_coffang.dto.OrderItemResponseDto;
import com.coffang.springboot2_coffang.dto.OrderItemSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class OrderItemService {
    private final OrderItemRepository orderItemRepository;
    private final ItemRepository itemRepository;

    @Transactional
    public OrderItem findByOrderItemId(Long orderItemId) {
        OrderItem entity = orderItemRepository.findById(orderItemId)
                .orElseThrow(() -> new IllegalArgumentException("해당 OrderItem이 없습니다. id=" + orderItemId));
        return entity;
    }

    @Transactional
    public Long save(OrderItemSaveRequestDto orderItemSaveRequestDto) {
        Long itemId = orderItemSaveRequestDto.getItemId();
        Item item = itemRepository.findById(itemId).orElseThrow(() -> new IllegalArgumentException("해당 item이 없습니다. itemId="+itemId));
        Long orderPrice = orderItemSaveRequestDto.getOrderPrice();
        Long count = orderItemSaveRequestDto.getCount();

        return orderItemRepository.save(OrderItem.builder()
                .item(item)
                .orderPrice(orderPrice)
                .count(count)
                .build()).getId();
    }
}