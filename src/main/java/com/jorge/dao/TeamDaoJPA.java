package com.jorge.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.jorge.domain.Team;


public interface TeamDaoJPA extends CrudRepository<Team, Long> { //CrudRepository es un repositorio proporcionado por la dependencia spring-boot-starter-data-jpa (Spring Data JPA library)

	List<Team> findAll(); //Spring Data is going to know how to implement that method for me
	
	Team findByName(String name); //Spring Data is going to know how to implement that method for me
}
