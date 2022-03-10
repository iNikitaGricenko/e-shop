package com.wolfhack.diploma.models.products;

import com.wolfhack.diploma.models.users.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "orders")
@Getter @Setter
public class Order implements Serializable {

    public enum OrderStatus {
        INPROGRESS, PENDING, DELIVERED, RETURN
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orders_id")
    private Long id;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "description", length = 1024)
    private String description;

    @Transient
    private int count;

    @Column(name = "created", insertable = false)
    @Basic(optional = false)
    private Date created;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    @Basic(optional = false)
    private OrderStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    @Column(name = "deleted")
    private boolean isDeleted = Boolean.FALSE;
    @Column(name = "deleted_at", insertable = false)
    private Date deletedAt;

    @ElementCollection
    @CollectionTable(name = "user_orders", joinColumns = {
            @JoinColumn(name = "order_id", referencedColumnName = "orders_id")})
    @AttributeOverrides({
            @AttributeOverride(name = "id", column = @Column(name = "product_id"))})
    private Set<Product> products;
}
