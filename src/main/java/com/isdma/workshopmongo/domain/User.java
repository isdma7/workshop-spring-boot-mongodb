package com.isdma.workshopmongo.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

//para dizer que user corresponde a uma coleçºao la no mongodb usamos esta anotação aqui na minha classe de dominio
@Document(collection = "user") // se nao meter (collection = "user") dá igual, ele pega no nome da classe que é User e coloca em letra pequena user criando a coleçao com esse nome
public class User implements Serializable {//dados transfomados em bytes para trafegar na rede ou gravado em arquivo
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String name;
	private String email;
	
	@DBRef(lazy = true) //lazy = true garante que os posts so sao carregados se eu explicitamente pedir, o DbRef da-nos no mongodb apenas as refs dos posts de cada user, tal como preferimos neste caso e nao aninhar os posts de cada user quando vamos buscar um
	private List<Post> posts = new ArrayList<>();
	
	

	public User() {
		
	}

	public User(String id, String name, String email) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
