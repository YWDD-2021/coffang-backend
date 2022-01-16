package com.coffang.springboot2_coffang.domain.order;

import com.coffang.springboot2_coffang.domain.BaseTimeEntity;
import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ORDER_TABLE")
public class Order extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name="orderitem_id")
    private List<OrderItem> orderItems;

    private Boolean isCompleted;

    @Builder
    public Order(User user, List<OrderItem> orderItems, boolean isCompleted) {
        this.user = user;
        this.orderItems = orderItems;
        this.isCompleted = isCompleted;
    }

    public void update(User user, List<OrderItem> orderItems, boolean isCompleted) {
        this.user = user;
        this.orderItems = orderItems;
        this.isCompleted = isCompleted;
    }
}