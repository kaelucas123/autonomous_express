package com.manager.autonomous_express.api.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class AuthenticationRequest {
    @NotBlank
    private String login;
    @NotBlank
    private String password;
}
