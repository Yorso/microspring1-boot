package com.jorge.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * De jar a war:
 * 	Cambiarlo en el pom.xml, en la etiqueta <packaging>
 * 	Extender de SpringBootServletInitializer en esta clase
 *  Desplegarlo en un servidor web que no sea el Tomcat embebido por la dependencia spring-boot-starter-web
 *
 */
@SpringBootApplication
public class Config extends SpringBootServletInitializer { //SpringBootServletInitializer: en el curso se dice que es necesario para convertir de jar a war, a parte de cambiarlo en el pom.xml

	public static void main(String[] args) {
		SpringApplication.run(Config.class, args);
	}
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(Config.class);
	}
	
}
