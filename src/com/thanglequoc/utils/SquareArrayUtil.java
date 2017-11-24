package com.thanglequoc.utils;

import java.util.Arrays;
import java.util.List;

import com.thanglequoc.data.CommandPoint;

/**
 * The Class SquareArrayUtil.
 */
public class SquareArrayUtil {
    private static final int MAXIMUM_SQUARE_SIZE = 7;
    private SquareArrayUtil(){}

    /**
     * Builds the square array.
     *
     * @param size the size of the square array
     * @return the two dimensional square array with element value from 0 to (size*size -1)
     */
    public static int[][] buildSquareArray(int size) throws IllegalArgumentException{
	if(size >MAXIMUM_SQUARE_SIZE){
	    throw new IllegalArgumentException("Size of square must be less than "+MAXIMUM_SQUARE_SIZE+1);
	}
	
	int[][] square = new int[size][size];
	for(int i=0; i<size; i++)
	    for(int j=0; j<size; j++){
		square[i][j] = i*size + j;
	    }
	return square;
    }
    
    
    /**
     * Perform square rotation with list of command element.
     *
     * @param square the square
     * @param commands the commands
     */
    public static void performSquareRotationWIthCommands(int [][]square, List<CommandPoint> commands){
	for (CommandPoint commandPoint : commands) {
	    int[][] partitionSquare = extractPartitionSquareByCommandPoint(square, commandPoint);
	    rotateSquare90DegreeClockwise(partitionSquare);
	    updateSquareWithPartitionSquareByCommandPoint(square, partitionSquare, commandPoint);
	}
    }
    
    /**
     * Extract the partition square from parent square by command point.
     *
     * @param square the square
     * @param commandPoint the command point
     * @return the extracted partition square 
     */
    public  static  int[][] extractPartitionSquareByCommandPoint(int[][]square, CommandPoint commandPoint){
	int topLeftRow = commandPoint.getTopLeftRow();
	int topLeftCol = commandPoint.getTopLeftCol();
	int bottomRightCol = commandPoint.getBottomRightCol();
	int bottomRightRow = commandPoint.getBottomRightRow();
	
	int partitionSquareRow = commandPoint.getBottomRightRow() - commandPoint.getTopLeftRow() +1;
	int partitionSquareCol = commandPoint.getBottomRightCol() - commandPoint.getTopLeftCol() +1;
	int[][] partitionSquare = new int[partitionSquareRow][partitionSquareCol];
	
	for(int i = topLeftRow,  partitionRowIndex = 0; i<=bottomRightRow; i++, partitionRowIndex++){
	    for(int j = topLeftCol, partitionColumnIndex =0; j<= bottomRightCol ; j++, partitionColumnIndex++){
		partitionSquare[partitionRowIndex][partitionColumnIndex] = square[i][j];
	    }
	}
	return partitionSquare;
    }
    
    /**
     * Update square with partition square by command point.
     *
     * @param square the square
     * @param partitionSquare the partition square
     * @param commandPoint the command point
     */
    public static void updateSquareWithPartitionSquareByCommandPoint(int[][] square, int[][] partitionSquare, CommandPoint commandPoint){
	int topLeftRow = commandPoint.getTopLeftRow();
	int topLeftCol = commandPoint.getTopLeftCol();
	int bottomRightCol = commandPoint.getBottomRightCol();
	int bottomRightRow = commandPoint.getBottomRightRow();
	
	for(int i= topLeftRow, partitionRowIndex =0; i<= bottomRightRow;i++, partitionRowIndex++){
	    for(int j= topLeftCol, partitionColIndex = 0; j<= bottomRightCol ;j++, partitionColIndex++){
		square[i][j] = partitionSquare[partitionRowIndex][partitionColIndex];
	    }
	}
    }
    
    
    /**
     * Rotate the square 90 degree clockwise.
     *
     * @param square the square
     */
    public  static void rotateSquare90DegreeClockwise(int [][] square){
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
    
    
    /**
     * Prints the square.
     *
     * @param square the square
     */
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
    
    /**
     * Prints the element location in square.
     *
     * @param square the square
     * @param key the element value
     */
    public static void printElementLocationInSquare(int[][]square, int key){
	int row = square.length;
	int col = square[0].length;
	for(int i =0; i< row; i++){
	    for(int j=0; j< col; j++){
		if(square[i][j] == key){
		    System.out.println((i+1)+" "+(j+1));
		    return;
		}
	    }
	}
    }
}
