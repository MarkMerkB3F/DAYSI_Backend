package com.dadef.daysi.entities;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Note extends BaseEntity{

    public Note(UUID todoId, String title, LocalDateTime creationDate, String content, String category) {
        Id = todoId;
        Title = title;
        CreationDate = creationDate;
        Content = content;
        Category = category;
    }

    private LocalDateTime CreationDate;
    private String Content;
    private String Category;
}
