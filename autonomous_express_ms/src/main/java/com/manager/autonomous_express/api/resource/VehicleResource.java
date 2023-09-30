package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.request.VehicleRequest;
import com.manager.autonomous_express.api.response.VehicleResponse;
import com.manager.autonomous_express.service.VehicleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/vehicle")
public class VehicleResource {
    private VehicleService vehicleService;

    @GetMapping
    public DeferredResult<ResponseEntity<List<VehicleResponse>>> findAll(){
        DeferredResult<ResponseEntity<List<VehicleResponse>>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(vehicleService.findAll()));
        return dr;
    }
    @GetMapping("/{id}")
    public DeferredResult<ResponseEntity<VehicleResponse>> findById(@PathVariable Integer id){
        DeferredResult<ResponseEntity<VehicleResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(vehicleService.findById(id)));
        return dr;
    }
    @PostMapping("/save")
    public DeferredResult<ResponseEntity<VehicleResponse>> save(@RequestBody VehicleRequest request){
        DeferredResult<ResponseEntity<VehicleResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(vehicleService.save(request)));
        return dr;
    }
}
