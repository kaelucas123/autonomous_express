package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.request.DeliveryRequest;
import com.manager.autonomous_express.api.response.DeliveryResponse;
import com.manager.autonomous_express.service.DeliveryService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@RestController
@RequestMapping("/delivery")
public class DeliveryResource {
    private DeliveryService deliveryService;
    @GetMapping
    public DeferredResult<ResponseEntity<List<DeliveryResponse>>> findAll(){
        DeferredResult<ResponseEntity<List<DeliveryResponse>>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(deliveryService.findAll()));
        return dr;
    }

    @GetMapping("/{id}")
    public DeferredResult<ResponseEntity<DeliveryResponse>> findById(@PathVariable UUID id){
        DeferredResult<ResponseEntity<DeliveryResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(deliveryService.findById(id)));
        return dr;
    }
    @PostMapping()
    public DeferredResult<ResponseEntity<DeliveryResponse>> save(@Valid @RequestBody DeliveryRequest request){
        DeferredResult<ResponseEntity<DeliveryResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(deliveryService.save(request)));
        return dr;
    }
}
