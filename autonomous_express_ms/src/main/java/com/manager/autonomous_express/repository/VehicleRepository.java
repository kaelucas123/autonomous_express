package com.manager.autonomous_express.repository;

import com.manager.autonomous_express.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
    public Optional<Vehicle> findByPlate(String plate);
}
