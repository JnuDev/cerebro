package com.meli.cerebro.service;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.meli.cerebro.dataset.Dataset;
import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.scanner.MutantScanner;
import com.meli.cerebro.service.MutantService;
import com.meli.cerebro.service.domain.pojo.Dna;


@SpringBootTest
public class MutantServiceTest {

	@MockBean
	private MutantScanner mutantSequencer;

	@Autowired
	private MutantService mutantService;

	@Test
	public void isMutantTrue() throws CerebroException {

		String[] dnaStr =Dataset.MUTANT_OK;

		Dna dna = new Dna();
		dna.setDna(dnaStr);

		ResponseEntity<String> responseExpected = new ResponseEntity<>(HttpStatus.OK);

		when(mutantSequencer.isMutant(dnaStr)).thenReturn(true);

		ResponseEntity<String> response = mutantService.isMutant(dna);

		assertEquals(responseExpected.getStatusCodeValue(), response.getStatusCodeValue());
		assertEquals(200, response.getStatusCodeValue());

	}

	@Test
	public void isMutantFalse() throws CerebroException {

		String[] dnaStr = Dataset.HUMAN_OK;

		Dna dna = new Dna();
		dna.setDna(dnaStr);

		ResponseEntity<String> responseExpected = new ResponseEntity<>(HttpStatus.FORBIDDEN);

		when(mutantSequencer.isMutant(dnaStr)).thenReturn(false);

		ResponseEntity<String> response = mutantService.isMutant(dna);

		assertEquals(responseExpected.getStatusCodeValue(), response.getStatusCodeValue());
		assertEquals(403, response.getStatusCodeValue());

	}
}