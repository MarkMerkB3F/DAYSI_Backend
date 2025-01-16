package com.dadef.daysi.mapper;

import com.dadef.daysi.dtos.TodoDTO;
import com.dadef.daysi.entities.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BigChug {

    @Mapping(target = "category", source = "todo.category")
    TodoDTO mapTodoEntityToTodoDto(Todo todo);
}
