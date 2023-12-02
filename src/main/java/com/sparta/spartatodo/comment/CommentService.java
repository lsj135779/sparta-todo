package com.sparta.spartatodo.comment;

import com.sparta.spartatodo.todo.Todo;
import com.sparta.spartatodo.todo.TodoService;
import com.sparta.spartatodo.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.RejectedExecutionException;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final TodoService todoService;

    public CommentResponseDto createComment(CommentRequestDto commentRequestDTO, User user) {
        Todo todo = todoService.getTodo(commentRequestDTO.getTodoId());

        Comment comment = new Comment(commentRequestDTO);
        comment.setUser(user);
        comment.setTodo(todo);

        commentRepository.save(comment);

        return new CommentResponseDto(comment);
    }


    public CommentResponseDto updateComment(Long commentId, CommentRequestDto commentRequestDto, User user) {
        Comment comment = getUserComment(commentId, user);

        comment.setText(commentRequestDto.getText());

        return new CommentResponseDto(comment);
    }

    public void deleteComment(Long commentId, User user) {
        Comment comment = getUserComment(commentId, user);

        commentRepository.delete(comment);
    }

    private Comment getUserComment(Long commentId, User user) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 댓글 ID 입니다."));

        if(!(user.getId() == (comment.getUser().getId()))) {
            throw new RejectedExecutionException("작성자만 수정할 수 있습니다.");
        }
        return comment;
    }
}
