package org.example.todolist.domain.dto.response.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ApiErrorResponse {
    private Object message;
    private int status;
    private LocalDate time;
    private String uri;
}
