package com.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.modelo.Cultivo;

@Repository
public interface CultivoRepositorio extends JpaRepository<Cultivo, Long>{
}
