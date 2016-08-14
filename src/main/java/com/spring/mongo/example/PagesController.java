package com.spring.mongo.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class PagesController {

	@RequestMapping(value="banner-form", method = RequestMethod.GET)
	public String banner(){
		return "banner";
	}
	
	@RequestMapping(value="categoria-form", method = RequestMethod.GET)
	public String categoria(){
		return "categoria";
	}
	
	@RequestMapping(value="subcategoria-form", method = RequestMethod.GET)
	public String subcategoria(){
		return "subcategoria";
	}

	@RequestMapping(value="usuario-form", method = RequestMethod.GET)
	public String usuario(){
		return "usuario";
	}
}
