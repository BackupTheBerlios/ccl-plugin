package org.cocons.uml.ccl.context_property1_3;

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
 * Insert the method's description here.
 * Creation date: (22.01.2002 16:02:10)
 * @return java.lang.String
 */
String getTag();/**
 * Sets the tag of this context property tag.
 * Creation date: (22.01.2002 16:29:49)
 * @param tag String the tag.
 */
void setTag(String tag);}