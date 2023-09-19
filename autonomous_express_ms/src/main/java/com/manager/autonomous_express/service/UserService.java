package com.manager.autonomous_express.service;

import com.manager.autonomous_express.api.request.UserRequest;
import com.manager.autonomous_express.api.response.UserResponse;
import com.manager.autonomous_express.model.User;
import com.manager.autonomous_express.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> findAll(){
        log.info("Looking for all users");
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }

    public UserResponse findById(Long id){
        log.info("Looking for user by id: {}", id);
        Optional<UserResponse> user = userRepository.findById(id).map(UserResponse::new);

        if (user.isEmpty()){
            throw new RuntimeException("User not found");
        }

        return user.get();
    }

    public UserResponse save(UserRequest request){
        log.info("Saving user");

        User user = User.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .cep(request.getCep())
                .email(request.getEmail())
                .address(request.getAddress())
                .build();

        this.userRepository.save(user);
        return new UserResponse(user);
    }
}
