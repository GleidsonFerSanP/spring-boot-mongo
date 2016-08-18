package com.spring.mongo.example.repository;

import java.util.List;

import com.spring.mongo.example.model.Usuario;

public interface IUsuarioRepositoryCustom{
	
	List<Usuario> findByNomeILikeOrEmailILike(String nome, String email);

}
