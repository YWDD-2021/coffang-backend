package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.domain.item.Brewing;
import com.coffang.springboot2_coffang.domain.item.Item;
import com.coffang.springboot2_coffang.dto.OrderItemResponseDto;
import com.coffang.springboot2_coffang.service.OrderItemService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(OrderItemController.class)
public class OrderItemControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    OrderItemService orderItemService;

    @Test
    @DisplayName("유저 주문 아이템 조회 테스트")
    void findByOrderItemTest() throws Exception {
//        // given
//        Long orderItemId = 1L;
//        Item item = new Brewing();;
//        Long orderPrice = 2L;
//        Long count = 3L;
//
//        OrderItemResponseDto orderItemResponseDto = new OrderItemResponseDto(orderItemId, item, orderPrice, count);
//
//        given(orderItemService.findByOrderItemId(orderItemId)).willReturn(orderItemResponseDto);
//
//        mvc.perform(get("/api/v1/orderItems/1"))
//                .andExpect(status().isOk());
//
//        // when
//        OrderItemResponseDto responseDto = orderItemService.findByOrderItemId(orderItemId);
//
//        // then
//        assertThat(responseDto.getId()).isEqualTo(orderItemId);
    }
}
