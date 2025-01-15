package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TodoRepository {
    Todo todo = new Todo(UUID.randomUUID(),"Lauchsuppe","Das Nielsferd steht am Herd","Kochen");

    public List<Todo> getAllTodos(){
        ArrayList<Todo> todoList = new ArrayList<Todo>();
        todoList.add(todo);
        todoList.add(todo);
        todoList.add(todo);
        return todoList;
    }
}
