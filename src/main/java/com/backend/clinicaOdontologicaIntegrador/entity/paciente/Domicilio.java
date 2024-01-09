package com.backend.clinicaOdontologicaIntegrador.entity.paciente;

import javax.persistence.*;

@Entity
@Table(name = "DOMICILIO")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "DOMICILIO_CALLE")
    private String calle;
    @Column(name = "DOMICILIO_NUMERO")
    private int numero;
    @Column(name = "DOMICILIO_LOCALIDAD")
    private String localidad;
    @Column(name = "DOMICILIO_PROVINCIA")
    private String provincia;

    public Domicilio() {
    }

    public Domicilio(String calle, int numero, String localidad, String provincia) {
        this.calle = calle;
        this.numero = numero;
        this.localidad = localidad;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
