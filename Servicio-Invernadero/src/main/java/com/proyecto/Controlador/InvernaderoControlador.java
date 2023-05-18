package com.proyecto.Controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.dto.SensorDTO;
import com.proyecto.modelo.Invernadero;
import com.proyecto.servicio.InvernaderoServicio;

@RestController
@RequestMapping("/invernadero")
public class InvernaderoControlador {
	
	@Autowired
	private InvernaderoServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Invernadero>> getTodo(){
		List<Invernadero> invernaderos = servicio.getAll();
		if (invernaderos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(invernaderos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Invernadero> getInventario(@PathVariable("id")Long id){
		Invernadero invernadero = servicio.getInvernaderoById(id);
		if (invernadero == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(invernadero);
	}
	
	@PostMapping
	public ResponseEntity <Invernadero> guardar(@RequestBody Invernadero inv){
		Invernadero newInv = servicio.save(inv);
		return ResponseEntity.ok(newInv);
	}
	
	@GetMapping("/cultivo/{cultivoId}")
	public ResponseEntity <List<Invernadero>> getAllInvByCulId(@PathVariable("cultivoId")Long culId){
		List<Invernadero> invernaderos = servicio.getByCulId(culId);
		if (invernaderos.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(invernaderos);
	}
	
	@GetMapping("/sensor/{invernaderoId}")
	public ResponseEntity<List<SensorDTO>> getSensores(@PathVariable("invernaderoId")Long id){
		Invernadero invernadero = servicio.getInvernaderoById(id);
		if (invernadero == null) {
			return ResponseEntity.notFound().build();
		}
		List<SensorDTO> sensores = servicio.getSensores(id);
		return ResponseEntity.ok(sensores);
	}

}
