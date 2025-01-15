package com.dadef.daysi.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Data
public class Appointment extends BaseEntity {

    public Appointment(UUID todoId, String title, LocalDateTime startTimeStamp, LocalDateTime endTimeStamp, ArrayList<String> participants, String location) {
        Id = todoId;
        Title = title;
        StartTimeStamp = startTimeStamp;
        EndTimeStamp = endTimeStamp;
        Participants = participants;
        Location = location;
    }

    private LocalDateTime StartTimeStamp;
    private LocalDateTime EndTimeStamp;
    private ArrayList<String> Participants;
    private String Location;
}
