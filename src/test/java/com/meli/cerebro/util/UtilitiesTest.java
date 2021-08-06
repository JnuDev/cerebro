package com.meli.cerebro.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UtilitiesTest {

	@Test
	void getArrayToMatrixNull() {		
		char[][] matrix = Utilities.arrayToMatrix(null);			
		assertEquals(matrix, null);
	}
	
	@Test
	void getArrayToMatrixZero() {	
		
		char[][] matrix = Utilities.arrayToMatrix(new String[0]);		
		assertEquals(matrix, null);
	}
	
	@Test
	void getArrayToMatrixOK() {	
		String[] dnaArray = { "AT", "CA" };		
		char[][] dnaMatriz = {{'A','T'},{'C','A'}};		
		
		char[][] matrix = Utilities.arrayToMatrix(dnaArray);		
		assertArrayEquals(matrix, dnaMatriz);
	}

}
