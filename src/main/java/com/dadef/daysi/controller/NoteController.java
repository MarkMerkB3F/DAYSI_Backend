package com.dadef.daysi.controller;

import com.dadef.daysi.dtos.AppointmentDTO;
import com.dadef.daysi.dtos.NoteDTO;
import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.entities.Note;
import com.dadef.daysi.mapper.BigChug;
import com.dadef.daysi.repositorys.NoteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
        System.out.println("Alle vorhandenen Notizen wurden versendet");
        List<Note> notes = repository.getAllNotes();
        List<NoteDTO> noteDtos = new ArrayList<NoteDTO>(notes.size());
        for (Note note : notes) {
            noteDtos.add(bigChug.mapNoteEntityToNoteDto(note));
        }
        return noteDtos;
    }
}
