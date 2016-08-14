package com.spring.mongo.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.example.model.Categoria;
import com.spring.mongo.example.service.ICategoriaService;


@RestController
@RequestMapping("categorias")
public class CategoriaResources {
	
	@Autowired
	private ICategoriaService iCategoriaService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(iCategoriaService.listarTodos());
	}
	
	@ResponseBody
	@RequestMapping(value = "/{nome}" ,method = RequestMethod.GET)
	public ResponseEntity<?> buscarPeloNome(@PathVariable String nome){
		return ResponseEntity.ok(iCategoriaService.buscarPeloNome(nome));
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> inserir(@RequestBody Categoria categoria){
		return ResponseEntity.ok(iCategoriaService.inserir(categoria));
	}
	
}
