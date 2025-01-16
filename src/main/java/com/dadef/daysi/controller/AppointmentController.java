package com.dadef.daysi.controller;

import com.dadef.daysi.dtos.AppointmentDTO;
import com.dadef.daysi.dtos.TodoDTO;
import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.entities.Todo;
import com.dadef.daysi.mapper.BigChug;
import com.dadef.daysi.repositorys.AppointmentRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppointmentController {
    private final AppointmentRepository repository;
    private final BigChug bigChug;

    AppointmentController(AppointmentRepository repository, BigChug bigChug) {
        this.repository = repository;
        this.bigChug = bigChug;
    }

    @GetMapping("/appointments")
    public List<AppointmentDTO> getAllAppointments(){
        System.out.println("Alle vorhandenen Termine wurden versendet");
        List<Appointment> appointments = repository.getAllAppointments();
        List<AppointmentDTO> appointmentDtos = new ArrayList<AppointmentDTO>(appointments.size());
        for (Appointment appointment : appointments) {
            appointmentDtos.add(bigChug.mapAppointmentEntityToAppointmentDto(appointment));
        }
        return appointmentDtos;
    }
}
