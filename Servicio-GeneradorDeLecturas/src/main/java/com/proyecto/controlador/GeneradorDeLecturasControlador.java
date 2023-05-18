package com.proyecto.controlador;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.configuracion.GeneradorGateway;
import com.proyecto.dto.LecturaDTO;

@RestController
@EnableScheduling
public class GeneradorDeLecturasControlador {
	
	@Autowired
	private GeneradorGateway gate;
	
//		@Autowired
//		private RestTemplate rest;
		
//		private String lecturaServiceUrl = "http://localhost:8060";
		
//		@Scheduled(fixedDelay = 10000)
//	    public void emulateTemperatureHumidity() {
	        // Generar datos de temperatura y humedad emulados
	    	//	        double temperature = ThreadLocalRandom.current().nextDouble(20, 30);
	    	//	        double humidity = ThreadLocalRandom.current().nextDouble(30, 60);
	        
	        // Enviar los datos al primer microservicio
	    	//	        LecturaDTO lecturaDto = new LecturaDTO();
	    	//	        lecturaDto.setTemperatura(temperature);
	    	//	        lecturaDto.setHumedad(humidity);
	    	//	        lecturaDto.setSensorId(1L);
	    	//	        rest.postForObject(lecturaServiceUrl+"/lectura", lecturaDto, LecturaDTO.class);
	    	//	    }
		
		@Scheduled(fixedDelay = 10000)
	    public void emulateTemperatureHumidity() {
	        // Generar datos de temperatura y humedad emulados
	        double temperature = ThreadLocalRandom.current().nextDouble(10, 60);
	        double humidity = ThreadLocalRandom.current().nextDouble(5, 50);
	        
	        // Enviar los datos al primer microservicio
	        LecturaDTO lecturaDto = new LecturaDTO();
	        lecturaDto.setTemperatura(temperature);
	        lecturaDto.setHumedad(humidity);
	        lecturaDto.setSensorId(2L);
	        gate.enviarTemperatura(lecturaDto);
	    }
}
