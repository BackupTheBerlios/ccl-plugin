package org.cocons.uml.ccl.context_property1_3;

import java.util.Vector;

/**
 * Describes a contextbased property tag.
 * Creation date: (21.12.2001 18:20:29)
 * @author: Fadi Chabarek, Stefan Tang, Philipp Schumacher.
 */
public interface MContextPropertyTag extends ru.novosoft.uml.foundation.core.MModelElement {

/**
 * This method deletes herself and all MContextPropertyValues beloging to this Tag.
 * Erstellungsdatum: (31.12.2001 03:40:23)
 */
void deleteMyself();
/**
 * Compares the argument with herself.
 * Return true if both are the same.
 * Erstellungsdatum: (31.12.2001 03:34:04)
 * @return boolean
 * @param __arg org.omg.CORBA.Object
 */
boolean equals(Object __arg);

// --------- hyshosha --------------------
void setTag(String tagName);
String getTag();
String getConstraintBody();
// ---------------------------------------

}


