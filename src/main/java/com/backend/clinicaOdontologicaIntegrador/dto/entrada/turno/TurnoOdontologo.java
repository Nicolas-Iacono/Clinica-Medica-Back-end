package com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class TurnoOdontologo {

    private Long id;

    public TurnoOdontologo(Long id) {
        this.id = id;
    }

    public TurnoOdontologo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
