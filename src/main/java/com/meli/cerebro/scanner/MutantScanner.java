package com.meli.cerebro.scanner;

import com.meli.cerebro.exception.BaseException;

public interface MutantScanner {

	public boolean isMutant(String[] dna) throws BaseException;
}

