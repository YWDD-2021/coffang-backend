package com.coffang.springboot2_coffang.domain.orderitem;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    List<OrderItem> findByOrderItemId(Long orderId);
}
