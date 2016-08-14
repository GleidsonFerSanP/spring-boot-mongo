package com.spring.mongo.example.service;

import java.util.List;

import com.spring.mongo.example.model.Subcategoria;

public interface ISubcategoriaService {

	List<Subcategoria> listarTodos();

	Subcategoria inserir(Subcategoria subcategoria);

	Subcategoria buscarPeloNome(String nome);

}
