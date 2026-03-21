package org.example.todolist.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity // Le indica a spring que es una entidad
@Table(name = "users") // Nombre con el que aparece en la base de datos
@Data // Genera los getters y setters de la clase
@Builder // Permite construir objetos de eata clase de forma mas comoda
@AllArgsConstructor //Genera un constructor con todos los campos de la clase
@NoArgsConstructor //Genera un constructor vacio de la clase
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "name")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}
