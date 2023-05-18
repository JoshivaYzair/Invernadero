package com.proyecto.dto;

public class SensorDTO {
	
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
	
	private String nombre;
	private Long invernaderoId;
	
	
	
	public SensorDTO() {
		// TODO Auto-generated constructor stub
	}
}
