package com.krakedev.peliculas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.krakedev.peliculas.entidades.Pelicula;
import com.krakedev.peliculas.repository.PeliculaRepository;

@Service
public class ServicioPelicula {

	private final PeliculaRepository peliculaRepository;

	public ServicioPelicula(PeliculaRepository peliculaRepository) {
		this.peliculaRepository = peliculaRepository;
	}

	public Pelicula crear(Pelicula pelicula) {
		return peliculaRepository.save(pelicula); // si existe id lo actualiza caso contrario lo crea
	}

	public List<Pelicula> listar() {
		return peliculaRepository.findAll();
	}

	public Pelicula buscarPorId(Long id) {
		Optional<Pelicula> resultado = peliculaRepository.findById(id);
		return resultado.orElse(null);
	}

	public Pelicula actualizar(Long id, Pelicula pelicula) {
		Pelicula encontrada = buscarPorId(id);
		if (encontrada == null) {
			return null;
		}
		encontrada.setNombre(pelicula.getNombre());
		encontrada.setDirector(pelicula.getDirector());
		encontrada.setGenero(pelicula.getGenero());
		encontrada.setDuracion(pelicula.getDuracion());
		encontrada.setDisponible(pelicula.isDisponible());

		return peliculaRepository.save(encontrada);
	}

	public boolean eliminar(Long id) {
		Pelicula encontrado = buscarPorId(id);
		if (encontrado == null) {
			return false;
		}
		peliculaRepository.delete(encontrado);
		return true;
	}

	public List<Pelicula> buscarPorGenero(String genero) {
		return peliculaRepository.findByGenero(genero);
	}

	public List<Pelicula> buscarPorDisponible(boolean disponible) {
		return peliculaRepository.findByDisponible(disponible);
	}

}
