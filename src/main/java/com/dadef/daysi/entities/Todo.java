package com.dadef.daysi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.util.UUID;


@Entity
@Data
public class Todo {

    public Todo(UUID todoId, String title, String content, String category) {
        TodoId = todoId;
        Title = title;
        Content = content;
        Category = category;
    }

    @Id
    private UUID TodoId;
    private String Title;
    private String Content;
    private String Category;
}
