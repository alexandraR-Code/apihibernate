package com.krakedev.peliculas.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
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

	@GetMapping
	public ResponseEntity<?> listar() {
		try {
			List<Pelicula> peliculas = servicio.listar();
			return ResponseEntity.ok(peliculas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al listar las peliculas");
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPoId(@PathVariable Long id) {
		try {
			Pelicula encontrada = servicio.buscarPorId(id);
			if (encontrada == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(encontrada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al buscar por id");
		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Pelicula pelicula) {
		try {
			Pelicula actualizada = servicio.actualizar(id, pelicula);
			if (actualizada == null) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(actualizada);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al actualizar pelicula por Id");
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> eliminar(@PathVariable Long id) {
		try {
			boolean eliminado = servicio.eliminar(id);
			if (!eliminado) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok("Se elimino el registro");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al eliminar la pelicula por id");
		}
	}

	@GetMapping("/genero")
	public ResponseEntity<?> buscarPorGenero(@RequestParam(required = false) String genero) {
		try {
			List<Pelicula> peliculas = new ArrayList<Pelicula>();
			if (genero != null) {
				peliculas = servicio.buscarPorGenero(genero);
			}
			if (peliculas.size() <= 0) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(peliculas);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al consultar pelicula por genero");
		}

	}
	// Filtrar por pathVariable

	@GetMapping("/disponible")
	public ResponseEntity<?> buscarPorDisponible(@RequestParam(required = false) Boolean disponible) {
		
		try {
			List<Pelicula> peliculas = servicio.buscarPorDisponible(disponible);
			
			if (disponible != null) {
				peliculas = servicio.buscarPorDisponible(disponible);

			}

			if (peliculas.size() <= 0) {
				return ResponseEntity.notFound().build();
			}
			return ResponseEntity.ok(peliculas);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error al consultar pelicula disponible ");
		}
	}

}
