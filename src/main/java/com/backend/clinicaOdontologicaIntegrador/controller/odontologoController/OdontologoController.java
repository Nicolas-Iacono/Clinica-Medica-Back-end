package com.backend.clinicaOdontologicaIntegrador.controller.odontologoController;

import com.backend.clinicaOdontologicaIntegrador.controller.pacienteController.PacienteController;
import com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo.OdontologoEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.OdontologoModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.modificacion.PacienteModificacionEntradaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.odontologo.OdontologoSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.dto.salida.paciente.PacienteSalidaDto;
import com.backend.clinicaOdontologicaIntegrador.exceptions.ResourceNotFoundException;
import com.backend.clinicaOdontologicaIntegrador.repository.IOdontologoRepository;
import com.backend.clinicaOdontologicaIntegrador.service.IOdontologoService;
import com.backend.clinicaOdontologicaIntegrador.utils.JsonPrinter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/odontologos")
public class OdontologoController {
    private final Logger LOGGER = LoggerFactory.getLogger(OdontologoController.class);

    private IOdontologoService odontologoService;

    public OdontologoController(IOdontologoService odontologoService) {
        this.odontologoService = odontologoService;
    }

    //REGISTRAR
    @Operation(summary = "Registro de un nuevo odontologo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Odontologo guardado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @PostMapping(value = "/registrar")
    public ResponseEntity<OdontologoSalidaDto> registrarOdontologo(@RequestBody OdontologoEntradaDto odontologo) {
        LOGGER.info("OdontologoEntradaDto: controller " + JsonPrinter.toString(odontologo));

        return new ResponseEntity<>(odontologoService.registrarOdontologo(odontologo), HttpStatus.CREATED);
    }


    //LISTAR
    @Operation(summary = "Listado de todos los odontologos")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Listado de dontologos obtenido correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping(value = "/listar")
    public ResponseEntity<List<OdontologoSalidaDto>> listarOdontologo() {
        return new ResponseEntity<>(odontologoService.listarOdontologos(), HttpStatus.OK);
        //List<OdontologoSalidaDto> odontologos = odontologoService.listarOdontologos();
        //return ResponseEntity.ok(odontologos);
    }

    //BUSCAR POR ID
    @Operation(summary = "Busqueda de odontologo por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontologo obtenido correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Id invalido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Odontologo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @GetMapping("/{id}")
    public OdontologoSalidaDto buscarOdontologoPorId(@PathVariable Long id) {
        return odontologoService.buscarOdontologoPorId(id);
    }

    //ACTUALIZAR
    @Operation(summary = "Actualizacion de un nuevo odontologo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Odontologo actualizado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = OdontologoSalidaDto.class))}),
            @ApiResponse(responseCode = "400", description = "Bad Request",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Odontologo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "UServer error",
                    content = @Content)
    })
    @PutMapping("/actualizar/{id}")
    public OdontologoSalidaDto actualizarOdontologo(@RequestBody OdontologoModificacionEntradaDto odontologo, @PathVariable Long id) {
        return odontologoService.actaulizarOdontologo(odontologo);
    }


    //DELETE
    @Operation(summary = "Eliminacion de un odontologo por Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Odontologo eliminado correctamente",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(responseCode = "400", description = "Id invalido",
                    content = @Content),
            @ApiResponse(responseCode = "404", description = "Odontologo no encontrado",
                    content = @Content),
            @ApiResponse(responseCode = "500", description = "Server error",
                    content = @Content)
    })
    @DeleteMapping("eliminar/{id}")
    public ResponseEntity<?> eliminarOdontologo(@PathVariable Long id) throws ConfigDataResourceNotFoundException, ResourceNotFoundException {
        try {
            odontologoService.eliminarOdontologo(id);
            return new ResponseEntity<>("Odontologo eliminado correctamente", HttpStatus.OK);
        } catch (ConfigDataResourceNotFoundException | ResourceNotFoundException ex) {
            return new ResponseEntity<>("Odontologo no encontrado", HttpStatus.NOT_FOUND);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al procesar la solicitud", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
