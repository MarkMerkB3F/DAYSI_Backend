package com.dadef.daysi.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import java.util.UUID;

@Entity
@Data
public class Todo extends BaseEntity{

    public Todo(){}

    public Todo(UUID todoId, String title, String content, String category) {
        Id = todoId;
        Title = title;
        Content = content;
        Category = category;
    }

    private String Content;
    private String Category;
}
