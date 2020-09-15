package com.isdma.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isdma.workshopmongo.domain.User;
import com.isdma.workshopmongo.dto.UserDTO;
import com.isdma.workshopmongo.repository.UserRepository;
import com.isdma.workshopmongo.services.exception.ObjectNotFoundException;

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

	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		
		return user.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado")); //SE O VALOR ESTIVER PRESENTE RETORNA SENAO LANÇA O QUE QUISERMOS
	}
	
	public User insert(User obj) {
		return repo.insert(obj);
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId()); //objeto orginal do bd e que queremos agora atualizar
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(User newObj, User obj) {
		
		newObj.setEmail(obj.getEmail());
		newObj.setName(obj.getName());
		
	}

	public User fromDTO(UserDTO objDto) {
		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
	
}
