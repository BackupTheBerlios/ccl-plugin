package org.cocons.testsuite;

import junit.framework.*;

/**
 * This class forms the main test suite of the cocons library
 * It should be continuously be extended to call all subtests
 * in the org.cocons package hierarchy
 * @author Martin Skinner
 * @version 1.0
 */
public class MasterTest extends TestCase {

/**
 * Constructs a test suite with a given name
 * @param p0 name of test suite
 */
  public MasterTest(String p0) {
      super(p0);
  }

/**
 * factory method to create a test suite containing all subtests.
 * This method is called by the JUnit framework
 */
  public static Test suite() {
    TestSuite suite=new TestSuite();
    suite.addTest(CclTest.suite());
    suite.addTest(UmlTest.suite());
    suite.addTest(org.cocons.argo.cognitive.test.TestAllRecursively.suite());
    return suite;
  }

  public static void main(String[] args) {
    junit.swingui.TestRunner.run(MasterTest.class);
  }

}