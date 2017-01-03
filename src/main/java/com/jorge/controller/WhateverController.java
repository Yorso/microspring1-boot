package com.jorge.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WhateverController {

	@RequestMapping("/hi") // Presentación de la página renderizada por @ResponseBody
	//@ResponseBody Se puede poner en la declaración del método
	public @ResponseBody String hiThere(){
		return "Hello world!"; //Resultado creado al vuelo gracias a @ResponseBody, no existe página html o jsp
	}
	
	@RequestMapping("/hello") //Thymeleaf
	public String helloThere1(){
		return "hello"; //Pinta la paǵina src/main/resources/templates/hello.html, ya no hay que poner @ResponseBody
		
	}
	
	@RequestMapping("/hello/{name}") //Thymeleaf
	public String helloThere2(Map model, @PathVariable String name){
		model.put("name", name);
		return "hello"; //Pinta la paǵina src/main/resources/templates/hello.html, ya no hay que poner @ResponseBody
		
	}
	
	@RequestMapping("/hello2/{name}") //JSP - prefijo y sufijo en src/main/resources/application.properties
	public String helloThere3(Map model, @PathVariable String name){
		model.put("name", name);
		return "hello2"; //Pinta la paǵina src/main/webapp/WEB-INF/views/hello2.jsp, ya no hay que poner @ResponseBody
		
	}
	
}
