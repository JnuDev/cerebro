package com.meli.cerebro.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.service.StatsService;
import com.meli.cerebro.service.domain.pojo.Stats;



public class StatsControllerTest {
			

	
	@Test
	public void getStatsTrue() throws CerebroException {
		StatsService statsService = Mockito.mock(StatsService.class);
		when(statsService.getRatio()).thenReturn(new Stats(40, 100));
		StatsController statsController = new StatsController(statsService);

		Stats statsExpected = new Stats(40, 100);
		assertEquals(statsExpected.getCount_human_dna(), statsController.stats().getCount_human_dna());
		assertEquals(statsExpected.getCount_mutant_dna(), statsController.stats().getCount_mutant_dna());
		assertEquals(statsExpected.getRatio(), statsController.stats().getRatio());
	}
	
	@Test
	public void repositoryExceptionGetStats() throws CerebroException {
		
		StatsService statsService = Mockito.mock(StatsService.class);
		when(statsService.getRatio()).thenThrow( new CerebroException("Error to get records"));
		StatsController statsController = new StatsController(statsService);
		statsController.stats();
	}
	

	@Test
	public void exceptionGetStats() throws Exception {
		StatsService statsService = Mockito.mock(StatsService.class);
		when(statsService.getRatio()).thenThrow(new CerebroException("Error to get records")); 
		StatsController statsController = new StatsController(statsService);
		statsController.stats();
	}
	
	@Test
	public void getDefaultStats() throws CerebroException {
		StatsService statsService = Mockito.mock(StatsService.class);
		when(statsService.getRatio()).thenReturn(new Stats(0, 0));
		StatsController statsController = new StatsController(statsService);

		Stats statsExpected = new Stats(0, 0);
		assertEquals(statsExpected.getCount_human_dna(), statsController.stats().getCount_human_dna());
		assertEquals(statsExpected.getCount_mutant_dna(), statsController.stats().getCount_mutant_dna());
		assertEquals(statsExpected.getRatio(), statsController.stats().getRatio());

	}
	
}
