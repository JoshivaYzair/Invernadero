package com.proyecto.dto;


public class LecturaDTO {
	
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

	private Double temperatura;
	private Double humedad;
	
	public LecturaDTO() {
	}
	
}
