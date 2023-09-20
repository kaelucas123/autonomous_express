package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CompanyRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String cnpj;
    @NotBlank
    private String logisticsCenterAddress;
}