package com.spring.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.example.model.Categoria;
import com.spring.mongo.example.repository.ICategoriaRepository;

@Service
public class CategoriaServiceImpl implements ICategoriaService{
	
	@Autowired
	private ICategoriaRepository iCategoriaRepository;
	
	@Override
	public List<Categoria> listarTodos() {
		return iCategoriaRepository.findAll();
	}

	@Override
	public Categoria inserir(Categoria categoria) {
		return iCategoriaRepository.save(categoria);
	}

	@Override
	public Categoria buscarPeloNome(String nome) {
		return iCategoriaRepository.findByNome(nome);
	}

}
