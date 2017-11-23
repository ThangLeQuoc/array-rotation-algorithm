package com.thanglequoc.data;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class CommandPointTest {
    
    private CommandPoint sampleCommandPoint;
    
    @Before
    public void setUp(){
	sampleCommandPoint = new CommandPoint(2, 3, 3);
	/**
	 * CommandPoint (2,3,3) => TopLeftElement (1,2) - BottomRightElement(4,5)
	 * */
    }
    
    @Test
    public void should_GetCorrectTopLeftColIndex_When_GetTopLeftColOnCommandPoint(){
	int expectedTopLeftColIndex = 2;
	int actualTopLeftColIndex = sampleCommandPoint.getTopLeftCol();
	assertEquals(expectedTopLeftColIndex, actualTopLeftColIndex);
    }
    
    @Test
    public void should_GetCorrectTopLeftRowIndex_When_GetTopLeftRowOnCommandPoint(){
	int expectedTopLeftRowIndex = 1;
	int actualTopLeftRowIndex = sampleCommandPoint.getTopLeftRow();
	assertEquals(expectedTopLeftRowIndex, actualTopLeftRowIndex);
    }
    
    @Test
    public void should_GetCorrectBottomRightColIndex_When_GetBottomRightColOnCommandPoint(){
	int expectedBottomRightRowIndex = 4;
	int actualBottomRightRowIndex = sampleCommandPoint.getBottomRightRow();
	assertEquals(expectedBottomRightRowIndex, actualBottomRightRowIndex);
    }
    
    @Test
    public void should_GetCorrectBottomRightRowIndex_When_GetBottomRightRowOnCommandPoint(){
	int expectedBottomRightColIndex = 5;
	int actualBottomRightColIndex = sampleCommandPoint.getBottomRightCol();
	assertEquals(expectedBottomRightColIndex, actualBottomRightColIndex);
    }
    
    
    
    
}
