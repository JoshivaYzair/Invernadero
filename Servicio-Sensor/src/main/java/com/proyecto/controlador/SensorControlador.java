package com.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.LecturaDTO;
import com.proyecto.modelo.Sensor;
import com.proyecto.servicio.SensorServicio;

@RestController
@RequestMapping("/sensor")
public class SensorControlador {
	
	@Autowired
	private SensorServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Sensor>> getTodo(){
		List<Sensor> sensor = servicio.getAll();
		if (sensor.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(sensor);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Sensor> getSensor(@PathVariable("id")Long id){
		Sensor sensor = servicio.getSensorById(id);
		if (sensor == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(sensor);
	}
	
	@PostMapping
	public ResponseEntity <Sensor> guardar(@RequestBody Sensor sen){
		Sensor newSen = servicio.save(sen);
		return ResponseEntity.ok(newSen);
	}
	
	@GetMapping("/invernadero/{invernaderoId}")
	public ResponseEntity <List<Sensor>> getAllInvBySenId(@PathVariable("invernaderoId")Long invId){
		List<Sensor> invernaderos = servicio.getByInvId(invId);
		if (invernaderos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(invernaderos);
	}
	
	@GetMapping("/lectura/{sensorId}")
	public ResponseEntity<List<LecturaDTO>> getLecturas(@PathVariable("sensorId")Long id){
		Sensor sensor = servicio.getSensorById(id);
		if (sensor == null) {
			return ResponseEntity.notFound().build();
		}
		List<LecturaDTO> lecturas = servicio.getLecturas(id);
		return ResponseEntity.ok(lecturas);
	}
}
