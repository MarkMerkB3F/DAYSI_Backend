package com.dadef.daysi.dtos;

import lombok.Data;

import java.util.UUID;

@Data
public class TodoDTO {
    private UUID Id;
    private String Title;
    private String Content;
    private String Category;
}
