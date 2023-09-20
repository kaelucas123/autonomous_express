package com.manager.autonomous_express.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class VehicleService {
    private VehicleRepository vehicleRepository;
}
