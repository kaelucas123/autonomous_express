package com.manager.autonomous_express.repository;

import com.manager.autonomous_express.model.CompanyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CompanyUserRepository extends JpaRepository<CompanyUser, UUID> {
    UserDetails findByLogin(String login);
}
