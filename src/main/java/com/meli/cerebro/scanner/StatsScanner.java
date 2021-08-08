package com.meli.cerebro.scanner;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.service.domain.pojo.Stats;

public interface StatsScanner {
	public Stats getRatio() throws CerebroException;
}
