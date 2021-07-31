package com.meli.cerebro.service;

import org.springframework.http.ResponseEntity;

import com.meli.cerebro.exception.BaseException;
import com.meli.cerebro.service.domain.pojo.Dna;

public interface MutantService {
	public ResponseEntity<String> isMutant(Dna dna) throws BaseException;
}
