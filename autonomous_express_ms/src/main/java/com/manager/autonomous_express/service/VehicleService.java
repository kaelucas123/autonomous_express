package com.manager.autonomous_express.service;

import com.manager.autonomous_express.api.request.VehicleRequest;
import com.manager.autonomous_express.api.response.VehicleResponse;
import com.manager.autonomous_express.model.Vehicle;
import com.manager.autonomous_express.repository.VehicleRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class VehicleService {
    private final VehicleRepository vehicleRepository;
    public List<VehicleResponse> findAll(){
        log.info("Looking for all vehicles");
        return vehicleRepository.findAll().stream().map(VehicleResponse::new).collect(Collectors.toList());
    }

    public VehicleResponse findById(Integer id){
        log.info("Looking for vehicle by id: {}", id);
        Optional<VehicleResponse> vehicle = vehicleRepository.findById(id).map(VehicleResponse::new);

        if (vehicle.isEmpty()){
            throw new RuntimeException("Vehicle no found");
        }

        return vehicle.get();
    }

    public VehicleResponse save(VehicleRequest request){
        log.info("Saving vehicle");
        Optional<Vehicle> vehicleO = vehicleRepository.findByPlate(request.getPlate());
        if (vehicleO.isPresent()){
            throw new RuntimeException();
        }

        Vehicle vehicle = Vehicle.builder()
                .plate(request.getPlate())
                .firstUse(request.getFirstUse())
                .lastMaintenance(request.getLastMaintenance())
                .build();

        this.vehicleRepository.save(vehicle);
        return new VehicleResponse(vehicle);
    }

}
