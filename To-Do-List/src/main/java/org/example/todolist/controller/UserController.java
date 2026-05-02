package org.example.todolist.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.domain.dto.response.user.GeneralResponse;
import org.example.todolist.domain.dto.response.user.PageableResponse;
import org.example.todolist.domain.dto.response.user.UserResponse;
import org.example.todolist.service.impl.UserServiceImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping(GET_ALL_PATH)
    public ResponseEntity<GeneralResponse> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String sortOrder
    ) {
        Sort sort = sortOrder.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() :
                Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        PageableResponse<UserResponse> pagedResponse = userService.getAllUsers(pageable);
        return buildResponse(USER+FOUND, HttpStatus.OK, pagedResponse);
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
