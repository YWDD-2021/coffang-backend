package com.coffang.springboot2_coffang.domain.item;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Data
public abstract class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=200)
    private String name;

    @Column(nullable= false)
    private Long price;

    @Column(nullable=false)
    private Integer stockQuantity;

    @Column(nullable=false)
    private String category;

    private String imageUrl;

}
