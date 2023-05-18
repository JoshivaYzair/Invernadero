package com.proyecto.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.proyecto.dto.InvernaderoDTO;
import com.proyecto.modelo.Cultivo;
import com.proyecto.repositorio.CultivoRepositorio;

@Service
public class CultivoServicio {
	
	@Autowired
	private RestTemplate rest;
	
	@Autowired
	private CultivoRepositorio repo;
	
    private String invernaderoServiceUrl = "http://localhost:8060";
	
	public List<InvernaderoDTO> getInvernaderos(Long cultivoId){
		List<InvernaderoDTO> invernaderos = rest.getForObject(invernaderoServiceUrl + "/invernadero/cultivo/" + cultivoId , List.class);
		return invernaderos;
	}
	
	public List<Cultivo> getAll(){
		return repo.findAll();
	}
	
	public Cultivo getCultivoById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public Cultivo save(Cultivo cul) {
		Cultivo newCul = repo.save(cul);
		return newCul;
	}
}
