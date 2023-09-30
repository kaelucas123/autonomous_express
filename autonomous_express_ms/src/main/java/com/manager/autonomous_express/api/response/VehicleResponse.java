package com.manager.autonomous_express.api.response;

import com.manager.autonomous_express.model.Delivery;
import com.manager.autonomous_express.model.Vehicle;
import com.manager.autonomous_express.model.enums.VehicleStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor

public class VehicleResponse {
    private LocalDate firstUse;
    private String plate;
    private LocalDate lastMaintenance;
    private LocalDate deactivation;
    private VehicleStatus status;
    private Delivery delivery;
    public VehicleResponse(Vehicle vehicle){
        this.firstUse = vehicle.getFirstUse();
        this.plate = vehicle.getPlate();
        this.lastMaintenance = vehicle.getLastMaintenance();
    }
}
