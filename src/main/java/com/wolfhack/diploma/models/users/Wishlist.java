package com.wolfhack.diploma.models.users;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "wishlist")
@Getter @Setter
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", columnDefinition = "id")
    private User user;

    @Column(name = "product_ids")
    private String productId;

    @Column(name = "created_at")
    private Date createdAt;
}
