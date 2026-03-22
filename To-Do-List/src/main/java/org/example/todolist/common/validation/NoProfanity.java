package org.example.todolist.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD}) // Le indica a spring que la anotacion se usa solo en atributos de clases
@Retention(RetentionPolicy.RUNTIME) // Le indica a spring cuando existe la anotacion
@Constraint(validatedBy = NoProfanityValidator.class) // Le indica a spring que clase contiene la logica de la anotacion
// El @ antes del interface le indica a Java que queremos crear una anotacion
public @interface NoProfanity {
    String message() default "Username contains invalid words";
    // Mensaje de error que se muestra por defecto si no cumple con la validacion

    Class<?>[] groups() default {};
    // Permite agrupar validaciones

    Class<? extends Payload>[] payload() default {};
    // Permite agregar metadata a la validacion
}
