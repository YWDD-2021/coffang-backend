package com.coffang.springboot2_coffang.domain.orderitem;

import com.coffang.springboot2_coffang.domain.item.Item;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="item_id")
    private Item item;

    private Long orderPrice;

    private Long count;

    @Builder
    public OrderItem(Item item, Long orderPrice, Long count) {
        this.item = item;
        this.orderPrice = orderPrice;
        this.count = count;
    }

    public void update(Long orderPrice, Long count) {
        this.orderPrice = orderPrice;
        this.count = count;
    }
}