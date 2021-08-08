package com.meli.cerebro.scanner.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.repository.HumanRepository;
import com.meli.cerebro.scanner.StatsScanner;
import com.meli.cerebro.service.domain.Human;
import com.meli.cerebro.service.domain.pojo.Stats;

@Component
public class StatsScannerImpl implements StatsScanner {

	@Autowired
	HumanRepository humanRepository;
	
	@Override
	public Stats getRatio() throws CerebroException {
		
		List<Human> mutants;
		List<Human> humans;
		try {
			 mutants = humanRepository.findByIsMutant(true);
			 humans = humanRepository.findByIsMutant(false);
			
		} catch (Exception e) {
			throw new CerebroException("Error to get records");
		}
		
		return  new Stats(mutants.size(),humans.size());
	}
	
	

}
