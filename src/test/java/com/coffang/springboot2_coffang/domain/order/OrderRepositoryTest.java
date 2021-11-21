package com.coffang.springboot2_coffang.domain.order;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

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
    public void Order_저장_불러오기() {
        // given
        User user = new User();
        OrderItem orderItem = new OrderItem();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
        Boolean isCompleted = true;

        orderRepository.save(
                Order.builder()
                        .user(user)
                        .orderItems(orderItems)
                        .isCompleted(isCompleted)
                        .build()
        );

        // when
        List<Order> orderList = orderRepository.findAll();
        Order order = orderList.get(0);

        // then
        assertThat(order.getUser().getId()).isEqualTo(user.getId());
        assertThat(order.getIsCompleted()).isEqualTo(isCompleted);
    }

    @Test
    public void Order_삭제() {
        // given
        User user = new User();
        OrderItem orderItem = new OrderItem();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        orderItems.add(orderItem);
        Boolean isCompleted = true;

        orderRepository.save(
                Order.builder()
                        .user(user)
                        .orderItems(orderItems)
                        .isCompleted(isCompleted)
                        .build()
        );

        // when
        List<Order> orderList = orderRepository.findAll();

        Order order = orderList.get(0);
        orderRepository.delete(order);

        // then
        List<Order> orderListAfterDelete = orderRepository.findAll();
        assertThat(orderListAfterDelete.size()).isEqualTo(0);
    }
}
