package org.cocons.uml.ccl.context_property1_3;

import ru.novosoft.uml.foundation.core.MModelElementImpl;

import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;

import org.cocons.argo.util.ModelIterator;

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
}
/**
 * Tests weather the parameter is equal to this object.
 * Erstellungsdatum: (31.12.2001 03:37:04)
 * @return boolean true - if both are equal.
 * @param Object the parameter.
 */
public boolean equals(Object __arg) {
	if(__arg instanceof MContextPropertyTag) {
		return ((MContextPropertyTag)__arg).getTag() == this.getTag();
	}
	return false;
}
	private java.lang.String tag;/**
 * Returns the tag of this context property tag.
 * Creation date: (22.01.2002 16:02:37)
 * @return java.lang.String the tag.
 */
public java.lang.String getTag() {
	return tag;
}/**
 * Sets the tag of this context property tag.
 * Creation date: (22.01.2002 16:02:37)
 * @param newTag java.lang.String the tag.
 */
public void setTag(java.lang.String newTag) {
	tag = newTag;
}}