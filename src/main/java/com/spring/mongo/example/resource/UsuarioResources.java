package com.spring.mongo.example.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.example.model.Usuario;
import com.spring.mongo.example.service.IUsuarioService;


@RestController
@RequestMapping("usuarios")
public class UsuarioResources {
	
	@Autowired
	private IUsuarioService iUsuarioService;

	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> listar(){
		return ResponseEntity.ok(iUsuarioService.listarTodos());
	}
	
	@ResponseBody
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ResponseEntity<?> listar(
			@RequestParam(required= false) String nome,
			@RequestParam(required= false) String email){
		return ResponseEntity.ok(iUsuarioService.buscar(nome, email));
	}

	@ResponseBody
	@RequestMapping(value = "/{login}" ,method = RequestMethod.GET)
	public ResponseEntity<?> buscarPeloLogin(@PathVariable String login){
		return ResponseEntity.ok(iUsuarioService.buscarPeloLogin(login));
	}
	
	@ResponseBody
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> inserir(@RequestBody Usuario usuario){
		return ResponseEntity.ok(iUsuarioService.inserir(usuario));
	}
	
}
