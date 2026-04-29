package org.example.todolist.common.mapper;

import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.domain.dto.response.user.UserResponse;
import org.example.todolist.domain.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toEntityCreate(CreateUserRequest createUserRequest) {
        return User.builder()
                .username(createUserRequest.getUsername())
                .email(createUserRequest.getEmail())
                .password(createUserRequest.getPassword())
                .image(createUserRequest.getImage())
                .build();
    }

    public UserResponse toDto(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getUsername())
                .email(user.getEmail())
                .image(user.getImage())
                .build();
    }

    public Page<UserResponse> toDtoList(Page<User> users) {
        return users.map(this::toDto);
    }
}
