package com.backend.clinicaOdontologicaIntegrador.dto.salida.odontologo;

import javax.persistence.Column;

public class OdontologoSalidaDto {

    private Long id;
    private String matricula;
    private String nombre;
    private String apellido;

    public OdontologoSalidaDto() {
    }

    public OdontologoSalidaDto(String matricula, String nombre, String apellido) {
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
