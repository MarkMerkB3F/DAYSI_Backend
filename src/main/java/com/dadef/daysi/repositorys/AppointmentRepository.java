package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Appointment;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;

@Repository
public class AppointmentRepository extends BaseRepository {
    AppointmentRepository(){
        databasePath = "C:/Users/iansc/OneDrive/Desktop/Berufsschule/3.Lehrjahr/Projektwoche/daysi/src/main/java/mockdata/Appointments.json";
    }

    public List<Appointment> getAllAppointments() {
        return objectMapper.convertValue(getAllEntities(), new TypeReference<List<Appointment>>() { });
    }

    public void saveAppointment(Appointment appointment) throws IOException {
        saveEntity(appointment);
    }
}
