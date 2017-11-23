package com.thanglequoc.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thanglequoc.data.CommandPoint;
import com.thanglequoc.utils.SquareArrayUtil;

public class Program {

    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	int squareSize = sc.nextInt();
	int[][] square = SquareArrayUtil.buildSquareArray(squareSize);

	int numberOfCommands = sc.nextInt();

	List<CommandPoint> commands = new ArrayList<>();
	for (int i = 0; i < numberOfCommands; i++) {
	    int a = sc.nextInt();
	    int b = sc.nextInt();
	    int d = sc.nextInt();
	    CommandPoint commandPoint = new CommandPoint(a, b, d);
	    commands.add(commandPoint);
	}

	int numberOfQueries = sc.nextInt();
	List<Integer> queries = new ArrayList<>();
	if (numberOfQueries > 0) {
	    for (int i = 0; i < numberOfQueries; i++) {
		int targetNumber = sc.nextInt();
		queries.add(Integer.valueOf(targetNumber));
	    }
	}

	SquareArrayUtil.performSquareRotationWIthCommands(square, commands);
	for (Integer targetNumber : queries) {
	    SquareArrayUtil.printElementLocationInSquare(square, targetNumber.intValue());
	}
	
    }

}
