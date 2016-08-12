package com.spring.mongo.example.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("banner-form")

public class BannerController {

	@RequestMapping( method = RequestMethod.GET)
	public String carregar(String id){
		return "banner";
	}
	
}
