package com.coffang.springboot2_coffang.controller;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.cartitem.CartItemRepository;
import com.coffang.springboot2_coffang.domain.item.Coffee;
import com.coffang.springboot2_coffang.domain.item.CoffeeRepository;
import com.coffang.springboot2_coffang.dto.CartItemSaveRequestDto;
import com.coffang.springboot2_coffang.dto.CartItemUpdateRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CartItemControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private CoffeeRepository coffeeRepository;

    String url = "/api/v1/cartItems";

    @AfterEach
    public void tearDown() throws Exception {
        cartItemRepository.deleteAll();
        coffeeRepository.deleteAll();
    }

    @Test
    @DisplayName("CartItem 생성 테스트")
    void CartItem_생성된다() throws Exception {

        // given
        String name = "supremo";
        Long price = 250L;
        Integer stockQuantity = 2;
        String category = "category";
        String type = "beans";
        String region = "colombia";

        Coffee coffee = coffeeRepository.save(Coffee.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .category(category)
                .type(type)
                .region(region)
                .build());

        Long cartPrice = 500L;
        Long count = 2L;

        CartItemSaveRequestDto cartItemSaveRequestDto = CartItemSaveRequestDto.builder()
                .item(coffee)
                .cartPrice(cartPrice)
                .count(count)
                .build();

        // when
        String postUrl = "http://localhost:" + port + url;
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(postUrl, cartItemSaveRequestDto, Long.class);

        // then
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody())
                .isGreaterThan(0L);

        List<CartItem> all = cartItemRepository.findAll();

        assertThat(all.get(0).getItem().getPrice()).isEqualTo(price);
        assertThat(all.get(0).getCartPrice()).isEqualTo(cartPrice);
        assertThat(all.get(0).getCount()).isEqualTo(count);
    }

    @Test
    @DisplayName("CartItem 업데이트 테스트")
    void CartItem_업데이트() throws Exception {
        // given
        String name = "supremo";
        Long price = 250L;
        Integer stockQuantity = 2;
        String category = "category";
        String type = "beans";
        String region = "colombia";

        Coffee coffee = coffeeRepository.save(Coffee.builder()
            .name(name)
            .price(price)
            .stockQuantity(stockQuantity)
            .category(category)
            .type(type)
            .region(region)
            .build());

        Long cartPrice = 500L;
        Long count = 2L;

        CartItem cartItem = cartItemRepository.save(CartItem.builder()
            .item(coffee)
            .cartPrice(cartPrice)
            .count(count)
            .build());

        Long cartItemId = cartItem.getId();

        Long cartPriceUpdated = 1000L;
        Long countUpdated = 4L;

        CartItemUpdateRequestDto cartItemUpdateRequestDto =
                CartItemUpdateRequestDto.builder()
                        .cartPrice(cartPriceUpdated)
                        .count(countUpdated)
                        .build();

        String putUrl = "http://localhost:" + port + url + "/" + cartItemId;

        HttpEntity<CartItemUpdateRequestDto> requestEntity =
                new HttpEntity<>(cartItemUpdateRequestDto);

        // when
        ResponseEntity<Long> responseEntity =
                restTemplate.exchange(putUrl, HttpMethod.PUT,
                        requestEntity, Long.class);

        // then
        assertThat(responseEntity.getStatusCode())
                .isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody())
                .isGreaterThan(0L);

        List<CartItem> all = cartItemRepository.findAll();

        assertThat(all.get(0).getItem().getPrice()).isEqualTo(price);
        assertThat(all.get(0).getCartPrice()).isEqualTo(cartPriceUpdated);
        assertThat(all.get(0).getCount()).isEqualTo(countUpdated);
    }

    @Test
    @DisplayName("CartItem 삭제 테스트")
    void CartItem_삭제() throws Exception {
        // given
        String name = "supremo";
        Long price = 250L;
        Integer stockQuantity = 2;
        String category = "category";
        String type = "beans";
        String region = "colombia";

        Coffee coffee = coffeeRepository.save(Coffee.builder()
                .name(name)
                .price(price)
                .stockQuantity(stockQuantity)
                .category(category)
                .type(type)
                .region(region)
                .build());

        Long cartPrice = 500L;
        Long count = 2L;

        CartItem cartItem = cartItemRepository.save(CartItem.builder()
                .item(coffee)
                .cartPrice(cartPrice)
                .count(count)
                .build());

        Long cartItemId = cartItem.getId();

        HttpEntity<CartItem> savedEntity = new HttpEntity<>(cartItem);

        // when
        String deleteUrl = "http://localhost:" + port + url + "/" + cartItemId;
        ResponseEntity<Long> responseEntity = restTemplate.exchange(deleteUrl, HttpMethod.DELETE, savedEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<CartItem> deleted = cartItemRepository.findAll();
        assertThat(deleted).isEmpty();
    }
}
