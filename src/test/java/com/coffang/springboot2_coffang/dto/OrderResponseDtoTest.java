package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import org.junit.jupiter.api.Test;
import org.springframework.security.test.context.support.WithMockUser;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderResponseDtoTest {
    @Test
    @WithMockUser(roles="USER")
    public void OrderResponseDto_테스트() {
        // given
        Long id = 1L;
        User user = new User();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();;
        LocalDateTime orderDateTime = LocalDateTime.now();;
        Boolean isCompleted = true;

        // when
        OrderResponseDto dto = new OrderResponseDto(id, user, orderItems, orderDateTime, isCompleted);

        // then
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getUser().getId()).isEqualTo(user.getId());
        assertThat(dto.getOrderItems()).isEqualTo(orderItems);
        assertThat(dto.getOrderDateTime()).isEqualTo(orderDateTime);
        assertThat(dto.getIsCompleted()).isEqualTo(isCompleted);
    }
}
