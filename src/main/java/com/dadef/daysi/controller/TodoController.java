package com.dadef.daysi.controller;

import com.dadef.daysi.entities.Todo;
import com.dadef.daysi.repositorys.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
public class TodoController {
    private final TodoRepository repository;

    TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/todos")
    public List<Todo> getAllTodos(){
        System.out.println("Alle vorhandenen Todos wurden versendet");
        return repository.getAllTodos();
    }

    @PostMapping("/todos")
    public HttpStatus saveTodos(@RequestBody Todo todo) throws IOException {
        System.out.println("Alle erhaltenen Todos wurden gespeichert");
        repository.saveTodos(todo);
        return HttpStatus.OK;
    }

    //@PutMapping("/todos")
    //public List<Todo> getAllTodos(){
    //    System.out.println("Alle vorhandenen Todos wurden versendet");
    //    return repository.getAllTodos();
    //}
//
    //@DeleteMapping("/todos")
    //public List<Todo> getAllTodos(){
    //    System.out.println("Alle vorhandenen Todos wurden versendet");
    //    return repository.getAllTodos();
    //}
}
