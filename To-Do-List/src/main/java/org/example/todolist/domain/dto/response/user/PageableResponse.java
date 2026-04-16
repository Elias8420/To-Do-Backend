package org.example.todolist.domain.dto.response.user;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PageableResponse<T> {
    private List<T> content;
    private int page;
    private int size;
    private int totalElements;
    private int totalPages;
    private boolean last;
}
