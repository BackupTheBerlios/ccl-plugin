package org.cocons.uml.ccl;

/**
 * A Comparator comparing to values.
 * Creation date: (26.12.2001 13:34:55)
 * @author: Fadi Chabarek
 */
public interface Comparator {

/**
 * Compares to Strings.
 * Creation date: (26.12.2001 13:43:46)
 * @return boolean if the strings compared to each other are satisfactory.
 */
boolean compare(Object value1, Object value2);}