package org.cocons.uml.ccl.logic_operations.test;

import org.cocons.uml.ccl.LogicOperation;
import org.cocons.uml.ccl.logic_operations.LogicFactoryImpl;
import org.cocons.uml.ccl.logic_operations.LogicFactory;
import junit.framework.TestCase;

/**
 * Test the production of logical operations.
 * Creation date: (26.12.2001 16:26:39)
 * @author: Fadi Chabarek
 */
public class TestLogicOperationFactory extends TestCase {

	/**
	 * A logic Factory.
	 */
	private org.cocons.uml.ccl.logic_operations.LogicFactory logicFactory;

	/**
	 * TestLogicOperationFactory constructor comment.
	 */
	public TestLogicOperationFactory(String name) {
		super(name);
	}

	/**
	 * Tests the production of the logic operation or.
	 * Creation date: (26.12.2001 16:28:00)
	 */
	public void testProductOr() {

		LogicOperation or = logicFactory.produceLogicOperationWithType(LogicFactory.OR);

		boolean t = true;
		boolean f = false;

		assertTrue("Fehler: true OR true -> false !", or.apply(t, t));
		assertTrue("Fehler: true OR false -> false !", or.apply(t, f));
		assertTrue("Fehler: false OR true -> false !", or.apply(f, t));
		assertTrue("Fehler: false OR false -> true !", !or.apply(f, f));

		boolean typeAvailable = false;
		int[] types = logicFactory.getAvailableTypes();
		for (int i = 0; i < types.length; i++) {
			typeAvailable = typeAvailable || types[i] == LogicFactory.OR;
		}

		assertTrue("Or müsste available sein.", typeAvailable);

	}

	/**
	* Runs this test.
	* Creation date: (28.12.2001 01:43:11)
	* @param args java.lang.String[]
	*/
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestLogicOperationFactory.class);

	}

	/**
	* Sets the test up.
	* Creation date: (28.12.2001 01:36:42)
	*/
	public void setUp() {
		logicFactory = new LogicFactoryImpl();
	} 
	
	/**
	* Tests the product logic operation AND.
	* Creation date: (28.12.2001 01:35:01)
	*/
	public void testProductAnd() {

		LogicOperation and = logicFactory.produceLogicOperationWithType(LogicFactory.AND);

		boolean t = true;
		boolean f = false;

		assertTrue("Fehler: true AND true -> true !", and.apply(t, t));
		assertTrue("Fehler: true AND false -> false !", !and.apply(t, f));
		assertTrue("Fehler: false AND true -> false !", !and.apply(f, t));
		assertTrue("Fehler: false AND false -> false !", !and.apply(f, f));

		boolean typeAvailable = false;
		int[] types = logicFactory.getAvailableTypes();
		for (int i = 0; i < types.length; i++) {
			typeAvailable = typeAvailable || types[i] == LogicFactory.AND;
		}

		assertTrue("Or müsste available sein.", typeAvailable);

	}
}