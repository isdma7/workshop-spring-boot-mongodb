package com.isdma.workshopmongo.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.isdma.workshopmongo.domain.User;
import com.isdma.workshopmongo.dto.UserDTO;
import com.isdma.workshopmongo.services.UserService;

@RestController
@RequestMapping(value="/users")
public class UserResource {
	
	@Autowired
	private UserService service; //Injetamos as dependecias igual ao que fizemos no repository, e entao assim sendo o Resource acessa o Service que posteriormente acessa o Repository
	
	@RequestMapping(method = RequestMethod.GET) //podia meter so GetMapping
	public ResponseEntity<List<UserDTO>> findAll(){ // podiamos retornar uma lista normal mas o Spring tem um objeto sufiticado que engloba o nosso objeto e agrega resposta de possiveis erros cabeçalhos etc, o ResponseEntity, tudo encapsulado numa resposta http
		//User maria = new User("1", "Maria Brown", "maria@gmail.com");
		//User alex= new User("2", "Alex Green", "alex@gmail.com");
		
		List<User> list = service.findAll();
		
		List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());//Converter User para userDTO usando lambda
		
		//list.addAll(Arrays.asList(maria, alex));	
		
		return ResponseEntity.ok().body(listDto);
				//ok metodo que instancia ResponseEntity ja com resposta de sucesso que ocorreu com sucesso a repsosta e no corpo da mensagem coloco a nossa list com o body
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) //podia meter so GetMapping
	public ResponseEntity<UserDTO> findById(@PathVariable String id){//para saber que vou bucar o id à requisição uso o PathVariable
		
		User obj = service.findById(id);
	
		return ResponseEntity.ok().body(new UserDTO(obj));
	}
	
	@RequestMapping(method = RequestMethod.POST) //inserir usamos o POST, se usar @PostMapping tambem da
	public ResponseEntity<Void> insert(@RequestBody UserDTO objDto){
		
		User obj = service.fromDTO(objDto); //converto primeito o userdto para user
		
		obj = service.insert(obj);
 	
		//boa pratica pegar o endereço do novo objeto que inseri e que no spring se faz com assim
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		
		
		return ResponseEntity.created(uri).build();
	}
	
	
}
