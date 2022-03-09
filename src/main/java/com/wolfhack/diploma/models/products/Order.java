package com.wolfhack.diploma.models.products;

import com.wolfhack.diploma.models.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
@Getter @Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orders_id;
    private int count;
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_orders",
            foreignKey = @ForeignKey(name = "user_order_id"),
            joinColumns = {@JoinColumn(
                    name = "order_id",
                    referencedColumnName = "orders_id"
            ),
            @JoinColumn(
                    name = "count",
                    referencedColumnName = "count"
            ),
            @JoinColumn(
                    name = "user_id",
                    referencedColumnName = "user_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "product_id",
                    referencedColumnName = "id",
                    unique = false
            )}
    )
    private Set<Product> products = new HashSet<>();

    @ManyToOne
    @JoinColumn(
            name = "user_id",
            referencedColumnName = "user_id"
    )
    private User users;
}
