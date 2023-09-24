package com.manager.autonomous_express.model;

import com.manager.autonomous_express.model.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

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

    @Column(name = "car_license_plate")
    private String carLicensePlate;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private Set<Delivery> deliveries = new LinkedHashSet<>();

}
