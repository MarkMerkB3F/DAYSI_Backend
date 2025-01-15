package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Appointment;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Repository
public class AppointmentRepository {
    public List<Appointment> getAllAppointments(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        try {
            return objectMapper.readValue(new File("C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Appointments.json"), new TypeReference<List<Appointment>>(){});
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
