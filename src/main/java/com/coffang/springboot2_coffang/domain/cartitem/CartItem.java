package com.coffang.springboot2_coffang.domain.cartitem;

import com.coffang.springboot2_coffang.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    private Long cartPrice;

    private Long count;

    @Builder
    public CartItem(Item item, Long cartPrice, Long count) {
        this.item = item;
        this.cartPrice = cartPrice;
        this.count = count;
    }

    public void update(Long cartPrice, Long count) {
        this.cartPrice = cartPrice;
        this.count = count;
    }
}
