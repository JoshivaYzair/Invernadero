package com.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.dto.SensorDTO;
import com.proyecto.modelo.Notificaciones;
import com.proyecto.repositorio.NotificacionesRepositorio;

@Service
public class NotificacionesServicio {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private NotificacionesRepositorio repo;
	
    private String lecturaServiceUrl = "http://localhost:8060";
	
	public SensorDTO getSensor(Long sensorId){
		SensorDTO sensor = rest.getForObject(lecturaServiceUrl + "/sensor/" + sensorId , SensorDTO.class);
		return sensor;
	}
	
	public List<Notificaciones> getAll(){
		return repo.findAll();
	}
	
	public Notificaciones getNotificacionById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Notificaciones save(Notificaciones lec) {
		Notificaciones newNot = repo.save(lec);
		return newNot;
	}
	
	public void delete(Long id) {
		repo.deleteById(id);
	}
	
}
