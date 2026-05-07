package org.example.todolist.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.todolist.common.mapper.UserMapper;
import org.example.todolist.domain.dto.request.user.CreateUserRequest;
import org.example.todolist.domain.dto.response.user.PageableResponse;
import org.example.todolist.domain.dto.response.user.UserResponse;
import org.example.todolist.exception.ResourceAlreadyExistException;
import org.example.todolist.exception.ResourceNotFoundException;
import org.example.todolist.repository.UserRepository;
import org.example.todolist.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static org.example.todolist.common.constants.EntitiesConstants.USER_ENTITY;
import static org.example.todolist.common.constants.ExceptionsMessageConstants.ALREADY_EXIST;
import static org.example.todolist.common.constants.ExceptionsMessageConstants.NOT_FOUND;

@Service // Marca la clase como parte de la logica de negocio
@RequiredArgsConstructor // Crea un constructor con parametros para cada campo
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUserRequest createUserRequest) {
        Boolean exist = userRepository.existsByEmail(createUserRequest.getEmail());

        if(exist) throw new ResourceAlreadyExistException(USER_ENTITY+ALREADY_EXIST);

        userRepository.save(userMapper.toEntityCreate(createUserRequest));
    }

    @Override
    //Se le pasa un pageable con la cantida, numero, etc para retornar
    public PageableResponse<UserResponse> getAllUsers(Pageable pageable) {
        //Al buscar en el repositorio en la query establecera las condiciones que se le pasa en el pageable

        Page<UserResponse> userPage = userMapper.toDtoList(userRepository.findAll(pageable));
        //Valida si hay usuario o no con la cantidad de elementos
        if(userPage.getTotalElements() == 0)
            throw new ResourceNotFoundException(USER_ENTITY+NOT_FOUND);
        
        return PageableResponse.<UserResponse>builder()
                .content(userPage.getContent())
                .page(userPage.getNumber())
                .size(userPage.getSize())
                .totalElements(userPage.getTotalElements())
                .last(userPage.isLast())
                .build();
    }
}
