package com.dadef.daysi.controller;

import com.dadef.daysi.dtos.TodoDTO;
import com.dadef.daysi.entities.Todo;
import com.dadef.daysi.mapper.BigChug;
import com.dadef.daysi.repositorys.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class TodoController {
    private final TodoRepository repository;

    private final BigChug bigChug;

    public TodoController(TodoRepository repository, BigChug bigChug) {
        this.repository = repository;
        this.bigChug = bigChug;
    }

    @GetMapping("/todos")
    public List<TodoDTO> getAllTodos(){
        System.out.println("Alle vorhandenen Todos wurden versendet");
        List<Todo> todos = repository.getAllTodos();
        List<TodoDTO> todoDTOS = new ArrayList<TodoDTO>(todos.size());
        for (Todo todo : todos) {
            todoDTOS.add(bigChug.mapTodoEntityToTodoDto(todo));
        }
        return todoDTOS;
    }

    @PostMapping("/todos")
    public HttpStatus saveTodos(@RequestBody TodoDTO todoDto) throws IOException {
        System.out.println("Alle erhaltenen Todos wurden gespeichert");
        repository.saveTodos(bigChug.mapTodoDtoToTodoEntity(todoDto));
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
