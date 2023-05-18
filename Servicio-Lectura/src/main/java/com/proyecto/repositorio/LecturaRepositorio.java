package com.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.modelo.Lectura;

@Repository
public interface LecturaRepositorio extends JpaRepository<Lectura, Long>{
	List<Lectura> findBySensorId(Long sensorId);
}
