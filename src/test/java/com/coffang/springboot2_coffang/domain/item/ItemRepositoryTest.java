package com.coffang.springboot2_coffang.domain.item;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @AfterEach
    public void cleanup(){
        itemRepository.deleteAll();
    }

    @Test
    public void Item의_서브클래스_객체들_casting으로_가져오기() {

        itemRepository.save(Brewing.builder()
                .name("Hario Cold Brew Bottle")
                .price(25000L)
                .stockQuantity(100)
                .category("카테고리")
                .imageUrl("www.naver.com")
                .toolType("Brewers")
                .build());

        itemRepository.save(Coffee.builder()
                .name("Neighbor Blend")
                .price(10000L)
                .stockQuantity(100)
                .category("카테고리")
                .imageUrl("www.naver.com")
                .type("Espresso")
                .region("East Africa")
                .build());

        List<Item> brs = itemRepository.findAll();
        List<Item> coffees = itemRepository.findAll();
        Brewing brewing = (Brewing) brs.get(0);
        Coffee coffee = (Coffee) coffees.get(1);

        assertThat(brewing.getName()).isEqualTo("Hario Cold Brew Bottle");
        assertThat(coffee.getName()).isEqualTo("Neighbor Blend");

    }

}
