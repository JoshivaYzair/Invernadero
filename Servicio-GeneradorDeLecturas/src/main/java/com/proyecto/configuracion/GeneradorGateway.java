package com.proyecto.configuracion;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.proyecto.dto.LecturaDTO;

@Component
public class GeneradorGateway {
	
	@Autowired
	private Publisher publisher;
	
	public void enviarTemperatura(LecturaDTO lecturaDto) {
        this.publisher.sens(lecturaDto);
    }
}
