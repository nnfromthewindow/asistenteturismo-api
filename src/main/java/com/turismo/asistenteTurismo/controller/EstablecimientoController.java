package com.turismo.asistenteTurismo.controller;

import java.net.URI;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import com.turismo.asistenteTurismo.controller.dto.DetalleEstablecimientoDTO;
import com.turismo.asistenteTurismo.controller.dto.EstablecimientoDTO;
import com.turismo.asistenteTurismo.controller.form.ActualizaEstablecimientoForm;
import com.turismo.asistenteTurismo.controller.form.EstablecimientoForm;
import com.turismo.asistenteTurismo.model.Establecimiento;
import com.turismo.asistenteTurismo.service.EstablecimientoService;



@RestController
@RequestMapping("/establecimiento")
public class EstablecimientoController {
		
	@Autowired	
	private EstablecimientoService establecimientoService;
	
	@GetMapping
	public ResponseEntity<Page<EstablecimientoDTO>> listado(
			@RequestParam(required = false) String nombre,
			@PageableDefault(page = 0, size = 10,
			sort = "id", direction = Direction.DESC) Pageable pageable) {
		return ResponseEntity.ok(establecimientoService.listado(nombre, pageable));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<DetalleEstablecimientoDTO> detalle(@PathVariable Long id) {
		DetalleEstablecimientoDTO detalle = establecimientoService.detalle(id);
		
		return ResponseEntity.ok(detalle);
	}
	
	
	@PostMapping
	public ResponseEntity<EstablecimientoDTO> registrar(@RequestBody @Valid EstablecimientoForm establecimientoForm, 
														UriComponentsBuilder uriComponentsBuilder) {
		Establecimiento establecimiento = establecimientoService.registrar(establecimientoForm);
		
		URI uri = uriComponentsBuilder.path("/establecimiento/{id}").buildAndExpand(establecimiento.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new EstablecimientoDTO(establecimiento));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<DetalleEstablecimientoDTO> actualizar(@PathVariable Long id, @RequestBody @Valid ActualizaEstablecimientoForm actualizaEstablecimientoForm) {
		Establecimiento establecimiento = establecimientoService.actualizar(id, actualizaEstablecimientoForm);
		
		return ResponseEntity.ok(new DetalleEstablecimientoDTO(establecimiento));
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity borrar(@PathVariable Long id) {
		establecimientoService.borrar(id);
		
		return ResponseEntity.ok().build();
	}
		
		
}
 	