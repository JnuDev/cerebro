package com.meli.cerebro.util;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.meli.cerebro.dataset.Dataset;

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
		String[] dnaArray =  Dataset.ARRAY_TO_MATRIX ;		
		char[][] dnaMatriz = Dataset.MATRIX_OK;		
		
		char[][] matrix = Utilities.arrayToMatrix(dnaArray);		
		assertArrayEquals(matrix, dnaMatriz);
	}	
		
}
