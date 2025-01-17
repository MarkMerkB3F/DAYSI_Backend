package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.BaseEntity;
import com.dadef.daysi.entities.Note;
import com.fasterxml.jackson.core.type.TypeReference;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

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

    public void updateNote(Note note) throws IOException, ExecutionControl.NotImplementedException {
        var currentTodos = getEntities();
        ListIterator<BaseEntity> iterator =  currentTodos.listIterator();
        while (iterator.hasNext()) {
            Note next = objectMapper.convertValue(iterator.next(), new TypeReference<Note>(){ }) ;
            if ( next.getId().equals(note.getId())) {
                iterator.set(note);
            }
        }
        writeToJsonFile(currentTodos);
    }

    public void deleteNote(Note note) throws IOException, ExecutionControl.NotImplementedException {
        var currentEntities= getEntities();
        ListIterator<BaseEntity> iterator =  currentEntities.listIterator();
        while (iterator.hasNext()) {
            Note next = objectMapper.convertValue(iterator.next(), new TypeReference<Note>(){ }) ;
            if (  next.getId().equals(note.getId())) {
                iterator.remove();
            }
        }
        writeToJsonFile(currentEntities);
    }
}
