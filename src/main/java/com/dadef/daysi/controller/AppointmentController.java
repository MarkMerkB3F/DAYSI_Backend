package com.dadef.daysi.controller;

import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.entities.Todo;
import com.dadef.daysi.repositorys.AppointmentRepository;
import com.dadef.daysi.repositorys.TodoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {
    private final AppointmentRepository repository;

    AppointmentController(AppointmentRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/appointments")
    public List<Appointment> getAllTodos(){
        System.out.println("Alle vorhandenen Termine wurden versendet");
        return repository.getAllAppointments();
    }
}
