package com.thanglequoc.utils;

import org.junit.Test;

public class SquareArrayUtilsTest {
    
    private static final int INVALID_SIZE = 10;

    @Test(expected = IllegalArgumentException.class)
    public void should_ThrowIllegalArgumentException_When_InputSizeGreaterThan7(){
	int[][]square = SquareArrayUtil.buildSquareArray(INVALID_SIZE);
    }
}
