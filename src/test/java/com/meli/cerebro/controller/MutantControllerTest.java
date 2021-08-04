package com.meli.cerebro.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.meli.cerebro.exception.BaseException;
import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.service.MutantService;
import com.meli.cerebro.service.domain.pojo.Dna;



public class MutantControllerTest {
			

	@Test
	public void isMutantTrue() throws CerebroException {

		Dna dna = new Dna();
		dna.setDna(new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" });

		MutantService mutantService = Mockito.mock(MutantService.class);

		ResponseEntity<String> responseExpected = new ResponseEntity<>(HttpStatus.OK);
		when(mutantService.isMutant(dna)).thenReturn(responseExpected);
		MutantController mutantController = new MutantController(mutantService);

		ResponseEntity<String> responseController = mutantController.isMutant(dna);

		assertEquals(responseExpected.getStatusCodeValue(), responseController.getStatusCodeValue());
		assertEquals(200, responseController.getStatusCodeValue());
	}
	
	
	@Test
	public void isMutantFalse() throws CerebroException {

		Dna dna = new Dna();
		dna.setDna(new String[] { "CGAG", "TGCG", "TGTG", "AGGT", "CTAC", "TCAC" });

		MutantService mutantService = Mockito.mock(MutantService.class);

		ResponseEntity<String> responseExpected = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		when(mutantService.isMutant(dna)).thenReturn(responseExpected);
		MutantController mutantController = new MutantController(mutantService);

		ResponseEntity<String> responseController = mutantController.isMutant(dna);

		assertEquals(responseExpected.getStatusCodeValue(), responseController.getStatusCodeValue());
		assertEquals(403, responseController.getStatusCodeValue());

	}
	
	@Test
	public void isMutantWhitException() throws CerebroException {

		Dna dna = new Dna();
		dna.setDna(new String[] { "CXA", "TXC", "TXT", "AXG", "CXA", "TXA" });

		MutantService mutantService = Mockito.mock(MutantService.class);

		when(mutantService.isMutant(dna)).thenThrow(new CerebroException("ScannerException"));
		MutantController mutantController = new MutantController(mutantService);

		ResponseEntity<String> responseController = mutantController.isMutant(dna);
		ResponseEntity<String> responseExpected = new ResponseEntity<>(HttpStatus.FORBIDDEN);

		assertEquals(responseExpected.getStatusCodeValue(), responseController.getStatusCodeValue());
		assertEquals(403, responseController.getStatusCodeValue());

	}
	
	@Test
	public void isMutantWhitRepositoryExceptionException() throws CerebroException {

		Dna dna = new Dna();
		dna.setDna(new String[] { "ABBB", "ACCC", "TXT", "AAXG", "DCXA", "TXCA" });

		MutantService mutantService = Mockito.mock(MutantService.class);

		when(mutantService.isMutant(dna)).thenThrow(new CerebroException("RepositoryException"));
		MutantController mutantController = new MutantController(mutantService);

		ResponseEntity<String> responseController = mutantController.isMutant(dna);
		ResponseEntity<String> responseExpected = new ResponseEntity<>(HttpStatus.FORBIDDEN);

		assertEquals(responseExpected.getStatusCodeValue(), responseController.getStatusCodeValue());
		assertEquals(403, responseController.getStatusCodeValue());

	}

}
