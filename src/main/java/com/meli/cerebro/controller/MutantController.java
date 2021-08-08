package com.meli.cerebro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.cerebro.exception.BaseException;
import com.meli.cerebro.service.MutantService;
import com.meli.cerebro.service.domain.pojo.Dna;

/**
 * 
 * @author Jusuga
 *
 */
@RestController
public class MutantController {

	@Autowired
	private MutantService mutantService;

	public MutantController(MutantService mutantService) {
		this.mutantService = mutantService;
	}

	/**
	 * DNA sequence must be of order N*N
	 * @param dna String[] n*n  
	 * @return HTTP/1.1 200  || HTTP/1.1 403
	 */
	
	@RequestMapping(value = "/mutant", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> isMutant(@RequestBody Dna dna) {

		ResponseEntity<String> response = null;
		try {
			response = mutantService.isMutant(dna);
		} catch (BaseException e) {
			response = new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		return response;

	}
}

