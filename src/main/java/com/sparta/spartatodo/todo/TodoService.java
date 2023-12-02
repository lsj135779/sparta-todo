package com.sparta.spartatodo.todo;

import com.sparta.spartatodo.user.User;
import com.sparta.spartatodo.user.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.RejectedExecutionException;

@Service
@RequiredArgsConstructor
public class TodoService {
    private  final TodoRepository todoRepository;

    public TodoResponseDto createTodo(TodoRequestDto todoRequestDto, User user) {
        Todo todo = new Todo(todoRequestDto);
        todo.setUser(user);

        todoRepository.save(todo);

        return new TodoResponseDto(todo);
    }

    public TodoResponseDto getTodoDto(Long todoId) {
        Todo todo = getTodo(todoId);
        return new TodoResponseDto(todo);
    }

    public Map<UserDto, List<TodoResponseDto>> getUserTodoMap() {
        Map<UserDto, List<TodoResponseDto>> userTodoMap = new HashMap<>();

        List<Todo> todoList = todoRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate")); // 작성일 기준 내림차순

        todoList.forEach(todo -> {
            var userDto = new UserDto(todo.getUser());
            var todoDto = new TodoResponseDto(todo);
            if (userTodoMap.containsKey(userDto)) {
                // 유저 할일목록에 항목을 추가
                userTodoMap.get(userDto).add(todoDto);
            } else {
                // 유저 할일목록을 새로 추가
                userTodoMap.put(userDto, new ArrayList<>(List.of(todoDto)));
            }
        });

        return userTodoMap;
    }

    @Transactional
    public TodoResponseDto updateTodo(Long todoId, TodoRequestDto todoRequestDTO, User user) {
        Todo todo = getUserTodo(todoId, user);

        todo.setTitle(todoRequestDTO.getTitle());
        todo.setContent(todoRequestDTO.getContent());

        return new TodoResponseDto(todo);
    }

    @Transactional
    public TodoResponseDto competeTodo(Long todoId, User user) {
        Todo todo = getUserTodo(todoId, user);

        todo.complete(); // 완료 처리

        return new TodoResponseDto(todo);
    }



    public Todo getTodo(Long todoId) {

        return todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할일 ID 입니다."));
    }

    public Todo getUserTodo(Long todoId, User user) {
        Todo todo = getTodo(todoId);

        if(!(user.getId() == todo.getUser().getId())) {
            throw new RejectedExecutionException("작성자만 수정할 수 있습니다.");
        }
        return todo;
    }
}
