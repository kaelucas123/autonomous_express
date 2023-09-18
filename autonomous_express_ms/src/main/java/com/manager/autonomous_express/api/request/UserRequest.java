package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotBlank;

public record UserRequest(
        @NotBlank
        String name,
        @NotBlank
        String cpf,
        @NotBlank
        String email,
        String cep,
        String address
) {
}
