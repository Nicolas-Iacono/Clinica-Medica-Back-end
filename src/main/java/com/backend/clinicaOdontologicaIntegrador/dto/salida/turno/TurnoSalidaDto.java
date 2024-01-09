package com.backend.clinicaOdontologicaIntegrador.dto.salida.turno;

import com.backend.clinicaOdontologicaIntegrador.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.odontologo.Odontologo;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

public class TurnoSalidaDto {

    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime fechaYHora;
    private PacienteTurnoSalidaDto pacienteTurnoSalidaDto;
    private OdontologoTurnoSalidaDto odontologoTurnoSalidaDto;

    public TurnoSalidaDto() {
    }

    public TurnoSalidaDto(Long id, LocalDateTime fechaYHora, PacienteTurnoSalidaDto pacienteTurnoSalidaDto, OdontologoTurnoSalidaDto odontologoTurnoSalidaDto) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.pacienteTurnoSalidaDto = pacienteTurnoSalidaDto;
        this.odontologoTurnoSalidaDto = odontologoTurnoSalidaDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaYHora() {
        return fechaYHora;
    }

    public void setFechaYHora(LocalDateTime fechaYHora) {
        this.fechaYHora = fechaYHora;
    }

    public PacienteTurnoSalidaDto getPacienteTurnoSalidaDto() {
        return pacienteTurnoSalidaDto;
    }

    public void setPacienteTurnoSalidaDto(PacienteTurnoSalidaDto pacienteTurnoSalidaDto) {
        this.pacienteTurnoSalidaDto = pacienteTurnoSalidaDto;
    }

    public OdontologoTurnoSalidaDto getOdontologoTurnoSalidaDto() {
        return odontologoTurnoSalidaDto;
    }

    public void setOdontologoTurnoSalidaDto(OdontologoTurnoSalidaDto odontologoTurnoSalidaDto) {
        this.odontologoTurnoSalidaDto = odontologoTurnoSalidaDto;
    }
}
