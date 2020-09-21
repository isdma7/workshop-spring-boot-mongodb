package com.isdma.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.isdma.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {//eu faço herdar desta classe e assim já tenho varios tidos de metodos que consigo fazer como criação para a bd etc, so tenho de colocar no T o tipo da classe de dominio que ele vai gerenciar no seguinte o tipo do id dessa classe que no caso é String
//so com isto o meu objeto UserRepository vai conseguir fazer varias operações com a bd com os meu Users
	//CRUD embiuitido no UserRepository
	
	// querya especificas usamos a tabbela do spring que tem muitas para usar
	List<Post> findByTitleContainingIgnoreCase(String text);
	

	//Fazemos agora o mesmo mas numa consulta personalizada feita por nos com json que é unico e usado neste caso pelo mongodb para qualquer linguagem que lhe aceda
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
}
