package com.meli.cerebro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.service.StatsService;
import com.meli.cerebro.service.domain.pojo.Stats;

@RestController
public class StatsController {

	@Autowired
	private StatsService statsService;

	public StatsController(StatsService statsService) {
		this.statsService = statsService;
	}

	/**
	 * Returns the statistics of scanned humans
	 * 
	 * @return {"ratio": y/x,"count_human_dna": x, "count_mutant_dna": y}
	 */
	@RequestMapping(value = "/stats", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Stats stats() {

		Stats response = null;

		try {
			response = statsService.getRatio();
		} catch (CerebroException e) {
			e.printStackTrace();
		}

		return response;

	}
}
