package com.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "notificaciones")
public class Notificaciones {
	
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
	 * @return the temperaturaMax
	 */
	public Double getTemperaturaMax() {
		return temperaturaMax;
	}
	/**
	 * @param temperaturaMax the temperaturaMax to set
	 */
	public void setTemperaturaMax(Double temperaturaMax) {
		this.temperaturaMax = temperaturaMax;
	}
	/**
	 * @return the humedadMax
	 */
	public Double getHumedadMax() {
		return humedadMax;
	}
	/**
	 * @param humedadMax the humedadMax to set
	 */
	public void setHumedadMax(Double humedadMax) {
		this.humedadMax = humedadMax;
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
	/**
	 * @return the temperaturaMin
	 */
	public Double getTemperaturaMin() {
		return temperaturaMin;
	}
	/**
	 * @param temperaturaMin the temperaturaMin to set
	 */
	public void setTemperaturaMin(Double temperaturaMin) {
		this.temperaturaMin = temperaturaMin;
	}
	/**
	 * @return the humedadMin
	 */
	public Double getHumedadMin() {
		return humedadMin;
	}
	/**
	 * @param humedadMin the humedadMin to set
	 */
	public void setHumedadMin(Double humedadMin) {
		this.humedadMin = humedadMin;
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
	
	
	@Id
	@Column(name = "notificacionesId")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "temperaturaMax")
	private Double temperaturaMax;
	@Column(name = "humedadMax")
	private Double humedadMax;
	@Column(name = "invernaderoId")
	private Long invernaderoId;
	@Column(name = "temperaturaMin")
	private Double temperaturaMin;
	@Column(name = "humedadMin")
	private Double humedadMin;
	
	
	
	
	public Notificaciones() {
	}
 
}
