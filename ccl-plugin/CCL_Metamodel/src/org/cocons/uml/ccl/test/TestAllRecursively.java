package org.cocons.uml.ccl.test;

import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * Title: AllTestRecursively.java
 * Description: The AllTestRecursively Class running all test cases in this test
 * package and in the test hirachy below.
 * Copyright:    Copyright (c) 2001
 * Company: TU-Berlin, CIS
 * @author Philipp Schumacher
 * @version 1.0
 */

public class TestAllRecursively {

  /**
   * Runs a TestRunner with this test case.
   */
  public static void main(String[] args) {
	junit.swingui.TestRunner.run(TestAllRecursively.class);
  }            

  /**
   * Returns a test suite containing the test hirarchy.
   */
  public static Test suite() {
	TestSuite suite = new TestSuite();
	suite.addTest(AllTest.suite());
	suite.addTest(org.cocons.uml.ccl.comparators.test.TestAllRecursively.suite());
	suite.addTest(org.cocons.uml.ccl.logic_operations.test.TestAllRecursively.suite());
	suite.addTest(org.cocons.uml.ccl.util.test.TestAllRecursively.suite());
	return suite;
  }                            
}