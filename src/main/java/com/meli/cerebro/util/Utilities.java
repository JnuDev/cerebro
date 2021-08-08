package com.meli.cerebro.util;

public class Utilities {
	
	
	/**
	 * Convierte un String[] a una matriz de caraceres 
	 * @param vec String[] 
	 * @return char[][] o null 
	 */
	public static char[][] arrayToMatrix(String[] vec){		
		
		if (vec == null || vec.length ==0 ) return null;
		
			int vecSize = vec.length;
			char[][] matrix = new char[vecSize][vecSize];
			int row = 0;
			for (String vRow: vec) {						
				char[] aChar = vRow.toCharArray();		
				for (int col = 0; col < aChar.length; col++) {
					matrix[row][col] = aChar[col];
				}
				row++;
			}
		
		return matrix;
	}
	
	
}
