package com.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.dto.LecturaDTO;
import com.proyecto.modelo.Sensor;
import com.proyecto.repositorio.SensorRepositorio;

@Service
public class SensorServicio {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private SensorRepositorio repo;
	
    private String lecturaServiceUrl = "http://localhost:8060";
	
	public List<LecturaDTO> getLecturas(Long sensorId){
		List<LecturaDTO> lecturas = rest.getForObject(lecturaServiceUrl + "/lectura/sensor/" + sensorId , List.class);
		return lecturas;
	}
	
	public List<Sensor> getAll(){
		return repo.findAll();
	}
	
	public Sensor getSensorById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Sensor save(Sensor sen) {
		Sensor newSen = repo.save(sen);
		return newSen;
	}
	
	public List<Sensor> getByInvId(Long invId){
		return repo.findByInvernaderoId(invId);
	}
}
