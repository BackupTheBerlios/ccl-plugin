package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.core.MModelElementImpl;
import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.data_types.MBooleanExpression;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

import org.cocons.argo.util.*;

import java.util.Vector;

/**
* //OLD Wraps a MTaggedValue, but deprecats its get/setValue()-Method, so that a
* change from argouml's nsuml 1.3 to nsuml 1.4 is easily made.
* //OLD Unfortunatly an Extension from MTaggedValueImpl is not possible, because
* //OLD the methods to deprecate are final, thus shadowing won't work.
*
* //OLD TO_DO: binary association with MContextPropertyValueImpl.
*
* Creation date: (21.12.2001 12:12:17)
* @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
*/
public class MContextPropertyTagImpl extends MModelElementImpl implements MContextPropertyTag {

/**
 * Forwarding to MModelElementImpl()
 * Erstellungsdatum: (31.12.2001 04:04:31)
 */
public MContextPropertyTagImpl() {
	super();
}
/**
 * This method deletes herself and all MContextPropertyValues beloging to this Tag.
 * Erstellungsdatum: (31.12.2001 03:23:45)
 */
public void deleteMyself() {
        // die beschriebene Funktionalität erledigt der ModelIterator, der die
        // TagListe verwaltet
        this.remove();
        /*
	//get all propertyValues belonging to this Tag
	Vector values = new Vector();
	ModelIterator iterator = new ModelIterator();
	Vector allValues = iterator.getAllContextPropertyValues();
	MContextPropertyValue aValue;
	for (int i = 0; i < allValues.size(); i++) {
		try{
			aValue = (MContextPropertyValue) allValues.elementAt(i);
			if (aValue.getContextPropertyTag().equals(this)) {
				// Hier muss der Value aus dem Project gelöscht werden
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// Hier muss der Tag aus dem Project gelöscht werden
        */
}
/**
 * Compares the argument with herself.
 * Return true if both are the same.
 * Erstellungsdatum: (31.12.2001 03:37:04)
 * @return boolean
 * @param __arg org.omg.CORBA.Object
 */
public boolean equals(Object __arg) {
	if (__arg instanceof MContextPropertyTag) {
          if (this.getUUID().equals(((MContextPropertyTag)__arg).getUUID())) return true;
        }
	return false;
}

// --------- hyshosha@gmx.de -------------
public void setTag(String tagName) {
  super.setName(tagName);
}

public String getTag() {
  return(super.getName());
}

public String getConstraintBody() {
  Object[] cons = this.getConstraints().toArray();
  if (cons.length > 0) return(((MConstraint)cons[0]).getBody().getBody());
  else return(null);
}

public String getValidValuesType() {
  VCPLTranslator trans = new VCPLTranslator();
  String constraintBody = this.getConstraintBody();
  String validValueType = "";
  if (trans.validValueIsListOfStrings(constraintBody)) {
    validValueType = "List Of Strings";
  }
  else if (trans.validValueIsIntegerNumber(constraintBody)) {
    validValueType = "Integer Number";
  }
  else if (trans.validValueIsFloatNumber(constraintBody)) {
    validValueType = "Float Number";
  }
  else validValueType = null;
  return(validValueType);
}

/*public String getUnit() {
  VCPLTranslator trans = new VCPLTranslator();
  return(trans.getUnit(this.getConstraintBody()));
}

public Vector getValidStrings() {
  VCPLTranslator trans = new VCPLTranslator();
  return(trans.getValidStrings(this.getConstraintBody()));
}

public int[] getIntegerRange() {
  VCPLTranslator trans = new VCPLTranslator();
  return(trans.getIntegerRange(this.getConstraintBody()));
}

public float[] getFloatRange() {
  VCPLTranslator trans = new VCPLTranslator();
  return(trans.getFloatRange(this.getConstraintBody()));
}*/
// ---------------------------------------

}
