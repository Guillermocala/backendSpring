package edu.unimagdalena.primerProyecto.model;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Mascotas")
public class Mascota {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String nombre;
	
	@Column
	private String raza;
	
	@Column
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;

	@ManyToOne
	@JoinColumn(name = "idPropietario")
	private Propietario propietario;
	
	public Mascota() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mascota(Long id, String nombre, String raza, Date fechaNacimiento, Propietario propietario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
		this.propietario = propietario;
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

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
}
