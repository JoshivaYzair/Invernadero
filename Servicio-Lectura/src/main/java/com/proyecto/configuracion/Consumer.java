package com.proyecto.configuracion;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.dto.LecturaDTO;
import com.proyecto.modelo.Lectura;
import com.proyecto.repositorio.LecturaRepositorio;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class Consumer {
	final String cola = "generacionLectura";
	
//	@Autowired
//	private LecturaGateway gate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired 
	private LecturaRepositorio repo; 
	
	@RabbitListener(queues = cola)
	public void recive(@Payload String json) {
		
		try {
			LecturaDTO lectura = objectMapper.readValue(json, LecturaDTO.class);
//			gate.guardarLectura(lectura);
			Lectura lec = new Lectura(lectura.getTemperatura(),lectura.getHumedad(),lectura.getSensorId());
			repo.save(lec);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
