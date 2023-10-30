package com.manager.autonomous_express.service;

import com.manager.autonomous_express.repository.CompanyUserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor

public class AuthorizationService implements UserDetailsService {

    @Autowired
    CompanyUserRepository companyUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return companyUserRepository.findByLogin(username);
    }

}
