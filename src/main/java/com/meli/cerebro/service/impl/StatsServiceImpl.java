package com.meli.cerebro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.scanner.StatsScanner;
import com.meli.cerebro.service.StatsService;
import com.meli.cerebro.service.domain.pojo.Stats;

@Service
public class StatsServiceImpl implements StatsService{
	
	@Autowired
	StatsScanner statsScanner;
	
	@Override
	public Stats getRatio() throws CerebroException {
		
		return statsScanner.getRatio();
	}

	
}
