package org.cocons.testsuite;

import junit.framework.*;
import java.util.*;
import java.lang.reflect.*;
import java.io.*;
import ru.novosoft.uml.undo.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.xmi.*;
import org.cocons.uml.xmi.*;
import ru.novosoft.uml.*;
import org.apache.xerces.parsers.*;
import org.xml.sax.*;

/**
 * This class contains auxillary methods which may be used when
 * creating test cases for metamodels.
 * @author Martin Skinner
 * @version 1.0
 */

abstract public class MMTestCase extends TestCase {

protected MModel theModel;

/**
 * Constructs a test case with a given name
 * @param p0 name of test suite
 */
  public MMTestCase(String p0) {
      super(p0);
  }

  protected void setUp() {
    theModel = new MModelImpl();
  }

/**
 * Test an association with bag roles at both ends (named <I>near</I> end
 * and <I>far</I> end).
 *
 * The following test steps are performed:
 * <OL>
 *   <LI>  association is added to the far end
 *   <LI>  association is removed from the near end
 *   <LI>  the remove operation is undone
 *   <LI>  the remove operation is redone
 *   <LI>  association is added to the near end
 *   <LI>  the far end is emptied
 * </OL>
 *
 * After every step the state of both ends are compared with
 * the pre-computed, correct states.
 *
 * @param roleNear name of the association role at the near end.
 * @param elementNear Model element at the near end
 * @param roleFar name of the association role at the far end.
 * @param elementFar Model element at the far end
 */

  protected void testAssoc_Bag_Bag(String roleNear, MBase elementNear, String roleFar, MBase elementFar)
  {
    // add an association
    elementFar.reflectiveAddValue(roleNear, elementNear);
    assertTrue( ((Collection)elementFar.reflectiveGetValue(roleNear)).contains(elementNear));
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    // set undo checkpoint
    MCheckPoint c1 = MCheckPointUndoManager.getCheckPoint();
    // remove the association from the other end
    elementNear.reflectiveRemoveValue(roleFar, elementFar);
    assertTrue( !((Collection)elementFar.reflectiveGetValue(roleNear)).contains(elementNear));
    assertTrue( !((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    // set redo checkpoint
    MCheckPoint c2 = MCheckPointUndoManager.getCheckPoint();
    // undo the remove
    MCheckPointUndoManager.undo(c1);
    assertTrue( ((Collection)elementFar.reflectiveGetValue(roleNear)).contains(elementNear));
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    // redo the remove
    MCheckPointUndoManager.redo(c2);
    assertTrue( !((Collection)elementFar.reflectiveGetValue(roleNear)).contains(elementNear));
    assertTrue( !((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    // add an association
    elementNear.reflectiveAddValue(roleFar, elementFar);
    assertTrue( ((Collection)elementFar.reflectiveGetValue(roleNear)).contains(elementNear));
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    // empty the bag
    elementFar.reflectiveSetValue(roleNear,Collections.EMPTY_LIST);
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).isEmpty() );
    assertTrue( ((Collection)elementFar.reflectiveGetValue(roleNear)).isEmpty() );
  }

/**
 * Test an association with a bag role at the near end and a reference role
 * at the far end.
 *
 * The following test steps are performed:
 * <OL>
 *   <LI>  association is added to the far end
 *   <LI>  association is removed from the near end
 *   <LI>  the remove operation is undone
 *   <LI>  the remove operation is redone
 *   <LI>  association is added to the near end
 *   <LI>  the far end is emptied
 * </OL>
 *
 * After every step the state of both ends are compared with
 * the pre-computed, correct states.
 *
 * @param roleNear name of the association role at the near end.
 * @param elementNear Model element at the near end
 * @param roleFar name of the association role at the far end.
 * @param elementFar Model element at the far end
 */
  protected void testAssoc_Bag_Ref(String roleNear, MBase elementNear, String roleFar, MBase elementFar)
  {
    // add an association
    elementFar.reflectiveSetValue(roleNear, elementNear);
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    assertTrue( elementFar.reflectiveGetValue(roleNear) == elementNear);
    // set undo checkpoint
    MCheckPoint c1 = MCheckPointUndoManager.getCheckPoint();
    // remove the association from the other end
    elementNear.reflectiveRemoveValue(roleFar, elementFar);
    assertTrue( !((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    assertTrue( elementFar.reflectiveGetValue(roleNear) == null);
    // set redo checkpoint
    MCheckPoint c2 = MCheckPointUndoManager.getCheckPoint();
    // undo the remove
    MCheckPointUndoManager.undo(c1);
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    assertTrue( elementFar.reflectiveGetValue(roleNear) == elementNear);
    // redo the remove
    MCheckPointUndoManager.redo(c2);
    assertTrue( !((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    assertTrue( elementFar.reflectiveGetValue(roleNear) == null);
    // add the association again
    elementNear.reflectiveAddValue(roleFar, elementFar);
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).contains(elementFar));
    assertTrue( elementFar.reflectiveGetValue(roleNear) == elementNear);
    // empty the bag
    elementNear.reflectiveSetValue(roleFar, Collections.EMPTY_LIST );
    assertTrue( ((Collection)elementNear.reflectiveGetValue(roleFar)).isEmpty() );
    assertTrue( elementFar.reflectiveGetValue(roleNear) == null);
  }

/**
 * Test an attribute by settings and changing its value
 *
 * The following test steps are performed:
 * <OL>
 *   <LI>  association is added to the far end
 *   <LI>  association is removed from the near end
 *   <LI>  the remove operation is undone
 *   <LI>  the remove operation is redone
 *   <LI>  association is added to the near end
 *   <LI>  the far end is emptied
 * </OL>
 *
 * After every step the state of the attribute is compared
 * the pre-computed, correct value.
 *
 * @param element Model element whose attribute is to be tested
 * @param attribute name of the attribute to be tested
 * @param oneValue first attribute value to be set
 * @param anotherValue value the attribute should be changed to
 */
  protected void testAttrib(MBase element, String attribute, Object oneValue, Object anotherValue) {
    // set  value
    element.reflectiveSetValue(attribute, oneValue);
    assertEquals(element.reflectiveGetValue(attribute),oneValue);
    // set undo checkpoint
    MCheckPoint c1 = MCheckPointUndoManager.getCheckPoint();
    // change the value
    element.reflectiveSetValue(attribute, anotherValue);
    assertEquals(element.reflectiveGetValue(attribute), anotherValue);
    // set redo checkpoint
    MCheckPoint c2 = MCheckPointUndoManager.getCheckPoint();
    // undo the change
    MCheckPointUndoManager.undo(c1);
    assertEquals(element.reflectiveGetValue(attribute), oneValue);
    // redo the change
    MCheckPointUndoManager.redo(c2);
    assertEquals(element.reflectiveGetValue(attribute), anotherValue);
  }

/**
 * Test an attribute by settings and clearing its value
 *
 * The following test steps are performed:
 * <OL>
 *   <LI>  attribute is set to oneValue
 *   <LI>  attribute is cleared (set to null)
 *   <LI>  the clear operation is undone
 *   <LI>  the clear operation is redone
 * </OL>
 *
 * After every step the state of the attribute is compared
 * the pre-computed, correct value.
 *
 * @param element Model element whose attribute is to be tested
 * @param attribute name of the attribute to be tested
 * @param oneValue attribute value to be set
 */
  protected void testAttrib(MBase element, String attribute, Object value) {
    testAttrib(element, attribute, value, null);
  }

/**
 * Test a bag attribute by settings and changing its value.
 * Bag attributes are attributes which contain a collection
 * of values (e.g. name[*])
 *
 * The following test steps are performed:
 * <OL>
 *   <LI>  Both values are added to the attribute
 *   <LI>  the first value is removed from the attribute
 *   <LI>  the remove operation is undone
 *   <LI>  all values are emptied from the attribute
 * </OL>
 *
 * After every step the state of the attribute is compared
 * the pre-computed, correct value.
 *
 * @param element Model element whose attribute is to be tested
 * @param attribute name of the attribute to be tested
 * @param value1 first attribute value to be added/removed
 * @param value2 second attribute value to be added/removed
 */
  protected void testAttrib_Bag(MBase element, String attribute, Object value1, Object value2) {
    // add both values
    element.reflectiveAddValue(attribute, value1);
    element.reflectiveAddValue(attribute, value2);
    Collection allDataValues = (Collection) element.reflectiveGetValue(attribute);
    assertTrue(allDataValues.contains(value1));
    assertTrue(allDataValues.contains(value2));
    // set undo checkpoint
    MCheckPoint c1 = MCheckPointUndoManager.getCheckPoint();
    // remove value
    element.reflectiveRemoveValue(attribute, value1);
    allDataValues = (Collection) element.reflectiveGetValue(attribute);
    assertTrue(!allDataValues.contains(value1));
    assertTrue(allDataValues.contains(value2));
    // set redo checkpoint
    MCheckPoint c2 = MCheckPointUndoManager.getCheckPoint();
    // undo the remove
    MCheckPointUndoManager.undo(c1);
    allDataValues = (Collection) element.reflectiveGetValue(attribute);
    assertTrue(allDataValues.contains(value1));
    assertTrue(allDataValues.contains(value2));
    // redo the remove
    MCheckPointUndoManager.redo(c2);
    allDataValues = (Collection) element.reflectiveGetValue(attribute);
    assertTrue(!allDataValues.contains(value1));
    assertTrue(allDataValues.contains(value2));
    // empty the bag
    element.reflectiveSetValue(attribute,Collections.EMPTY_LIST );
    allDataValues = (Collection) element.reflectiveGetValue(attribute);
    assertTrue(allDataValues.isEmpty() );
  }

  protected MBase findInCollection(Collection c, String feature, Object value)
  {
    Iterator i = c.iterator();
    while (i.hasNext())
      {
        MBase e = (MBase)i.next();
        if (e.reflectiveGetValue(feature).equals(value))
          return e;
      }
    return null;
  }

  protected void XMIReload() {
     // save the element to a stream
    // discard the element and restore it from the stream
    try {
      // save the model to a stream then discard it
      // CharArrayWriter cw = new CharArrayWriter();
      Writer w = new FileWriter("XMLTest.xml");
      XMIWriter xmiw = new CCLXMIWriter(theModel, w);
      xmiw.gen();
      xmiw = null;
      // now restore the model
      Reader r = null;
      if (w instanceof CharArrayWriter)
        r = new CharArrayReader( ((CharArrayWriter)w).toCharArray() );
      else
        r = new FileReader("XMLTest.xml");
      XMIReader xmir = new CCLXMIReader(true);
      xmir.setErrorHandler(new UnitTestErrorHandler());
      MModel restored = xmir.parse(new InputSource(r));
      relinkModel( restored );
    }
    catch (Exception e)
    {
      fail(e.getLocalizedMessage());
    }
 }

 abstract protected void relinkModel(MModel m);

}