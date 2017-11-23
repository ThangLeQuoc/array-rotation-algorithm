package com.thanglequoc.utils;

import java.util.Arrays;
import java.util.List;

import com.thanglequoc.data.CommandPoint;

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
    
    public static void performSquareRotationWIthCommands(int [][]square, List<CommandPoint> commands){
	for (CommandPoint commandPoint : commands) {
	    int[][] partitionSquare = SquareArrayUtil.getPartitionSquareFromCommandPoint(square, commandPoint);
	    
	    
	}
    }
    
    public  static  int[][] getPartitionSquareFromCommandPoint(int[][]square, CommandPoint commandPoint){
	int topLeftRow = commandPoint.getTopLeftRow();
	int topLeftCol = commandPoint.getTopLeftCol();
	int bottomRightCol = commandPoint.getBottomRightCol();
	int bottomRightRow = commandPoint.getBottomRightRow();
	
	int partitionSquareRow = commandPoint.getBottomRightRow() - commandPoint.getTopLeftRow();
	int partitionSquareCol = commandPoint.getBottomRightCol() - commandPoint.getTopLeftCol();
	int[][] partitionSquare = new int[partitionSquareRow][partitionSquareCol];
	
	for(int i = topLeftRow-1,  partitionRowIndex = 0; i<(bottomRightRow-1); i++, partitionRowIndex++){
	    for(int j = topLeftCol -1, partitionColumnIndex =0; j< bottomRightRow -1 ; j++, partitionColumnIndex++){
		partitionSquare[partitionRowIndex][partitionColumnIndex] = square[i][j];
	    }
	}
	return partitionSquare;
    }
    
    
    
    
    public  static void rotateSquare(int [][] square){
	int row = square.length;
	int col = square[0].length;
	int [][] cloneSquare = new int[row][col];
	for(int i=0; i< row; i++){
	    for(int j=0; j<col;j++){
		cloneSquare[i][j] = square[i][j];
	    }
	}
	
	for(int i=0; i< row; i++){
	    for(int j=0;j<col;j++){
		square[i][j] = cloneSquare[row-1-j][i];
	    }
	}
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
