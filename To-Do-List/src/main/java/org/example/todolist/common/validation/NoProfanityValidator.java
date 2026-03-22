package org.example.todolist.common.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.Set;

import static org.example.todolist.common.constants.BlockedWords.*;

@Component
public class NoProfanityValidator implements ConstraintValidator<NoProfanity, String> {
    private static final Set<String> BLOCKED_WORDS = Set.of(
            BAD_WORD1, BAD_WORD2, BAD_WORD3,
            BAD_WORD4, BAD_WORD5, BAD_WORD6,
            BAD_WORD7, BAD_WORD8, BAD_WORD9
    );

    @Override
    public void initialize(NoProfanity constraintAnnotation) {
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return true;

        String normalized = value.toLowerCase().trim();

        return BLOCKED_WORDS.stream()
                .noneMatch(normalized::contains);
    }
}
