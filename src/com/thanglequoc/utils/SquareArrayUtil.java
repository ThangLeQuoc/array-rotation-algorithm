package com.thanglequoc.utils;

/**
 * The Class SquareArrayUtil.
 */
public class SquareArrayUtil {
    

    /**
     * Builds the square array.
     *
     * @param size the size of the square array
     * @return the two dimensional square array
     */
    public static int[][] buildSquareArray(int size) throws IllegalArgumentException{
	if(size >7){
	    throw new IllegalArgumentException("Size of square must be less than 8");
	}
	
	int[][] square = new int[size][size];
	for(int i=0; i<size; i++)
	    for(int j=0; j<size; j++){
		square[i][j] = i*size + j;
	    }
	return square;
    }
    
    public  static void printSquare(int[][] square){
	int row = square.length;
	int col = square[0].length;
	for(int i =0; i< row; i++){
	    for(int j=0; j< col; j++){
		System.out.printf("%3d", square[i][j]);
	    }
	    System.out.println();
	}
    }
}
