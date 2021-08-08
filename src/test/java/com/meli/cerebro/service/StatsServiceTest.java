package com.meli.cerebro.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.scanner.StatsScanner;
import com.meli.cerebro.service.domain.pojo.Stats;

@SpringBootTest
class StatsServiceTest {
	
		
	@MockBean
	private StatsScanner statsScanner;
	

	@Autowired
	private StatsService statsService;
	
	@Test
	public void shouldGetStats() throws CerebroException {
		Stats statsExpected = new Stats(0, 0);
		when(statsScanner.getRatio()).thenReturn(statsExpected);
		
		Stats stats = statsService.getRatio();

		assertEquals(statsExpected.getCount_human_dna(), stats.getCount_human_dna());
		assertEquals(statsExpected.getCount_mutant_dna(), stats.getCount_mutant_dna());
		assertEquals(statsExpected.getRatio(), stats.getRatio());

	}
}
