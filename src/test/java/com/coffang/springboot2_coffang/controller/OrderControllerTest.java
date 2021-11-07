package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.domain.order.Order;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import com.coffang.springboot2_coffang.dto.OrderResponseDto;
import com.coffang.springboot2_coffang.dto.OrderSaveRequestDto;
import com.coffang.springboot2_coffang.dto.OrderUpdateRequestDto;
import com.coffang.springboot2_coffang.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(OrderController.class)
@WithMockUser
@MockBean(JpaMetamodelMappingContext.class)
public class OrderControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    OrderService orderService;

    @Test
    @DisplayName("유저 주문 조회 테스트")
    void findByUserIdTest() throws Exception {
        // given
        Long userId = 1L;
        User user = new User();
        user.setId(userId);

        Long orderId = 2L;

        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        LocalDateTime createdDate = LocalDateTime.now();
        Boolean isCompleted = true;

        List<OrderResponseDto> dtos = new ArrayList<OrderResponseDto>();
        OrderResponseDto orderResponseDto = new OrderResponseDto(orderId, user, orderItems, createdDate, isCompleted);
        dtos.add(orderResponseDto);

        given(orderService.findByUserId(userId)).willReturn(dtos);

        mvc.perform(get("/api/v1/orders/1"))
                .andExpect(status().isOk());

        // when
        List<OrderResponseDto> responseDto = orderService.findByUserId(userId);

        // then
        assertThat(responseDto.get(0).getId()).isEqualTo(orderId);
    }

    @Test
    @DisplayName("Order 생성 테스트")
    void Order_생성된다() throws Exception {
        // given
        Long userId = 1L;
        Long orderId = 2L;
        User user = new User();
        user.setId(userId);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        Boolean isCompleted = true;

        OrderSaveRequestDto orderSaveRequestDto = new OrderSaveRequestDto(user, orderItems, isCompleted);
        given(orderService.save(orderSaveRequestDto)).willReturn(orderId);

        Order order = new Order(user, orderItems, isCompleted);
        OrderResponseDto orderResponseDto = new OrderResponseDto(order);
        orderResponseDto.setId(orderId);
        List<OrderResponseDto> dtos = new ArrayList<OrderResponseDto>();
        dtos.add(orderResponseDto);
        given(orderService.findByUserId(userId)).willReturn(dtos);

        // when
        mvc.perform(post("/api/v1/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(orderSaveRequestDto)))
                .andExpect(status().isOk());
        List<OrderResponseDto> orderResponseDtos = orderService.findByUserId(userId);

        // then
        assertThat(orderResponseDtos.get(0).getId()).isEqualTo(orderId);
    }

    @Test
    @DisplayName("Order 업데이트 테스트")
    void Order_업데이트() throws Exception {
        // given
        Long userId = 1L;
        Long orderId = 2L;
        User user = new User();
        user.setId(userId);
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        Boolean isCompleted = true;

        OrderSaveRequestDto orderSaveRequestDto = new OrderSaveRequestDto(user, orderItems, isCompleted);
        given(orderService.save(orderSaveRequestDto)).willReturn(orderId);

        Long userUpdatedId = 3L;
        User userUpdated = new User();
        user.setId(userUpdatedId);
        List<OrderItem> orderItemsUpdated = new ArrayList<OrderItem>();
        Boolean isCompletedUpdated = false;

        Order orderUpdated = new Order(userUpdated, orderItemsUpdated, isCompletedUpdated);
        OrderResponseDto orderResponseDto = new OrderResponseDto(orderUpdated);
        orderResponseDto.setId(orderId);
        List<OrderResponseDto> dtos = new ArrayList<OrderResponseDto>();
        dtos.add(orderResponseDto);
        given(orderService.findByUserId(userId)).willReturn(dtos);

        OrderUpdateRequestDto orderUpdateRequestDto = new OrderUpdateRequestDto(userUpdated, orderItemsUpdated, isCompletedUpdated);

        // when
        mvc.perform(put("/api/v1/orders/" + orderId.toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(orderUpdateRequestDto)))
                .andExpect(status().isOk());
        List<OrderResponseDto> orderResponseDtos = orderService.findByUserId(userId);

        // then
        assertThat(orderResponseDtos.get(0).getId()).isEqualTo(orderId);
    }
}