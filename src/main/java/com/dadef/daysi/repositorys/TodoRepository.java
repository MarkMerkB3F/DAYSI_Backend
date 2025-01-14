package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Todo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class TodoRepository {
    public List<Todo> getAllTodos(){

        ArrayList<Todo> todoList = new ArrayList<Todo>();
        todoList.add(new Todo(UUID.randomUUID(),"Todo1","Ich muss was tun","Sonstiges"));
        todoList.add(new Todo(UUID.randomUUID(),"Retro","Patschi Patschi vom Rebadschi","Scrum"));
        todoList.add(new Todo(UUID.randomUUID(),"Lauchsuppe","Das Nielsferd steht am Herd","Kochen"));
        return todoList;
    }
}
