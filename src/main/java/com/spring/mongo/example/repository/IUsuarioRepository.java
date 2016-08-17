package com.spring.mongo.example.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.example.model.Usuario;

public interface IUsuarioRepository extends MongoRepository<Usuario, String>{

	Usuario findByLogin(String login);

	List<Usuario> findByNomeOrEmail(String nome, String email);
}
