package com.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "sensor")
public class Sensor {
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the invernaderoId
	 */
	public Long getInvernaderoId() {
		return invernaderoId;
	}

	/**
	 * @param invernaderoId the invernaderoId to set
	 */
	public void setInvernaderoId(Long invernaderoId) {
		this.invernaderoId = invernaderoId;
	}

	@Id
	@Column(name = "sensorId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre ;
	@Column(name = "invernaderoId")
	private Long invernaderoId;
	
	public Sensor() {
	}

	public Sensor(String nombre, Long invernaderoId) {
		this.nombre = nombre;
		this.invernaderoId = invernaderoId;
	}
	
}
