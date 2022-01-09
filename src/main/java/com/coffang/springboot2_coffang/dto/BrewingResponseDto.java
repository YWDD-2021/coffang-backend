package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Brewing;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BrewingResponseDto extends ItemResponseDto {
    private String toolType;

    public BrewingResponseDto(Brewing entity){
        super(entity);
        this.toolType = entity.getToolType();
    }
}
