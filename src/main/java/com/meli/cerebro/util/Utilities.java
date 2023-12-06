package com.meli.cerebro.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Utilities {

	/**
	 * Convierte un String[] a una matriz de caraceres
	 * 
	 * @param vec String[]
	 * @return char[][] o null
	 */
	public static char[][] arrayToMatrix(String[] vec) {

		if (vec == null || vec.length == 0)
			return null;

		int vecSize = vec.length;
		char[][] matrix = new char[vecSize][vecSize];
		int row = 0;
		for (String vRow : vec) {
			char[] aChar = vRow.toCharArray();
			for (int col = 0; col < aChar.length; col++) {
				matrix[row][col] = aChar[col];
			}
			row++;
		}

		return matrix;
	}

	public static List<String> arrayToListString(String[] vec) {

		if (vec == null || vec.length == 0)
			return null;

		List<String> chrNucleotides = new ArrayList<String>();
		List<String> origen = Arrays.asList(vec);

		// captura horizontales
		chrNucleotides.addAll(origen);
		String newWord = "";
		// captura verticales
		for (int i = 0; i < origen.size(); i++) {
			newWord = "";
			for (String string : origen) {
				newWord += string.charAt(i);
			}
			chrNucleotides.add(newWord);
		}

		// capturar diagonales
		getWordDigPrin(vec, chrNucleotides);
		getWordDigSecund(vec, chrNucleotides);

		// chrNucleotides.forEach(System.out::println);

		return chrNucleotides;
	}

	private static void getWordDigPrin(String[] vec, List<String> chrNucleotides) {

		String newWord = "";
		int word = 3; // palabra en lista (index)
		int ind = 0; // pocición del caracter (.charAt(i))
		int maxLen = vec.length - 1;
		for (int len = 0; len <= maxLen - 1; len++) {

			for (Integer vertical = word, horizontal = ind; (vertical >= 0 && horizontal <= maxLen); // límites.
					vertical -= 1, horizontal += 1 // Avanza en diagonal incrementando ambos ejes.
					) {
				newWord += vec[vertical].charAt(horizontal);
			}

			if (word == maxLen) {
				ind += 1;
			} else {
				word += 1;
			}

			chrNucleotides.add(newWord);
			newWord = "";
		}
	}

	private static void getWordDigSecund(String[] vec, List<String> chrNucleotides) {

		String newWord = "";
		int word = 0; // palabra en lista (index)
		int ind = 3; // pocición del caracter (.charAt(i))
		int maxLen = vec.length - 1;

		for (int len = 0; len <= maxLen - 1; len++) {

			for (Integer vertical = word, horizontal = ind; (vertical <= maxLen && horizontal >= 0); // límites.
					vertical += 1, horizontal -= 1 // Avanza en diagonal incrementando ambos ejes.
					) {
				newWord += vec[vertical].charAt(horizontal);
			}

			if (ind == maxLen) {
				word += 1;
			} else {
				ind += 1;
			}

			chrNucleotides.add(newWord);
			newWord = "";
		}
	}
}
