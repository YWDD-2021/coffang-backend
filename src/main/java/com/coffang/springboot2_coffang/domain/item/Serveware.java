package com.coffang.springboot2_coffang.domain.item;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Serveware")
@Data
public class Serveware extends Item {
    //id,name,price,stockQuantity,category,imageUrl 상속

    @Column(nullable= false,length=100)
    String brand;

    @Builder
    public Serveware(String name,Long price,Integer stockQuantity,String category,String imageUrl,String brand){
        super(name,price,stockQuantity,category,imageUrl);
        this.brand=brand;
    }
}
