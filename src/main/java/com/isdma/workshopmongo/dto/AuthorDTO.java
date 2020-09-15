package com.isdma.workshopmongo.dto;

import java.io.Serializable;

import com.isdma.workshopmongo.domain.User;

//DTO servem para projetar apenas as partes que queiramos dos objetos por exemplo aqui so vou queres o id e nome do user que é autor do post neste caso
public class AuthorDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDTO() {
		
	}

	public AuthorDTO(User obj) {
		super();
		this.id = obj.getId();
		this.name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
