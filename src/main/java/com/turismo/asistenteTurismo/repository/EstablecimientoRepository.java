package com.turismo.asistenteTurismo.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.turismo.asistenteTurismo.model.Establecimiento;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {

	Page<Establecimiento> findByNombre(String nombre, Pageable pageable);
	
}
