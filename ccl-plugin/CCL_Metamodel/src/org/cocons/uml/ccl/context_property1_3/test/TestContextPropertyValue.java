package org.cocons.uml.ccl.context_property1_3.test;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValueImpl;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyTagImpl;
import org.cocons.uml.ccl.BaseClasses;

/**
 * TestCase for the class MContextPropertyValueImpl.
 * Creation date: (07.02.2002 19:34:26)
 * @author: Fadi Chabarek
 */
public class TestContextPropertyValue extends junit.framework.TestCase {

	public TestContextPropertyValue(String name) {
		super(name);
	}
	/**
	 * Starts this test.
	 * Creation date: (07.02.2002 19:39:17)
	 * @param args java.lang.String[] no args needed.
	 */
	public static void main(String[] args) {
		junit.swingui.TestRunner.run(TestContextPropertyValue.class);
	}
	/**
	 * Sets up this test.
	 * Creation date: (07.02.2002 19:38:18)
	 */
	public void setUp() {

	}
	/**
	 * Tests the setContextPropertyTag method.
	 * Creation date: (07.02.2002 20:05:34)
	 */
	public void testSetContextPropertyTagMethod() {
          MContextPropertyValueImpl value = new MContextPropertyValueImpl();
          MContextPropertyTagImpl tag = new MContextPropertyTagImpl();
          value.setContextPropertyTag(tag);
	}
}