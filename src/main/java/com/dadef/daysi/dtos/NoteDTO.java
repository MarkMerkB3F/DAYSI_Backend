package com.dadef.daysi.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class NoteDTO {
    private UUID Id;
    private String Title;
    private LocalDateTime CreationDate;
    private String Content;
    private String Category;
}
