package com.manager.autonomous_express.model;

import com.manager.autonomous_express.api.request.ProductRequest;
import com.manager.autonomous_express.model.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {
    private final Long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "status")
    private ProductStatus status;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "pending_logistic_center_date")
    private LocalDateTime pendingLogisticCenterDate;

    @Column(name = "in_transit_date")
    private LocalDateTime inTransitDate;

    @Column(name = "delivered_date")
    private LocalDateTime deliveredDate;

    @ManyToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    public Product(ProductRequest request){
        this.name = request.getName();
    }
}
