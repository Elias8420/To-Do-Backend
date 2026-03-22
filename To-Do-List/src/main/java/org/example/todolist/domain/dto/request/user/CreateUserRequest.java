package org.example.todolist.domain.dto.request.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.todolist.common.validation.NoProfanity;

import static org.example.todolist.common.constants.ValidationMessages.*;
import static org.example.todolist.common.regexp.PasswordRegexp.REGEXP_PASSWORD;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserRequest {
    @NotBlank(message = USERNAME_EMPTY)
    @NoProfanity()
    private String username;

    @NotBlank(message = EMAIL_EMPTY)
    @Email(message = INVALID_EMAIL)
    private String email;

    @NotBlank(message = PASSWORD_EMPTY)
    @Pattern(regexp = REGEXP_PASSWORD, message = NOT_ALPHANUMERIC_PASSWORD)
    @Size(min = 4, message = NOT_LONG_PASSWORD)
    private String password;
}
