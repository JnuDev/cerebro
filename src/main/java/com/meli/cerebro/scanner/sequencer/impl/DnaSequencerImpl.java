package com.meli.cerebro.scanner.sequencer.impl;

import org.springframework.stereotype.Component;

import com.meli.cerebro.scanner.sequencer.DnaSequencer;
import com.meli.cerebro.util.Utilities;

@Component
public class DnaSequencerImpl implements DnaSequencer {

	private final  int NUCLEOTIDES_SIZE = 4 ;

	private  final int MIN_SEQUENCES = 2;

	enum direction{H,V,Dd,Di;} 
	
	private  int matrixlent =0;

	@Override
	public int getSequences(String[] dna) {		
		char[][] matrix = Utilities.arrayToMatrix(dna);
		matrixlent =matrix.length;
		return analyze(matrix);
	}

	private  int analyze(char[][] matrix) {

		Integer sequencesCounter= 0 ;	
		
		//buscar horizontales 
		 sequencesCounter =findHorizontal(matrix,sequencesCounter);		
		if (sequencesCounter < MIN_SEQUENCES ) {
			//buscar verticales
			 sequencesCounter = findVertical(matrix,sequencesCounter);	
			if (sequencesCounter < MIN_SEQUENCES ) {
				  sequencesCounter = findDiagonals(matrix,sequencesCounter);
			}
		}

		return sequencesCounter;
	}

	private  int findDiagonals(char[][] matrix,int countSequences ) {

		countSequences=findDiagonalL(matrix, countSequences );
		if (evalSequencesCount(countSequences)){ return countSequences;}
		countSequences=findDiagonalR(matrix, countSequences );		
		return countSequences;
	}

	private  int findHorizontal(char[][] matrix,Integer countSequences) {		
		
		for (int row = 0; row <matrixlent; row++) {
			for (int col = 0; col <= (matrix.length - NUCLEOTIDES_SIZE); col++) {
				if (col+3 <=matrixlent-1){					
					countSequences += evalSequence(matrix[row][col],matrix[row][col+1],matrix[row][col+2],matrix[row][col+3]);
					if (evalSequencesCount(countSequences)){ return countSequences;}
				}
			}
		}

		return countSequences;
	}

	private  int findVertical(char[][] matrix,Integer countSequences) {		
		
		for (int col = 0; col <matrixlent; col++) {
			for (int row = 0; row <= (matrix.length - NUCLEOTIDES_SIZE); row++) {
				if (row+3 <=matrixlent-1){				
					countSequences +=  evalSequence(matrix[row][col],matrix[row+1][col],matrix[row+2][col],matrix[row+3][col]);
					if (evalSequencesCount(countSequences)){ return countSequences;}
				}
			}
		}

		return countSequences;
	}

	private  int findDiagonalR(char[][] matrix,int countSequences ) {		
		
		// Calcula la altura y la anchura de la matriz introducida.
		Integer altura =matrixlent, anchura = matrix[0].length;

		for (
				// Recorre los inicios de cada diagonal en los bordes de la matriz.
				Integer diagonal = 1 - (anchura - (NUCLEOTIDES_SIZE-1) ); // Comienza con un número negativo.
				diagonal <=  (matrixlent - NUCLEOTIDES_SIZE); // Mientras no llegue a la última diagonal.
				diagonal += 1 // Avanza hasta el comienzo de la siguiente diagonal.
				) {
			for (
					// Recorre cada una de las diagonales a partir del extremo superior derecho.
					Integer vertical = Math.max(0, diagonal), horizontal = -Math.min(0, diagonal);
					(vertical < altura  && horizontal < anchura) ; // Mientras no excedan los límites.
					vertical += 1, horizontal += 1 // Avanza en diagonal incrementando ambos ejes.
					) {
				if ( horizontal + NUCLEOTIDES_SIZE <=matrixlent)
					countSequences += evalDiagonal(matrix,vertical,horizontal,direction.Dd);	
				if (evalSequencesCount(countSequences)){ return countSequences;}            	           
			}
		}

		return countSequences;
	}

	private  int findDiagonalL(char[][] matrix,int countSequences ) {		
			  
			        for (
			            // Recorre los inicios de cada diagonal en los bordes de la matriz.
			            Integer diagonal = NUCLEOTIDES_SIZE-1; // Comienza con un número positivo.
			            diagonal <=  (matrixlent ) ; // Mientras no llegue a la última diagonal.
			            diagonal += 1 // Avanza hasta el comienzo de la siguiente diagonal.
			        ) {	       
			            for (
			                // Recorre cada una de las diagonales a partir del extremo superior izq.
			                Integer vertical =-Math.min(0, diagonal) , horizontal = Math.max(0, diagonal);
			                (vertical >= 0   && horizontal >= 0) ; // Mientras no excedan los límites.
			                vertical += 1, horizontal -= 1 // Avanza en diagonal incrementando ambos ejes.
			            ) {
			         	if ( horizontal - (NUCLEOTIDES_SIZE - 1 )>= 0)
			            		countSequences +=   evalDiagonal(matrix,vertical,horizontal,direction.Di);
			            		if (evalSequencesCount(countSequences))return countSequences;	            	           
			            }
		
			        }

		//recorre diagonales por debajo de la diagonal secundaria 
		for (	         
				Integer diagonal = 1 ; // Comienza en la segunda fila.
				diagonal <  (matrixlent ) ; // Mientras no llegue a la última diagonal.
				diagonal += 1 // Avanza al comienzo de la siguiente diagonal.
				) {	       

			for (
					//inicio de las diagonales a partir del extremo superior derecho.
					Integer vertical =diagonal, horizontal =  matrixlent - 1 ;
					( vertical <= NUCLEOTIDES_SIZE && horizontal >= NUCLEOTIDES_SIZE ); // tamaño de secuencia al borde.
					vertical += 1, horizontal -= 1//  en diagonal decrementando en h.
					) {
				if  (vertical <= (matrixlent - NUCLEOTIDES_SIZE )){
					countSequences +=   evalDiagonal(matrix,vertical,horizontal,direction.Di);
					if (evalSequencesCount(countSequences))return countSequences;	
				}  
			}      
		}

		return countSequences;
	}

	
	private  int evalDiagonal(char[][] matrix,Integer i,Integer j,direction dir)
	{
		Integer altura =matrixlent, anchura = matrix[0].length;
		Integer ind = 0;
		char seq[] = new char[4];

		switch (dir) {
		case Dd:
			for (	        
					Integer vertical =i, horizontal = j;
					(vertical < altura  && horizontal < anchura) && ind < 4  ;
					vertical += 1, horizontal += 1 // Avanza en diagonal incrementando ambos ejes.
					){	            
				seq[ind++] = matrix[vertical][horizontal];			
			}	
			break;
		case Di:
			for (	        
					Integer vertical =i, horizontal = j;
					(vertical < altura  && horizontal < anchura) && ind < 4  ;
					vertical += 1, horizontal -= 1 // Avanza en diagonal incrementando ambos v decremetando h.
					){	            
				seq[ind++] = matrix[vertical][horizontal];			
			}	
			break;

		default:
			break;
		}

		if (ind == 4)
			return evalSequence(seq[0] ,seq[1],seq[2] ,seq[3]);		
		return 0;
	}		

	private  int evalSequence(char a,char b ,char c, char d) {		
	//	System.out.println(a+"-"+b +"- "+c +" -"+d);		
		return (a == b && b == c && c == d)? 1:0;	
	}
	private  boolean evalSequencesCount(int count){
		return  count >=  MIN_SEQUENCES? true : false;
	}
}
