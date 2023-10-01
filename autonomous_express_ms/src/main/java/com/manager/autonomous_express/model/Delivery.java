package com.manager.autonomous_express.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "starting_date")
    private LocalDate startingDate;

    @Column(name = "conclusion_date")
    private LocalDate conclusionDate;

    @Column(name = "is_concluded")
    private Boolean isConcluded;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToOne(orphanRemoval = true)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "delivery", orphanRemoval = true)
    private Set<Product> products = new LinkedHashSet<>();

}