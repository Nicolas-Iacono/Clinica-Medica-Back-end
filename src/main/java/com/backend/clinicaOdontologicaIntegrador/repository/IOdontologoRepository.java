package com.backend.clinicaOdontologicaIntegrador.repository;

import com.backend.clinicaOdontologicaIntegrador.entity.odontologo.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository<Odontologo, Long> {


}
