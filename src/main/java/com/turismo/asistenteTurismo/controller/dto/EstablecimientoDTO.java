package com.turismo.asistenteTurismo.controller.dto;

import java.time.LocalDateTime;
import org.springframework.data.domain.Page;
import com.turismo.asistenteTurismo.model.Establecimiento;
import com.turismo.asistenteTurismo.model.Localidad;
import com.turismo.asistenteTurismo.model.TipoEstablecimiento;

public class EstablecimientoDTO {

	private Long id;
	
	private String nombre;
	
	private String descripcion;
	
	private String direccion;
	
	private Integer telefono;
	
	private String paginaInternet;
	
	private LocalDateTime fechaRegistro;
	
	private TipoEstablecimiento tipoEstablecimiento;
	
	private Localidad localidad;
	
	private String foto1;
	
	private String foto2;
	
	private String foto3;
	
	public EstablecimientoDTO(Establecimiento establecimiento) {
		this.id = establecimiento.getId();
		this.nombre = establecimiento.getNombre();
		this.descripcion = establecimiento.getDescripcion();
		this.direccion = establecimiento.getDireccion();
		this.telefono = establecimiento.getTelefono();
		this.paginaInternet = establecimiento.getPaginaInternet();
		this.fechaRegistro = establecimiento.getFechaRegistro();
		this.tipoEstablecimiento = establecimiento.getTipoEstablecimiento();
		this.localidad = establecimiento.getLocalidad();
		this.foto1 = establecimiento.getFoto1();
		this.foto2 = establecimiento.getFoto2();
		this.foto3 = establecimiento.getFoto3();
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

	public String getFoto1() {
		return foto1;
	}

	public String getFoto2() {
		return foto2;
	}

	public String getFoto3() {
		return foto3;
	}

	public static Page<EstablecimientoDTO> convertir(Page<Establecimiento> establecimientos) {
		return establecimientos.map(EstablecimientoDTO::new);
	};
	
}
