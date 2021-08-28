package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.item.Coffee;
import com.coffang.springboot2_coffang.dto.CartItemResponseDto;
import com.coffang.springboot2_coffang.dto.CartItemSaveRequestDto;
import com.coffang.springboot2_coffang.service.CartItemService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(CartItemController.class)
@WithMockUser
public class CartItemControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    CartItemService cartItemService;

    String url = "/api/v1/cartItems";

    @Test
    @DisplayName("CartItem 생성 테스트")
    void CartItem_생성된다() throws Exception {

        // given
        Long id = 1L;
        String name = "supremo";
        Long price = 250L;
        Integer stockQuantity = 2;

        Coffee coffee = new Coffee(id, name, price, stockQuantity, "", "", "", "");

        Long cartPrice = 500L;
        Long count = 2L;

        CartItemSaveRequestDto cartItemSaveRequestDto =
                new CartItemSaveRequestDto(coffee, cartPrice, count);
        given(cartItemService.save(cartItemSaveRequestDto)).willReturn(id);

        CartItem cartItem = new CartItem(coffee, cartPrice, count);
        CartItemResponseDto cartItemResponseDto = new CartItemResponseDto(cartItem);
        cartItemResponseDto.setId(id);
        given(cartItemService.findById(id)).willReturn(cartItemResponseDto);

        // when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(cartItemSaveRequestDto)))
                .andExpect(status().isOk());

        // then
        CartItemResponseDto responseDto = cartItemService.findById(id);
        assertThat(responseDto.getId()).isEqualTo(id);
        assertThat(responseDto.getCartPrice()).isEqualTo(cartPrice);

    }
}
