package com.spring.mongo.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.spring.mongo.example.model.Banner;

@Repository
public interface IBannerRepository extends MongoRepository<Banner, String>{

}
