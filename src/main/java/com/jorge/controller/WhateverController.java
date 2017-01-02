package com.jorge.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WhateverController {

	@RequestMapping("/hi")
	//@ResponseBody Se puede poner en la declaración del método
	public @ResponseBody String hiThere(){
		return "Hello world!";
	}
}
