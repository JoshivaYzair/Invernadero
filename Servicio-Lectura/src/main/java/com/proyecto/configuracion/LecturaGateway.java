package com.proyecto.configuracion;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.proyecto.dto.LecturaDTO;
import com.proyecto.modelo.Lectura;
import com.proyecto.repositorio.LecturaRepositorio;

@Component
public class LecturaGateway {
	
	@Autowired
	private LecturaRepositorio repo;
	
	public void guardarLectura(LecturaDTO lectura) {
		Lectura lec = new Lectura(lectura.getTemperatura(),lectura.getHumedad(),lectura.getSensorId());
		repo.save(lec);
	}
	
}
