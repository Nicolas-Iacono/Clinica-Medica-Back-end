package com.backend.clinicaOdontologicaIntegrador.dto.modificacion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OdontologoModificacionEntradaDto {
    @NotNull(message = "Debe proveerse el id de del odontologo que se desea modificar")
    private Long id;
    @NotNull(message = "El campo matricula no puede ser nulo")
    @NotBlank(message = "Debe especificarse la matricula del odontologo")
    private String matricula;
    @NotNull(message = "El campo nombre no puede ser nulo")
    @NotBlank(message = "Debe especificarse el nombre del odontologo")
    private String nombre;
    @NotNull(message = "El campo apellido no puede ser nulo")
    @NotBlank(message = "Debe especificarse el apellido del odontologo")
    private String apellido;

    public OdontologoModificacionEntradaDto() {
    }

    public OdontologoModificacionEntradaDto(Long id, String matricula, String nombre, String apellido) {
        this.id = id;
        this.matricula = matricula;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
