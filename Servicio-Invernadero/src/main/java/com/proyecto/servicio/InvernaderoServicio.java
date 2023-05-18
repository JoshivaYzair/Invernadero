package com.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.dto.SensorDTO;
import com.proyecto.modelo.Invernadero;
import com.proyecto.repositorio.InvernaderoRepositorio;

@Service
public class InvernaderoServicio {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private InvernaderoRepositorio repo;
	
    private String sensorServiceUrl = "http://localhost:8060";
	
	public List<SensorDTO> getSensores(Long invernaderoId){
		List<SensorDTO> sensores = rest.getForObject(sensorServiceUrl + "/sensor/invernadero/" + invernaderoId , List.class);
		return sensores;
	}
	
	public List<Invernadero> getAll(){
		return repo.findAll();
	}
	
	public Invernadero getInvernaderoById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Invernadero save(Invernadero inv) {
		Invernadero newInv = repo.save(inv);
		return newInv;
	}
	
	public List<Invernadero> getByCulId(Long culId){
		return repo.findByCultivoId(culId);
	}
}
