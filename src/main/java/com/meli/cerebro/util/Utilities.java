package com.meli.cerebro.util;

public class Utilities {
	
	
	/**
	 * convierte un array a una matrix de caraceres 
	 * @param vec
	 * @return
	 */
	public static char[][] arrayToMatrix(String[] vec){		
			
		int vecSize = vec.length;
		char[][] matrix = new char[vecSize][vecSize];
		int row = 0;
		for (String vRow: vec) {						
			char[] aChar = vRow.toCharArray();		
			for (int col = 0; col < vecSize; col++) {
				matrix[row][col] = aChar[col];
			}
			row++;
		}
		return matrix;
	}
	
	/**
	 * retona un mapa de nodos
	 * @param vec
	 */
	public static void arrayToMapNode(String[] vec){	
		//TODO crear mapa de nodos en lista ligada
		
	}
	

}
