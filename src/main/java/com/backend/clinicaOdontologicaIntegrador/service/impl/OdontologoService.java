package com.backend.clinicaOdontologicaIntegrador.service.impl;

import com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.entity.odontologo.Odontologo;
import com.backend.clinicaOdontologicaIntegrador.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologicaIntegrador.repository.IOdontologoRepository;
import com.backend.clinicaOdontologicaIntegrador.service.IOdontologoService;
import com.backend.clinicaOdontologicaIntegrador.utils.JsonPrinter;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OdontologoService implements IOdontologoService {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoService.class);

    private IOdontologoRepository odontologoRepository;
    private ModelMapper modelMapper;

    public OdontologoService(IOdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
        configureMapping();
    }

    @Override
    public OdontologoSalidaDto registrarOdontologo(OdontologoEntradaDto odontologo) {
            LOGGER.info("OdontologoEntradaDto: " + odontologo);
            Odontologo odontologoEntidad = modelMapper.map(odontologo, Odontologo.class);
        LOGGER.info("OdontologoEntidad: " + JsonPrinter.toString(odontologoEntidad));

            Odontologo odontologoAPersistir = odontologoRepository.save(odontologoEntidad);
        LOGGER.info("OdontologoAPersistir: " + JsonPrinter.toString(odontologoAPersistir));

            OdontologoSalidaDto odontologoSalidaDto = modelMapper.map(odontologoAPersistir, OdontologoSalidaDto.class);
        LOGGER.info("OdontologoSalidaDto: " + JsonPrinter.toString(odontologoSalidaDto));

        return odontologoSalidaDto;
    }

    @Override
    public List<OdontologoSalidaDto> listarOdontologos() {
        List<OdontologoSalidaDto> odontologosSalidaDto = odontologoRepository.findAll()
                .stream()
                .map(odontologo -> modelMapper.map(odontologo, OdontologoSalidaDto.class))
                .collect(Collectors.toList());

        if(LOGGER.isInfoEnabled()){
            LOGGER.info("Listado de odontologos: ", odontologosSalidaDto);
        }
        return odontologosSalidaDto;
    }

    @Override
    public OdontologoSalidaDto buscarOdontologoPorId(Long id) {
        Odontologo odontologoBuscado = odontologoRepository.findById(id).orElse(null);
        OdontologoSalidaDto odontologoEncontrado = null;

        if(odontologoBuscado != null){
            odontologoEncontrado = modelMapper.map(odontologoBuscado, OdontologoSalidaDto.class);

            LOGGER.info("Odontologo encontrado: ", odontologoEncontrado);
        }else LOGGER.error("El id no se encuentra registrado.");

        return odontologoEncontrado;
    }

    @Override
    public OdontologoSalidaDto actaulizarOdontologo(OdontologoModificacionEntradaDto odontologo) {
        Odontologo odontologoRecibido = modelMapper.map(odontologo, Odontologo.class);
        Odontologo odontologoAActualizar = odontologoRepository.findById(odontologoRecibido.getId()).orElse(null);

        OdontologoSalidaDto odontologoSalidaDto = null;

        if(odontologoAActualizar != null){
            odontologoAActualizar = odontologoRecibido;
            odontologoRepository.save(odontologoAActualizar);

            odontologoSalidaDto= modelMapper.map(odontologoAActualizar, OdontologoSalidaDto.class);
            LOGGER.warn("Odontologo actualizado : ", odontologoSalidaDto);
        }else{
            LOGGER.error("No fue posible actualizar el registro, odontologo no encontrado...");
        }

        return odontologoSalidaDto;
    }

    @Override
    public void eliminarOdontologo(Long id)  throws ResourceNotFoundException {
        if(odontologoRepository.findById(id).orElse(null)!= null) {
            odontologoRepository.deleteById(id);
            LOGGER.warn("Se ha eliminado el odontologo con id: {}", id);
        }else{
            LOGGER.error("No se ha encontrado el odontontolgo con el id buscado.. ", id);
        }

    }

    private void configureMapping(){
        modelMapper.typeMap(OdontologoEntradaDto.class, Odontologo.class);
        modelMapper.typeMap(Odontologo.class, OdontologoSalidaDto.class);
        modelMapper.typeMap(OdontologoModificacionEntradaDto.class, Odontologo.class);

    }

}
