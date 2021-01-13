package com.navidomangumo.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.navidomangumo.cursomc.domain.Pedido;
import com.navidomangumo.cursomc.repositories.PedidoRepository;
import com.navidomangumo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository repo;
	
	public Pedido find(Integer Id) {		
		Optional<Pedido> obj = repo.findById(Id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto nao encontrado! Id: "+ Id +", Tipo: "+ Pedido.class.getName()));
	}

}
