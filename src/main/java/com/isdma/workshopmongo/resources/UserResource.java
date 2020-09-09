package com.isdma.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isdma.workshopmongo.domain.User;
import com.isdma.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service; //Injetamos as dependecias igual ao que fizemos no repository, e entao assim sendo o Resource acessa o Service que posteriormente acessa o Repository
	
	@RequestMapping(method = RequestMethod.GET) //podia meter so GetMapping
	public ResponseEntity<List<User>> findAll(){ // podiamos retornar uma lista normal mas o Spring tem um objeto sufiticado que engloba o nosso objeto e agrega resposta de possiveis erros cabeçalhos etc, o ResponseEntity, tudo encapsulado numa resposta http
		//User maria = new User("1", "Maria Brown", "maria@gmail.com");
		//User alex= new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = service.findAll();
		
		//list.addAll(Arrays.asList(maria, alex));	
		
		return ResponseEntity.ok().body(list);
				//ok metodo que instancia ResponseEntity ja com resposta de sucesso que ocorreu com sucesso a repsosta e no corpo da mensagem coloco a nossa list com o body
	}

}
