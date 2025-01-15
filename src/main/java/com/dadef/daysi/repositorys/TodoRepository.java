package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Todo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class TodoRepository {
    ObjectMapper objectMapper = new ObjectMapper();

    public List<Todo> getAllTodos(){
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(new File("C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Todos.json"), new TypeReference<List<Todo>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveTodos(Todo todo) throws IOException {
        //objectMapper.writeValue(new File("C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Todos.json"), todo);
        //Todo: todo in Json File ueberfuehren, ohne sie zu ueberschreiben
    }
}
