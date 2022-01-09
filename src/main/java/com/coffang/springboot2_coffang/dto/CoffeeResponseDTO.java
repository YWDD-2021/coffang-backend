package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Coffee;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoffeeResponseDto extends ItemResponseDto{
    private String type;
    private String region;

    public CoffeeResponseDto(Coffee entity){
        super(entity);
        this.type = entity.getType();
        this.region = entity.getRegion();
    }
}
