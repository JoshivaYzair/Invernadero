package com.proyecto.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.modelo.Notificaciones;
import com.proyecto.servicio.NotificacionesServicio;

@RestController
@RequestMapping("/notificaciones")
public class NotificacionesControlador {

	@Autowired
	private NotificacionesServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Notificaciones>> getTodo(){
		List<Notificaciones> notificaciones = servicio.getAll();
		if (notificaciones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(notificaciones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity <Notificaciones> getNotificaciones(@PathVariable("id")Long id){
		Notificaciones notificaciones = servicio.getNotificacionById(id);
		if (notificaciones == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(notificaciones);
	}
	
	@PostMapping
	public ResponseEntity <Notificaciones> guardar(@RequestBody Notificaciones lec){
		Notificaciones newLec = servicio.save(lec);
		return ResponseEntity.ok(newLec);
	}
	
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id")Long id) {
		servicio.delete(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> actualizar(@RequestBody Notificaciones not, @PathVariable("id")Long id){
		Notificaciones notiActual = servicio.getNotificacionById(id);
		notiActual.setNombre(not.getNombre());
		notiActual.setTemperaturaMax(not.getTemperaturaMax());
		notiActual.setTemperaturaMin(not.getTemperaturaMin());
		notiActual.setHumedadMax(not.getHumedadMax());
		notiActual.setHumedadMin(not.getHumedadMin());
		
		servicio.save(notiActual);
		
		return ResponseEntity.ok(notiActual);
		
		
	}
}
