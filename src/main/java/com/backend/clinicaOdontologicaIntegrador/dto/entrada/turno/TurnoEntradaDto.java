package com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.odontologo.Odontologo;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class TurnoEntradaDto{
    @FutureOrPresent(message = "La fecha no puede ser anterior al día de hoy")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd HH:mm")
    private LocalDateTime fechaYhora;
    @NotNull(message = "Debe asignarse un odontologo por turno")
    @Valid
    @JsonProperty("odontologo_id")
    private Long idOdontologo;
    @NotNull(message = "Debe asignarse un paciente por turno")
    @Valid
    @JsonProperty("paciente_id")
    private Long idPaciente;


    public TurnoEntradaDto() {
    }

    public TurnoEntradaDto(LocalDateTime fechaYhora, Long idOdontologo, Long idPaciente) {
        this.fechaYhora = fechaYhora;
        this.idOdontologo = idOdontologo;
        this.idPaciente = idPaciente;
    }

    public LocalDateTime getFechaYhora() {
        return fechaYhora;
    }

    public void setFechaYhora(LocalDateTime fechaYhora) {
        this.fechaYhora = fechaYhora;
    }

    public Long getIdOdontologo() {
        return idOdontologo;
    }

    public void setIdOdontologo(Long idOdontologo) {
        this.idOdontologo = idOdontologo;
    }

    public Long getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(Long idPaciente) {
        this.idPaciente = idPaciente;
    }
}
