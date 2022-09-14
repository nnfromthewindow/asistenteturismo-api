package com.turismo.asistenteTurismo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Establecimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String direccion;
	
	private Integer telefono;
	
	private String paginaInternet;
	
	private LocalDateTime fechaRegistro = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)
	private TipoEstablecimiento tipoEstablecimiento;
	
	@Enumerated(EnumType.STRING)
	private Localidad localidad;
	
	public Establecimiento() {
		
	};
	
	

	public Establecimiento(String nombre, String descripcion, String direccion, Integer telefono,
			String paginaInternet, TipoEstablecimiento tipoEstablecimiento,
			 Localidad localidad  ) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.paginaInternet = paginaInternet;
		this.tipoEstablecimiento = tipoEstablecimiento;
		this.localidad = localidad;
		 
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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
