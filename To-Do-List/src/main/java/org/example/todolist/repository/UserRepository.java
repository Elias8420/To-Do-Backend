package org.example.todolist.repository;

import org.example.todolist.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository // Marca la interfaz como un DAO, encargandose de la interaccion con la DB
public interface UserRepository extends JpaRepository<User, UUID> {
    Boolean existsByEmail(String email);
}
