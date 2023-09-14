package com.manager.autonomous_express.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "company")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company implements Serializable {
    private final Long serialVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "workspace")
    private Long workspace;

    @Column(name = "cpnj")
    private String cnpj;

    @Column(name = "logistics_center_address")
    private String logisticsCenterAddress;
}
