package org.howard.edu.lsp.finalExam;

import java.util.HashMap;
import java.util.Set;

/**
 * This class serves as a utility for checking HashMaps
 * @author earltankardjr
 */
public class MapUtilities {
	/**
	 * Checks for common key-value pairs between two HashMaps 
	 * @param map1 -- a HashMap
	 * @param map2 -- another HashMap
	 * @return int
	 * @throws NullMapException
	 */
	public static int commonKeyValuePairs(HashMap<String, String> map1, HashMap<String, String> map2) throws NullMapException {
		if (map1 == null || map2 == null) throw new NullMapException("One or both maps are null!");
		if (map1.isEmpty() || map2.isEmpty()) return 0;
		
		//get common keys
		Set<String> keySet  = map1.keySet();
		Set<String> keySet2 = map2.keySet();
		keySet.retainAll(keySet2);

		//if no common keys, return 0 (save resources!)
		if (keySet.size() == 0) return 0;
		
		//check for common values
		int commonPairs = 0;
		for (String key : keySet) {
			if (map1.get(key).equals(map2.get(key))) commonPairs += 1;
		}
				
		return commonPairs;
	}
}
