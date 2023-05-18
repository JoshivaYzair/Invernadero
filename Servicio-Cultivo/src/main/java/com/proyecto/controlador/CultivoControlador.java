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

import com.proyecto.dto.InvernaderoDTO;
import com.proyecto.modelo.Cultivo;
import com.proyecto.servicio.CultivoServicio;

@RestController
@RequestMapping("/cultivo")
public class CultivoControlador {
	
	@Autowired
	private CultivoServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Cultivo>> getTodo(){
		List<Cultivo> cultivo = servicio.getAll();
		if (cultivo.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cultivo);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Cultivo> getCultivo(@PathVariable("id")Long id){
		Cultivo cultivo = servicio.getCultivoById(id);
		if (cultivo == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cultivo);
	}
	
	@PostMapping
	public ResponseEntity <Cultivo> guardar(@RequestBody Cultivo cul){
		Cultivo newCul = servicio.save(cul);
		return ResponseEntity.ok(newCul);
	}
	
	@GetMapping("/invernadero/{cultivoId}")
	public ResponseEntity<List<InvernaderoDTO>> getInvernaderos(@PathVariable("cultivoId")Long id){
		Cultivo cultivo = servicio.getCultivoById(id);
		if (cultivo == null) {
			return ResponseEntity.notFound().build();
		}
		List<InvernaderoDTO> invernadero = servicio.getInvernaderos(id);
		return ResponseEntity.ok(invernadero);
	}

}
