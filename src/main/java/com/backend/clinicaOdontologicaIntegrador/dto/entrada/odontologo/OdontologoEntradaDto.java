package com.backend.clinicaOdontologicaIntegrador.dto.entrada.odontologo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class OdontologoEntradaDto {

    @NotNull(message = "El campo matricula no puede ser nulo")
    @NotBlank(message = "Debe especificarse la matricula del odontologo")
    private String matricula;
    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    private String nombre;
    @NotNull(message = "El campo apellido no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del odontologo")
    private String apellido;

    public OdontologoEntradaDto() {
    }

    public OdontologoEntradaDto(String matricula, String nombre, String apellido) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }



    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
