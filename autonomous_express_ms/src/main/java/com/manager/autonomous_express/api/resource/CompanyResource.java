package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.response.CompanyResponse;
import com.manager.autonomous_express.api.response.UserResponse;
import com.manager.autonomous_express.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.lang.annotation.Repeatable;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/company")
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
}
