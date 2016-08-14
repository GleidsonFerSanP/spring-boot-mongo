package com.spring.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.example.model.Subcategoria;
import com.spring.mongo.example.repository.ISubcategoriaRepository;

@Service
public class SubcategoriaServiceImpl implements ISubcategoriaService{
	
	@Autowired
	private ISubcategoriaRepository isubcategoriaRepository;
	
	@Override
	public List<Subcategoria> listarTodos() {
		return isubcategoriaRepository.findAll();
	}

	@Override
	public Subcategoria inserir(Subcategoria categoria) {
		return isubcategoriaRepository.save(categoria);
	}

	@Override
	public Subcategoria buscarPeloNome(String nome) {
		return isubcategoriaRepository.findByNome(nome);
	}

}
