package com.manager.autonomous_express.service;

import com.manager.autonomous_express.api.response.UserResponse;
import com.manager.autonomous_express.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserResponse> findAll(){
        return userRepository.findAll().stream().map(UserResponse::new).collect(Collectors.toList());
    }
}
