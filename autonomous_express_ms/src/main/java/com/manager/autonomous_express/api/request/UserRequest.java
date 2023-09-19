package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRequest {
    @NotBlank
    private String name;
    @NotBlank
    private String cpf;
    @NotBlank
    private String email;
    @NotBlank
    private String cep;
    @NotBlank
    private String address;
}
