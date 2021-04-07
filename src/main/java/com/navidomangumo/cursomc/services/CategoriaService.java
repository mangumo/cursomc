package com.navidomangumo.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.navidomangumo.cursomc.domain.Categoria;
import com.navidomangumo.cursomc.repositories.CategoriaRepository;
import com.navidomangumo.cursomc.services.exceptions.DataIntegrityException;
import com.navidomangumo.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;
	
	public Categoria find(Integer Id) {		
		Optional<Categoria> obj = repo.findById(Id);
		return obj.orElseThrow(()-> new ObjectNotFoundException(
				"Objecto nao encontrado! Id: "+ Id +", Tipo: "+ Categoria.class.getName()));
	}
	
	public Categoria insert(Categoria obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Categoria update(Categoria obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
		repo.deleteById(id);
		}
		catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Nao é possível excluir uma categoria que possui produtos");
		}
	}
	
	public List<Categoria> findAll(){
		return repo.findAll();
	}
	
	
	public Page<Categoria> findPage(int page, int linesPerPage, String direction,String orderBy){
		PageRequest pageRequest = PageRequest.of(page,linesPerPage,Direction.valueOf(direction),orderBy);
		return repo.findAll(pageRequest);
	}
}
