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
	 * @param intSetb -- another IntegerSet object
	 * @return boolean
	 */
	public boolean equals(IntegerSet intSetb) {
		//true if both are empty sets
		if(this.isEmpty() && intSetb.isEmpty()) return true;
		
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
	 * @param value -- element to look for
	 * @return boolean
	 */
	public boolean contains(int value) {
		return this.set.contains(value);
	};    
	
	
	/**
	 * Returns the largest item in the set; Throws a IntegerSetException if the set is empty
	 * @return int
	 * @throws IntegerSetException -- empty set
	 */
	public int largest() throws IntegerSetException {
		if(this.isEmpty()) throw new IntegerSetException("Error in 'largest()': Set is empty");
		return Collections.max(this.set);
	}; 
	
	
	/**
	 * Returns the smallest item in the set; Throws a IntegerSetException if the set is empty
	 * @return int
	 * @throws IntegerSetException -- empty set
	 */
	public int smallest() throws IntegerSetException {
		if(this.isEmpty()) throw new IntegerSetException("Error in 'smallest()': Set is empty");		
		return Collections.min(this.set);
	};
	
	
	/**
	 * Adds an item to the set or does nothing if already in set
	 * @param item -- element to add
	 */
	public void add(int item) {
		if(!this.set.contains(item)) this.set.add(item);
	};
	
	
	/**
	 * Removes an item from the set or does nothing if not in set
	 * @param item -- element to remove
	 * @throws IntegerSetException -- empty set
	 */
	public void remove(int item) throws IntegerSetException {
		if(this.isEmpty()) throw new IntegerSetException("Error in 'remove()': Set is empty");
		if(this.set.contains(item)) this.set.remove(this.set.indexOf(item));
	};
	
	
	/**
	 * Print elements present in the sets
	 * @param intSetb -- another IntegerSet object 
	 */
	public void union(IntegerSet intSetb) {
		//create set to hold all elements
		Set<Integer> unionSet = new HashSet<Integer>();
		
		//add all elements
		unionSet.addAll(this.set);
		unionSet.addAll(intSetb.set);
		
		//print elements
		System.out.print("Union: ");
		for(int num : unionSet) {
			System.out.print(Integer.toString(num) + " ");
		}
		System.out.print('\n');
	};
	
	
	/**
	 * Print elements in both sets
	 * @param intSetb -- another IntegerSet object
	 */
	public void intersect(IntegerSet intSetb) {
		//create copy of this.set (reason: Collections.retainAll() changes object in-place;
		//don't want to modify the original sets
		List<Integer> setCopy = new ArrayList<Integer>(this.set);
		
		//find elements common to both
		setCopy.retainAll(intSetb.set);
		
		//print elements
		System.out.print("Intersect: ");
		for(int num : setCopy) {
			System.out.print(Integer.toString(num) + " ");
		}
		System.out.print('\n');
	}; 
	
	
	/**
	 * Print elements in this.set that are not in intSetb
	 * @param intSetb -- another IntegerSet object
	 */
	public void diff(IntegerSet intSetb) {
		//cast sets (really ArrayLists) to HashSets
		Set<Integer> setCopy        = new HashSet<Integer>(this.set);
		Set<Integer> intSetbSetCopy = new HashSet<Integer>(intSetb.set);
		
		//perform set difference
		setCopy.removeAll(intSetbSetCopy);
		
		//print elements
		System.out.print("Set Difference: ");
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
		if(this.isEmpty()) return "no elements";
		String elements = "";
		for(int num : this.set) {
			elements = elements.concat(Integer.toString(num)) + ", ";
		}
		
		//removing the ", " off the last element
		elements = elements.substring(0, elements.length() - 2);
		
		return elements;
	};
}

