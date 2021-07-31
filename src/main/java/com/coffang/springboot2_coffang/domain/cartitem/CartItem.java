package com.coffang.springboot2_coffang.domain.cartitem;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne
//    @JoinColumn(name="item_id")
//    private Item item;

    private Long cartPrice;

    private Long count;
}
