package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.BaseEntity;
import com.dadef.daysi.entities.Todo;
import com.fasterxml.jackson.core.type.TypeReference;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

@Repository
public class TodoRepository extends BaseRepository {

    TodoRepository(){
        databasePath = "C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Todos.json";
    }

    public List<Todo> getAllTodos() {
        return objectMapper.convertValue(getAllEntities(), new TypeReference<List<Todo>>() { });
    }

    public void saveTodo(Todo todo) throws IOException {
        saveEntity(todo);
    }

    public void updateTodo(Todo todo) throws IOException, ExecutionControl.NotImplementedException {
        var currentTodos = getEntities();
        ListIterator<BaseEntity> iterator =  currentTodos.listIterator();
        while (iterator.hasNext()) {
            Todo next = objectMapper.convertValue(iterator.next(), new TypeReference<Todo>(){ }) ;
            if ( next.getId().equals(todo.getId())) {
                iterator.set(todo);
            }
        }
        writeToJsonFile(currentTodos);
    }

    public void deleteTodo(Todo todo) throws IOException, ExecutionControl.NotImplementedException {
        var currentEntities = getEntities();
        ListIterator<BaseEntity> iterator =  currentEntities.listIterator();
        while (iterator.hasNext()) {
            Todo next = objectMapper.convertValue(iterator.next(), new TypeReference<Todo>(){ }) ;
            if ( next.getId().equals(todo.getId())) {
                iterator.remove();
            }
        }
        writeToJsonFile(currentEntities);
    }

}
