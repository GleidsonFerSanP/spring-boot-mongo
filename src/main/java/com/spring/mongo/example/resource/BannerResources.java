package com.spring.mongo.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.example.model.Banner;
import com.spring.mongo.example.service.IBannerService;


@RestController
@RequestMapping("banners")
public class BannerResources {
	
	@Autowired
	private IBannerService iBannerService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(iBannerService.listarTodos());
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> inserir(@RequestBody Banner banner){
		return ResponseEntity.ok(iBannerService.inserir(banner));
	}
	
}
