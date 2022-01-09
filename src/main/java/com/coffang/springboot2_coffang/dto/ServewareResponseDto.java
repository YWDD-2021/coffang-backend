package com.coffang.springboot2_coffang.dto;

import com.coffang.springboot2_coffang.domain.item.Coffee;
import com.coffang.springboot2_coffang.domain.item.Serveware;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ServewareResponseDto extends ItemResponseDto{
    private String brand;

    public ServewareResponseDto(Serveware entity){
        super(entity);
        this.brand = entity.getBrand();
    }
}
