package com.proyecto.modelo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "lectura")
public class Lectura {
	
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
	 * @return the temperatura
	 */
	public Double getTemperatura() {
		return temperatura;
	}
	/**
	 * @param temperatura the temperatura to set
	 */
	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}
	/**
	 * @return the humedad
	 */
	public Double getHumedad() {
		return humedad;
	}
	/**
	 * @param humedad the humedad to set
	 */
	public void setHumedad(Double humedad) {
		this.humedad = humedad;
	}
	/**
	 * @return the sensorId
	 */
	public Long getSensorId() {
		return sensorId;
	}
	/**
	 * @param sensorId the sensorId to set
	 */
	public void setSensorId(Long sensorId) {
		this.sensorId = sensorId;
	}
	
	@Id
	@Column(name = "lecturaId")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	@Column(name = "temperatura")
	private Double temperatura;
	@Column(name = "humedad")
	private Double humedad;
	@Column(name = "sensorId")
	private Long sensorId;
	
	public Lectura(Double temperatura, Double humedad, Long sensorId) {
		this.temperatura = temperatura;
		this.humedad = humedad;
		this.sensorId = sensorId;
	}
	
	public Lectura() {
	}
}
