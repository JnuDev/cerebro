package com.meli.cerebro.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.validation.DnaValidation;

@Component
public class DnaValidationImpl implements DnaValidation {

	
	private final static String REGEXR = "[^ATCG]";
	
	private static int SEQUENCE_SIZE_LIMIT = 4;
	
	@Override
	public void validate(String[] dna) throws CerebroException {
	
		if (dna != null ){
			int dnaSize = dna.length;

			validateSize(dnaSize);
			validateNucleotides(dna); 			
			
			for (String seq : dna) {
				validateSizeSequence(seq.length(), dnaSize); 				
			}
		}else {
			throw new CerebroException("DNA without values");
		}
		
	}	
	
	private void validateNucleotides(String[] dna) throws CerebroException {
		
		String str =  String.join("", dna);		
		Pattern pattern = Pattern.compile(REGEXR, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		if (matcher.find()) {
			throw new CerebroException("Invalid nucleotides! ");
		}
		
	}

	private void validateSizeSequence(int seqSize, int dnaSize) throws CerebroException {
		if (seqSize != dnaSize) {
			throw new CerebroException("A sequence with the wrong size was found");
		}
		
	}

	private void validateSize(int dnaSize) throws CerebroException {		
		if (dnaSize < SEQUENCE_SIZE_LIMIT) {
			throw new CerebroException("Invalid size DNA");
		}		
		
	}
	
	
	
	

}
