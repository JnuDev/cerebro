package com.meli.cerebro.scanner.sequencer;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.meli.cerebro.dataset.Dataset;
import com.meli.cerebro.exception.CerebroException;

@SpringBootTest
public class DnaSequencerTest {
	
	
	@Autowired
	private DnaSequencer dnaSequencer;
	
	@Test
	public void getSequencesHorizontalMutant() throws CerebroException {
		
		String[] dna = Dataset.MUTANT_OK;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(2, result);
	}
	
	@Test
	public void getSequencesHuman() throws CerebroException {
		
		String[] dna = Dataset.HUMAN_OK;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(1, result);
	}
	
	@Test
	public void getSequencesVerticalMutant() throws CerebroException {
		
		String[] dna = Dataset.MATRIX_MUTANT_VERTICAL;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(2, result);
	}
	
	@Test
	public void getSequencesDiagonalPrimaryMutant() throws CerebroException {
		
		String[] dna = Dataset.MATRIX_MUTANT_DIAGONAL_PRIMARY;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(1, result);
	}
	@Test
	public void getSequencesDiagonalSecundaryMutant() throws CerebroException {
		
		String[] dna = Dataset.MATRIX_MUTANT_DIAGONAL_SECUNDARY;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(1, result);
	}
	
	@Test
	public void getSequencesDiagonalPrimary2Mutant() throws CerebroException {
		
		String[] dna = Dataset.MATRIX_MUTANT_DIAGONAL_PRIMARY2;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(2, result);
	}
	@Test
	public void getSequencesDiagonalSecundary2Mutant() throws CerebroException {
		
		String[] dna = Dataset.MATRIX_MUTANT_DIAGONAL_SECUNDARY2;		
		int result= dnaSequencer.getSequences(dna) ;
		assertEquals(2, result);
	}
	
	
	
	
	
}
