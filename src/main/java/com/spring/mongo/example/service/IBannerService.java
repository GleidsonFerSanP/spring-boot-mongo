package com.spring.mongo.example.service;

import java.util.List;

import com.spring.mongo.example.model.Banner;

public interface IBannerService {
	
	List<Banner> listarTodos();

	Banner inserir(Banner banner);

}
