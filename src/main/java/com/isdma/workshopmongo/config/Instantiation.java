package com.isdma.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.isdma.workshopmongo.domain.User;
import com.isdma.workshopmongo.repository.UserRepository;

//para o Spring perceber que é uma classe de configuração
@Configuration
public class Instantiation implements CommandLineRunner {
	// temos de implementar os metodos desta interface, esta classe serve para fazer testes
	//serve para instanciarmos a nossa bd etc
	
	//injetar a dependencia do repository para podermos trabalhar com a bd apartir daqui
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		// TODO Auto-generated method stub
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.deleteAll(); //zerar coleção na bd
		
		
		userRepository.saveAll(Arrays.asList(maria,alex,bob));	
	}
	

}
