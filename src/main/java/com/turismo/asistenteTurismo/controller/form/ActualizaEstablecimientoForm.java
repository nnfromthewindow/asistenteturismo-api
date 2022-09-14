package com.turismo.asistenteTurismo.controller.form;

import java.time.LocalDateTime;

import com.turismo.asistenteTurismo.model.Localidad;
import com.turismo.asistenteTurismo.model.TipoEstablecimiento;

public class ActualizaEstablecimientoForm {
	
	private String nombre;
	
	private String descripcion;
	
	private String direccion;
	
	private Integer telefono;
	
	private String paginaInternet;
	
	private LocalDateTime fechaRegistro = LocalDateTime.now();
	
	private TipoEstablecimiento tipoEstablecimiento;

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

	public LocalDateTime getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(LocalDateTime fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
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

}
