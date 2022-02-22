package org.howard.edu.lsp.assignment5.implementation;

@SuppressWarnings("serial")
/**
 * Custom Exception for the IntegerSet class
 * @author earltankardjr
 */
public class IntegerSetException extends Exception {
	String errorMsg;
	
	/**
	 * Default Constructor
	 * @param s
	 */
    public IntegerSetException(String s)
    {
       this.errorMsg = s;
    }
    
    /**
     * Print out error message
     */
    public String toString(){ 
    	return "IntegerSetException Occurred: " + this.errorMsg;
    }
    
}
