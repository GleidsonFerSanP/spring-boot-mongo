package com.spring.mongo.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.example.model.Categoria;

public interface ICategoriaRepository extends MongoRepository<Categoria, String>{

	List<Categoria> findById(String nome);
	
	List<Categoria> findByNome(String nome);
	
	List<Categoria> findByNomeIgnoreCase(String nome);

}
