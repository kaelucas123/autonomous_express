package com.manager.autonomous_express.model;

import com.manager.autonomous_express.model.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_use")
    private LocalDate firstUse;

    @Column(name = "last_maintenance")
    private LocalDate lastMaintenance;

    @Column(name = "deactivation")
    private LocalDate deactivation;

    @Column(name = "status")
    private VehicleStatus status;

    @OneToOne(mappedBy = "vehicle", orphanRemoval = true)
    private Delivery delivery;

}
