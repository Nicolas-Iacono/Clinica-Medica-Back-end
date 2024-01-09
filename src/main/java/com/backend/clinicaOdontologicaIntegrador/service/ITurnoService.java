package com.backend.clinicaOdontologicaIntegrador.service;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.exceptions.BadRequestException;

import java.util.List;

public interface ITurnoService {

    TurnoSalidaDto registrarTurno(TurnoEntradaDto turno)throws BadRequestException;

    List<TurnoSalidaDto> listarTurnos();

    TurnoSalidaDto buscarTurnoPorId(Long id);

    TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turno);

    void eliminarTurno(Long id);

}
