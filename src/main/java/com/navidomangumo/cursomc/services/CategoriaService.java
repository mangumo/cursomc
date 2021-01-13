package com.navidomangumo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navidomangumo.cursomc.domain.Categoria;
import com.navidomangumo.cursomc.repositories.CategoriaRepository;
import com.navidomangumo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria buscar(Integer Id) {		
		Optional<Categoria> obj = repo.findById(Id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto nao encontrado! Id: "+ Id +", Tipo: "+ Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
}
