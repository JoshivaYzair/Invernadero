package com.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.modelo.Lectura;
import com.proyecto.servicio.LecturaServicio;

@RestController
@RequestMapping("/lectura")
public class LecturaControlador {

	@Autowired
	private LecturaServicio servicio;
	
	@GetMapping
	@CrossOrigin(origins = "http://127.0.0.1:5500'")
	public ResponseEntity<List<Lectura>> getTodo(){
		List<Lectura> lecturas = servicio.getAll();
		if (lecturas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lecturas);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Lectura> getLectura(@PathVariable("id")Long id){
		Lectura lectura = servicio.getLecturaById(id);
		if (lectura == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(lectura);
	}
	
	@PostMapping
	public ResponseEntity <Lectura> guardar(@RequestBody Lectura lec){
		Lectura newLec = servicio.save(lec);
		return ResponseEntity.ok(newLec);
	}
	
	@GetMapping("/sensor/{sensorId}")
	public ResponseEntity <List<Lectura>> getAllLecBySenId(@PathVariable("sensorId")Long senId){
		List<Lectura> lecturas = servicio.getBySenId(senId);
		if (lecturas.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(lecturas);
	}
}
