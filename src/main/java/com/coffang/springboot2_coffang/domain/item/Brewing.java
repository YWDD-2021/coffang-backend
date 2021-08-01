package com.coffang.springboot2_coffang.domain.item;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
@Data
public class Brewing extends Item{

    @Column(nullable = false,length=100)
    String toolType;
}
