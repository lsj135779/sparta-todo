package com.sparta.spartatodo.todo;

import com.sparta.spartatodo.CommonResponseDto;
import com.sparta.spartatodo.user.UserDto;

import java.time.LocalDateTime;

public class TodoResponseDto extends CommonResponseDto {
    private Long id;
    private String title;
    private String content;
    private Boolean isCompleted;
    private UserDto user;
    private LocalDateTime createDate;

    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.isCompleted = todo.getIsCompleted();
        this.user = new UserDto(todo.getUser());
        this.createDate = todo.getCreatedDate();
    }
}
