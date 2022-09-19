package com.turismo.asistenteTurismo.service;

import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.turismo.asistenteTurismo.controller.dto.DetalleEstablecimientoDTO;
import com.turismo.asistenteTurismo.controller.dto.EstablecimientoDTO;
import com.turismo.asistenteTurismo.controller.form.ActualizaEstablecimientoForm;
import com.turismo.asistenteTurismo.controller.form.EstablecimientoForm;
import com.turismo.asistenteTurismo.exception.RecursoNoEncontradoException;
import com.turismo.asistenteTurismo.model.Establecimiento;
import com.turismo.asistenteTurismo.repository.EstablecimientoRepository;

@Service
public class EstablecimientoService {

	@Autowired
	private EstablecimientoRepository establecimientoRepository;
	
	@Cacheable(value = "listaEstablecimiento")
	public Page<EstablecimientoDTO> listado(String nombre, Pageable pageable) {
		Page<Establecimiento> resultado;
		
		if (nombre == null) {
			resultado = establecimientoRepository.findAll(pageable);
		} else {
			resultado = establecimientoRepository.findByNombre(nombre, pageable);
		}
		
		return EstablecimientoDTO.convertir(resultado);
	}
	
	@CacheEvict(value = "listaEstablecimiento", allEntries = true)
	public Establecimiento registrar(@Valid EstablecimientoForm establecimientoForm) {
	
		Establecimiento establecimiento = establecimientoForm.convertir();
		
		return establecimientoRepository.save(establecimiento);
	}

	public DetalleEstablecimientoDTO detalle(Long id) {
		
		Optional<Establecimiento> establecimiento = establecimientoRepository.findById(id);
		
		if(!establecimiento.isPresent())  {
			throw new RecursoNoEncontradoException(String.format("El establecimiento de id %s no fue encontrado", id));
		}
		
		return new DetalleEstablecimientoDTO(establecimiento.get());
	}

	@CacheEvict(value = "listaEstablecimiento", allEntries = true)
	public void borrar(Long id) {
		Optional<Establecimiento> optEstablecimiento = establecimientoRepository.findById(id);
		
		if(!optEstablecimiento.isPresent())  {
			throw new RecursoNoEncontradoException(String.format("El establecimiento de id %s no fue encontrado", id));
		}
		
		establecimientoRepository.deleteById(id);
		
	}
	
	@CacheEvict(value = "listaEstablecimiento", allEntries = true)
	@Transactional
	public Establecimiento actualizar(Long id, @Valid ActualizaEstablecimientoForm actualizaEstablecimientoForm) {
		Optional<Establecimiento> optEstablecimiento = establecimientoRepository.findById(id);
		
		if(!optEstablecimiento.isPresent())  {
			throw new RecursoNoEncontradoException(String.format("El establecimiento de id %s no fue encontrado", id));
		}
		
		Establecimiento establecimiento = optEstablecimiento.get();
		establecimiento.setNombre(actualizaEstablecimientoForm.getNombre());
		establecimiento.setDescripcion(actualizaEstablecimientoForm.getDescripcion());
		establecimiento.setDireccion(actualizaEstablecimientoForm.getDireccion());
		establecimiento.setTelefono(actualizaEstablecimientoForm.getTelefono());
		establecimiento.setPaginaInternet(actualizaEstablecimientoForm.getPaginaInternet());
		establecimiento.setTipoEstablecimiento(actualizaEstablecimientoForm.getTipoEstablecimiento());
		establecimiento.setLocalidad(actualizaEstablecimientoForm.getLocalidad());
		
		return establecimiento;
	}
	
	
	
}
																									