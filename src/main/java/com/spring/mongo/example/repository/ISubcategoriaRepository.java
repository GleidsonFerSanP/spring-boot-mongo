package com.spring.mongo.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.example.model.Subcategoria;

public interface ISubcategoriaRepository extends MongoRepository<Subcategoria, String>{

	Subcategoria findByNome(String nome);

}
