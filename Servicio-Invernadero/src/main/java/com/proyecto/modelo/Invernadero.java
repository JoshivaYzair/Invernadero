package com.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "invernadero")
public class Invernadero {
	
	/**
	 * @return the cultivoId
	 */
	public Long getCultivoId() {
		return cultivoId;
	}
	/**
	 * @param cultivoId the cultivoId to set
	 */
	public void setCultivoId(Long cultivoId) {
		this.cultivoId = cultivoId;
	}
	/**
	 * @return the ubicacion
	 */
	public String getUbicacion() {
		return ubicacion;
	}
	/**
	 * @param ubicacion the ubicacion to set
	 */
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}
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

	
	@Id
	@Column(name = "invernaderoId")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "ubicacion")
	private String ubicacion;
	@Column(name = "cultivoId")
	private Long cultivoId;
	
	
	public Invernadero(String nombre, String ubicacion, Long cultivoId) {
		super();
		this.nombre = nombre;
		this.ubicacion = ubicacion;
		this.cultivoId = cultivoId;
	}
	public Invernadero() {
	}
}
