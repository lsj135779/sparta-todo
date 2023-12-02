package com.sparta.spartatodo.comment;

import com.sparta.spartatodo.todo.Todo;
import com.sparta.spartatodo.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "todo_id")
    private Todo todo;

    @Column
    private LocalDateTime createDate;

    public Comment(CommentRequestDto dto) {
        this.text = dto.getText();
        this.createDate = LocalDateTime.now();
    }

    // 연관관계 편의 메서드
    public void setUser(User user) {
        this.user = user;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
        todo.getComments().add(this);
    }

    // 서비스 메서드
    public void setText(String text) {
        this.text = text;
    }
}
