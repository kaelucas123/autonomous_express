package com.manager.autonomous_express.service;

import com.manager.autonomous_express.api.request.DeliveryRequest;
import com.manager.autonomous_express.api.response.DeliveryResponse;
import com.manager.autonomous_express.model.Delivery;
import com.manager.autonomous_express.model.Product;
import com.manager.autonomous_express.model.User;
import com.manager.autonomous_express.repository.DeliveryRepository;
import com.manager.autonomous_express.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
@Slf4j
@Service
@AllArgsConstructor
public class DeliveryService {
    private DeliveryRepository deliveryRepository;
    private UserRepository userRepository;

    public List<DeliveryResponse> findAll() {
        log.info("Looking for all products");
        return deliveryRepository.findAll().stream().map(DeliveryResponse::new).collect(Collectors.toList());
    }

    public DeliveryResponse findById(UUID id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        if (delivery.isEmpty()) {
            throw new RuntimeException("Delivery not found by id");
        }
        return new DeliveryResponse(delivery.get());
    }
    public DeliveryResponse save(DeliveryRequest request){
        log.info("Saving delivery");
        Optional<User> userO = userRepository.findByCpf(request.getUserCPF());

        if(userO.isEmpty()){
            return null;
        }

        Delivery delivery = Delivery.builder()
                .user(userO.get())
                .products(request.getProducts().stream().map(Product::new).collect(Collectors.toSet()))
                .build();

        this.deliveryRepository.save(delivery);
        return new DeliveryResponse(delivery);
    }
}
