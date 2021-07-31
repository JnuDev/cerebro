package com.meli.cerebro.validation;

import com.meli.cerebro.exception.CerebroException;

public interface DnaValidation {

	public void validate(String[] dna) throws CerebroException;

}
