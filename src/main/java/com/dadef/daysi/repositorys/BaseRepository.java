package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.BaseEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.stereotype.Repository;

import java.io.*;
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

    protected void saveEntity(BaseEntity entity) throws IOException {
        ArrayList<BaseEntity> entityList = getEntities();

        entityList.add(entity);

        writeToJsonFile(entityList);
    }

    protected ArrayList<BaseEntity> getEntities() throws FileNotFoundException {
        objectMapper.registerModule(new JavaTimeModule());
        JSONParser parser = new JSONParser(new FileReader(databasePath));

        try {
            return (ArrayList<BaseEntity>) parser.parse();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    protected <T> void writeToJsonFile(ArrayList<T> newEntities){
        String jsonString = "";

        try {
            jsonString  = objectMapper.writeValueAsString(newEntities);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        FileWriter file = null;
        try {
            file = new FileWriter(databasePath);
            file.write(jsonString);
            file.flush();
            file.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
