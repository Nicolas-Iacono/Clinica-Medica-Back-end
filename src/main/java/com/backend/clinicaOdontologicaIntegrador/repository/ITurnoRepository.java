package com.backend.clinicaOdontologicaIntegrador.repository;

import com.backend.clinicaOdontologicaIntegrador.entity.turno.Turno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITurnoRepository extends JpaRepository<Turno, Long> {


}
