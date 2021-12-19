package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Coffee;

public class CoffeeResponseDTO extends ItemResponseDto{
    private String type;
    private String region;

    public CoffeeResponseDTO(Coffee entity){
        super(entity);
        this.type = entity.getType();
        this.region = entity.getRegion();
    }
}
