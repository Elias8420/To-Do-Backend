package org.example.todolist.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.domain.dto.response.user.GeneralResponse;
import org.example.todolist.service.impl.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.time.LocalDateTime;

import static org.example.todolist.common.constants.EndpointsConstants.*;
import static org.example.todolist.common.constants.ResponseMessageConstants.*;

@RestController
@RequestMapping(BASE_URL+USERS_ENDPOINT)
@AllArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping(CREATE_PATH)
    public ResponseEntity<GeneralResponse> createUser(@RequestBody @Valid CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
        return buildResponse(USER+CREATED+SUCCESS, HttpStatus.CREATED, null);
    }

    public ResponseEntity<GeneralResponse> buildResponse(String message, HttpStatus status, Object data) {
        String uri = ServletUriComponentsBuilder.fromCurrentRequestUri().build().getPath();
        return ResponseEntity
                .status(status)
                .body(GeneralResponse.builder()
                        .uri(uri)
                        .message(message)
                        .status(status.value())
                        .time(LocalDateTime.now())
                        .data(data)
                        .build()
                );
    }
}
