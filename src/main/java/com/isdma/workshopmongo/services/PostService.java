package com.isdma.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isdma.workshopmongo.domain.Post;
import com.isdma.workshopmongo.repository.PostRepository;
import com.isdma.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {
	
	//tem de conversar com o repository que esse é que conversa com BD
	//entao instanciamos do tipo UserRepository
	
	@Autowired //instancia automaticamente um objeto no serviço
	private PostRepository repo; //ou seja no caso o proprio Spring procurar a definição deste objeto que no caso é no repository e vai isntacia-lo automaticamente para mim
	//mecanismo de injeçao automatica de dependencia do Spring
	
	public Post findById(String id) {
		Optional<Post> post = repo.findById(id);
		
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); //SE O VALOR ESTIVER PRESENTE RETORNA SENAO LANÇA O QUE QUISERMOS
	}

}
