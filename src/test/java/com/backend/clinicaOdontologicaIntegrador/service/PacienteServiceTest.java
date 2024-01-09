package com.backend.clinicaOdontologicaIntegrador.service;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.service.impl.PacienteService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    private PacienteService pacienteService;


    @Test
    @Order(1)
    void deberiaRegistrarUnPacienteDeNombreJuanYRetornarElId(){
        PacienteEntradaDto pacienteEntradaDto = new PacienteEntradaDto("Juan","Marquez",38394919, LocalDate.of(2024,10,22),
                new DomicilioEntradaDto("calle",2588,"quilmes","buenosAires"));

        PacienteSalidaDto pacienteSalidaDto = pacienteService.registrarPaciente(pacienteEntradaDto);

        assertNotNull(pacienteSalidaDto.getId());
        assertEquals("Juan", pacienteSalidaDto.getNombre());

    }

    @Test
    @Order(2)
    void alIntentarEliminarUnPacienteConElIdYaEliminado_deberiaLanzarUnaResoourceNotFoundException(){

    }


}
