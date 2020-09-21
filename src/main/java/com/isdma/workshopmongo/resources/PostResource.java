package com.isdma.workshopmongo.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.isdma.workshopmongo.domain.Post;
import com.isdma.workshopmongo.resources.util.URL;
import com.isdma.workshopmongo.services.PostService;

@RestController
@RequestMapping(value="/posts")
public class PostResource {
	
	@Autowired
	private PostService service; //Injetamos as dependecias igual ao que fizemos no repository, e entao assim sendo o Resource acessa o Service que posteriormente acessa o Repository

	@RequestMapping(value = "/{id}", method = RequestMethod.GET) //podia meter so GetMapping
	public ResponseEntity<Post> findById(@PathVariable String id){//para saber que vou bucar o id à requisição uso o PathVariable
		
		Post obj = service.findById(id);
	
		return ResponseEntity.ok().body(obj);
		
	}
	
	
	//URL para pesquisar sera http://localhost:8081/posts/titlesearch?teta=m%20dia no postman
	@RequestMapping(value = "/titlesearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitle(@RequestParam(value="teta", defaultValue = "") String text){ //para meu endpoint identificar o nome do paramentro que eu dei @RequestParam(value="text") que é text no caso, se valor nao for informado colocamos string vazia por defeito
		text = URL.decodeParam(text);
		
		List<Post> list = service.findByTitle(text);
	
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@RequestMapping(value = "/fullsearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value="teta", defaultValue = "") String text,
			@RequestParam(value="minDate", defaultValue = "") String minDate,
			@RequestParam(value="maxDate", defaultValue = "") String maxDate){ 
		text = URL.decodeParam(text);
		Date min = URL.convertDate(minDate, new Date(0L));//caso ocorra problema na conversao damos data minima java fica 01-01-1970
		Date max = URL.convertDate(maxDate, new Date());//caso de problema damos data atual
		
		List<Post> list = service.fullSearch(text, min, max);
	
		return ResponseEntity.ok().body(list);
		
	}
	
	
	
}
