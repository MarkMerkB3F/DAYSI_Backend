package com.dadef.daysi.controller;

import com.dadef.daysi.dtos.TodoDTO;
import com.dadef.daysi.entities.Todo;
import com.dadef.daysi.mapper.BigChug;
import com.dadef.daysi.repositorys.TodoRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        List<Todo> todos = repository.getAllTodos();
        List<TodoDTO> todoDTOS = new ArrayList<TodoDTO>(todos.size());
        for (Todo todo : todos) {
            todoDTOS.add(bigChug.mapTodoEntityToTodoDto(todo));
        }
        System.out.println("Alle vorhandenen Todos wurden versendet");
        return todoDTOS;
    }

    @PostMapping("/todos")
    public HttpStatus saveTodo(@RequestBody TodoDTO todoDto) throws IOException {
        repository.saveTodo(bigChug.mapTodoDtoToTodoEntity(todoDto));
        System.out.println("Das erhaltene Todo wurden gespeichert");
        return HttpStatus.OK;
    }

    @PutMapping("/todos")
    public HttpStatus updateTodo(@RequestBody TodoDTO todoDto) throws ExecutionControl.NotImplementedException, IOException {
        repository.updateTodo(bigChug.mapTodoDtoToTodoEntity(todoDto));
        System.out.println("Das erhaltene Todo wurde geupdated");
        return HttpStatus.OK;
    }

    @DeleteMapping("/todos")
    public HttpStatus deleteTodo(@RequestBody TodoDTO todoDTO) throws ExecutionControl.NotImplementedException, IOException {
        repository.deleteTodo(bigChug.mapTodoDtoToTodoEntity(todoDTO));
        System.out.println("Das entsprechende Todo wurde geloescht");
        return HttpStatus.OK;
    }
}
