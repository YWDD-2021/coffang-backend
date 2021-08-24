package com.coffang.springboot2_coffang.domain.item;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@EqualsAndHashCode(callSuper = true)
@DiscriminatorValue("Coffee")
@Data
public class Coffee extends Item {
    //id,name,price,stockQuantity,category,imageUrl 상속

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

}
