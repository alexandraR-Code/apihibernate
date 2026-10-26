package com.krakedev.peliculas.entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pelicula")
public class Pelicula {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, length = 100) // NOT NULL
	private String nombre;
	@Column(nullable = false, length = 100)
	private String director;
	@Column(nullable = false, length = 100)
	private String genero;
	@Column(nullable = false)
	private int duracion;
	@Column(nullable = false)
	private boolean disponible;
	@Column(nullable = false)
	private double calificacion;
	@Column(nullable = false)
	private String idioma;
	
	
	
	

	public Pelicula() {
	}

	public Pelicula(Long id, String nombre, String director, String genero, int duracion, boolean disponible,
			double calificacion, String idioma) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.director = director;
		this.genero = genero;
		this.duracion = duracion;
		this.disponible = disponible;
		this.calificacion = calificacion;
		this.idioma = idioma;
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

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	@Override
	public String toString() {
		return "Pelicula [id=" + id + ", nombre=" + nombre + ", director=" + director + ", genero=" + genero
				+ ", duracion=" + duracion + ", disponible=" + disponible + ", calificacion=" + calificacion
				+ ", idioma=" + idioma + "]";
	}

	

}