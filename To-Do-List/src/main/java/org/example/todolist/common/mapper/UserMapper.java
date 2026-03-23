package org.example.todolist.common.mapper;

import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.domain.entities.User;

public class UserMapper {
    public static User toEntityCreate(CreateUserRequest createUserRequest) {
        return User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .image(createUserRequest.getImage())
                .build();
    }
}
