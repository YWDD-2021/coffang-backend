package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Item;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ItemResponseDto {
        private Long id;
        private String name;
        private Long price;
        private Integer stockQuantity;
        private String category;
        private String imageUrl;
        ItemResponseDto(Item entity){
            this.id= entity.getId();
            this.name = entity.getName();
            this.price = entity.getPrice();
            this.stockQuantity = entity.getStockQuantity();
            this.category = entity.getCategory();
            this.imageUrl = entity.getImageUrl();
        }
}
