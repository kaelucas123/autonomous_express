package com.manager.autonomous_express.api.response;

import com.manager.autonomous_express.model.Delivery;
import com.manager.autonomous_express.model.Product;
import com.manager.autonomous_express.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
public class DeliveryResponse {
    private User user;
    private Set<Product> products;


    public DeliveryResponse(Delivery delivery){
        this.user = delivery.getUser();
        this.products = delivery.getProducts();
    }
}
