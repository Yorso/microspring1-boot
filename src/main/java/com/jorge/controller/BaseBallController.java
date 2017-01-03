package com.jorge.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.dao.TeamDao;
import com.jorge.domain.Player;
import com.jorge.domain.Team;

//@Controller está comentado porque tenemos definido @RestController
@RestController //Considera cualquier respuesta de los métodos de esta clase como @ResponseBody. Hay que eliminar las 
				//anotaciones @ResponseBody de todos los métodos y @Controller de la clase
				//Es decir, o usamos @Controller + @ResponseBody, o sólo @RestController
public class BaseBallController {

	private Team team;
	
	//Para el ejemplo de Spring Data, JPA, persistencia, etc
	@Autowired
	TeamDao teamDao;
	
	//Para el ejemplo de Spring Data, JPA, persistencia, etc movemos este método a MainApplication.java
	/*
	@PostConstruct //Este método se ejecuta una vez se ha inicializado el constructor
	public void init(){
		Set<Player> players = new HashSet<>();
		
		players.add(new Player("Homer Simpson", "pitcher"));
		players.add(new Player("Mr. Burns","shortstop"));
		
		team = new Team("California", "Peanuts", players);
	}
	*/
	
	@RequestMapping("/hiTeam")
	//@ResponseBody está comentado porque tenemos definido @RestController
	public Team hiTeam(){
		return team; //This method returns a domain object, NOT a logical view name (page)
	}
	
	
	//Para el ejemplo de Spring Data, JPA, persistencia, etc
	@RequestMapping("/findTeam/{teamName}")
	//@ResponseBody está comentado porque tenemos definido @RestController
	public Team findTeam(@PathVariable String teamName){
		return teamDao.findByName(teamName); //Encuentra el equipo con ese nombre y lo mostramos en la página
	}
	
}
