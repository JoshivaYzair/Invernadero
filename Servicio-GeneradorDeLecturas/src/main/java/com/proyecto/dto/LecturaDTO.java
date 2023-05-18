package com.proyecto.dto;

import java.io.Serializable;

public class LecturaDTO{
	
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
	
	private Double temperatura;
	private Double humedad;
	private Long sensorId;
	
	public LecturaDTO() {
	}
	
}
