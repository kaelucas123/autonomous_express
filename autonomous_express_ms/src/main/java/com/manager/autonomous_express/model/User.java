package com.manager.autonomous_express.model;

import com.manager.autonomous_express.api.request.UserRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.validator.constraints.br.CPF;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "user")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private final Long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @CPF
    @Column(name = "cpf")
    private String cpf;

    @Column(name = "cep")
    private String cep;

    @Email
    @Column(name = "email")
    private String email;

    @Column(name = "address")
    private String address;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public User(UserRequest request) {
        this.name = request.getName();
        this.cpf = request.getCpf();
        this.cep = request.getCep();
        this.email = request.getEmail();
        this.address = request.getAddress();
    }
}
