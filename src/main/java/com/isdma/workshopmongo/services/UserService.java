package com.isdma.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isdma.workshopmongo.domain.User;
import com.isdma.workshopmongo.repository.UserRepository;

@Service
public class UserService {
	
	//tem de conversar com o repository que esse é que conversa com BD
	//entao instanciamos do tipo UserRepository
	
	@Autowired //instancia automaticamente um objeto no serviço
	private UserRepository repo; //ou seja no caso o proprio Spring procurar a definição deste objeto que no caso é no repository e vai isntacia-lo automaticamente para mim
	//mecanismo de injeçao automatica de dependencia do Spring
	
	public List<User> findAll(){
		return repo.findAll(); //e assim posso chamar imensas operações na bd
	}

}
