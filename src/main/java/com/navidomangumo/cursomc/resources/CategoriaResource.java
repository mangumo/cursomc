package com.navidomangumo.cursomc.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.navidomangumo.cursomc.domain.Categoria;

@RestController
@RequestMapping(value="/categoria")
public class CategoriaResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Categoria> listar() {
		Categoria cat1 = new Categoria(1,"Informatica");
		Categoria cat2 = new Categoria(1,"Informatica");
		
		List<Categoria> lista =  new ArrayList<>();
		lista.add(cat1);
		lista.add(cat2);
		return lista;
	}
}
