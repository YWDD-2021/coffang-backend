package com.coffang.springboot2_coffang.domain.order;

import com.coffang.springboot2_coffang.domain.orderitem.OrderItem;
import com.coffang.springboot2_coffang.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name="ORDER_TABLE")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="orderitem_id")
    private List<OrderItem> orderItems;

    private LocalDateTime orderDateTime;

    private Boolean isCompleted;

    @Builder
    public Order(User user, List<OrderItem> orderItems, LocalDateTime orderDateTime, boolean isCompleted) {
        this.user = user;
        this.orderItems = orderItems;
        this.orderDateTime = orderDateTime;
        this.isCompleted = isCompleted;
    }
}
