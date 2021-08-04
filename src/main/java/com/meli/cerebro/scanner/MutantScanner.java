package com.meli.cerebro.scanner;

import com.meli.cerebro.exception.CerebroException;

public interface MutantScanner {

	public boolean isMutant(String[] dna) throws CerebroException;
}

