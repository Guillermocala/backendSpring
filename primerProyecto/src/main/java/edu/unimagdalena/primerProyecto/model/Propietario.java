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
	private long id;
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
