package com.coffang.springboot2_coffang.domain.cart;

import com.coffang.springboot2_coffang.domain.cartitem.CartItem;
import com.coffang.springboot2_coffang.domain.user.User;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@WithMockUser(roles="USER")
public class CartRepositoryTest {

    @Autowired
    CartRepository cartRepository;

    @AfterEach
    public void cleanup() {
        cartRepository.deleteAll();
    }

    @Test
    public void Cart_저장_불러오기() {
        User user = new User();

        CartItem cartItem = new CartItem();
        List<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(cartItem);

        Cart newCart = Cart.builder()
                .user(user)
                .cartItems(cartItems)
                .build();

        cartRepository.save(newCart);

        // when
        List<Cart> cartList = cartRepository.findAll();

        // then
        Cart cart = cartList.get(0);
//        assertThat(cart.getUser().getId()).isEqualTo(user.getId());
        assertThat(cart.getCartItems().size()).isEqualTo(1);
    }

    @Test
    public void Cart_업데이트() {
        User user = new User();

        CartItem cartItem = new CartItem();
        List<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(cartItem);

        Cart newCart = Cart.builder()
                .user(user)
                .cartItems(cartItems)
                .build();

        cartRepository.save(newCart);

        // when
        List<Cart> cartList = cartRepository.findAll();

        Cart cart = cartList.get(0);
        CartItem respCartItem = cart.getCartItems().get(0);
        respCartItem.update(100L, 10L);
        List<CartItem> updatedCartItems = Arrays.asList(respCartItem);
        cart.update(updatedCartItems);

        cartRepository.save(cart);

        // then
        List<CartItem> items = cart.getCartItems();
        assertThat(cart.getCartItems().size()).isEqualTo(1);
        assertThat(cart.getCartItems().get(0).getCartPrice()).isEqualTo(100);
    }

    @Test
    public void Cart_삭제() {
        User user = new User();

        CartItem cartItem = new CartItem();
        List<CartItem> cartItems = new ArrayList<CartItem>();
        cartItems.add(cartItem);

        Cart newCart = Cart.builder()
                .user(user)
                .cartItems(cartItems)
                .build();

        cartRepository.save(newCart);

        // when
        List<Cart> cartList = cartRepository.findAll();

        Cart cart = cartList.get(0);

        cartRepository.delete(cart);

        // then
        List<Cart> cartListAfterDelete = cartRepository.findAll();
        assertThat(cartListAfterDelete.size()).isEqualTo(0);
    }
}
