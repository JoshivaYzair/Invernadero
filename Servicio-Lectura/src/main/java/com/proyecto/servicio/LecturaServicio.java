package com.proyecto.servicio;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.proyecto.modelo.Lectura;
import com.proyecto.repositorio.LecturaRepositorio;

@Service
//@EnableScheduling 
public class LecturaServicio {

	@Autowired
	private LecturaRepositorio repo;
	
	public List<Lectura> getAll(){
		return repo.findAll();
	}
	
	public Lectura getLecturaById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Lectura save(Lectura lec) {
		Lectura newLec = repo.save(lec);
		return newLec;
	}
	
	public List<Lectura> getBySenId(Long senId){
		return repo.findBySensorId(senId);
	}
	
//	@Scheduled(fixedRate = 2000)
//    public void generateAndSaveData() {
//        // Generar los datos de temperatura y humedad de manera aleatoria para el sensor "sensor-1"
//        Lectura data = new Lectura();
//        double temperature = ThreadLocalRandom.current().nextDouble(15, 35);
//        double humidity = ThreadLocalRandom.current().nextDouble(20, 80);
//       data.setHumedad(humidity);
//        data.setTemperatura(temperature);
//        data.setSensorId(2L);
//        // Guardar los datos en la base de datos
//        save(data);
//    }
	
}
