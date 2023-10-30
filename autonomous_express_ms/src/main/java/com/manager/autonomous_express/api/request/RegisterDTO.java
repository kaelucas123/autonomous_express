package com.manager.autonomous_express.api.request;

import com.manager.autonomous_express.model.enums.CompanyUserRole;

public record RegisterDTO(String login, String password, CompanyUserRole role) {
}
