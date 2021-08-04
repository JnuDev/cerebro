package com.meli.cerebro.scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.repository.HumanRepository;
import com.meli.cerebro.service.domain.Human;
import com.meli.cerebro.validation.DnaValidation;

@SpringBootTest
public class MutantScannerTest {
	@MockBean
	private HumanRepository dnaHumanRepository;
	
	@MockBean
	private DnaValidation dnaValidation;
	
	@MockBean
	private DnaSequencer dnaSequencer;
	
	@Autowired
	private MutantScanner mutantScanner;
	
	
	@Test
	public void isMutantAllStepsTrue() throws CerebroException {
		String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

	
		doNothing().when(dnaValidation).validate(dna);
		dnaValidation.validate(dna);
		verify(dnaValidation, times(1)).validate(dna);
		
		when(dnaSequencer.getSequences(dna)).thenReturn(2);
		
		boolean result = mutantScanner.isMutant(dna);

		assertEquals(true, result);
	}
	
	
	@Test
	public void isMutantAllStepsFalse() throws CerebroException {
		String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		
		doNothing().when(dnaValidation).validate(dna);
		dnaValidation.validate(dna);
		verify(dnaValidation, times(1)).validate(dna);
		
		when(dnaSequencer.getSequences(dna)).thenReturn(1);
		
		boolean result = mutantScanner.isMutant(dna);

		assertEquals(false, result);
	}
	
	
	@Test
	public void isMutantSaveStepNullCase() throws CerebroException {
		String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		
		doNothing().when(dnaValidation).validate(dna);
		dnaValidation.validate(dna);
		verify(dnaValidation, times(1)).validate(dna);
		
		when(dnaSequencer.getSequences(dna)).thenReturn(1);
		
		when(dnaHumanRepository.findByDna(String.join("", dna))).thenReturn(null);
		
		boolean result = mutantScanner.isMutant(dna);

		assertEquals(false, result);
	}
	
	@Test
	public void isMutantSaveStepHumanExistCase() throws CerebroException {
		String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		
		doNothing().when(dnaValidation).validate(dna);
		dnaValidation.validate(dna);
		verify(dnaValidation, times(1)).validate(dna);
		
		when(dnaSequencer.getSequences(dna)).thenReturn(1);
		
		String chainAnd = String.join("", dna);
		
		Human human = new Human(chainAnd, false);
		when(dnaHumanRepository.findByDna(chainAnd)).thenReturn(human);
		
		boolean result = mutantScanner.isMutant(dna);

		assertEquals(false, result);
	}
	
	
	@Test
	public void isMutantSaveStepExceptionCase() throws CerebroException{
		String[] dna = new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };

		//execute validations
		doNothing().when(dnaValidation).validate(dna);
		dnaValidation.validate(dna);
		verify(dnaValidation, times(1)).validate(dna);
		
		when(dnaSequencer.getSequences(dna)).thenReturn(1);
		
		when(dnaHumanRepository.findByDna(String.join("", dna))).thenThrow(new RuntimeException());
		
		Exception e = assertThrows(CerebroException.class, () -> mutantScanner.isMutant(dna));
		assertEquals("Error saving records into Person table", e.getMessage());
	}
}
