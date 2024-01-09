package com.backend.clinicaOdontologicaIntegrador.repository;

import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Domicilio;
import com.backend.clinicaOdontologicaIntegrador.entity.paciente.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

public interface IPacienteRepository extends JpaRepository<Paciente, Long> {



}
