package com.manager.autonomous_express.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "delivery")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

}
