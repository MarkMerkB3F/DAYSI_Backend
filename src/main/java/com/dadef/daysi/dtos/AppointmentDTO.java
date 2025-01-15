package com.dadef.daysi.dtos;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

@Data
public class AppointmentDTO {
    private UUID Id;
    private String Title;
    private LocalDateTime StartTimeStamp;
    private LocalDateTime EndTimeStamp;
    private ArrayList<String> Participants;
    private String Location;
}
