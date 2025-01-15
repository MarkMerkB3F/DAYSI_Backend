package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Note;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class NoteRepository {
    public List<Note> getAllNotes(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(new File("C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Notes.json"), new TypeReference<List<Note>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
