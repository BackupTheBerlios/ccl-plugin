package org.cocons.testsuite;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */

public class TestDesignCritic extends TestCase {

  public TestDesignCritic(String p0) {
    super(p0);
  }
  public static void main(String[] args) {
    TestDesignCritic testDesignCritics1 = new TestDesignCritic("");
  }

  protected void setUp() {

  }

  public static Test suite() {
    TestSuite suite=new TestSuite();

    return suite;
  }
}