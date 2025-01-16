package com.dadef.daysi.repositorys;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BaseRepository {
    String databasePath = "";
    ObjectMapper objectMapper = new ObjectMapper();

    protected <T> List<T> getAllEntities(){
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(new File(databasePath), new TypeReference <List<T>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> void saveEntity(T entity) throws IOException {
        JSONParser parser = new JSONParser(new FileReader(databasePath));

        ArrayList<T> obj = null;
        try {
            obj = (ArrayList<T>) parser.parse();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        obj.add(entity);

        String jsonString = "";

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonString  = objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        WriteToJsonFile(jsonString);
    }


    void WriteToJsonFile(String inputData){
        FileWriter file = null;
        try {
            file = new FileWriter(databasePath);
            file.write(inputData);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
