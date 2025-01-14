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
@Getter
@Setter
public class Todo {
    @Id
    private UUID TodoId;
    private String Title;
    private String Content;
    private String Category;
}
