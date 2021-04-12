package com.navidomangumo.cursomc.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.navidomangumo.cursomc.domain.Categoria;


public class CategoriaDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer Id;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(min=5,max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	public CategoriaDTO() {
	}
	
	public CategoriaDTO(Categoria obj) {
		Id = obj.getId();
		nome = obj.getNome();
	}
	
	public Integer getId() {
		return Id;
	}
	
	public void setId(Integer id) {
		Id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
}
