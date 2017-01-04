package com.jorge;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

import com.jorge.dao.TeamDaoJPA;
import com.jorge.domain.Player;
import com.jorge.domain.Team;

/**
 * De jar a war:
 * 	1º Cambiarlo en el pom.xml, en la etiqueta "<packaging>"
 * 	2º Extender de SpringBootServletInitializer en esta clase
 *  3º Desplegarlo en un servidor web que no sea el Tomcat embebido por la dependencia spring-boot-starter-web
 *  	http://localhost:8080/<app-name>/
 *
 */
//@SpringBootApplication //Si @SpringBootApplication estuviera en com.jorge no habría que especificar scanBasePackages, escanearía todos los paquetes que hay desde su nivel hacia abajo, incluyendo com.jorge.controller que es donde está el mapeo de "/hi"
						 //Si no especificamos scanBasePackages o esta clase no está en com.jorge, nunca escanearía el controlador WhateverController.java ni mapearía "/hi"
@SpringBootApplication //(scanBasePackages={"com.jorge.controller"})
public class MainApplication extends SpringBootServletInitializer { //SpringBootServletInitializer: en el curso se dice que es necesario para convertir de jar a war, a parte de cambiarlo en el pom.xml en la etiqueta <packaging></packaging>

	//Ejemplo de Spring Data, JPA, persistencia, etc
	@Autowired
	TeamDaoJPA teamDao;
	
	/**
	 * Used when run as a JAR
	 * */
	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}
	
	/**
	 * Used when run as a WAR
	 * */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(MainApplication.class);
	}
	
	
	//Ponemos aquí este método que estaba en el controlador BaseBallController.java para el
	//ejemplo de Spring Data, JPA, persistencia, etc
	@PostConstruct //Este método se ejecuta una vez se ha inicializado el constructor
	public void init(){
		Set<Player> players = new HashSet<>();
		
		players.add(new Player("Homer Simpson", "pitcher"));
		players.add(new Player("Mr. Burns","shortstop"));
		
		Team team = new Team("California", "Peanuts", players);
		
		//Lo que viene a continuación ya no está en el método original
		teamDao.save(team);
	}
	
}
