package org.cocons.uml.ccl.util.test;

import org.cocons.uml.ccl.Condition;
import org.cocons.uml.ccl.util.ConditionalTreeGenerator;

/**
 * Tests the ConditionalTreeGenerator class.
 * Creation date: (28.12.2001 17:49:53)
 * @author: Fadi Chabarek
 */
public class TestTreeGenerator extends junit.framework.TestCase {

	/**
	 * A ConditionalTreeGenerator.
	 */
	private org.cocons.uml.ccl.util.ConditionalTreeGenerator treeGenerator;
	
	
	/**
	 * Constructs this test.
	 * @param name java.lang.String
	 */
	public TestTreeGenerator(String name) {
		super(name);
	}
	
	/**
	 * Starts this test.
	 * Creation date: (28.12.2001 17:55:46)
	 * @param args java.lang.String[]
	 */
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestTreeGenerator.class);
	}
	
	/**
	 * Sets this test up.
	 * Creation date: (28.12.2001 17:50:47)
	 */
	public void setUp() {
		treeGenerator = new ConditionalTreeGenerator();
	}
	
	/**
	 * Tests the generation of an conditional tree.
	 * Creation date: (28.12.2001 17:51:29)
	 */
	public void testGenerateTree() {

		try {
			treeGenerator.generateConditionalTree(0);
		} catch (NullPointerException e) {
			fail("Generating a tree with size 0 throws a NullPointerException");
		}

		Condition tree = treeGenerator.generateConditionalTree(100);
		
		assertTrue("Generated Tree should have been valid", tree.isValid());
	}
}