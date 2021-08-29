package com.coffang.springboot2_coffang.domain.Item;


import com.coffang.springboot2_coffang.domain.item.Brewing;
import com.coffang.springboot2_coffang.domain.item.Coffee;
import com.coffang.springboot2_coffang.domain.item.ItemRepository;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class ItemRepositoryTest {
    @Autowired
    ItemRepository itemRepository;

    @AfterAll
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

        Brewing brewing = (Brewing)itemRepository.findAll().get(0);
        Coffee coffee = (Coffee)itemRepository.findAll().get(1);

        assertThat(brewing.getName()).isEqualTo("Hario Cold Brew Bottle");
        assertThat(coffee.getName()).isEqualTo("Neighbor Blend");

    }

}
