package com.isdma.workshopmongo.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.isdma.workshopmongo.domain.Post;
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
	
}
