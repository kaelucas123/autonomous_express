package com.manager.autonomous_express.api.response;

import com.manager.autonomous_express.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserResponse {
    private Long id;
    private String name;
    private String cpf;
    private String cep;
    private String email;
    private String address;
    public UserResponse (User user) {
        this.name = user.getName();
        this.cpf = user.getCpf();
        this.cep = user.getCep();
        this.email = user.getEmail();
        this.address = user.getAddress();
    }
}
