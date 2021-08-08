package com.meli.cerebro.scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.repository.HumanRepository;
import com.meli.cerebro.service.domain.Human;
import com.meli.cerebro.service.domain.pojo.Stats;

@SpringBootTest
class StatsScannerTest {

	

	@MockBean
	private HumanRepository humanRepository;
	
	@Autowired
	private StatsScanner statsScanner;

	@Test
	public void shouldFindByIsMutant() throws CerebroException {
		
		Stats statsExpected = new Stats(0, 0); 
		
		when(humanRepository.findByIsMutant(false)).thenReturn(new ArrayList<Human>());
		when(humanRepository.findByIsMutant(true)).thenReturn(new ArrayList<Human>());

		Stats statsResponse = statsScanner.getRatio();

		assertEquals(statsExpected.getCount_human_dna(), statsResponse.getCount_human_dna());
		assertEquals(statsExpected.getCount_mutant_dna(), statsResponse.getCount_mutant_dna());
		assertEquals(statsExpected.getRatio(), statsResponse.getRatio());

	}
	
	@Test
	public void shouldFindByIsMutantFail() throws CerebroException {
		when(humanRepository.findByIsMutant(false)).thenThrow(new RuntimeException());
		Exception e = assertThrows(CerebroException.class, () -> statsScanner.getRatio());
		assertEquals("Error to get records", e.getMessage());
	}

}
