package org.cocons.testsuite;

import junit.framework.*;
import java.util.*;
import ru.novosoft.uml.undo.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.*;
import ru.novosoft.uml.model_management.*;
import org.cocons.uml.*;
import org.cocons.uml.ccl.*;



/**
 * Forms the test suite for the concons ccl package.
 * It tests all java implementation of all the metaclasses, metaattributes
 * and metaassociations in the cocons ccl library.
 * @author Martin Skinner
 * @version 1.0
 */

public class CclTest extends MMTestCase {

  private MStereotype myStereotype;
  private MTaggedValue myTaggedValue;
  private MContextPropertyTag myContextPropertyTag;
  private MContextbasedConstraint myContextbasedConstraint;
  private MContextCondition constrainedContextCondition;
  private MContextCondition scopeContextCondition;
  private MConstraint myConstraint;
  private static final Integer INT_17 = new Integer(17);
  private static final Integer INT_23 = new Integer(23);

/**
 * Constructs a test suite with a given name
 * @param p0 name of test suite
 */
  public CclTest(String p0) {
    super(p0);
  }

/**
 * Performs test initialization.
 * This method is called by the framework before each individual test.
 */
  protected void setUp() {
    super.setUp();
    myStereotype = new MStereotypeImpl();
    myStereotype.setName("myStereotype");
    theModel.addOwnedElement(myStereotype);

    myTaggedValue = new MTaggedValueImpl();
    myTaggedValue.setName("myTaggedValue");
    theModel.addOwnedElement(myTaggedValue);

    myContextPropertyTag = new MContextPropertyTagImpl();
    myContextPropertyTag.setName("myContextPropertyTag");
    theModel.addOwnedElement(myContextPropertyTag);

    myConstraint = new MConstraintImpl();
    myConstraint.setName("myConstraint");
    theModel.addOwnedElement(myConstraint);

    myContextbasedConstraint = new MContextbasedConstraintImpl();
    myContextbasedConstraint.setName("myContextbasedConstraint");
    theModel.addOwnedElement(myContextbasedConstraint);

    constrainedContextCondition = new MContextConditionImpl();
    myContextbasedConstraint.setConstrainedSet(constrainedContextCondition);

    scopeContextCondition = new MContextConditionImpl();
    myContextbasedConstraint.setScopeSet(scopeContextCondition);

    // active undo support
    MCheckPointUndoManager.setUndoPolicy(MCheckPointUndoManager.UNDO_POLICY_ENABLED);
  }

/**
 * Performs test finalization.
 * This method is called by the framework after each individual test.
 */
  protected void tearDown() {
    // clean up
    // MCheckPointUndoManager.forget(MCheckPointUndoManager.getCheckPoint());
    MCheckPointUndoManager.setUndoPolicy(MCheckPointUndoManager.UNDO_POLICY_DISABLED);
  }

  // ////////////////////////////////////////////////////
  //
  // static factory method
  //
  // ////////////////////////////////////////////////////

/**
 * Factory method to create a test suite containing all
 * individual tests.
 */
  public static Test suite() {
    TestSuite suite=new TestSuite();
    suite.addTest(new CclTest("testCCLXMI") );
    suite.addTest(new CclTest("testContextCondition") );
    suite.addTest(new CclTest("testRestrictedStereotypeRestriction") );
    suite.addTest(new CclTest("testRefConditionContextPropertyValue") );
    suite.addTest(new CclTest("testContextPropertyTag") );
    suite.addTest(new CclTest("testAssocValueValidationContextPropertyTag") );
    suite.addTest(new CclTest("testContextbasedConstraint") );
    suite.addTest(new CclTest("testScopedSetScopedConstraint") );
    suite.addTest(new CclTest("testConstrainedSetContextbasedConstraint") );
    return suite;
  }

  // ////////////////////////////////////////////////////
  //
  // The individual test cases
  //
  // ////////////////////////////////////////////////////
/**
 * test for metaclass ContextCondition
 */
  public void testContextCondition() {
    assertTrue(scopeContextCondition.getUMLClassName() == "ContextCondition");
    // Test Query
    testAttrib(scopeContextCondition, "query", new MBooleanExpression("Dummy","Value") );
    // Test Multiplicity
    testAttrib(scopeContextCondition, "range", MMultiplicity.M1_1 );
  }

/**
 * test for association
 * restrictedStereotype(Stereotype) / restriction(ContextCondition)
 */
  public void testRestrictedStereotypeRestriction() {
    testAssoc_Bag_Bag("restriction", scopeContextCondition, "restrictedStereotype", myStereotype );
    testAssoc_Bag_Bag("restrictedStereotype", myStereotype, "restriction", scopeContextCondition );
  }

/**
 * test for association
 * refCondition(ContextCondition) / contextPropertyValue(TaggedValue)
 */
  public void testRefConditionContextPropertyValue() {
    testAssoc_Bag_Bag("refCondition", scopeContextCondition, "contextPropertyValue", myTaggedValue );
    testAssoc_Bag_Bag("contextPropertyValue", myTaggedValue, "refCondition", scopeContextCondition );
  }

/**
 * test for metaclass ContextPropertyTag
 */
  public void testContextPropertyTag() {
    assertTrue(myContextPropertyTag.getUMLClassName() == "ContextPropertyTag");
  }

/**
 * test for association
 * valueValidition(Constraint) / contextPropertyTag(ContextPropertyValue)
 */
  public void testAssocValueValidationContextPropertyTag() {
    testAssoc_Bag_Ref("valueValidation", myConstraint, "contextPropertyTag", myContextPropertyTag);
  }

/**
 * test for metaclass ContextbasedConstraint
 */
  public void testContextbasedConstraint() {
    assertTrue(myContextbasedConstraint.getUMLClassName() == "ContextbasedConstraint");
    testAttrib(myContextbasedConstraint, "priority",  INT_17, INT_23 );
  }

/**
 * test for association
 * scopeSet(ContextCondition) / scopedConstraint(ContextbasedConstraint)
 */
  public void testScopedSetScopedConstraint() {
    testAssoc_Bag_Ref("scopeSet", scopeContextCondition, "scopedConstraint", myContextbasedConstraint);
  }

/**
 * test for association
 * constrainedSet(ContextCondition) / contextbasedConstraint(ContextbasedConstraint)
 */
  public void testConstrainedSetContextbasedConstraint() {
    testAssoc_Bag_Ref("constrainedSet", scopeContextCondition, "contextbasedConstraint", myContextbasedConstraint);
  }

  protected void relinkModel(MModel m) {
    theModel = m;
    myStereotype = (MStereotype)theModel.lookup("myStereotype");
    myTaggedValue = (MTaggedValue)theModel.lookup("myTaggedValue");
    myContextPropertyTag = (MContextPropertyTag)theModel.lookup("myContextPropertyTag");
    myConstraint = (MConstraint)theModel.lookup("myConstraint");
    myContextbasedConstraint = (MContextbasedConstraint)theModel.lookup("myContextbasedConstraint");
    if (myContextbasedConstraint != null)
    {
      scopeContextCondition = myContextbasedConstraint.getScopeSet();
      constrainedContextCondition = myContextbasedConstraint.getConstrainedSet();
    }
  }

/**
 * Test XMI
 */
  public void testCCLXMI() {
    String s1 = new String("1stValue");
    String s2 = new String("2ndValue");
    String s3 = new String("3rdValue");
    String s4 = new String("4thValue");
    //
    myContextPropertyTag.setValueValidation(myConstraint);  // Link 1
    //
    XMIReload();
    // assert myContextPropertyTag state
    assertNotNull(myContextPropertyTag);
    assertSame(myContextPropertyTag.getValueValidation(), myConstraint);

    // assert myConstraint state
    assertNotNull(myConstraint);
    assertTrue(myConstraint.getContextPropertyTags().contains(myContextPropertyTag));
    assertTrue(myConstraint.getContextPropertyTags().size() == 1);

    // assert myContextbasedConstraint
    assertNotNull(myContextbasedConstraint);
  }

}
