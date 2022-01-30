package org.howard.edu.lsp.assignment2;

import java.util.Scanner;

/**
 * This class is used to drive the TextProcessor class
 * @author earltankardjr
 *
 */
public class Main {

	/**
	 * The main method for running assignment 2
	 * @param args
	 */
	public static void main(String[] args) {
		TextProcessor tp = new TextProcessor();
		Scanner scanner  = new Scanner(System.in);
		String userInput = "";

		do {
			userInput = tp.getUserInput(scanner);
			
			if(tp.keepLooping(userInput)) {
				String[] userInputArray = tp.tokenizeUserInput(userInput);
				tp.printSumAndProd(userInputArray);				
			} //end if
			
		} while(tp.keepLooping(userInput)); //end do-while
		
		scanner.close();
				
	} //end main

} //end Main
