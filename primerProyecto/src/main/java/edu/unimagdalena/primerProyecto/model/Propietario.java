package edu.unimagdalena.primerProyecto.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name = "Propietarios")
public class Propietario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	@Column
	private String identificacion;
	
	@OneToMany(mappedBy = "propietario")
	private Set<Mascota> mascotas;
	
	public Propietario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Propietario(Long id, String nombre, String identificacion, Set<Mascota> mascotas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.mascotas = mascotas;
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

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public Set<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(Set<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
		
}
