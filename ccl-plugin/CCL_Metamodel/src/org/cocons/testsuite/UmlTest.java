package org.cocons.testsuite;

import junit.framework.*;
import java.util.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.undo.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.model_management.*;

import org.cocons.testsuite.MMTestCase;

/**
 * Forms the test suite for the concons uml package.
 * It tests all java implementation of all the metaclasses, metaattributes
 * and metaassociations in the cocons UML extension library.
 * @author Martin Skinner
 * @version 1.0
 */

public class UmlTest extends MMTestCase {

  private MTaggedValue tv0;
  private MTaggedValue tv1;
  private MTaggedValue tv2;
  private MStereotype st1;
  private MConstraint con1;
  private MClass c1;
  private MClassifier cfr1;
  private MAttribute att1;
  private MAttribute att2;
  private MAttribute att3;
  private MTagDefinition td0;
  private MTagDefinition td1;
  private MTagDefinition td2;

  private static String BASE_CLASS = new String("Class");
  private static String STRING_VALUE = new String("1.3");
  private static String TRUE_VALUE = new String("True");

/**
 * Constructs a test suite with a given name
 * @param p0 name of test suite
 */
  public UmlTest(String p0) {
    super(p0);
  }

/**
 * Performs test initialization.
 * This method is called by the framework before each individual test.
 */
  protected void setUp() {
    super.setUp();
    con1 = new MConstraintImpl();
    con1.setName("nop");
    st1 = new MStereotypeImpl();
    st1.setName("persistant");
    td1 = new MTagDefinitionImpl();
    td1.setName("isPersistant");
    td2 = new MTagDefinitionImpl();
    td2.setName("primaryKey");
    c1 = new MClassImpl();
    c1.setName("Employee");
    tv1 = new MTaggedValueImpl();
    tv1.setName("tv1");
    tv2 = new MTaggedValueImpl();
    tv2.setName("tv2");
    att1 = new MAttributeImpl();
    att1.setName("id");
    att2 = new MAttributeImpl();
    att2.setName("firstName");
    att3 = new MAttributeImpl();
    att3.setName("lastName");
    cfr1 = new MClassifierImpl();
    cfr1.setName("String");
    // active undo support
    MCheckPointUndoManager.setUndoPolicy(MCheckPointUndoManager.UNDO_POLICY_ENABLED);
  }

  protected void relinkModel(MModel m) {
    theModel = m;
    tv1 = null;
    tv2 = null;
    st1 = null;
    con1 = null;
    c1 = null;
    att1 = null;
    att2 = null;
    att3 = null;
    td1 = null;
    td2 = null;
  }

/**
 * Performs test finalization.
 * This method is called by the framework after each individual test.
 */
  protected void tearDown() {
    // clean up
    // MCheckPointUndoManager.forget(MCheckPointUndoManager.getCheckPoint());
    MCheckPointUndoManager.setUndoPolicy(MCheckPointUndoManager.UNDO_POLICY_DISABLED);
    theModel.setOwnedElements(Collections.EMPTY_LIST);
    theModel = null;
  }

/**
 * factory method to create a test suite containing all
 * individual tests.
 */
  public static Test suite() {
    TestSuite suite=new TestSuite();
    suite.addTest(new UmlTest("testTaggedValue"));
    suite.addTest(new UmlTest("testAssocReferenceTagReferenceValue"));
    suite.addTest(new UmlTest("testUMLXMI"));
    suite.addTest(new UmlTest("testAssocModelElementTaggedValue"));
    suite.addTest(new UmlTest("testStereotype"));
    suite.addTest(new UmlTest("testConstraint"));
    suite.addTest(new UmlTest("testTagDefinition"));
    suite.addTest(new UmlTest("testAssocTypeTypedValue"));
    suite.addTest(new UmlTest("testAssocOwnerDefinedTag"));
    return suite;
  }


/**
 * test for association
 * referenceTag(TaggedValue) / referenceValue(ModelElement)
 */
  public void testAssocReferenceTagReferenceValue() {
    testAssoc_Bag_Bag("referenceTag", tv1, "referenceValue", c1);
    testAssoc_Bag_Bag("referenceValue", c1, "referenceTag", tv1);
  }

/**
 * test for association
 * modelElement(ModelElement) / taggedValue(TaggedValue)
 */
  public void testAssocModelElementTaggedValue() {
    testAssoc_Bag_Ref("modelElement", c1, "taggedValue", tv1);
  }

/**
 * test for metaclass TaggedValue
 */
  public void testTaggedValue() {
    assertTrue(tv1.getUMLClassName() == "TaggedValue");
    // Test DataValues
    testAttrib_Bag(tv1, "dataValue", "FirstValue", "SecondValue");
  }

/**
 * test for metaclass TagDefinition
 */
  public void testTagDefinition() {
    assertTrue(td1.getUMLClassName() == "TagDefinition");
    // Test Name
    testAttrib(td1, "tagType", "SomeValue");
    // Test DataValues
    testAttrib(td1, "multiplicity", MMultiplicity.M0_1);
  }

/**
 * test for association
 * type(TagDefinition) / typedValue(TaggedValue)
 */
  public void testAssocTypeTypedValue() {
    testAssoc_Bag_Ref("type", td1, "typedValue", tv1);
  }

/**
 * test for association
 * owner(Stereotype) / definedTag(TagDefinition)
 */
  public void testAssocOwnerDefinedTag() {
    testAssoc_Bag_Ref("owner", st1, "definedTag", td1);
  }

/**
 * test for metaclass Stereotype
 */
  public void testStereotype() {
    assertTrue(st1.getUMLClassName() == "Stereotype");
    // Test baseClass
    testAttrib_Bag(st1, "baseClass", "FirstValue", "SecondValue");
    // Test icon
    testAttrib(st1, "icon", "SomeValue");
  }

/**
 * test for metaclass Constraint
 */
  public void testConstraint() {
    assertTrue(con1.getUMLClassName() == "Constraint");
  }

/**
 * Test XMI
 */
  public void testUMLXMI() {
    String s1 = new String("1stValue");
    String s2 = new String("2ndValue");
    String s3 = new String("3rdValue");
    String s4 = new String("4thValue");
    // setup the stereotype
    st1.addBaseClass(BASE_CLASS);
    st1.addStereotypeConstraint(con1);
    theModel.addOwnedElement(st1);
    // the stereotype gets two tagDefinitions
    td1.setTagType("UML::DataTypes::Boolean");
    td1.setMultiplicity(MMultiplicity.M1_1);
    st1.addDefinedTag(td1);
    td2.setTagType("UML::Foundation::Core::Attribute");
    td2.setMultiplicity(MMultiplicity.M1_N);
    st1.addDefinedTag(td2);
    // create a "String" data type in the model
    theModel.addOwnedElement(cfr1);
    // now setup the class with our stereotype
    c1.setNamespace(theModel);
    c1.setStereotype(st1);
    // add a few attributes
    att1.setType(cfr1);
    c1.addFeature(att1);
    att2.setType(cfr1);
    c1.addFeature(att2);
    att3.setType(cfr1);
    c1.addFeature(att3);
    // add some UML 1.4 taggedvalues to the class
    tv1.setType(td1);
    tv1.addDataValue(TRUE_VALUE);
    c1.addTaggedValue(tv1);
    tv2.setType(td2);
    tv2.addReferenceValue(att1);
    c1.addTaggedValue(tv2);
    // add a UML 1.3 taggedValue to the class
    c1.setTaggedValue("legacyTag",STRING_VALUE);

    XMIReload();
    // assert theModel state
    assertTrue(theModel.getOwnedElements().size()==4);
    st1 = (MStereotype) theModel.lookup("persistant");
    assertTrue(st1!=null);
    c1 = (MClass) theModel.lookup("Employee");
    assertTrue(c1!=null);
    td0 = (MTagDefinition) theModel.lookup("legacyTag");
    assertTrue(td0 != null);
    cfr1 = (MClassifier) findInCollection(theModel.getOwnedElements(),"name","String");
    assertTrue(cfr1 != null);

    // assert Stereotype st1 state
    assertTrue(st1.getBaseClasses().contains(BASE_CLASS));
    assertSame(st1.getNamespace(), theModel);

    assertTrue(st1.getDefinedTags().size()==2);
    td1 = (MTagDefinition) findInCollection(st1.getDefinedTags(),"name","isPersistant");
    assertTrue(td1!=null);
    td2 = (MTagDefinition) findInCollection(st1.getDefinedTags(),"name","primaryKey");
    assertTrue(td2!=null);

    assertTrue(st1.getExtendedElements().size()==1);
    assertSame(findInCollection(st1.getExtendedElements(),"name","Employee"), c1);

    // assert TagDefinition td0 state
    assertEquals(td0.getTagType(), "UML::DataTypes::String");
    assertEquals(td0.getMultiplicity(), MMultiplicity.M1_1 );
    assertEquals(td0.getNamespace(), theModel);

    assertTrue(td0.getTypedValues().size()==1);
    tv0 = (MTaggedValue) findInCollection(td0.getTypedValues(),"modelElement",c1);

    // assert TagDefinition td1 state
    assertEquals(td1.getTagType(), "UML::DataTypes::Boolean");
    assertEquals(td1.getMultiplicity(), MMultiplicity.M1_1 );
    assertSame(td1.getOwner(), st1);

    assertTrue(td1.getTypedValues().size()==1);
    tv1 = (MTaggedValue) findInCollection(td1.getTypedValues(),"modelElement",c1);

    // assert TagDefinition td2 state
    assertEquals(td2.getTagType(), "UML::Foundation::Core::Attribute");
    assertEquals(td2.getMultiplicity(), MMultiplicity.M1_N );
    assertSame(td2.getOwner(), st1);

    assertTrue(td2.getTypedValues().size()==1);
    tv2 = (MTaggedValue) findInCollection(td2.getTypedValues(),"modelElement",c1);

    // assert Class c1 state
    assertSame(c1.getNamespace(),theModel);
    assertSame(c1.getStereotype(), st1);

    assertTrue(c1.getFeatures().size()==3);
    att1 = (MAttribute) findInCollection(c1.getFeatures(),"name","id");
    assertTrue(att1!=null);
    att2 = (MAttribute) findInCollection(c1.getFeatures(),"name","firstName");
    assertTrue(att2!=null);
    att3 = (MAttribute) findInCollection(c1.getFeatures(),"name","lastName");
    assertTrue(att3!=null);

    assertTrue(c1.getTaggedValues().size()==3);
    assertTrue(c1.getTaggedValues().contains(tv0));
    assertTrue(c1.getTaggedValues().contains(tv1));
    assertTrue(c1.getTaggedValues().contains(tv2));

    // assert Attribute att1
    assertSame(att1.getOwner(), c1);
    assertSame(att1.getType(), cfr1);
    assertTrue(att1.getReferenceTags().size()==1);
    assertTrue(att1.getReferenceTags().contains(tv2));

    // assert Attribute att2
    assertSame(att2.getOwner(), c1);
    assertSame(att2.getType(), cfr1);

    // assert Attribute att3
    assertSame(att3.getOwner(), c1);
    assertSame(att3.getType(), cfr1);

    // assert tv0
    assertSame(tv0.getType(), td0);
    assertSame(tv0.getModelElement(), c1);
    assertTrue(tv0.getDataValues().size()==1);
    assertTrue(tv0.getDataValues().contains(STRING_VALUE));
    assertTrue(tv0.getReferenceValues().isEmpty());

    // assert tv1
    assertSame(tv1.getType(), td1);
    assertSame(tv1.getModelElement(), c1);
    assertTrue(tv1.getDataValues().size()==1);
    assertTrue(tv1.getDataValues().contains(TRUE_VALUE));
    assertTrue(tv1.getReferenceValues().isEmpty());

    // assert tv2
    assertSame(tv2.getType(), td2);
    assertSame(tv2.getModelElement(), c1);
    assertTrue(tv2.getDataValues().isEmpty());
    assertTrue(tv2.getReferenceValues().size()==1);
    assertTrue(tv2.getReferenceValues().contains(att1));

    // assert legacy TaggedValue
    assertEquals(c1.getTaggedValue("legacyTag"),"1.3");

    return;
  }

}