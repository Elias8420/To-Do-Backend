package org.example.todolist.service;

import org.example.todolist.domain.dto.request.user.CreateUserRequest;

public interface UserService {
    void createUser(CreateUserRequest createUserRequest);
}
