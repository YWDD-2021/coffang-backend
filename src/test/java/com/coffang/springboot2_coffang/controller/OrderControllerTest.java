package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import com.coffang.springboot2_coffang.dto.OrderResponseDto;
import com.coffang.springboot2_coffang.service.OrderService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(OrderController.class)
@WithMockUser
public class OrderControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    OrderService orderService;

    @Test
    @DisplayName("유저 주문 조회 테스트")
    void findByUserIdTest() throws Exception {
        // given
        Long userId = Long.valueOf(1);
        User user = new User();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();;
        LocalDateTime orderDateTime = LocalDateTime.now();;
        Boolean isCompleted = true;

        List<OrderResponseDto> dtos = new ArrayList<OrderResponseDto>();
        OrderResponseDto orderResponseDto = new OrderResponseDto(userId, user, orderItems, orderDateTime, isCompleted);
        dtos.add(orderResponseDto);

        given(orderService.findByUserId(userId)).willReturn(dtos);

        mvc.perform(get("/api/v1/orders/1"))
                .andExpect(status().isOk());

        List<OrderResponseDto> responseDto = orderService.findByUserId(userId);
        assertThat(responseDto.get(0).getId()).isEqualTo(userId);

    }
}
