package com.spring.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.example.model.Usuario;
import com.spring.mongo.example.repository.IUsuarioRepository;

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
		
		return iUsuarioRepository.findByNomeOrEmail(nome,email);
	}

}
