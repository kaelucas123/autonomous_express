package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class VehicleRequest {
    @NotBlank
    private String plate;
    @NotBlank
    private LocalDate firstUse;
    @NotBlank
    private LocalDate lastMaintenance;
}
