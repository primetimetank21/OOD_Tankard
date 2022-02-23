package org.howard.edu.lsp.assignment5.test;

import org.howard.edu.lsp.assignment5.implementation.IntegerSet;
import org.howard.edu.lsp.assignment5.implementation.IntegerSetException;

/**
 * This class serves as a driver for the IntegerSet
 * @author earltankardjr
 */
public class Driver {

	/**
	 * Test IntegerSet implementation
	 * @param args
	 */
	public static void main(String[] args) {
		//call constructor
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		//explicitly call toString
		System.out.println("Elements in set1: " + set1.toString());
		System.out.println("Elements in set2: " + set2.toString());
		System.out.print('\n');
		
		//call add
		set1.add(3);
		set1.add(3);
		set1.add(2);
		set1.add(10);
		System.out.println("***Added elements to set1***");
		System.out.println("Elements in set1: " + set1);
		System.out.print('\n');
		
		//call clear
		set1.clear();
		System.out.println("***Cleared set1***");
		System.out.println("Elements in set1: " + set1);
		System.out.print('\n');
		
		//call length
		set1.add(3);
		set1.add(3);
		set1.add(2);
		set1.add(10);
		System.out.println("***Added elements to set1***");
		System.out.println("Length of set1: " + set1.length());
		System.out.println("Length of set2: " + set2.length());
		System.out.print('\n');
		
		//call equals
		System.out.println("Is set1 == set2: " + set1.equals(set2)); //expect true
		set1.add(10);
		set1.add(3);
		set1.add(2);
		System.out.println("***Added elements to set1***");
		System.out.println("Is set1 == set2: " + set1.equals(set2)); //expect false
		set1.clear();
		System.out.println("***Cleared set1***");
		set2.clear();
		System.out.println("***Cleared set2***");
		System.out.println("Is set1 == set2: " + set1.equals(set2)); //expect true
		System.out.print('\n');
		
		//call contains
		set1.add(3);
		set1.add(2);
		set1.add(10);
		System.out.println("***Added elements to set1***");
		System.out.println("Does set1 contain " + Integer.toString(4) + "? => " + set1.contains(4)); //expect false
		System.out.println("Does set1 contain " + Integer.toString(3) + "? => " + set1.contains(3)); //expect true
		System.out.print('\n');
		
		//call largest (with exception)
		try {
			set2.clear();
			System.out.println("***Cleared set2***");
			System.out.println("Elements in set1: " + set1);
			System.out.println("Largest element in set1: " + set1.largest()); //expect work
			System.out.println("Largest element in set2: " + set2.largest()); //expect fail
		} catch (IntegerSetException e) {
			e.printStackTrace();
		} finally {			
			System.out.print('\n');
		}


		//call smallest (with exception)
		try {
			set2.clear();
			System.out.println("***Cleared set2***");
			System.out.println("Elements in set1: " + set1);
			System.out.println("Smallest element in set1: " + set1.smallest()); //expect work
			System.out.println("Smallest element in set2: " + set2.smallest()); //expect fail
		} catch (IntegerSetException e) {
			e.printStackTrace();
		} finally {
			System.out.print('\n');
		}

		//call remove (with exception)
		try {
			System.out.println("Elements in set1: " + set1);
			System.out.println("***Removing " + Integer.toString(3) + " from set1***");
			set1.remove(3); //should work
			System.out.println("Elements in set1: " + set1);
			System.out.println("***Removing " + Integer.toString(11) + " from set1***");
			set1.remove(11); //shouldn't work but won't fail
			System.out.println("Elements in set1: " + set1);
			System.out.println("***Removing " + Integer.toString(3) + " from set2***");
			set2.remove(3); //expect error
		} catch (IntegerSetException e) {
			e.printStackTrace();
		} finally {
			System.out.print('\n');
		}
		
		//call union
		System.out.println("Elements in set1: " + set1);
		System.out.println("Elements in set2: " + set2);
		set1.union(set2);
		set2.union(set1);
		set2.add(33);
		set2.add(22);
		set2.add(100);
		System.out.println("***Added elements to set2***");
		set1.union(set2);
		set2.union(set1);
		System.out.print('\n');
		
		//call intersect
		set2.clear();
		System.out.println("***Cleared set2***");
		System.out.println("Elements in set1: " + set1);
		System.out.println("Elements in set2: " + set2);
		set1.intersect(set2); //expect no elements
		set2.intersect(set1); //expect no elements
		set2.add(2);
		set2.add(22);
		set2.add(100);
		System.out.println("***Added elements to set2***");
		System.out.println("Elements in set1: " + set1);
		System.out.println("Elements in set2: " + set2);
		set1.intersect(set2); //expect 2
		set2.intersect(set1); //expect 2
		System.out.print('\n');
		
		//call diff
		System.out.println("Elements in set1: " + set1);
		System.out.println("Elements in set2: " + set2);
		set1.diff(set2);
		set2.diff(set1);
		set2.add(33);
		set2.add(12);
		set2.add(0);
		System.out.println("***Added elements to set2***");
		set1.diff(set2);
		set2.diff(set1);
	}
}
