package com.thanglequoc.utils;

import static org.junit.Assert.*;
import org.junit.Test;

import com.thanglequoc.data.CommandPoint;

public class SquareArrayUtilsTest {
    
    private static final int INVALID_SIZE = 10;

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_When_InputSizeGreaterThan7(){
	int[][]square = SquareArrayUtil.buildSquareArray(INVALID_SIZE);
    }
    
    @Test
    public void should_RotateSquareBy90DegreeClockwise_When_CallRotateMethod(){
	int[][] square = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
	int[][] expectedSquare = new int[][]{{7,4,1},{8,5,2}, {9,6,3}};
	SquareArrayUtil.rotateSquare90DegreeClockwise(square);
	
	assertArrayEquals(square[0], expectedSquare[0]);
	assertArrayEquals(square[1], expectedSquare[1]);
	assertArrayEquals(square[2], expectedSquare[2]);
    }
    
    @Test
    public void should_GetCorrectPartitionSquareFromParentSquare_When_GetWithCommandPoint(){
	int[][] square = buildSampleSquare();
	CommandPoint commandPoint = new CommandPoint(2, 3, 3);
	int[][] expectedPartitionSquare = new int[][]{
	    {9,10,11,12},
	    {16,17,18,19},
	    {23,24,25,26},
	    {30,31,32,33}
	};
	
	int[][] actualPartitionSquare = SquareArrayUtil.extractPartitionSquareByCommandPoint(square, commandPoint);
	assertArrayEquals(expectedPartitionSquare[0], actualPartitionSquare[0]);
	assertArrayEquals(expectedPartitionSquare[1], actualPartitionSquare[1]);
	assertArrayEquals(expectedPartitionSquare[2], actualPartitionSquare[2]);
	assertArrayEquals(expectedPartitionSquare[3], actualPartitionSquare[3]);
    }
    
    @Test
    public void should_UpdateSquareWithPartitionSquare_When_UpdateSquareWithPartitionSquareAndCommandPoint(){
	int[][] square = buildSampleSquare();
	int[][] partitionSquare = new int[][]{
	    {30,23,16,9},
	    {31,24,17,10},
	    {32,25,18,11},
	    {33,26,19,12}
	};
	
	CommandPoint commandPoint = new CommandPoint(2, 3, 3);
	SquareArrayUtil.updateSquareWithPartitionSquareByCommandPoint(square, partitionSquare, commandPoint);
	
	int[][] expectedSquare = new int[][]{
	    {0,1,2,3,4,5,6},
	    {7,8,30,23,16,9,13},
	    {14,15,31,24,17,10,20},
	    {21,22,32,25,18,11,27},
	    {28,29,33,26,19,12,34},
	    {35,36,37,38,39,40,41},
	    {42,43,44,45,46,47,48}
	};
	
	assertArrayEquals(expectedSquare[0], square[0]);
	assertArrayEquals(expectedSquare[1], square[1]);
	assertArrayEquals(expectedSquare[2], square[2]);
	assertArrayEquals(expectedSquare[3], square[3]);
	assertArrayEquals(expectedSquare[4], square[4]);
	assertArrayEquals(expectedSquare[5], square[5]);
	assertArrayEquals(expectedSquare[6], square[6]);
	
    }
    
    private int[][] buildSampleSquare(){
	return  new int[][]{
	    {0,1,2,3,4,5,6},
	    {7,8,9,10,11,12,13},
	    {14,15,16,17,18,19,20},
	    {21,22,23,24,25,26,27},
	    {28,29,30,31,32,33,34},
	    {35,36,37,38,39,40,41},
	    {42,43,44,45,46,47,48}
	};
    }
    
    
    
    
    
    
}
