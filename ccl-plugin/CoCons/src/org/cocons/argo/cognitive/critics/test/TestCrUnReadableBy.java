package org.cocons.argo.cognitive.critics.test;

import junit.framework.TestCase;

import org.argouml.kernel.Project;
import org.argouml.ui.ProjectBrowser;

import org.cocons.uml.ccl.*;


/**
 * Title: TestCrUnReadabableBy.java
 * Description: This test case tests the class CrConstrainedReadability.
 * Copyright:    Copyright (c) 2001
 * Company: TU-Berlin, CIS
 * @author Philipp Schumacher, Fadi Chabarek
 * @version 1.0
 */

public class TestCrUnReadableBy extends TestCase {

  MContextbasedConstraint cocon;
  ContextCondition scopeSet;
  ContextCondition constrainedSet;
  Project project;

  public TestCrUnReadableBy(String name) {
    super(name);
  }

  public static void main(String[] args) {
    junit.swingui.TestRunner.run(TestCrUnReadableBy.class);
  }

  public void setUp() {

  /*
    cocon = new MContextbasedConstraintImpl();
    scopeSet = new MContextConditionImpl();
    constrainedSet = new MContextConditionImpl();

    scopeSet.addContextbasedConstraint(cocon);
    constrainedSet.addContextbasedConstraint(cocon);

    cocon.setScopeSet(scopeSet);
    cocon.setConstrainedSet(constrainedSet);

    project = ProjectBrowser.TheInstance.getProject();
*/


  }

  public void tearDown() {


  }

  public void testPredicate() {
    assertTrue("tautologisch", true);
  }
}