package com.spring.mongo.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.example.model.Subcategoria;
import com.spring.mongo.example.service.ISubcategoriaService;


@RestController
@RequestMapping("subcategorias")
public class SubcategoriaResources {
	
	@Autowired
	private ISubcategoriaService iSubcategoriaService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(iSubcategoriaService.listarTodos());
	}
	
	@ResponseBody
	@RequestMapping(value = "/{nome}" ,method = RequestMethod.GET)
	public ResponseEntity<?> buscarPeloNome(@PathVariable String nome){
		return ResponseEntity.ok(iSubcategoriaService.buscarPeloNome(nome));
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> inserir(@RequestBody Subcategoria subcategoria){
		return ResponseEntity.ok(iSubcategoriaService.inserir(subcategoria));
	}
	
}
