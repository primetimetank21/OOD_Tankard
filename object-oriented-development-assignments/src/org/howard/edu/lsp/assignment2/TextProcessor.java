package org.howard.edu.lsp.assignment2;
import java.util.Scanner;


/**
 * This class takes in an input string of numbers, tokenizes them,
 * and then prints the tokens, the sum of the tokens, and the 
 * product of the tokens
 * @author earltankardjr 
 */
public class TextProcessor {
	
	/**
	 * Gets the input from a user
	 * @return userString -- values received from user
	 */
	public String getUserInput(Scanner scanner) {
		System.out.println("String?");
		String userString = scanner.nextLine();
		return userString;
	}
	
	/**
	 * Converts the values to a String array
	 * @param userInput -- values received from user
	 * @return tokens -- tokenized user input string
	 */
	public String[] tokenizeUserInput(String userInput) {
		String[] tokens = userInput.split(" ");
		System.out.println("Tokens:");
		for(String token : tokens)
			System.out.println(token);
		return tokens;
	}
	
	/**
	 * Prints sum and product of the tokens
	 * @param tokens -- tokenized user input string
	 */
	public void printSumAndProd(String[] tokens) {
		int sum  = calcSum(tokens);
		int prod = calcProd(tokens);
		
		System.out.println("Sum: " + sum + "\nProduct: " + prod + '\n');		
	}
	
	/**
	 * Calculates product
	 * @param tokens -- tokenized user input string
	 * @return prod -- product of tokens
	 */
	private Integer calcProd(String[] tokens) {
		int prod = 1;
		for(String strNum : tokens) {
			int num = Integer.parseInt(strNum);
			prod *= num;
		}
		
		return prod;
	}
	
	/**
	 * Calculates sum
	 * @param tokens -- tokenized user input string
	 * @return sum -- sum of tokens
	 */
	private Integer calcSum(String[] tokens) {
		int sum = 0;
		for(String strNum : tokens) {
			int num = Integer.parseInt(strNum);
			sum += num;
		}
		
		return sum;
	}
	
	/**
	 * Checks if user is done giving input
	 * @param userInput -- value received from the user
	 * @return Boolean
	 */
	public boolean keepLooping(String userInput) {
		if(userInput.strip().toLowerCase().equals("goodbye")) {
			return false;
		}
		return true;
	}

}
