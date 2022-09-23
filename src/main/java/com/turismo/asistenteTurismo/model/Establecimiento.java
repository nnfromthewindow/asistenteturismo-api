package com.turismo.asistenteTurismo.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Establecimiento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull
	private String nombre;
	
	@Size(max = 1000 )@NotNull
	private String descripcion;
	
	@NotNull
	private String direccion;
	
	@NotNull
	private Integer telefono;
	
	private String paginaInternet;
	
	private LocalDateTime fechaRegistro = LocalDateTime.now();
	
	@Enumerated(EnumType.STRING)@NotNull
	private TipoEstablecimiento tipoEstablecimiento;
	
	@Enumerated(EnumType.STRING)@NotNull
	private Localidad localidad;
	
	private String foto1;
	
	private String foto2;
	
	private String foto3;
	
	public Establecimiento() {
		
	};
	
	

	public Establecimiento(String nombre, String descripcion, String direccion, Integer telefono,
			String paginaInternet, TipoEstablecimiento tipoEstablecimiento,
			 Localidad localidad, String foto1, String foto2, String foto3  ) {
		
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.direccion = direccion;
		this.telefono = telefono;
		this.paginaInternet = paginaInternet;
		this.tipoEstablecimiento = tipoEstablecimiento;
		this.localidad = localidad;
		this.foto1 = foto1;
		this.foto2 = foto2;
		this.foto3 = foto3;
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

	
}
