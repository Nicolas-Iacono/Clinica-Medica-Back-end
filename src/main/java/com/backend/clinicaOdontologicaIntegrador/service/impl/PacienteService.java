package com.backend.clinicaOdontologicaIntegrador.service.impl;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.DomicilioEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Domicilio;
import com.backend.clinicaOdontologicaIntegrador.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologicaIntegrador.utils.JsonPrinter;
import com.backend.clinicaOdontologicaIntegrador.utils.ModelMapperConfig;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.paciente.PacienteEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Paciente;
import com.backend.clinicaOdontologicaIntegrador.repository.IPacienteRepository;
import com.backend.clinicaOdontologicaIntegrador.service.IPacienteService;
//import com.backend.clinicaOdontologicaIntegrador.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import static java.util.Arrays.stream;

@Service
public class PacienteService implements IPacienteService {

    private final Logger LOGGER = LoggerFactory.getLogger(PacienteService.class);
    private IPacienteRepository pacienteRepository;
    private ModelMapper modelMapper;


    public PacienteService(IPacienteRepository pacienteRepository, ModelMapper modelMapper) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public PacienteSalidaDto registrarPaciente(PacienteEntradaDto paciente) {

        LOGGER.info("PacienteEntradaDto: " + JsonPrinter.toString(paciente));


      LOGGER.info("PacienteEntradaDto: " + paciente);
        Paciente pacienteEntidad = modelMapper.map(paciente, Paciente.class);
        LOGGER.info("PacienteEntidad: " + JsonPrinter.toString(pacienteEntidad));

        Paciente pacienteAPersistir = pacienteRepository.save(pacienteEntidad);
        LOGGER.info("PacienteAPersistir: " + JsonPrinter.toString(pacienteAPersistir));

        PacienteSalidaDto pacienteSalidaDto = modelMapper.map(pacienteAPersistir, PacienteSalidaDto.class);
        LOGGER.info("PacienteSalidaDto: " + JsonPrinter.toString(pacienteSalidaDto));
//     LOGGER.info("PacienteSalidaDto: " + pacienteSalidaDto);


        return pacienteSalidaDto;
    }

    @Override
    public List<PacienteSalidaDto> listarPacientes() {
        List<PacienteSalidaDto> pacientesSalidaDto = pacienteRepository.findAll()
                .stream()
                .map(paciente -> modelMapper.map(paciente, PacienteSalidaDto.class))
                .collect(Collectors.toList());

        if (LOGGER.isInfoEnabled()) {
            LOGGER.info("Listado de todos los pacientes: {}", JsonPrinter.toString(pacientesSalidaDto));
        LOGGER.info("Listado de todos los pacientes: {}", pacientesSalidaDto);

        }

        return pacientesSalidaDto;
    }

    @Override
    public PacienteSalidaDto buscarPacientePorId(Long id) {
        Paciente pacienteBuscado = pacienteRepository.findById(id).orElse(null);
        PacienteSalidaDto pacienteEncontado = null;

        if(pacienteBuscado != null){
            pacienteEncontado = modelMapper.map(pacienteBuscado, PacienteSalidaDto.class);
            LOGGER.info("Paciente encontrado: ", JsonPrinter.toString(pacienteEncontado));
            LOGGER.info("Paciente encontrado: ", pacienteEncontado);

        } else LOGGER.error("El id no se encuentra registrado.");

        return pacienteEncontado;
    }

    @Override
    public PacienteSalidaDto actaulizarPaciente(PacienteModificacionEntradaDto paciente) {
        Paciente pacienteRecibido = modelMapper.map(paciente, Paciente.class);
        Paciente pacienteAActualizar = pacienteRepository.findById(pacienteRecibido.getId()).orElse(null);

        PacienteSalidaDto pacienteSalidaDto = null;

        if(pacienteAActualizar != null){
            pacienteAActualizar = pacienteRecibido;
            pacienteRepository.save(pacienteAActualizar);

            pacienteSalidaDto = modelMapper.map(pacienteAActualizar, PacienteSalidaDto.class);
            LOGGER.warn("Paciente actualizado : ", JsonPrinter.toString(pacienteSalidaDto));
            LOGGER.warn("Paciente actualizado : ", pacienteSalidaDto);

        }else{
            LOGGER.error("No fue posible actualizar el registro, intenete nuevamente...");
        }

        return pacienteSalidaDto;
    }

    @Override
    public void eliminarPaciente(Long id) throws ResourceNotFoundException {
        if (pacienteRepository.findById(id).orElse(null) != null) {
            pacienteRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el paciente con id: {}", id);
        } else {
            LOGGER.error("No se ha encontrado el paciente con id {}", id);
            throw new ResourceNotFoundException("No se ha encontrado el paciente con el id: " + id);

        }
    }



    private void configureMapping() {
        modelMapper.typeMap(PacienteEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteEntradaDto::getDomicilioEntradaDto, Paciente::setDomicilio));
        modelMapper.typeMap(Paciente.class, PacienteSalidaDto.class)
                .addMappings(modelMapper -> modelMapper.map(Paciente::getDomicilio, PacienteSalidaDto::setDomicilioSalidaDto));
        modelMapper.typeMap(PacienteModificacionEntradaDto.class, Paciente.class)
                .addMappings(mapper -> mapper.map(PacienteModificacionEntradaDto::getDomicilioModificacionEntradaDto, Paciente::setDomicilio));

    }
}
