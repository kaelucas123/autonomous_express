package com.manager.autonomous_express.api.response;

import com.manager.autonomous_express.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ProductResponse {
    private String name;
    private String description;

    public ProductResponse(Product product){
        this.name = product.getName();
        this.description = product.getDescription();
    }

}
