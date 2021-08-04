package com.meli.cerebro.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.meli.cerebro.exception.CerebroException;
import com.meli.cerebro.scanner.MutantScanner;
import com.meli.cerebro.service.MutantService;
import com.meli.cerebro.service.domain.pojo.Dna;

@Service
public class MutantServiceImpl implements MutantService{

	@Autowired
	private MutantScanner scanner;

	@Override
	public ResponseEntity<String> isMutant(Dna dna) throws CerebroException {
		HttpStatus httpStatus = (scanner.isMutant(dna.getDna())) ? HttpStatus.OK : HttpStatus.FORBIDDEN;
		return new ResponseEntity<>(httpStatus);
	}
}
