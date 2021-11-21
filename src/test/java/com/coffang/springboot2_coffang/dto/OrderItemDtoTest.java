package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Brewing;
import com.coffang.springboot2_coffang.domain.item.Item;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class OrderItemDtoTest {
    @Test
    public void OrderItemResponse_테스트() {
        // given
        Long id = 1L;
        Item item = new Brewing();;
        Long orderPrice = 2L;
        Long count = 3L;

        // when
        OrderItemResponseDto dto = new OrderItemResponseDto(id, item, orderPrice, count);

        // then
        assertThat(dto.getId()).isEqualTo(id);
        assertThat(dto.getItem()).isEqualTo(item);
        assertThat(dto.getOrderPrice()).isEqualTo(orderPrice);
        assertThat(dto.getCount()).isEqualTo(count);
    }

}
