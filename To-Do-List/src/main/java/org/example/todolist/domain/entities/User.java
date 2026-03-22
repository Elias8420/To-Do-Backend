package org.example.todolist.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static org.example.todolist.common.constants.DBNameConstants.*;

@Entity // Le indica a spring que es una entidad
@Table(name = USERTABLE) // Nombre con el que aparece en la base de datos
@Data // Genera los getters y setters de la clase
@Builder // Permite construir objetos de eata clase de forma mas comoda
@AllArgsConstructor //Genera un constructor con todos los campos de la clase
@NoArgsConstructor //Genera un constructor vacio de la clase
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID) // Genera un Id de forma secuencial automaticamente
    private UUID id;

    @Column(name = USERNAME)
    private String username;

    @Column(name = USEREMAIL)
    private String email;

    @Column(name = USERPASSWORD)
    private String password;

    @Column(name = USERIMAGE)
    private String image;
}
