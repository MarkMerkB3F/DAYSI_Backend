package com.dadef.daysi.mapper;

import com.dadef.daysi.dtos.AppointmentDTO;
import com.dadef.daysi.dtos.NoteDTO;
import com.dadef.daysi.dtos.TodoDTO;
import com.dadef.daysi.entities.Appointment;
import com.dadef.daysi.entities.Note;
import com.dadef.daysi.entities.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BigChug {

    TodoDTO mapTodoEntityToTodoDto(Todo todo);

    Todo mapTodoDtoToTodoEntity(TodoDTO todoDto);

    NoteDTO mapNoteEntityToNoteDto(Note note);

    Note mapNoteDtoToNoteEntity(NoteDTO noteDto);

    AppointmentDTO mapAppointmentEntityToAppointmentDto(Appointment appointment);

    Appointment mapAppointmentDtoToAppointmentEntity(AppointmentDTO appointmentDto);
}
