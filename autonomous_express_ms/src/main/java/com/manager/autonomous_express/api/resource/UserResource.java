package com.manager.autonomous_express.api.resource;

import com.manager.autonomous_express.api.request.UserRequest;
import com.manager.autonomous_express.api.response.UserResponse;
import com.manager.autonomous_express.service.UserService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.UUID;

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

    @GetMapping("/{id}")
    public DeferredResult<ResponseEntity<UserResponse>> findById(@PathVariable UUID id){
        DeferredResult<ResponseEntity<UserResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok(userService.findById(id)));
        return dr;
    }

    @PostMapping("/save")
    public DeferredResult<ResponseEntity<UserResponse>> save(@Valid @RequestBody UserRequest request){
        DeferredResult<ResponseEntity<UserResponse>> dr = new DeferredResult<>();
        dr.setResult(ResponseEntity.ok().body(userService.save(request)));
        return dr;
    }
}
