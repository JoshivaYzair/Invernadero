package com.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.modelo.Sensor;

@Repository
public interface SensorRepositorio extends JpaRepository<Sensor, Long>{
	
	List<Sensor> findByInvernaderoId(Long invernaderoId);
}
