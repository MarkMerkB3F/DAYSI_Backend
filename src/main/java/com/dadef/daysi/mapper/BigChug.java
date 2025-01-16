package com.dadef.daysi.mapper;

import com.dadef.daysi.dtos.TodoDTO;
import com.dadef.daysi.entities.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface BigChug {
    @Mapping(target = "Id", source = "todo.Id")
    @Mapping(target = "Title", source = "todo.Title")
    TodoDTO mapTodoEntityToTodoDto(Todo todo);
}
