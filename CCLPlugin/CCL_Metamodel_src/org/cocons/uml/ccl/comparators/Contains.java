package org.cocons.uml.ccl.comparators;

import org.cocons.uml.ccl.Comparator;

import java.util.Collection;

/**
* If a String contains another string or a collection contains the
* elements of the other collection
* (usable for value comparisons and set comparisons as well).
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
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {

		return "CONTAINS";
	}

	/**
	 * Compares to Strings if the first contains the second or if the first collection
	 * contains the elements of the second.
	 * Creation date: (28.12.2001 21:38:28)
	 * @return boolean true if the value1 contains value2 and both are unequal null.
	 */
	public boolean compare(Object value1, Object value2) {

		try {

			// for value comparisons
			if (value1 instanceof String && value2 instanceof String) {
				return ((String) value1).lastIndexOf((String) value2) >= 0;

			} else
				if (value1 instanceof Collection && value2 instanceof Collection) {

					// for set comparisons
					return ((Collection) value1).containsAll((Collection) value2);
				}

		} catch (NullPointerException npe) {
		}
		return false;
	}
	
	/**
	 * Returns the negated string representation of this comparator.
	 * Creation date: (12.02.2002 15:32:39)
	 * @return java.lang.String the negated string represantation.
	 */
	public java.lang.String toNegatedString() {
		return "DOES NOT CONTAIN";
	}
}