package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.request.ProductRequest;
import com.manager.autonomous_express.api.response.ProductResponse;
import com.manager.autonomous_express.service.ProductService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
@AllArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductResource {
    private ProductService productService;
    @GetMapping
    public DeferredResult<ResponseEntity<List<ProductResponse>>> findAll(){
        DeferredResult<ResponseEntity<List<ProductResponse>>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(productService.findAll()));
        return dr;
    }

    @GetMapping("/{id}")
    public DeferredResult<ResponseEntity<ProductResponse>> findById(@PathVariable Long id){
        DeferredResult<ResponseEntity<ProductResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(productService.findById(id)));
        return dr;
    }
    @PostMapping("/save")
    public DeferredResult<ResponseEntity<ProductResponse>> save(@Valid @RequestBody ProductRequest request){
        DeferredResult<ResponseEntity<ProductResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(productService.save(request)));
        return dr;
    }
}
