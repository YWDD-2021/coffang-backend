package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.domain.cart.Cart;
import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.item.Item;
import com.coffang.springboot2_coffang.domain.user.User;
import com.coffang.springboot2_coffang.dto.CartResponseDto;
import com.coffang.springboot2_coffang.service.CartItemService;
import com.coffang.springboot2_coffang.service.CartService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CartItemController.class)
public class CartItemControllerTest {

//    @LocalServerPort
//    private int port;
//
//    @Autowired
//    MockMvc mvc;
//
//    @MockBean
//    CartItemService cartItemService;
//
//    String url = "/api/v1/cartItems";
//
//    @Test
//    @WithMockUser
//    @DisplayName("유저 장바구니 조회 테스트")
//    void CartItem_등록된다() throws Exception {
//
//    }
}
