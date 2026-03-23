package org.example.todolist.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.repository.UserRepository;
import org.example.todolist.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {

    }
}
