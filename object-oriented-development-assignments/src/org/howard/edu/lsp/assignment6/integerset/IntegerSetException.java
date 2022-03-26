package org.howard.edu.lsp.assignment6.integerset;

@SuppressWarnings("serial")
/**
 * Custom Exception for the IntegerSet class
 * @author earltankardjr
 */
public class IntegerSetException extends Exception {
	String errorMsg;
	
	/**
	 * Default Constructor
	 * @param err -- error string
	 */
    public IntegerSetException(String err) {
       this.errorMsg = err;
    }
    
    /**
     * Print out error message
     */
    public String toString() { 
    	return "IntegerSetException Occurred: " + this.errorMsg;
    }
    
}
