package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Note;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class NoteRepository extends BaseRepository {

    NoteRepository(){
        databasePath = "C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Notes.json";
    }

    public List<Note> getAllNotes() {
        return objectMapper.convertValue(getAllEntities(), new TypeReference<List<Note>>() { });
    }

    public void saveNote(Note note) throws IOException {
        saveEntity(note);
    }
}
