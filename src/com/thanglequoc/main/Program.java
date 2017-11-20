package com.thanglequoc.main;

import java.util.Scanner;

import com.thanglequoc.utils.SquareArrayUtil;

public class Program {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int i = sc.nextInt();
	System.out.println(i);
	int[][] square = SquareArrayUtil.buildSquareArray(i);
	SquareArrayUtil.printSquare(square);
    }

}
