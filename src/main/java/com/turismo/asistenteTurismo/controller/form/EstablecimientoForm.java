package com.turismo.asistenteTurismo.controller.form;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.turismo.asistenteTurismo.model.Establecimiento;
import com.turismo.asistenteTurismo.model.Localidad;
import com.turismo.asistenteTurismo.model.TipoEstablecimiento;

public class EstablecimientoForm {
	
	private String nombre;
	
	private String descripcion;
	
	private String direccion;
	
	private Integer telefono;
	
	private String paginaInternet;
	
	//private LocalDateTime fechaRegistro = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private TipoEstablecimiento tipoEstablecimiento;
	
	@Enumerated(EnumType.STRING)
	private Localidad localidad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getPaginaInternet() {
		return paginaInternet;
	}

	public void setPaginaInternet(String paginaInternet) {
		this.paginaInternet = paginaInternet;
	}

	public TipoEstablecimiento getTipoEstablecimiento() {
		return tipoEstablecimiento;
	}

	public void setTipoEstablecimiento(TipoEstablecimiento tipoEstablecimiento) {
		this.tipoEstablecimiento = tipoEstablecimiento;
	}

	public Localidad getLocalidad() {
		return localidad;
	}

	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	
	public  Establecimiento convertir() {
		return new Establecimiento(nombre, descripcion, direccion, telefono, paginaInternet, tipoEstablecimiento,localidad);
	}
	

}
