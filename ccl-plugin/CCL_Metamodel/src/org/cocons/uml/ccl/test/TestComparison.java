package org.cocons.uml.ccl.test;

import org.cocons.uml.ccl.Comparator;
import org.cocons.uml.ccl.comparators.ComparatorFactory;
import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.Comparison;


import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyValueImpl;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyTag;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyTagImpl;

import ru.novosoft.uml.foundation.data_types.MBooleanExpression;
import ru.novosoft.uml.foundation.core.MConstraintImpl; 

import org.cocons.uml.ccl.ValueComparison;import ru.novosoft.uml.foundation.core.MClassImpl;/**
* Tests the ComparisonImpl class. 
* Creation date: (26.12.2001 16:38:43)
* @author: Fadi Chabarek
*/
public class TestComparison extends junit.framework.TestCase {
	private org.cocons.uml.ccl.comparators.ComparatorFactory comparatorFactory;

	/**
	 * TestComparison constructor comment.
	 * @param name java.lang.String
	 */
	public TestComparison(String name) {
		super(name);
	}

	/**
	 * Runs this test.
	 * Creation date: (26.12.2001 16:38:51)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestComparison.class);
	}

	/**
	 * Sets the test sceen up.
	 * Creation date: (26.12.2001 17:12:54)
	 */
	public void setUp() {

		comparatorFactory = new ComparatorFactoryImpl();
	}

	/**
	 * Generic try to test the covers method.
	 * Creation date: (26.12.2001 18:19:34)
	 */
	public void testCoversPropertyValue() {

		// random strings
		String comparisonValue = String.valueOf(Math.random());
		String elementValue = String.valueOf(Math.random());

		String comparisonTag = String.valueOf(Math.random());
		String elementTag = String.valueOf(Math.random());

		// tagged value
		MClassImpl cl = new MClassImpl();
		MContextPropertyValueImpl value = new MContextPropertyValueImpl();
		MContextPropertyTagImpl tag = new MContextPropertyTagImpl();

		MConstraintImpl con = new MConstraintImpl();
		con.setBody(new MBooleanExpression(null, "\"List Of Strings\" "));
		tag.addConstraint(con);

		tag.setTag(elementTag);
		value.setContextPropertyTag(tag);
		value.setValue(elementValue);

		cl.addTaggedValue(value);

		// comparison
		ValueComparison comparison = new ValueComparison();
		comparison.setValue(comparisonValue);
		comparison.setTag(comparisonTag);

		// tests for all available comperators
		Comparator[] comparators = comparatorFactory.produceAllAvailableComparators();
		boolean compared = false;
		boolean covered = false;

		for (int i = 0; i < comparators.length; i++) {

			// supposed that the boudary compares its value with the given value
			// and not the other way round.
			compared = comparators[i].compare(comparisonValue, elementValue);
			compared = compared && comparisonTag.equals(elementTag);

			comparison.setComparator(comparators[i]);
			covered = comparison.covers(cl);

			assertTrue("The compared and covered should be the same for the comparison", compared == covered);

		}

	}

	/**
	 * Tests the covers method with context property values for nullpointer exceptions.
	 * Creation date: (26.12.2001 16:50:04)
	 */
	public void testCoversPropertyValueForNullPointerExceptions() {

		/********************* TEST A: NullPointerExceptions ******************
		
			a) property value = null
			b) comparison value = null
			c) comparison tag = null
			d) comparison comparator = null
			e) comparison value + tag != null, comparator = null
		
			*/

		MClassImpl cl = new MClassImpl();
		ValueComparison comparison = new ValueComparison();
		MContextPropertyValueImpl value = new MContextPropertyValueImpl();
		MContextPropertyTagImpl tag = new MContextPropertyTagImpl();

		MConstraintImpl con = new MConstraintImpl();
		con.setBody(new MBooleanExpression(null, "\"List Of Strings\" "));
		tag.addConstraint(con);

		value.setContextPropertyTag(tag);

		cl.addTaggedValue(value);

		//a)
		try {
			comparison.setComparator(comparatorFactory.produceComparatorWithType(ComparatorFactory.EQUAL));
			comparison.setTag("null?");
			comparison.setValue("no");

			comparison.covers(null);
		} catch (NullPointerException e) {
			fail("NullPointerException caught with property value = null");
		}
		//b)

		try {
			value.setValue("yes");
			value.getContextPropertyTag().setTag("yes?");

			comparison.setValue(null);

			comparison.covers(cl);
		} catch (NullPointerException e) {
			fail("NullPointerException caught with comparison value = null");
		}

		//c)
		try {
			comparison.setValue("no");
			comparison.setTag(null);

			comparison.covers(cl);

		} catch (NullPointerException e) {
			fail("NullPointerException caught with comparison tag = null");
		}
		//d)
		try {
			comparison.setTag("bla");
			comparison.setComparator(null);

			comparison.covers(cl);

		} catch (NullPointerException e) {
			fail("NullPointerException caught with comparison tag + value = null");
		}
	}

	/**
	 * Test the covers method with the comparator equation.
	 * Creation date: (26.12.2001 17:56:13)
	 */
	public void testCoversPropertyValueWithEquation() {

		/********************* TEST A: Equation ******************
		
			a) with equal tagged values -> covers = true
			b) with unequal tags -> covers = false
			c) with unequal values -> covers = false
			d) with unequal tags and values -> covers = false
		
			*/

		MClassImpl cl = new MClassImpl();
		MContextPropertyValueImpl value = new MContextPropertyValueImpl();
		MContextPropertyTagImpl tag = new MContextPropertyTagImpl();

		MConstraintImpl con = new MConstraintImpl();
		con.setBody(new MBooleanExpression(null, "\"List Of Strings\" "));
		tag.addConstraint(con);

		value.setContextPropertyTag(tag);
		
		cl.addTaggedValue(value);

		Comparator equation = comparatorFactory.produceComparatorWithType(ComparatorFactory.EQUAL);

		double equalValue = Math.random();
		double unequalValue = Math.random();

		while (equalValue == unequalValue) {
			unequalValue = Math.random();
		}

		double equalTag = Math.random();
		double unequalTag = Math.random();

		while (equalTag == unequalTag) {
			unequalTag = Math.random();
		}

		ValueComparison comparison = new ValueComparison();
		comparison.setValue(String.valueOf(equalValue));
		comparison.setTag(String.valueOf(equalTag));

		comparison.setComparator(equation);

		//a
		value.setValue(String.valueOf(equalValue));
		tag.setTag(String.valueOf(equalTag));

		assertTrue(
			"With equal tagged values the comparison should have covered. Detail:\n"
				+ "Comparison "
				+ comparison.toString()
				+ ", PropertyValue: "
				+ equalValue
				+ " : "
				+ equalTag, 
			comparison.covers(cl)); 

		//b
		value.getContextPropertyTag().setTag(String.valueOf(unequalTag));

		assertTrue(
			"With unequal tags the comparison should not have covered. Detail:\n"
				+ "Comparison "
				+ comparison.toString()
				+ ", PropertyValue: "
				+ equalValue
				+ " : "
				+ equalTag, 
			!comparison.covers(cl)); 

		//c
		value.getContextPropertyTag().setTag(String.valueOf(equalTag));
		value.setValue(String.valueOf(unequalValue));

		assertTrue(
			"With unequal values the comparison should not have covered. Detail:\n"
				+ "Comparison "
				+ comparison.toString()
				+ ", PropertyValue: "
				+ equalValue
				+ " : "
				+ equalTag, 
			!comparison.covers(cl)); 

		//d
		value.getContextPropertyTag().setTag(String.valueOf(unequalTag));
		value.setValue(String.valueOf(unequalValue));

		assertTrue(
			"With unequal tagged values the comparison should not have covered. Detail:\n"
				+ "Comparison "
				+ comparison.toString()
				+ ", PropertyValue: "
				+ equalValue
				+ " : "
				+ equalTag, 
			!comparison.covers(cl)); 

	}
}