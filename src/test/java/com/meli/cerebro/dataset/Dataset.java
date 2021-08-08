package com.meli.cerebro.dataset;

public class Dataset {
	
	public static final String[] MUTANT_OK =  new String[] { "ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG" };
	public static final String[] HUMAN_OK =  new String[] { "GTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCGCTA", "TCACTG" };
	public static final String[] INVALID_NUCLEOTIDES =  new String[] { "BBBB", "DDDD", "VVVV", "EEEE"};
	public static final String[] INVALID_SIZE =  new String[] { "ATGA", "CAGTGC", "TTT", "AGAAG", "CCTA", "TCACTG" };
	public static final String[] ARRAY_NULL =  null;
	
	public static final String[] ARRAY_TO_MATRIX = new String[] { "ATG", "CAG","TTG"};	
	public static final char[][] MATRIX_OK =  {{'A','T','G'},{'C','A','G'},{'T','T','G'}};
	
	/**
	 * MATRIZ CON SECUENCIAS HORIZONTALES
	 */	public static final  String[] MATRIX_MUTANT_HORIZONTAL = new String[] {"AAAA","CCCC","TTTT","TTTG"};
	/**
	 * MATRIZ CON SECUENCIAS VERTICALES
	 */
	public static final  String[] MATRIX_MUTANT_VERTICAL = new String[] {"ACTG","ACTG","ACTG","ACTG"};
	/**
	 * MATRIZ CON DIAGONAL PRINCIPAL
	 */
	public static final  String[] MATRIX_MUTANT_DIAGONAL_PRIMARY =new String[] {"ACGA","CACC","TGAT","GTTA"};
	
	/**
	 * MATRIZ CON DIAGONAL PRINCIPAL
	 */
	public static final  String[] MATRIX_MUTANT_DIAGONAL_PRIMARY2 =new String[] {"ACGAG","CAAGC","TAGTG","AGTAG","AGTAG"};
	/**
	 * MATRIZ CON DIAGONAL SECUNDARIA 2
	 */
	public static final  String[] MATRIX_MUTANT_DIAGONAL_SECUNDARY = new String[] {"GGAA","CGGC","TTGT","TTTG"};
			
	/**
	 * MATRIZ CON DIAGONAL SECUNDARIA 2
	 */
	public static final  String[] MATRIX_MUTANT_DIAGONAL_SECUNDARY2 = new String[] {"AGAAT","AGGCT","TAGGT","TTAGT","AGTAG"};

	
}
