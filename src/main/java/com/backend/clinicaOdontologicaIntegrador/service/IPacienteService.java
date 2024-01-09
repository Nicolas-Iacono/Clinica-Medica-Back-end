package com.backend.clinicaOdontologicaIntegrador.service;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Paciente;
import com.backend.clinicaOdontologicaIntegrador.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IPacienteService {

    PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente);
    List<PacienteSalidaDto> listarPacientes();
    PacienteSalidaDto buscarPacientePorId(Long id);

    PacienteSalidaDto actaulizarPaciente(PacienteModificacionEntradaDto paciente);

    void eliminarPaciente(Long id)  throws ResourceNotFoundException;


}
