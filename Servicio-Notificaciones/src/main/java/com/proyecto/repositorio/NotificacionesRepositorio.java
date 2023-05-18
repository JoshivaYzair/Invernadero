package com.proyecto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.proyecto.modelo.Notificaciones;


@Repository
public interface NotificacionesRepositorio extends JpaRepository<Notificaciones, Long>{
}
