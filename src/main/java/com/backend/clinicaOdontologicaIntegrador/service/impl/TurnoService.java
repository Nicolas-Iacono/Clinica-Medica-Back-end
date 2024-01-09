package com.backend.clinicaOdontologicaIntegrador.service.impl;
import com.backend.clinicaOdontologicaIntegrador.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno.TurnoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno.TurnoOdontologo;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.turno.TurnoPaciente;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.TurnoModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.turno.OdontologoTurnoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.turno.PacienteTurnoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.turno.TurnoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.odontologo.Odontologo;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Paciente;
import com.backend.clinicaOdontologicaIntegrador.entity.turno.Turno;
import com.backend.clinicaOdontologicaIntegrador.repository.IOdontologoRepository;
import com.backend.clinicaOdontologicaIntegrador.repository.IPacienteRepository;
import com.backend.clinicaOdontologicaIntegrador.repository.ITurnoRepository;
import com.backend.clinicaOdontologicaIntegrador.service.IOdontologoService;
import com.backend.clinicaOdontologicaIntegrador.service.ITurnoService;
import com.backend.clinicaOdontologicaIntegrador.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class TurnoService implements ITurnoService {
    private final Logger LOGGER = LoggerFactory.getLogger(TurnoService.class);


    private final ITurnoRepository turnoRepository;
    private final ModelMapper modelMapper;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    public TurnoService(ITurnoRepository turnoRepository, ModelMapper modelMapper, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.modelMapper = modelMapper;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;

    }

    @Override
    public TurnoSalidaDto registrarTurno(TurnoEntradaDto turnoEntradaDto) throws BadRequestException {
        TurnoSalidaDto turnoSalidaDto;

        PacienteSalidaDto paciente = pacienteService.buscarPacientePorId(turnoEntradaDto.getIdPaciente());
        OdontologoSalidaDto odontologo = odontologoService.buscarOdontologoPorId(turnoEntradaDto.getIdOdontologo());

        String pacienteNoEnBdd = "El paciente no se encuentra en nuestra base de datos";
        String odontologoNoEnBdd = "El odontologo no se encuentra en nuestra base de datos";

        if (paciente == null || odontologo == null) {
            if (paciente == null && odontologo == null) {
                LOGGER.error("El paciente y el odontologo no se encuentran en nuestra base de datos");
                throw new BadRequestException("El paciente y el odontologo no se encuentran en nuestra base de datos");
            } else if (paciente == null) {
                LOGGER.error(pacienteNoEnBdd);
                throw new BadRequestException(pacienteNoEnBdd);
            } else {
                LOGGER.error(odontologoNoEnBdd);
                throw new BadRequestException(odontologoNoEnBdd);
            }
        } else {

            Turno turnoNuevo = turnoRepository.save(modelMapper.map(turnoEntradaDto, Turno.class));
            turnoSalidaDto = entidadADto(turnoNuevo);

            LOGGER.info("Nuevo turno registrado con exito: {}", turnoSalidaDto);
        }

        return turnoSalidaDto;
    }


    @Override
    public List<TurnoSalidaDto> listarTurnos() {
        List<TurnoSalidaDto> turnosSalidaDto = turnoRepository.findAll()
                .stream()
                .map(turno -> modelMapper.map(turno, TurnoSalidaDto.class))
                .collect(Collectors.toList());

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Listado de pacientes: {}", turnosSalidaDto);
        }

        return turnosSalidaDto;
    }

    @Override
    public TurnoSalidaDto buscarTurnoPorId(Long id) {

        Turno turnoBuscado = turnoRepository.findById(id).orElse(null);

        TurnoSalidaDto turnoEncontrado = null;

        if (turnoBuscado != null) {
            turnoEncontrado = modelMapper.map(turnoBuscado, TurnoSalidaDto.class);
            LOGGER.info("Turno Encontrado: ", turnoEncontrado);
        } else {
            LOGGER.error("El turno con el id solicitado no se encuentra registrado..");
        }
        return turnoEncontrado;
    }

    @Override
    public TurnoSalidaDto actualizarTurno(TurnoModificacionEntradaDto turno) {
        Turno turnoRecibido = modelMapper.map(turno, Turno.class);
        Turno turnoAActualizar = turnoRepository.findById(turnoRecibido.getId()).orElse(null);

        TurnoSalidaDto turnoSalidaDto = null;

        if (turnoAActualizar != null) {
            turnoAActualizar = turnoRecibido;
            turnoRepository.save(turnoAActualizar);
            turnoSalidaDto = modelMapper.map(turnoAActualizar, TurnoSalidaDto.class);

            LOGGER.warn("turno actualizado: ", turnoSalidaDto);
        } else {
            LOGGER.error("No fue posible actualizar el registro");
        }
        return turnoSalidaDto;
    }

    @Override
    public void eliminarTurno(Long id) {
        if (turnoRepository.findById(id).orElse(null) != null) {
            turnoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el turno con el id: {} ", id);
        }
    }

    private PacienteTurnoSalidaDto pacienteSalidaDtoASalidaTurnoDto(Long id) {
        return modelMapper.map(pacienteService.buscarPacientePorId(id), PacienteTurnoSalidaDto.class);
    }

    private OdontologoTurnoSalidaDto odontologoSalidaDtoASalidaTurnoDto(Long id) {
        return modelMapper.map(odontologoService.buscarOdontologoPorId(id), OdontologoTurnoSalidaDto.class);
    }

    private TurnoSalidaDto entidadADto(Turno turno){

        TurnoSalidaDto turnoSalidaDto = modelMapper.map(turno, TurnoSalidaDto.class);
        turnoSalidaDto.setPacienteTurnoSalidaDto(pacienteSalidaDtoASalidaTurnoDto(turno.getPaciente().getId()));
        turnoSalidaDto.setOdontologoTurnoSalidaDto(odontologoSalidaDtoASalidaTurnoDto(turno.getOdontologo().getId()));
        return turnoSalidaDto;
    }



}
