package org.cocons.uml.ccl.test;

import org.cocons.uml.ccl.ComparisonImpl;
import org.cocons.uml.ccl.logic_operations.LogicFactoryImpl;
import org.cocons.uml.ccl.logic_operations.LogicFactory;
import org.cocons.uml.ccl.comparators.ComparatorFactory;
import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.Condition;
import org.cocons.uml.ccl.ConditionImpl;
import org.cocons.uml.ccl.ContextConditionImpl;

import org.cocons.uml.ccl.util.ConditionalTreeGenerator;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValueImpl;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyTagImpl;

import ru.novosoft.uml.foundation.data_types.MBooleanExpression;
import ru.novosoft.uml.foundation.core.MConstraintImpl;
import ru.novosoft.uml.foundation.core.MClassImpl;

/**
* Tests the ConditionImpl class from org.cocons.uml.ccl. 
*/
public class TestCondition extends junit.framework.TestCase {

	/**
	 * A comparison with equation as comparator. A tag and value will be setup.
	 */
	private org.cocons.uml.ccl.Comparison equationComparison;

	/**
	 * A logic factory.
	 */
	private org.cocons.uml.ccl.logic_operations.LogicFactory logicFactory;

	/**
	 * A comparator factory.
	 */
	private org.cocons.uml.ccl.comparators.ComparatorFactory comparatorFactory;

	/**
	 * The logic factory or.
	 */
	private org.cocons.uml.ccl.LogicOperation or;

	/**
	 * Constructs this test.
	 * @param name java.lang.String the test's name.
	 */
	public TestCondition(String name) {
		super(name);
	}

	/**
	 * Runs this test.
	 * Creation date: (27.12.2001 18:21:22)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestCondition.class);
	}

	/**
	 * Sets the test up.
	 * Creation date: (27.12.2001 18:32:35)
	 */
	public void setUp() {

		comparatorFactory = new ComparatorFactoryImpl();
		logicFactory = new LogicFactoryImpl();

		ComparisonImpl b = new ComparisonImpl();
		b.setComparator(comparatorFactory.produceComparatorWithType(ComparatorFactory.EQUAL));
		b.setTag("tag");
		b.setValue("0");
		equationComparison = b;

		or = logicFactory.produceLogicOperationWithType(LogicFactory.OR);

	}

	/**
	 * Tests the is complied with method.
	 * Creation date: (28.12.2001 00:22:19)
	 */
	public void testIsCompliedWith() {

		//model element with no tagged value -> not comply.
		MClassImpl modelElement = new MClassImpl();

		Condition cond = ConditionalTreeGenerator.generateConditionalTree(100);
		assertTrue(
			"Model element has no tag, so condition can't be complied with", 
			!cond.isCompliedWith(modelElement)); 

		// build up a complex compliant tree

		MContextPropertyValueImpl value = new MContextPropertyValueImpl();
		MContextPropertyTagImpl tag = new MContextPropertyTagImpl();

		MConstraintImpl con = new MConstraintImpl();
		con.setBody(new MBooleanExpression(null, "\"List Of Strings\" "));
		tag.addConstraint(con);

		value.setContextPropertyTag(tag);

		tag.setTag(ConditionalTreeGenerator.generateTag(10));
		value.setValue(String.valueOf(Math.random()));

		modelElement.addTaggedValue(value);

		// TODO: build up a usual complient and non complient tree.
		// ALL CLASSES WHERE 'personal data' = 'yes'.

		// ALL COMPONENTS WHERE 'tier' CONTAINS 'Internet User Interface'.

	}

	/**
	 * Tests the is complied with method with the operation OR.
	 * Creation date: (28.12.2001 00:22:19)
	 */
	public void testIsCompliedWithOr() {

		ContextConditionImpl contextCondition = new ContextConditionImpl();
		ConditionImpl cond1 = new ConditionImpl();
		ConditionImpl cond2 = new ConditionImpl();

		// build up a valid conditional tree
		contextCondition.setLogicOperation(or);
		cond1.setComparison(equationComparison);
		cond2.setComparison(equationComparison);

		contextCondition.setFirstChild(cond1);
		contextCondition.setSecondChild(cond2);

		assertTrue("The simple tree should be valid", contextCondition.isValid());

		// build up a complient model element.
		MContextPropertyValueImpl value = new MContextPropertyValueImpl();
		MContextPropertyTagImpl tag = new MContextPropertyTagImpl();

		MConstraintImpl con = new MConstraintImpl();
		con.setBody(new MBooleanExpression(null, "\"List Of Strings\" "));
		tag.addConstraint(con);

		tag.setTag(cond1.getComparison().getTag());
		value.setValue(cond1.getComparison().getValue());
		value.setContextPropertyTag(tag);

		MClassImpl modelElement = new MClassImpl();
		modelElement.addTaggedValue(value);

		assertTrue(
			"The tag and the value of the model element should be complient", 
			contextCondition.isCompliedWith(modelElement)); 

		// build up non complient
		value.setValue("-1");
		assertTrue(
			"The tag and the value of the model element should be complient", 
			!contextCondition.isCompliedWith(modelElement)); 

	}

	/**
	 * Tests the validity method.
	 * Creation date: (27.12.2001 18:13:30)
	 */
	public void testValidity() {

		// a) comparison + two childs -> invalid
		// b) comparison + one child -> invalid
		// c) no comparison + one child -> invalid
		// d) no comparison + no child -> invalid

		// e) comparison + no childs -> valid
		// f) no comparison + two childs -> valid

		ConditionImpl firstC = new ConditionImpl();
		ConditionImpl secondC = new ConditionImpl();
		firstC.setComparison(equationComparison);
		secondC.setComparison(equationComparison);

		assertTrue(
			"A simple condition with comparison should be valid", 
			firstC.isValid() && secondC.isValid()); 

		// invalid 
		ConditionImpl invalidC = new ConditionImpl();

		//a)
		invalidC.setComparison(equationComparison);
		invalidC.setFirstChild(firstC);
		invalidC.setSecondChild(secondC);

		assertTrue("Condition with comparison and two childs should be invalid", !invalidC.isValid());

		//b)
		invalidC.setComparison(equationComparison);
		invalidC.setFirstChild(firstC);
		invalidC.setSecondChild(null);

		assertTrue("Condition with comparison and one child should be invalid", !invalidC.isValid());

		//c)
		invalidC.setComparison(null);
		invalidC.setFirstChild(null);
		invalidC.setSecondChild(secondC);

		assertTrue("Condition with no comparison and one child should be invalid", !invalidC.isValid());

		//d)
		invalidC.setComparison(null);
		invalidC.setFirstChild(null);
		invalidC.setSecondChild(null);

		assertTrue("Condition with no comparison and no child should be invalid", !invalidC.isValid());

		//valid
		ConditionImpl validC = new ConditionImpl();

		//e)
		validC.setComparison(equationComparison);
		validC.setFirstChild(null);
		validC.setSecondChild(null);

		assertTrue("Condition with comparison and no child should be valid", validC.isValid());

		//f)
		validC.setComparison(null);
		validC.setFirstChild(firstC);
		validC.setSecondChild(secondC);

		assertTrue("Condition with no comparison and two childs should be valid", validC.isValid());

	}

	/**
	 * Tests the isValid Method with conditions that have circles (thus are not trees).
	 * Creation date: (27.12.2001 18:13:30)
	 */
	public void testValidityWithCircles() {

		ConditionImpl circle = new ConditionImpl();
		ConditionImpl cond1 = new ConditionImpl();
		ConditionImpl cond2 = new ConditionImpl();
		ConditionImpl cond3 = new ConditionImpl();
		ConditionImpl cond4 = new ConditionImpl();

		// build up a valid conditional tree
		circle.setLogicOperation(or);
		cond1.setLogicOperation(or);
		cond2.setComparison(equationComparison);
		cond3.setComparison(equationComparison);
		cond4.setComparison(equationComparison);

		circle.setFirstChild(cond1);
		circle.setSecondChild(cond2);

		cond1.setFirstChild(cond3);
		cond1.setSecondChild(cond4);

		assertTrue("The simple tree should be valid", circle.isValid());

		// build in a circle between 1 and circle.
		cond1.setFirstChild(circle);

		assertTrue("The condition has a circle, so it can't be valid", !circle.isValid());

	}
}