package com.dadef.daysi.controller;

import com.dadef.daysi.entities.Todo;
import com.dadef.daysi.repositorys.TodoRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class TodoController {
    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        System.out.println("hat geklappt");
        return repository.getAllTodos();
    }
}
