package org.example.todolist.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.todolist.common.mapper.UserMapper;
import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.exception.ResourceAlreadyExistException;
import org.example.todolist.repository.UserRepository;
import org.example.todolist.service.UserService;
import org.springframework.stereotype.Service;

import static org.example.todolist.common.constants.EntitiesConstants.USER_ENTITY;
import static org.example.todolist.common.constants.ExceptionsMessageConstants.ALREADY_EXIST;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        Boolean exist = userRepository.existsByEmail(createUserRequest.getEmail());

        if(exist) throw new ResourceAlreadyExistException(USER_ENTITY+ALREADY_EXIST);

        userRepository.save(userMapper.toEntityCreate(createUserRequest));
    }
}
