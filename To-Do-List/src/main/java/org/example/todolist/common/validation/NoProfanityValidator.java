package org.example.todolist.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Set;

import static org.example.todolist.common.constants.BlockedWords.*;

@Component // Lo registra como un bean para que lo gestione spring boot
// Lo que esta entre <> el primero indica la anotacion que valida y el segundo el tipo de dato que valida
public class NoProfanityValidator implements ConstraintValidator<NoProfanity, String> {
    // Set es similar a list, solo que no permite elementos duplicados y no permite buscar por indice, solo iterando
    // Lista de palabras bloqueadas
    private static final Set<String> BLOCKED_WORDS = Set.of(
            BAD_WORD1, BAD_WORD2, BAD_WORD3,
            BAD_WORD4, BAD_WORD5, BAD_WORD6,
            BAD_WORD7, BAD_WORD8, BAD_WORD9
    );

    @Override
    public void initialize(NoProfanity constraintAnnotation) {
        // Aqui se cargarian las palabras si las tuvieramos en un archivo o desde la DB
        // Pero de momento estan quemadas en la app, asi que, cosa para despues xd
    }

    @Override // Dentro de este metodo esta la logica de la validacion
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true; // Si va vacio indica que pasa la validacion, no le interesa si esta vacio o no
        // De eso se encargara otra anotacion

        // Para validar casos donde solo cambian mayusculas o minusculas
        String normalized = value.toLowerCase().trim();

        return BLOCKED_WORDS.stream() // Stream filtra una por una las palabras comparando el valor con los elementos de la lista
                .noneMatch(normalized::contains); // nonematch valida si ninguna palabra coincide, si ninguna coincide devuelve true
                // contains verifica que la palabra no se encuentre en medio del texto
    }
}
