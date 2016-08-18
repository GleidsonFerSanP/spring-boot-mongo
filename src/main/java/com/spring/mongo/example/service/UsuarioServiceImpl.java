package com.spring.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatcher;
import org.springframework.data.domain.ExampleMatcher.MatcherConfigurer;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.spring.mongo.example.model.Usuario;
import com.spring.mongo.example.repository.IUsuarioRepository;
import com.spring.mongo.example.util.Uteis;

@Service
public class UsuarioServiceImpl implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepository iUsuarioRepository;
	
	@Override
	public List<Usuario> listarTodos() {
		return iUsuarioRepository.findAll();
	}

	@Override
	public Usuario inserir(Usuario usuario) {
		return iUsuarioRepository.save(usuario);
	}

	@Override
	public Usuario buscarPeloLogin(String login) {
		return iUsuarioRepository.findByLogin(login);
	}

	@Override
	public List<Usuario> buscar(String nome, String email) {
		
		if(!Uteis.ehNuloOuVazio(nome) && !Uteis.ehNuloOuVazio(email)){
			
			Usuario usuario = new Usuario();                          
			usuario.setNome(nome);                           
			usuario.setEmail(email);                           

			ExampleMatcher matcher = ExampleMatcher.matching()     
			  .withIgnoreCase("nome","email");

			Example<Usuario> example = Example.of(usuario, matcher);
			
			return iUsuarioRepository.findAll(example);
		}
		
		if(!Uteis.ehNuloOuVazio(nome)){
			return iUsuarioRepository.findByNome(nome);
		}
		
		if(!Uteis.ehNuloOuVazio(email)){
			return iUsuarioRepository.findByEmail(email);
		}
		
		return iUsuarioRepository.findAll();
	}

}
