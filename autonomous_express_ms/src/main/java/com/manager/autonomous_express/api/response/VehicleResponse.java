package com.manager.autonomous_express.api.response;

import com.manager.autonomous_express.model.enums.VehicleStatus;
import com.manager.autonomous_express.model.Delivery;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

public class VehicleResponse {
    @NotBlank
    private Integer id;
    @NotBlank
    private LocalDate firstUse;
    @NotBlank
    private LocalDate lastMaintenance;
    @NotBlank
    private LocalDate deactivation;
    @NotBlank
    private VehicleStatus status;
    @NotBlank
    private String carLicensePlate;
    @NotBlank
    private Set<Delivery> deliveries;
}