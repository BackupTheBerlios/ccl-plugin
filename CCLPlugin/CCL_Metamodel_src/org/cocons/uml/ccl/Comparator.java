package org.cocons.uml.ccl;

/**
 * A Comparator compars two objects with another.
 * Creation date: (26.12.2001 13:34:55)
 * @author: Fadi Chabarek
 */
public interface Comparator {

	/**
	 * Compares the first Object with the second..
	 * Creation date: (26.12.2001 13:43:46)
	 * @return boolean if the objects compared to each other are satisfactory.
	 */
	boolean compare(Object value1, Object value2);
    
	/**
	 * Returns the negated string representation of this comparator.
	 * Creation date: (12.02.2002 15:32:04)
	 * @return java.lang.String the negated string represantation.
	 */
	String toNegatedString();
}