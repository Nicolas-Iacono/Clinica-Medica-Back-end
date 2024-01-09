package com.backend.clinicaOdontologicaIntegrador.service;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.exceptions.ResourceNotFoundException;

import java.util.List;

public interface IOdontologoService {


    OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo);
    List<OdontologoSalidaDto> listarOdontologos();
    OdontologoSalidaDto buscarOdontologoPorId(Long id);

    OdontologoSalidaDto actaulizarOdontologo(OdontologoModificacionEntradaDto odontologo);

    void eliminarOdontologo(Long id)  throws ResourceNotFoundException;
}
