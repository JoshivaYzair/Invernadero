package com.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.modelo.Invernadero;

@Repository
public interface InvernaderoRepositorio extends JpaRepository<Invernadero, Long>{
	List<Invernadero> findByCultivoId(Long cultivoId);
}
