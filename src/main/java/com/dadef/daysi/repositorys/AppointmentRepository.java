package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.entities.BaseEntity;
import com.fasterxml.jackson.core.type.TypeReference;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.List;
import java.util.ListIterator;

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

    public void updateAppointment(Appointment appointment) throws IOException, ExecutionControl.NotImplementedException {
        var currentTodos = getEntities();
        ListIterator<BaseEntity> iterator =  currentTodos.listIterator();
        while (iterator.hasNext()) {
            Appointment next = objectMapper.convertValue(iterator.next(), new TypeReference<Appointment>(){ }) ;
            if ( next.getId().equals(appointment.getId())) {
                iterator.set(appointment);
            }
        }
        writeToJsonFile(currentTodos);
    }

    public void deleteAppointment(Appointment appointment) throws IOException, ExecutionControl.NotImplementedException {
        var currentEntities = getEntities();
        ListIterator<BaseEntity> iterator =  currentEntities.listIterator();
        while (iterator.hasNext()) {
            Appointment next = objectMapper.convertValue(iterator.next(), new TypeReference<Appointment>(){ }) ;
            if ( next.getId().equals(appointment.getId())) {
                iterator.remove();
            }
        }
        writeToJsonFile(currentEntities);
    }
}
