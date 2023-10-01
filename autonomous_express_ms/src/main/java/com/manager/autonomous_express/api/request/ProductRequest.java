package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class ProductRequest {
    @NotBlank
    private String name;
}
