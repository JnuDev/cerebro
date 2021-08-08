package com.meli.cerebro.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.meli.cerebro.service.domain.Human;

public interface HumanRepository extends MongoRepository<Human, String> {

	public Human findByDna(String dna);
		
	public List<Human> findByIsMutant(boolean isMutant); 
	
}
