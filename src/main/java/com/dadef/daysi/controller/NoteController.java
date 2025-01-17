package com.dadef.daysi.controller;

import com.dadef.daysi.dtos.NoteDTO;
import com.dadef.daysi.entities.Note;
import com.dadef.daysi.mapper.BigChug;
import com.dadef.daysi.repositorys.NoteRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class NoteController {

    private final NoteRepository repository;
    private final BigChug bigChug;

    NoteController(NoteRepository repository, BigChug bigChug) {
        this.repository = repository;
        this.bigChug = bigChug;
    }

    @GetMapping("/notes")
    public List<NoteDTO> getAllNotes(){
        System.out.println("Alle vorhandenen Notes wurden versendet");
        List<Note> notes = repository.getAllNotes();
        List<NoteDTO> noteDtos = new ArrayList<NoteDTO>(notes.size());
        for (Note note : notes) {
            noteDtos.add(bigChug.mapNoteEntityToNoteDto(note));
        }
        return noteDtos;
    }

    @PostMapping("/notes")
    public HttpStatus saveNote(@RequestBody NoteDTO noteDto) throws IOException {
        repository.saveNote(bigChug.mapNoteDtoToNoteEntity(noteDto));
        System.out.println("Das erhaltene Note wurden gespeichert");
        return HttpStatus.OK;
    }

    @PutMapping("/notes")
    public HttpStatus updateNote(@RequestBody NoteDTO noteDto) throws ExecutionControl.NotImplementedException, IOException {
        repository.updateNote(bigChug.mapNoteDtoToNoteEntity(noteDto));
        System.out.println("Das erhaltene Note wurde geupdated");
        return HttpStatus.OK;
    }

    @DeleteMapping("/notes")
    public HttpStatus deleteNote(@RequestBody NoteDTO noteDto) throws ExecutionControl.NotImplementedException, IOException {
        repository.deleteNote(bigChug.mapNoteDtoToNoteEntity(noteDto));
        System.out.println("Das entsprechende Note wurde geloescht");
        return HttpStatus.OK;
    }
}
