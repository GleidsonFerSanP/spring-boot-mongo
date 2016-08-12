package com.spring.mongo.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mongo.example.model.Banner;
import com.spring.mongo.example.repository.IBannerRepository;

@Service
public class BannerServiceImpl implements IBannerService{
	
	@Autowired
	private IBannerRepository iBannerRepository;
	
	@Override
	public List<Banner> listarTodos() {
		return iBannerRepository.findAll();
	}

	@Override
	public Banner inserir(Banner banner) {
		return iBannerRepository.save(banner);
	}

}
