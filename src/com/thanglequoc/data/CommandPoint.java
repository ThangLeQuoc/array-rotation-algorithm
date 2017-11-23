package com.thanglequoc.data;

public class CommandPoint {
    private int a;
    private int b;
    private int d;
    
    public CommandPoint(int a, int b, int d){
	this.a = a;
	this.b = b;
	this.d = d;
    }
    
    public int getTopLeftCol(){
	return b-1;
    }
    
    public int getTopLeftRow(){
	return a-1;
    }
    
    public int getBottomRightCol(){
	return b+d-1;
    }
    
    public int getBottomRightRow(){
	return a + d-1;
    }
}
