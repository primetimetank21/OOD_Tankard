package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

public class Driver {

	public static void main(String[] args) {
		IntegerSet set1 = new IntegerSet();
		
		//exception handled
		try {
			System.out.println(set1.largest());
		} catch (IntegerSetException e) {
			e.printStackTrace();
		}
		
		set1.add(1);
		set1.add(3);
		System.out.println(set1);

	}

}
