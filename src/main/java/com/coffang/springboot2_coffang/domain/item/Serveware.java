package com.coffang.springboot2_coffang.domain.item;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Serveware extends Item {
    //id,name,price,stockQuantity,category,imageUrl 상속

    @Column(nullable= false,length=100)
    String brand;
}
