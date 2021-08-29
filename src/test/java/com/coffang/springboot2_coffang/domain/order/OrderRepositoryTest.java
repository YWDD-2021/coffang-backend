package com.coffang.springboot2_coffang.domain.order;

import com.coffang.springboot2_coffang.domain.user.User;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @AfterEach
    public void cleanup() {
        orderRepository.deleteAll();
    }

    @Test
    public void Order저장_불러오기() {
        User user = new User();

        OrderItem orderItem = new OrderItem();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);

        LocalDateTime orderDateTime = LocalDateTime.now();
        OrderStatus orderStatus = OrderStatus.COMPLETE;

        orderRepository.save(
                Order.builder()
                    .user(user)
                    .orderItems(orderItems)
                    .orderDateTime(orderDateTime)
                    .orderStatus(orderStatus)
                    .build()
        );

        // when
        List<Order> orderList = orderRepository.findAll();

        // then
        Order order = orderList.get(0);
        assertThat(order.getUser().getId()).isEqualTo(user.getId());
        assertThat(order.getOrderStatus()).isEqualTo(orderStatus);
    }
}
