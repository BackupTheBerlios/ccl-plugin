package org.cocons.argo.cognitive.critics.test;

import junit.framework.TestCase;
import junit.framework.Assert;
import junit.framework.TestSuite;
import junit.framework.Test;

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
    //suite.addTest(TestXXX.suite());
    return suite;
  }
}