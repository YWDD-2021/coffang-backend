package com.coffang.springboot2_coffang.domain.item;


import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Brewing")
@Data
public class Brewing extends Item{

    @Column(nullable = false,length=100)
    String toolType;

    @Builder
    public Brewing(String name,Long price,Integer stockQuantity,String category,String imageUrl,String toolType){
        super(name,price,stockQuantity,category,imageUrl);
        this.toolType=toolType;
    }
}
