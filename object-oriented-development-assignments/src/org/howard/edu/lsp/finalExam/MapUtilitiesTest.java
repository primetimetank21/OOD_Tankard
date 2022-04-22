package org.howard.edu.lsp.finalExam;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapUtilitiesTest {
	@Test
	@DisplayName("MapUtilities.commonKeyValuePairs() test cases")
	public void testCommonKeyValuePairs() {
		HashMap<String, String> map1 = new HashMap<String, String>();
		HashMap<String, String> map2 = new HashMap<String, String>();
		
		//map1 null -- throws NullMapException
		Exception e1 = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(null, map2);
		});
		
		String expectedMsg1 = "One or both maps are null!";
		String actualMsg1   = e1.toString();
		assertTrue(actualMsg1.contains(expectedMsg1));

		//map2 null -- throws NullMapException
		Exception e2 = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(map1, null);
		});
		
		String expectedMsg2 = "One or both maps are null!";
		String actualMsg2   = e2.toString();
		assertTrue(actualMsg2.contains(expectedMsg2));

		//both null -- throws NullMapException
		Exception e3 = assertThrows(NullMapException.class, () -> {
			MapUtilities.commonKeyValuePairs(null, null);
		});

		String expectedMsg3 = "One or both maps are null!";
		String actualMsg3   = e3.toString();
		assertTrue(actualMsg3.contains(expectedMsg3));

		//empty HashMaps (both)
		try {
			int pairs = MapUtilities.commonKeyValuePairs(map1, map2);
			assertEquals(pairs, 0);
		} catch (Exception e) {
			fail();
		}

		//empty HashMaps (one or other)
		try {
			map1.put("Alice", "Healthy"); //map1 is non-empty
			int pairs = MapUtilities.commonKeyValuePairs(map1, map2);
			assertEquals(pairs, 0);

			pairs = MapUtilities.commonKeyValuePairs(map2, map1);
			assertEquals(pairs, 0);
		} catch (Exception e) {
			fail();
		}

		//normal case (proper input)
		try {
			map1.put("Alice", "Healthy");
			map1.put("Mary", "Ecastic");
			map1.put("Bob", "Happy");
			map1.put("Chuck", "Fine");
			map1.put("Felix", "Sick");
			map2.put("Mary", "Ecastic");
			map2.put("Felix", "Healthy");
			map2.put("Ricardo", "Subperb");
			map2.put("Tam", "Fine");
			map2.put("Bob", "Happy");		
			int pairs = MapUtilities.commonKeyValuePairs(map1, map2);
			assertEquals(pairs, 2);
		} catch (Exception e) {
			fail();
		}
	};
}
