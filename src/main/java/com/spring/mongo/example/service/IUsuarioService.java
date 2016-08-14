package com.spring.mongo.example.service;

import java.util.List;

import com.spring.mongo.example.model.Usuario;

public interface IUsuarioService {

	List<Usuario> listarTodos();

	Usuario inserir(Usuario usuario);

	Usuario buscarPeloLogin(String login);

}
