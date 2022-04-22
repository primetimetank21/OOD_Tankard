package org.howard.edu.lsp.finalExam;

@SuppressWarnings("serial")
public class NullMapException extends Exception {
	String errorMsg;
	
	/**
	 * Default Constructor
	 * @param err -- error string
	 */
    public NullMapException(String err) {
       this.errorMsg = err;
    }
    
    /**
     * Print out error message
     */
    public String toString(){ 
    	return "NullMapException Occurred: " + this.errorMsg;
    }
}
