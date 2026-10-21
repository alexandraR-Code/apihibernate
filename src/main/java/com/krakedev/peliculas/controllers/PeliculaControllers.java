package com.krakedev.peliculas.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.peliculas.services.ServicioPelicula;
import com.krakedev.peliculas.entidades.Pelicula;

@RestController
@RequestMapping("/peliculas")
public class PeliculaControllers {

	private final ServicioPelicula servicio;

	public PeliculaControllers(ServicioPelicula servicio) {
		this.servicio = servicio;
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Pelicula pelicula) {
		try {
			Pelicula creado = servicio.crear(pelicula);

			return ResponseEntity.status(HttpStatus.CREATED).body(creado);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al crear");
		}

	}
}