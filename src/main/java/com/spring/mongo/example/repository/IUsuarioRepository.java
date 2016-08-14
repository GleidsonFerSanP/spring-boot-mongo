package com.spring.mongo.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.example.model.Usuario;

public interface IUsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findByLogin(String login);
}
