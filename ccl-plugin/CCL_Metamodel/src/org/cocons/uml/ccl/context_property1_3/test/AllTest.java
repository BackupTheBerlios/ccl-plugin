package org.cocons.uml.ccl.context_property1_3.test;

import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * Title: AllTest.java
 * Description: The AllTest Class running all TestCase this package.
 * Copyright:    Copyright (c) 2001
 * Company: TU-Berlin, CIS
 * @author Philipp Schumacher, Fadi Chabarek
 * @version 1.0
 */

public class AllTest {

  /**
   * Runs all test cases in this package.
   */
  public static void main(String[] args) {
	junit.swingui.TestRunner.run(AllTest.class);
  }                  

  /**
   * Returns a test suite containing all test cases of this package.
   */
  public static Test suite() {
	TestSuite suite = new TestSuite();
	//suite.addTestSuite(TestLogicOperationFactory.class);
	return suite;
  }                      

}