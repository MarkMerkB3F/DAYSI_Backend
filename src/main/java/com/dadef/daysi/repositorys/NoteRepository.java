package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Note;
import com.dadef.daysi.entities.Todo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class NoteRepository {
    Note note = new Note(UUID.randomUUID(),"Notiz an mich", LocalDateTime.now(),"Frank Rosin ist fassungslos","Kochen");
    public List<Note> getAllNotes(){
        ArrayList<Note> todoList = new ArrayList<Note>();
        todoList.add(note);
        todoList.add(note);
        todoList.add(note);
        return todoList;
    }
}
