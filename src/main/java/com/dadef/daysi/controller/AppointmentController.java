package com.dadef.daysi.controller;

import com.dadef.daysi.dtos.AppointmentDTO;
import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.mapper.BigChug;
import com.dadef.daysi.repositorys.AppointmentRepository;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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

    @PostMapping("/appointments")
    public HttpStatus saveAppointment(@RequestBody AppointmentDTO appointmentDTO) throws IOException {
        repository.saveAppointment(bigChug.mapAppointmentDtoToAppointmentEntity(appointmentDTO));
        System.out.println("Der erhaltene Termin wurden gespeichert");
        return HttpStatus.OK;
    }

    @PutMapping("/appointments")
    public HttpStatus updateAppointment(@RequestBody AppointmentDTO appointmentDTO) throws ExecutionControl.NotImplementedException, IOException {
        repository.updateAppointment(bigChug.mapAppointmentDtoToAppointmentEntity(appointmentDTO));
        System.out.println("Der erhaltene Termin wurde geupdated");
        return HttpStatus.OK;
    }

    @DeleteMapping("/appointments")
    public HttpStatus deleteAppointment(@RequestBody AppointmentDTO appointmentDTO) throws ExecutionControl.NotImplementedException, IOException {
        repository.deleteAppointment(bigChug.mapAppointmentDtoToAppointmentEntity(appointmentDTO));
        System.out.println("Der entsprechende Termin wurde geloescht");
        return HttpStatus.OK;
    }
}
