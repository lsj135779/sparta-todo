package com.sparta.spartatodo.todo;

import com.sparta.spartatodo.user.UserDto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoListResponseDto {
    private UserDto user;
    private List<TodoResponseDto> todoList;

    public TodoListResponseDto(UserDto user, List<TodoResponseDto> todoList) {
        this.user = user;
        this.todoList = todoList;
    }
}
