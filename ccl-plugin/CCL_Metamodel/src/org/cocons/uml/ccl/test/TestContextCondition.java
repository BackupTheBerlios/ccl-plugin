package org.cocons.uml.ccl.test;

import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.ComparisonImpl;
import org.cocons.uml.ccl.ContextConditionImpl;
import org.cocons.uml.ccl.ContextCondition;
import org.cocons.uml.ccl.BaseClasses;
import org.cocons.uml.ccl.CCLConstants;

/**
 * TestCase for the class Context Conditions.
 * Creation date: (07.02.2002 19:34:26)
 * @author: Fadi Chabarek
 */
public class TestContextCondition extends junit.framework.TestCase {
	
	/**
	 * Constructs this test case.
	 * Creation date: (08.02.2002 13:21:16)
	 * @param name java.lang.String the name of the test case.
	 */
	public TestContextCondition(String name) {
		super(name);
	}
    
	/**
	 * Starts this test.
	 * Creation date: (08.02.2002 14:05:46)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestContextCondition.class);
	}
    
	/**
	 * Sets this test up.
	 * Creation date: (08.02.2002 13:27:47)
	 */
	public void setUp() {
	}
    
	/**
	 * Tests if the method is base class valid.
	 * Creation date: (08.02.2002 14:59:38)
	 */
	public void testBaseClass() {

		// base class
		// A: with null -> invalid
		// B: with defined type -> valid
		// C: with not defined type -> invalid

		// setup a valid context condition (until B)
		ContextConditionImpl cc = new ContextConditionImpl();
		ComparatorFactoryImpl cf = new ComparatorFactoryImpl();
		ComparisonImpl comp = new ComparisonImpl();
		comp.setTag("tag");
		comp.setComparator(cf.produceComparatorWithType(cf.EQUAL));
		comp.setValue("value");

		cc.setRange(CCLConstants.INDIRECT_RANGE_ALL);
		cc.setBaseClass(null);
		cc.setComparison(comp);

		// A
		assertTrue("The base class is null, so it should have been invalid.", !cc.isValid());

		// B
		cc.setBaseClass(BaseClasses.COMPONENT);
		assertTrue("The base class is defined, so it should have been valid.", cc.isValid());

		// C
		cc.setBaseClass("COMPINTF");
		assertTrue("The base class is not defined, so it shouldn't have been valid.", !cc.isValid());
	}
    
	/**
	 * Test the is complied with method.
	 * Creation date: (08.02.2002 13:32:40)
	 */
	public void testIsCompliedWith() {

		//ToDo: test a big tree with range and with base class.

		assertTrue(true);
	}
    
	/**
	 * Test the validity of ranges.
	 * Creation date: (08.02.2002 13:51:07)
	 */
	public void testRange() {

		// A: with null -> invalid
		// B: with random integer -> valid
		// C: with keyword -> valid
		// D: with random word -> invalid (assumed that the word is not a keyword)
		// E: with random word + integer -> invalid 
		// F: with keyword + integer -> invalid
		// G: with keyword + word -> invalid

		String randomWord = org.cocons.uml.ccl.util.ConditionalTreeGenerator.generateTag(3);

		while (randomWord.compareToIgnoreCase(CCLConstants.INDIRECT_RANGE_ALL) == 0) {
			randomWord = org.cocons.uml.ccl.util.ConditionalTreeGenerator.generateTag(3);
		}

		String randomInteger = String.valueOf(new Double(Math.random() * 10000.0).intValue());

		// setup a valid context condition (until B)
		ContextConditionImpl cc = new ContextConditionImpl();
		ComparatorFactoryImpl cf = new ComparatorFactoryImpl();
		ComparisonImpl comp = new ComparisonImpl();
		comp.setTag(randomWord);
		comp.setComparator(cf.produceComparatorWithType(cf.EQUAL));
		comp.setValue(randomInteger);

		cc.setBaseClass(BaseClasses.COMPONENT);
		cc.setComparison(comp);

		// A
		assertTrue("The range is null, so it should have been invalid.", !cc.isValid());

		// B
		cc.setRange(randomInteger);
		assertTrue(
			"The integer " + randomInteger + " was declared as invalid, although it should have been valid.", 
			cc.isValid()); 

		// C
		cc.setRange(CCLConstants.INDIRECT_RANGE_ALL);
		assertTrue(
			"The keyword "
				+ CCLConstants.INDIRECT_RANGE_ALL
				+ " was declared as invalid, although it should have been valid.", 
			cc.isValid()); 

		// D
		cc.setRange(randomWord);
		assertTrue(
			"The word " + randomWord + " was declared as valid, although it should have been invalid.", 
			!cc.isValid()); 

		// E
		cc.setRange(randomWord + randomInteger);
		assertTrue(
			"The word "
				+ randomInteger
				+ randomWord
				+ " was declared as valid, although it should have been invalid.", 
			!cc.isValid()); 

		// F
		cc.setRange(CCLConstants.INDIRECT_RANGE_ALL + randomInteger);
		assertTrue(
			"The keyword + integer"
				+ CCLConstants.INDIRECT_RANGE_ALL
				+ randomInteger
				+ " was declared as valid, although it should have been invalid.", 
			!cc.isValid()); 

		// G
		cc.setRange(CCLConstants.INDIRECT_RANGE_ALL + randomWord);
		assertTrue(
			"The keyword + the word"
				+ CCLConstants.INDIRECT_RANGE_ALL
				+ randomWord
				+ " was declared as valid, although it should have been invalid.", 
			!cc.isValid()); 
	}
}