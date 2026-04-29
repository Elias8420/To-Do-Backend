package org.example.todolist.service;

import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.domain.dto.response.user.PageableResponse;
import org.example.todolist.domain.dto.response.user.UserResponse;
import org.springframework.data.domain.Pageable;

public interface UserService {
    void createUser(CreateUserRequest createUserRequest);
    PageableResponse<UserResponse> getAllUsers(Pageable pageable);
}
