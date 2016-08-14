package com.spring.mongo.example.service;

import java.util.List;

import com.spring.mongo.example.model.Categoria;

public interface ICategoriaService {

	List<Categoria> listarTodos();

	Categoria inserir(Categoria categoria);

	Categoria buscarPeloNome(String nome);

}
