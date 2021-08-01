package com.coffang.springboot2_coffang.domain.item;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Coffee extends Item {
    //id,name,price,stockQuantity,category,imageUrl 상속

    @Column(nullable= false)
    String type;

    @Column(nullable= false)
    String region;

}
