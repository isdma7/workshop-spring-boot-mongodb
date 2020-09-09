package com.isdma.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isdma.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@RequestMapping(method = RequestMethod.GET) //podia meter so GetMapping
	public ResponseEntity<List<User>> findAll(){ // podiamos retornar uma lista normal mas o Spring tem um objeto sufiticado que engloba o nosso objeto e agrega resposta de possiveis erros cabeçalhos etc, o ResponseEntity, tudo encapsulado numa resposta http
		User maria = new User("1", "Maria Brown", "maria@gmail.com");
		User alex= new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = new ArrayList<>();
		
		list.addAll(Arrays.asList(maria, alex));	
		
		return ResponseEntity.ok(list);
	}

}