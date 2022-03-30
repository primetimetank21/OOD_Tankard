package org.howard.edu.lsp.assignment6.junit;

import java.util.ArrayList;
import org.howard.edu.lsp.assignment6.integerset.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class IntegerSetTest {
	@BeforeEach
	public void initEach(TestInfo testInfo) {
    	System.out.println("Start..." + testInfo.getDisplayName());
    };


    @AfterEach
    public void endEach(TestInfo testInfo) {
    	System.out.println("Finished..." + testInfo.getDisplayName());
    	System.out.print("\n");
    };


	@Test
	@DisplayName("IntegerSet.clear() test cases")
	public void testClear() {
		IntegerSet set1 = new IntegerSet();
		
		//clear empty set (no errors/failures)
		set1.clear();
		assertEquals(set1.isEmpty(), true);
		
		//clear set
		set1.add(1);
		set1.add(2);
		set1.add(3);
		set1.clear();
		assertEquals(set1.isEmpty(), true);
	};


	@Test
	@DisplayName("IntegerSet.length() test cases")
	public void testLength() {
		IntegerSet set1 = new IntegerSet();
		
		assertEquals(set1.length(), 0);
		set1.add(1);
		set1.add(2);
		assertEquals(set1.length(), 2);
	};


	@Test
	@DisplayName("IntegerSet.equals() test cases")
	public void testEquals() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		
		//empty sets
		assertTrue(set1.equals(set2));
		
		//sets of different lengths
		set1.add(1);
		assertFalse(set1.equals(set2));
		
		//equal sets
		set1.add(2);
		set1.add(3);
		set2.add(3);
		set2.add(2);
		set2.add(1);
		assertTrue(set1.equals(set2));
	};


	@Test
	@DisplayName("IntegerSet.contains() test cases")
	public void testContains() {
		IntegerSet set1 = new IntegerSet();
		
		//empty set
		assertFalse(set1.contains(1));
		
		//value within set
		set1.add(1);
		assertTrue(set1.contains(1));
		
		//value not within set
		assertFalse(set1.contains(2));
	};


	@Test
	@DisplayName("IntegerSet.largest() test cases")
	public void testLargest() {
		IntegerSet set1 = new IntegerSet();

		//throws empty set exception
		Exception e = assertThrows(IntegerSetException.class, () -> {
			set1.largest();
		});
		
		String expectedMsg = "Set is empty";
		String actualMsg   = e.toString();
		assertTrue(actualMsg.contains(expectedMsg));

		//returns largest value
		set1.add(1);
		set1.add(2);
		set1.add(3);

		try {
			int largestVal = set1.largest();
			assertEquals(largestVal, 3);
			assertNotEquals(largestVal, 2);
		} catch (IntegerSetException e1) {
			fail();
		}
	};


	@Test
	@DisplayName("IntegerSet.smallest() test cases")
	public void testSmallest() {
		IntegerSet set1 = new IntegerSet();

		//throws empty set exception
		Exception e = assertThrows(IntegerSetException.class, () -> {
			set1.smallest();
		});
		
		String expectedMsg = "Set is empty";
		String actualMsg   = e.toString();
		assertTrue(actualMsg.contains(expectedMsg));
		
		//returns smallest value
		set1.add(1);
		set1.add(2);
		set1.add(3);

		try {
			int smallestVal = set1.smallest();
			assertEquals(smallestVal, 1);
			assertNotEquals(smallestVal, 2);
		} catch (IntegerSetException e1) {
			fail();
		}
	};


	@Test
	@DisplayName("IntegerSet.add() test cases")
	public void testAdd() {
		IntegerSet set1 = new IntegerSet();
		
		int oldLength = set1.length();
		set1.add(1);
		
		//new value added
		assertNotEquals(set1.length(), oldLength);
		assertTrue(set1.contains(1));
	};


	@Test
	@DisplayName("IntegerSet.remove() test cases")
	public void testRemove() {
		IntegerSet set1 = new IntegerSet();

		//throws empty set exception
		Exception e = assertThrows(IntegerSetException.class, () -> {
			set1.remove(1);
		});
		
		String expectedMsg = "Set is empty";
		String actualMsg   = e.toString();
		assertTrue(actualMsg.contains(expectedMsg));
		
		//removes correct item
		set1.add(1);
		set1.add(2);
		
		try {
			int oldLength = set1.length();
			set1.remove(1);
			assertNotEquals(set1.length(), oldLength);
			assertFalse(set1.contains(1));
			assertTrue(set1.contains(2));
		} catch (IntegerSetException e1) {
			fail();
		}
	};


	@Test
	@DisplayName("IntegerSet.union() test cases")
	public void testUnion() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		ArrayList<Integer> unionSet;
		
		//two empty sets
		unionSet = set1.union(set2);
		assertTrue(unionSet.size() == 0);

		unionSet = set2.union(set1);
		assertTrue(unionSet.size() == 0);
		
		//one empty set
		set1.add(1);
		unionSet = set1.union(set2);
		assertTrue(unionSet.size() == 1);
		assertTrue(unionSet.contains(1));

		unionSet = set2.union(set1);
		assertTrue(unionSet.size() == 1);
		assertTrue(unionSet.contains(1));
		
		//contains all elements
		set2.add(2);
		set2.add(3);
		set1.add(4);
		
		unionSet = set1.union(set2);
		assertTrue(unionSet.size() == 4);
		for (int val = 1; val < unionSet.size() + 1; val++) 
			assertTrue(unionSet.contains(val));
		
		unionSet = set2.union(set1);
		assertTrue(unionSet.size() == 4);
		for (int val = 1; val < unionSet.size() + 1; val++) 
			assertTrue(unionSet.contains(val));
	};


	@Test
	@DisplayName("IntegerSet.intersect() test cases")
	public void testIntersect() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		ArrayList<Integer> intersectSet;

		//two empty sets
		intersectSet = set1.intersect(set2);
		assertTrue(intersectSet.size() == 0);

		intersectSet = set2.intersect(set1);
		assertTrue(intersectSet.size() == 0);

		//one empty set
		set1.add(1);
		intersectSet = set1.intersect(set2);
		assertTrue(intersectSet.size() == 0);
		assertFalse(intersectSet.contains(1));

		intersectSet = set2.intersect(set1);
		assertTrue(intersectSet.size() == 0);
		assertFalse(intersectSet.contains(1));
		
		//contains all elements present in BOTH
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set1.add(2);
		set1.add(4);

		intersectSet = set1.intersect(set2);
		assertTrue(intersectSet.contains(1));
		assertTrue(intersectSet.contains(2));
		assertFalse(intersectSet.contains(3));
		assertFalse(intersectSet.contains(4));

		intersectSet = set2.intersect(set1);
		assertTrue(intersectSet.contains(1));
		assertTrue(intersectSet.contains(2));
		assertFalse(intersectSet.contains(3));
		assertFalse(intersectSet.contains(4));

	};


	@Test
	@DisplayName("IntegerSet.diff() test cases")
	public void testDiff() {
		IntegerSet set1 = new IntegerSet();
		IntegerSet set2 = new IntegerSet();
		ArrayList<Integer> diffSet;
		
		//two empty sets
		diffSet = set1.diff(set2);
		assertTrue(diffSet.size() == 0);

		diffSet = set2.diff(set1);
		assertTrue(diffSet.size() == 0);

		//one empty set
		set1.add(1);

		diffSet = set1.diff(set2);
		assertTrue(diffSet.size() == 1);
		assertTrue(diffSet.contains(1));
		
		diffSet = set2.diff(set1);
		assertTrue(diffSet.size() == 0);
		assertFalse(diffSet.contains(1));
		
		//contains all elements present in one but not the other (assuming "one.intersect(other)")
		set2.add(1);
		set2.add(2);
		set2.add(3);
		set1.add(2);
		set1.add(4);

		diffSet = set1.diff(set2);
		assertTrue(diffSet.size() == 1);
		assertFalse(diffSet.contains(1));
		assertFalse(diffSet.contains(2));
		assertFalse(diffSet.contains(3));
		assertTrue(diffSet.contains(4));

		diffSet = set2.diff(set1);
		assertTrue(diffSet.size() == 1);
		assertFalse(diffSet.contains(1));
		assertFalse(diffSet.contains(2));
		assertTrue(diffSet.contains(3));
		assertFalse(diffSet.contains(4));
	};


	@Test
	@DisplayName("IntegerSet.isEmpty() test cases")
	public void testIsEmpty() {
		IntegerSet set1 = new IntegerSet();
		
		//empty set
		assertTrue(set1.isEmpty());
		
		//non-empty set
		set1.add(1);
		assertFalse(set1.isEmpty());
		
		//cleared set
		set1.clear();
		assertTrue(set1.isEmpty());
	};


	@Test
	@DisplayName("IntegerSet.toString() test cases")
	public void testToString() {
		IntegerSet set1 = new IntegerSet();
		String expected;
		
		//empty set
		expected = "[]";
		assertEquals(expected, set1.toString());
		
		//non-empty set
		expected = "[1]";
		set1.add(1);
		assertEquals(expected, set1.toString());
		
		//cleared set
		expected = "[]";
		set1.clear();
		assertTrue(set1.isEmpty());
	};
}
