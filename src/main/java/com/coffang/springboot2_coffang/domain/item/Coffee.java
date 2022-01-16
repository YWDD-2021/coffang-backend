package com.coffang.springboot2_coffang.domain.item;


import com.coffang.springboot2_coffang.dto.CoffeeResponseDto;
import lombok.*;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Coffee")
@Data
@JsonDeserialize(using= JsonDeserializer.None.class)
public class Coffee extends Item {
    //id,name,price,stockQuantity,category,imageUrl 상속

    @JsonCreator
    public Coffee(@JsonProperty("id") Long id,
           @JsonProperty("name") String name,
           @JsonProperty("price") Long price,
           @JsonProperty("stock_quantity") Integer stockQuantity,
           @JsonProperty("category") String category,
           @JsonProperty("image_url") String imageUrl,
           @JsonProperty("type") String type,
           @JsonProperty("region") String region
           ) {
        super(id, name, price, stockQuantity, category, imageUrl);
        this.type = type;
        this.region = region;
    }

    @Column(nullable= false)
    String type;

    @Column(nullable= false)
    String region;

    @Builder
    public Coffee(String name,Long price,Integer stockQuantity,String category,String imageUrl,String type,String region){
        super(name,price,stockQuantity,category,imageUrl);
        this.type=type;
        this.region=region;
    }

    public CoffeeResponseDto toResponseDto() {
        return new CoffeeResponseDto(this);
    }
}
