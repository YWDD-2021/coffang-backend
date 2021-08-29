package com.coffang.springboot2_coffang;

import com.coffang.springboot2_coffang.domain.item.Coffee;
import com.coffang.springboot2_coffang.domain.item.Item;
import com.coffang.springboot2_coffang.domain.item.ItemDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ObjectMapperConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        SimpleModule module = new SimpleModule();
        module.addDeserializer(Item.class, new ItemDeserializer());
        return new ObjectMapper().registerModules(module);
    }
}
