package com.isdma.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.isdma.workshopmongo.domain.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {//eu faço herdar desta classe e assim já tenho varios tidos de metodos que consigo fazer como criação para a bd etc, so tenho de colocar no T o tipo da classe de dominio que ele vai gerenciar no seguinte o tipo do id dessa classe que no caso é String
//so com isto o meu objeto UserRepository vai conseguir fazer varias operações com a bd com os meu Users
	//CRUD embiuitido no UserRepository
	
}
