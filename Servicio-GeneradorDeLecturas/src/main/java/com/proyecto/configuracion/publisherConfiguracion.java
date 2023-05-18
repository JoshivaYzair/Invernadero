package com.proyecto.configuracion;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class publisherConfiguracion {
	
	@Value("${cola.Publicacion}")
	private String cola;
	
	@Bean
	public Queue queue() {
		return new Queue(cola,true);
	}


}
