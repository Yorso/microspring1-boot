package com.jorge.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;

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
@SpringBootApplication(scanBasePackages={"com.jorge.controller"})
public class MainApplication extends SpringBootServletInitializer { //SpringBootServletInitializer: en el curso se dice que es necesario para convertir de jar a war, a parte de cambiarlo en el pom.xml

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
	
}
