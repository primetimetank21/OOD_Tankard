package org.howard.edu.lsp.assignment5.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * This class handles Integer Sets and their respective operations (i.e., union, difference, intersection, etc.)
 * @author earltankardjr
 *
 */
public class IntegerSet  {
	private List<Integer> set;

	/**
	 * Default Constructor
	 */
	public IntegerSet() {
		this.set = new ArrayList<Integer>();
	}

	
	/**
	 * Clears the internal representation of the set
	 */
	public void clear() {
		this.set.clear();
	};
	
	
	/**
	 * Returns the length of the set
	 * @return int
	 */
	public int length() {
		return this.set.size();
	};
	
	
	/**
	 * Returns true if the 2 sets are equal, false otherwise;
	 * Two sets are equal if they contain all of the same values in ANY order.
	 * @param b
	 * @return boolean
	 */
	public boolean equals(IntegerSet intSetb) {
		//true if both are empty sets
		if(this.length() == 0 && intSetb.length() == 0) return true;
		
		//false if sets are of different lengths
		if(this.length() != intSetb.length()) return false;
		
		//create copy of each set (reason: Collections.sort() changes object in-place;
		//don't want to modify the original sets
		List<Integer> setCopy        = new ArrayList<Integer>(this.set);
		List<Integer> intSetbSetCopy = new ArrayList<Integer>(intSetb.set);
		
		//sort sets and see if equal
		Collections.sort(setCopy);
		Collections.sort(intSetbSetCopy);
		return setCopy.equals(intSetbSetCopy);				
	}; 
	
	
	/**
	 * Returns true if the set contains the value, otherwise false
	 * @param value
	 * @return boolean
	 */
	public boolean contains(int value) {
		return this.set.contains(value);
	};    
	
	
	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
	 * @return int
	 * @throws IntegerSetException
	 */
	public int largest() throws IntegerSetException {
		try {
			if(this.length() == 0) throw new IntegerSetException("Set is empty");
			
			int num = Collections.max(this.set);
			return num;
		} catch(IntegerSetException e) {
			System.out.println("Error in 'largest()': " + e);
		}
		
		return 0;
	}; 
	
	
	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 * @return int
	 * @throws IntegerSetException
	 */
	public int smallest() throws IntegerSetException {
		try {
			if(this.length() == 0) throw new IntegerSetException("Set is empty");
			
			int num = Collections.min(this.set);
			return num;
			
		} catch(IntegerSetException e) {
			System.out.println("Error in 'smallest()': " + e);
		}
		
		return 0;
	};
	
	
	/**
	 * Adds an item to the set or does nothing if already in set
	 * @param item
	 */
	public void add(int item) {
		if(!this.set.contains(item)) this.set.add(item);
	};
	
	
	/**
	 * Removes an item from the set or does nothing if not in set
	 * @param item
	 */
	public void remove(int item) throws IntegerSetException {
		try {
			if(this.length() == 0) throw new IntegerSetException("Set is empty");
			
			if(this.set.contains(item)) this.set.remove(item);
			
		} catch(IntegerSetException e) {
			System.out.println("Error in 'remove()': " + e);
		}
	};
	
	
	/**
	 * Print elements present in the sets
	 * @param intSetb
	 */
	public void union(IntegerSet intSetb) {
		//create set to hold all elements
		Set<Integer> unionSet = new HashSet<Integer>();
		
		//add all elements
		unionSet.addAll(this.set);
		unionSet.addAll(intSetb.set);
		
		//print elements
		System.out.println("Union:");
		for(int num : unionSet) {
			System.out.print(Integer.toString(num) + " ");
		}
		System.out.print('\n');
	};
	
	
	/**
	 * Print elements in both sets
	 * @param intSetb
	 */
	public void intersect(IntegerSet intSetb) {
		//create copy of this.set (reason: Collections.retainAll() changes object in-place;
		//don't want to modify the original sets
		List<Integer> setCopy = new ArrayList<Integer>(this.set);
		
		//find elements common to both
		setCopy.retainAll(intSetb.set);
		
		//print elements
		System.out.println("Intersect:");
		for(int num : setCopy) {
			System.out.print(Integer.toString(num) + " ");
		}
		System.out.print('\n');
	}; 
	
	
	/**
	 * Print elements in this.set that are not in intSetb
	 * @param intSetb
	 */
	public void diff(IntegerSet intSetb) {
		//cast sets (really ArrayLists) to HashSets
		Set<Integer> setCopy        = new HashSet<Integer>(this.set);
		Set<Integer> intSetbSetCopy = new HashSet<Integer>(intSetb.set);
		
		//perform set difference
		setCopy.removeAll(intSetbSetCopy);
		
		//print elements
		System.out.println("Set Difference:");
		for(int num : setCopy) {
			System.out.print(Integer.toString(num) + " ");
		}
		System.out.print('\n');
	};
	
	
	/**
	 * Returns true if the set is empty, false otherwise
	 * @return boolean
	 */
	boolean isEmpty() {
		if(this.length() == 0) return true;
		return false;
	}; 
	
	
	/**
	 * Returns elements in the set
	 */
	public String toString() {
		String elements = "";
		for(int num : this.set) {
			elements = elements.concat(Integer.toString(num)) + ", ";
		}
		
		//removing the ", " off the last element
		elements = elements.trim();
		elements = elements.substring(0, elements.length() - 1);
		
		return elements;
	};
}

