package org.cocons.uml.ccl.comparators;

import org.cocons.uml.ccl.Comparator;

/**
 * If a String contains another string.
 * Creation date: (28.12.2001 21:35:08)
 * @author: Fadi Chabarek
 */
public class Contains implements Comparator {
/**
 * Constructs this comparison.
 */
public Contains() {
	super();
}
/**
 * Compares to Strings if the first contains the second.
 * Creation date: (28.12.2001 21:38:28)
 * @return boolean true if the value1 contains value2.
 */
public boolean compare(java.lang.String value1, java.lang.String value2) {
	return value1.lastIndexOf(value2) >= 0;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {

	return "CONTAINS";
}
}