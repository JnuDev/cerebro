package com.meli.cerebro.service;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.service.domain.pojo.Stats;

public interface StatsService {
	public Stats getRatio() throws CerebroException;
}
