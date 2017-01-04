package com.jorge.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.jorge.domain.Team;

/*
 * Try in browser:
 * 		http://localhost:8080/microspring1-boot/teams 
 * 		http://localhost:8080/microspring1-boot/teams/1
 */
@RestResource(path="teams", rel="teams")
public interface TeamDaoREST extends CrudRepository<Team, Long> { //CrudRepository es un repositorio proporcionado por la dependencia spring-boot-starter-data-jpa (Spring Data JPA library)

	List<Team> findAll(); //Spring Data is going to know how to implement that method for me
	
	Team findByName(String name); //Spring Data is going to know how to implement that method for me
}
