package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.request.CompanyRequest;
import com.manager.autonomous_express.api.response.CompanyResponse;
import com.manager.autonomous_express.service.CompanyService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
@AllArgsConstructor
public class CompanyResource {
    private CompanyService companyService;

    @GetMapping
    public DeferredResult<ResponseEntity<List<CompanyResponse>>> findAll(){
        DeferredResult<ResponseEntity<List<CompanyResponse>>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(companyService.findAll()));
        return dr;
    }

    @GetMapping("/{id}")
    public DeferredResult<ResponseEntity<CompanyResponse>> findById(@PathVariable UUID id){
        DeferredResult<ResponseEntity<CompanyResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(companyService.findById(id)));
        return dr;
    }

    @PostMapping("/save")
    public DeferredResult<ResponseEntity<CompanyResponse>> save(@Valid @RequestBody CompanyRequest request){
        DeferredResult<ResponseEntity<CompanyResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(companyService.save(request)));
        return dr;
    }
}
