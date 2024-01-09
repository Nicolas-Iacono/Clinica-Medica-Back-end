package com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class TurnoPaciente {

    private Long id;

    public TurnoPaciente() {
    }

    public TurnoPaciente(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
