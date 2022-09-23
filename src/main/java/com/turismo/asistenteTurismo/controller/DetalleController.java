package com.turismo.asistenteTurismo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/edit")
public class DetalleController {

	@GetMapping
	public String cargaDetalle(Model model) {
		
		return"edit";
	}
}
