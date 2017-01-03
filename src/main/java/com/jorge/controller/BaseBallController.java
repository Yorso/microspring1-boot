package com.jorge.controller;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jorge.domain.Player;
import com.jorge.domain.Team;

//@Controller
@RestController //Considera cualquier respuesta de los métodos de esta clase como @ResponseBody. Hay que eliminar las 
				//anotaciones @ResponseBody de todos los métodos y @Controller de la clase
public class BaseBallController {

	private Team team;
	
	@PostConstruct //Este método se ejecuta una vez se ha inicializado el conSet<E>uctor
	public void init(){
		Set<Player> players = new HashSet<>();
		
		players.add(new Player("Homer Simpson", "pitcher"));
		players.add(new Player("Mr. Burns","shortstop"));
		
		team = new Team("California", "Peanuts", players);
	}
	
	@RequestMapping("/hiTeam")
	//@ResponseBody
	public Team hiTeam(){
		return team; //This method returns a domain object, NOT a logical view name (page)
	}
	
}
