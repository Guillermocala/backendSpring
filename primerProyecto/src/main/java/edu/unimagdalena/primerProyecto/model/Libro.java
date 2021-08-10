package edu.unimagdalena.primerProyecto.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nombre;
	
	@Column(nullable = false, name = "fecha_pub")
	@Temporal(TemporalType.DATE)
	private Date fechaPublicacion;
	
	@ManyToMany(mappedBy = "libros")
	private Set<Autor> autores;

	public Libro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Libro(Long id, String nombre, Date fechaPublicacion, Set<Autor> autores) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaPublicacion = fechaPublicacion;
		this.autores = autores;
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

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
}
