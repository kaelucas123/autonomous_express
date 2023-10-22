package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.request.AuthenticationRequest;
import com.manager.autonomous_express.api.request.RegisterDTO;
import com.manager.autonomous_express.api.response.LoginResponseDTO;
import com.manager.autonomous_express.infra.security.TokenService;
import com.manager.autonomous_express.model.CompanyUser;
import com.manager.autonomous_express.repository.CompanyUserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationResource {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private CompanyUserRepository companyUserRepository;
    @Autowired
    private TokenService tokenService;
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((CompanyUser) auth.getPrincipal());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody @Valid RegisterDTO request) {
        if (this.companyUserRepository.findByLogin(request.login()) != null) {
            return ResponseEntity.badRequest().build();
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
        CompanyUser newCompanyUser = new CompanyUser(request.login(), encryptedPassword, request.role());
        this.companyUserRepository.save(newCompanyUser);
        return ResponseEntity.ok().build();
    }
}