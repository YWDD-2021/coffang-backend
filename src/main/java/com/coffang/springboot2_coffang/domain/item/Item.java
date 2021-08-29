package com.coffang.springboot2_coffang.domain.item;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Data
@DiscriminatorColumn
@Getter
@JsonDeserialize(using = ItemDeserializer.class)
public abstract class Item {

    @JsonCreator
    public Item(@JsonProperty("id") Long id,
         @JsonProperty("name") String name,
         @JsonProperty("price") Long price,
         @JsonProperty("stock_quantity") Integer stockQuantity,
         @JsonProperty("category") String category,
         @JsonProperty("image_url") String imageUrl) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.imageUrl = imageUrl;
    }

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

    public Item(String name,Long price,Integer stockQuantity,String category,String imageUrl){
        this.name=name;
        this.price=price;
        this.stockQuantity=stockQuantity;
        this.category=category;
        this.imageUrl=imageUrl;
    }
}
