package org.cocons.uml.ccl.comparators.test;

import org.cocons.uml.ccl.Comparator;
import org.cocons.uml.ccl.comparators.ComparatorFactory;
import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;

import org.cocons.uml.ccl.util.ConditionalTreeGenerator;

/**
 * Tests the comparators and it's production through the ComparatorFactory.
 */
public class TestComparatorFactory extends junit.framework.TestCase {

	/**
	 * A comparator factory.
	 */
	private ComparatorFactory comparatorFactory;

	/**
	 * Constructs this test.
	 * @param name java.lang.String the name of the test.
	 */
	public TestComparatorFactory(String name) {
		super(name);
	}

	/**
	 * Starts the test for the ComparatorFactory.
	 * Creation date: (26.12.2001 16:12:05)
	 * @param args java.lang.String[] no args needed.
	 */
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestComparatorFactory.class);
	}

	/**
	 * Tests if the equation works for doubles.
	 * Creation date: (26.12.2001 15:43:05)
	 */
	public void testEquation() {

		double equalValue = Math.random();
		double unequalValue = Math.random();

		while (equalValue == unequalValue) {
			unequalValue = Math.random();
		}

		ComparatorFactory cf = new ComparatorFactoryImpl();
		Comparator eq = cf.produceComparatorWithType(ComparatorFactory.EQUAL);

		assertTrue(
			"Doubles are equal, but compared with Equation they are not", 
			eq.compare(String.valueOf(equalValue), String.valueOf(equalValue))); 

		assertTrue(
			"Doubles are unequal, but compared with Equation they are not", 
			!eq.compare(String.valueOf(equalValue), String.valueOf(unequalValue))); 

	}

	/**
	* Sets this test up.
	* Creation date: (28.12.2001 01:52:02)
	*/
	public void setUp() {
		comparatorFactory = new ComparatorFactoryImpl();
	}

	/**
	* Tests if the produced operation less is reliable.
	* Creation date: (28.12.2001 01:49:44)
	*/
	public void testLess() {

		Comparator less = comparatorFactory.produceComparatorWithType(ComparatorFactory.LESS);

		double value1 = Math.random();
		double value2 = Math.random();

		if (value1 < value2) {
			assertTrue(
				"First value should be less than the second", 
				less.compare(String.valueOf(value1), String.valueOf(value2))); 
		}

	}

	/**
	 * Tests the contains comparator.
	 * Creation date: (28.12.2001 22:05:41)
	 */
	public void testContains() {

		String substring = ConditionalTreeGenerator.generateTag(23);

		String frontString = ConditionalTreeGenerator.generateTag(45);
		String endString = ConditionalTreeGenerator.generateTag(56);

		String concatenatedString = frontString + substring + endString;

		Comparator contains = comparatorFactory.produceComparatorWithType(ComparatorFactory.CONTAINS);

		assertTrue(
			"The substring should be contained in the concatenated string.", 
			contains.compare(concatenatedString, substring)); 

		// numbers are not contained in the containing string
		substring += '1';

		assertTrue(
			"The substring should not be contained in the concatenated string.", 
			!contains.compare(concatenatedString, substring)); 

	}
}