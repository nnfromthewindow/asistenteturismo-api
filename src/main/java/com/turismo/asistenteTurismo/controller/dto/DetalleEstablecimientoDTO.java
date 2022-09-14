package com.turismo.asistenteTurismo.controller.dto;

import java.time.LocalDateTime;

import com.turismo.asistenteTurismo.model.Establecimiento;
import com.turismo.asistenteTurismo.model.Localidad;
import com.turismo.asistenteTurismo.model.TipoEstablecimiento;

public class DetalleEstablecimientoDTO {

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String direccion;
	
	private Integer telefono;
	
	private String paginaInternet;
	
	private LocalDateTime fechaRegistro = LocalDateTime.now();
	
	private TipoEstablecimiento tipoEstablecimiento;

	private Localidad localidad;

	public DetalleEstablecimientoDTO(Establecimiento establecimiento) {
		
		this.id = establecimiento.getId();
		this.nombre = establecimiento.getNombre();
		this.descripcion = establecimiento.getDescripcion();
		this.direccion = establecimiento.getDireccion();
		this.telefono = establecimiento.getTelefono();
		this.paginaInternet = establecimiento.getPaginaInternet();
		this.fechaRegistro = establecimiento.getFechaRegistro();
		this.tipoEstablecimiento = establecimiento.getTipoEstablecimiento();
		this.localidad = establecimiento.getLocalidad();
	}

	
	public Long getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public String getPaginaInternet() {
		return paginaInternet;
	}

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public TipoEstablecimiento getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}

	public Localidad getLocalidad() {
		return localidad;
	}
	
	
}