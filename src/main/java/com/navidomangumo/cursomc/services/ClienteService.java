package com.navidomangumo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navidomangumo.cursomc.domain.Cliente;
import com.navidomangumo.cursomc.repositories.ClienteRepository;
import com.navidomangumo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repo;
	
	public Cliente buscar(Integer Id) {		
		Optional<Cliente> obj = repo.findById(Id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto nao encontrado! Id: "+ Id +", Tipo: "+ Cliente.class.getName()));
	}

}
