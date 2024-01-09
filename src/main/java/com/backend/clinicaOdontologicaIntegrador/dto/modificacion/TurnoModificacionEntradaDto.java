package com.backend.clinicaOdontologicaIntegrador.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@JsonIgnoreProperties(ignoreUnknown = true)
public class TurnoModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id del turno que se desea modificar")
    private Long id;
    @NotNull(message = "La fecha y la hora del turno no pueden ser nulos")
    @NotBlank(message = "Debe especificarse la fecha y la hora del turno")
    private LocalDateTime fechaYHora;
    @NotNull(message = "El odontologo del turno no puede ser nulo")
    @Valid
    private OdontologoModificacionEntradaDto odontologoModificacionEntradaDto;
    @NotNull(message = "El paciente del turno no puede ser nulo")
    @Valid
    private PacienteModificacionEntradaDto pacienteModificacionEntradaDto;

    public TurnoModificacionEntradaDto() {
    }

    public TurnoModificacionEntradaDto(Long id, LocalDateTime fechaYHora, OdontologoModificacionEntradaDto odontologoModificacionEntradaDto, PacienteModificacionEntradaDto pacienteModificacionEntradaDto) {
        this.id = id;
        this.fechaYHora = fechaYHora;
        this.odontologoModificacionEntradaDto = odontologoModificacionEntradaDto;
        this.pacienteModificacionEntradaDto = pacienteModificacionEntradaDto;
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

    public OdontologoModificacionEntradaDto getOdontologoModificacionEntradaDto() {
        return odontologoModificacionEntradaDto;
    }

    public void setOdontologoModificacionEntradaDto(OdontologoModificacionEntradaDto odontologoModificacionEntradaDto) {
        this.odontologoModificacionEntradaDto = odontologoModificacionEntradaDto;
    }

    public PacienteModificacionEntradaDto getPacienteModificacionEntradaDto() {
        return pacienteModificacionEntradaDto;
    }

    public void setPacienteModificacionEntradaDto(PacienteModificacionEntradaDto pacienteModificacionEntradaDto) {
        this.pacienteModificacionEntradaDto = pacienteModificacionEntradaDto;
    }
}
