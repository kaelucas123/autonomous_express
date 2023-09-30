package com.manager.autonomous_express.model;

import com.manager.autonomous_express.model.enums.VehicleStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "vehicle")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "first_use")
    private LocalDate firstUse;

    @Column(name = "plate")
    private String plate;

    @Column(name = "last_maintenance")
    private LocalDate lastMaintenance;

    @Column(name = "deactivation")
    private LocalDate deactivation;

    @Column(name = "status")
    private VehicleStatus status;

    @OneToOne(mappedBy = "vehicle", orphanRemoval = true)
    private Delivery delivery;

}
