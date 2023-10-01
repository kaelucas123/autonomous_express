package com.manager.autonomous_express.service;

import com.manager.autonomous_express.api.request.ProductRequest;
import com.manager.autonomous_express.api.response.ProductResponse;
import com.manager.autonomous_express.model.Product;
import com.manager.autonomous_express.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository productRepository;
    public List<ProductResponse> findAll() {
        log.info("Looking for all products");
        return productRepository.findAll().stream().map(ProductResponse::new).collect(Collectors.toList());
    }

    public ProductResponse findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isEmpty()) {
            throw new RuntimeException("Product not found by id");
        }
        return new ProductResponse(product.get());
    }
    public ProductResponse save(ProductRequest request){
        log.info("Saving product");

        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        this.productRepository.save(product);
        return new ProductResponse(product);
    }
}

