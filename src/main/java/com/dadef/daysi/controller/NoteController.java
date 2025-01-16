package com.dadef.daysi.controller;

import com.dadef.daysi.entities.Note;
import com.dadef.daysi.repositorys.NoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NoteController {
    private final NoteRepository repository;

    NoteController(NoteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/notes")
    public List<Note> getAllNotes(){
        System.out.println("Alle vorhandenen Notizen wurden versendet");
        return repository.getAllNotes();
    }
}
