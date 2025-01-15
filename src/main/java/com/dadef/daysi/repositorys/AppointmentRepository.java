package com.dadef.daysi.repositorys;

import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.entities.Todo;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class AppointmentRepository {
    Appointment appointment = new Appointment(UUID.randomUUID(),"Daily", LocalDateTime.now(),LocalDateTime.now(),new ArrayList<>(),"Bielefeld");
    public List<Appointment> getAllAppointments(){
        ArrayList<Appointment> appointmentList = new ArrayList<Appointment>();
        appointmentList.add(appointment);
        appointmentList.add(appointment);
        appointmentList.add(appointment);
        return appointmentList;
    }
}
