package com.turismo.asistenteTurismo.controller.form;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.turismo.asistenteTurismo.model.Establecimiento;
import com.turismo.asistenteTurismo.model.Localidad;
import com.turismo.asistenteTurismo.model.TipoEstablecimiento;

public class EstablecimientoForm {
	
	@NotBlank
	private String nombre;
	@NotBlank @Size(max = 1000 )
	private String descripcion;
	@NotBlank
	private String direccion;
	
	private Long telefono;
	
	private String paginaInternet;
	
	@Enumerated(EnumType.STRING)
	private TipoEstablecimiento tipoEstablecimiento;
	
	@Enumerated(EnumType.STRING)
	private Localidad localidad;

	private String foto1;
	
	private String foto2;
	
	private String foto3;
	
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

	public Long getTelefono() {
		return telefono;
	}

	public void setTelefono(Long telefono) {
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
	
	public String getFoto1() {
		return foto1;
	}

	public void setFoto1(String foto1) {
		this.foto1 = foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public void setFoto2(String foto2) {
		this.foto2 = foto2;
	}

	public String getFoto3() {
		return foto3;
	}

	public void setFoto3(String foto3) {
		this.foto3 = foto3;
	}

	public  Establecimiento convertir() {
		return new Establecimiento(nombre, descripcion, direccion, telefono, paginaInternet, tipoEstablecimiento,localidad,foto1,foto2,foto3);
	}
	

}
