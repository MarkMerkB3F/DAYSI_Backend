package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Todo;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class TodoRepository extends BaseRepository {

    TodoRepository(){
        databasePath = "C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Todos.json";
    }

    public List<Todo> getAllTodos() {
        return objectMapper.convertValue(getAllEntities(), new TypeReference<List<Todo>>() { });
    }

    public void saveTodos(Todo todo) throws IOException {
        saveEntity(todo);
    }

}
