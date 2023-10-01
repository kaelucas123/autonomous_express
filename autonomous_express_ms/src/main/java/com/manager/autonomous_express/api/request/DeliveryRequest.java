package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.LinkedHashSet;
import java.util.Set;
@AllArgsConstructor
@Getter
public class DeliveryRequest {
    @NotNull
    private UserRequest user;
    @NotNull
    private final Set<ProductRequest> products = new LinkedHashSet<>();
}
