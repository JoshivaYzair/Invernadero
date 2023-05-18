package com.proyecto.configuracion;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.dto.LecturaDTO;

@Component
@EnableRabbit
public class Publisher {
	
	@Autowired
	private RabbitTemplate rabbirTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired()
	private Queue queue;
	
	public void sens(Object mensaje) {
		try {
			String json = objectMapper.writeValueAsString(mensaje);
			rabbirTemplate.convertAndSend(queue.getName(), json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
