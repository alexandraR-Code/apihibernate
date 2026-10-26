package com.krakedev.peliculas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.krakedev.peliculas.entidades.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
	// todo la configuracion para todos los metodos de la base de datos

	List<Pelicula> findByGenero(String genero);

	List<Pelicula> findByDisponible(boolean disponible);

	List<Pelicula> findByDirector(String director);

}
