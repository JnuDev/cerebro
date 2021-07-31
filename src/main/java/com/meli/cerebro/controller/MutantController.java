package com.meli.cerebro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.meli.cerebro.exception.BaseException;
import com.meli.cerebro.service.MutantService;
import com.meli.cerebro.service.domain.pojo.Dna;

import io.swagger.annotations.ApiOperation;

@RestController
public class MutantController {

	@Autowired
	private MutantService mutantService;

	public MutantController(MutantService mutantService) {
		this.mutantService = mutantService;
	}

	@ApiOperation(value = "", notes = "Mutant detection service")
	@RequestMapping(value = "/mutant", method = RequestMethod.POST)
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

