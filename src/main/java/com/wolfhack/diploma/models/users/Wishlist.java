package com.wolfhack.diploma.models.users;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.util.Date;

import static javax.persistence.CascadeType.*;
import static javax.persistence.FetchType.EAGER;

@Entity(name = "wishlist")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
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
