package com.meli.cerebro.scanner.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.repository.DnaHumanRepository;
import com.meli.cerebro.scanner.DnaSequencer;
import com.meli.cerebro.scanner.MutantScanner;
import com.meli.cerebro.service.domain.Human;
import com.meli.cerebro.validation.DnaValidation;

public class MutantScannerImpl implements MutantScanner {

	@Autowired
	DnaValidation validation;
	
	@Autowired
	DnaSequencer dnaSequencer;
	
	private DnaHumanRepository dnaHumanRepository;
	
	private static final int MIN_SEQUENCES = 2;
	
	@Override
	public boolean isMutant(String[] dna) throws CerebroException {
		boolean isMutant = false;
		int sequences = 0;

		validation.validate(dna);

		sequences = dnaSequencer.getSequences(dna);
		if (sequences >= MIN_SEQUENCES) {
			isMutant = true;
		}

		saveDna(dna, isMutant);

		return isMutant;
	}
	private void saveDna(String[] dna, boolean isMutant) throws CerebroException {
		
		String dnaChain = String.join("", dna);
		
		try {
			Human human = dnaHumanRepository.findByDna(dnaChain);

			if (human == null || !dnaChain.equalsIgnoreCase(human.getDna())) {
				human = new Human(dnaChain, isMutant);
				dnaHumanRepository.save(human);
			}

		} catch (Exception e) {
			throw new CerebroException("Error saving records into Person table");
		}
		
		
	}

}
