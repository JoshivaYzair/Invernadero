package com.proyecto.consumidor;

import java.util.Iterator;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.proyecto.dto.LecturaDTO;
import com.proyecto.dto.SensorDTO;
import com.proyecto.modelo.Notificaciones;
import com.proyecto.servicio.NotificacionesServicio;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Component
public class Consumer {
	final String cola = "generacionLectura";
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private NotificacionesServicio servicio;
	
	@RabbitListener(queues = cola)
	public void recive(@Payload String json) {
		
		try {
			SimpleMailMessage email = new SimpleMailMessage();
			email.setTo("joshivatapia@gmail.com");
			email.setFrom("joshivatapia@hotmail.com");
			
			LecturaDTO lectura = objectMapper.readValue(json, LecturaDTO.class);
			SensorDTO sensor = servicio.getSensor(lectura.getSensorId());
			Notificaciones not = servicio.getAll().get(0);
			if(sensor.getInvernaderoId() == not.getInvernaderoId()) {
				if( lectura.getHumedad() >=  not.getHumedadMax()|| 
					lectura.getTemperatura() >= not.getTemperaturaMax()) {
						email.setSubject("ALERTA DE TEMPERATURA O HUMEDAD");
						email.setText(not.getNombre()+ ": El invernadero tiene anomalias en su temperatura o humedad maxima");
						mailSender.send(email);
				}
				if( lectura.getHumedad()<=  not.getHumedadMin()|| 
					lectura.getTemperatura() <= not.getTemperaturaMin()) {
						email.setSubject("ALERTA DE TEMPERATURA O HUMEDAD");
						email.setText(not.getNombre()+ ": El invernadero tiene anomalias en su temperatura o humedad minima");
						mailSender.send(email);
				}
			}
					
			
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
