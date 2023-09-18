package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.response.UserResponse;
import com.manager.autonomous_express.service.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
@Transactional
public class UserResource {

    private final UserService userService;

    @GetMapping
    public DeferredResult<ResponseEntity<List<UserResponse>>> findAll(){
        DeferredResult<ResponseEntity<List<UserResponse>>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok(userService.findAll()));
        return dr;
    }
}
