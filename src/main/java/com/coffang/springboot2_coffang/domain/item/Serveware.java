package com.coffang.springboot2_coffang.domain.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = true)
@Data
@JsonDeserialize(using= JsonDeserializer.None.class)
public class Serveware extends Item {
    //id,name,price,stockQuantity,category,imageUrl 상속

    @JsonCreator
    public Serveware(@JsonProperty("id") Long id,
                  @JsonProperty("name") String name,
                  @JsonProperty("price") Long price,
                  @JsonProperty("stock_quantity") Integer stockQuantity,
                  @JsonProperty("category") String category,
                  @JsonProperty("image_url") String imageUrl,
                  @JsonProperty("type") String type,
                  @JsonProperty("brand") String brand
    ) {
        super(id, name, price, stockQuantity, category, imageUrl);
        this.brand = brand;
    }

    @Column(nullable= false,length=100)
    String brand;
}
