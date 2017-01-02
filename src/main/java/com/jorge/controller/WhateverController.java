package com.jorge.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WhateverController {

	@RequestMapping("/hi")
	//@ResponseBody Se puede poner en la declaración del método
	public @ResponseBody String hiThere(){
		return "Hello world!"; //Resultado creado al vuelo gracias a @ResponseBody, no existe página html o jsp
	}
	
	@RequestMapping("/hello")
	public String helloThere1(){
		return "hello"; //Va a la paǵina hello.html, ya no hay que poner @ResponseBody
		
	}
	
	@RequestMapping("/hello/{name}")
	public String helloThere2(Map model, @PathVariable String name){
		model.put("name", name);
		return "hello"; //Va a la paǵina hello.html, ya no hay que poner @ResponseBody
		
	}
	
}
