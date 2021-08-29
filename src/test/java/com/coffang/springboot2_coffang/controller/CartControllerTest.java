package com.coffang.springboot2_coffang.controller;
import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.user.User;
import com.coffang.springboot2_coffang.dto.CartResponseDto;
import com.coffang.springboot2_coffang.service.CartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.BDDMockito.given;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest(CartController.class)
public class CartControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    CartService cartService;

    @Test
    @WithMockUser
    @DisplayName("유저 장바구니 조회 테스트")
    void findByUserIdTest() throws Exception {
        Cart cart = new Cart();
        User user = new User();
        Long userId = Long.valueOf(1);
        cart.setId(userId);
        cart.setUser(user);

        CartResponseDto cartResponseDto = new CartResponseDto(cart);

        given(cartService.findByUserId(userId)).willReturn(cartResponseDto);

        mvc.perform(get("/api/v1/carts/1"))
                .andExpect(status().isOk());

        CartResponseDto responseDto = cartService.findByUserId(userId);
        assertThat(responseDto.getId()).isEqualTo(userId);
    }
}
