package org.cocons.uml.ccl.comparators;

/**
 * A comparator that checks whether a value is less than another (<).
 * Creation date: (28.12.2001 01:46:14)
 * @author: Fadi Chabarek
 */
public class Less implements org.cocons.uml.ccl.Comparator {

	/**
	 * Constructs the comparison less.
	 */
	public Less() {
		super();
	}

	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {
		return "LESS THEN";
	}
	/**
	 * Compares to Strings if one is less then the other.
	 * Creation date: (28.12.2001 01:46:14)
	 * @return boolean true if value1 is less then value2 and both values are unequal null.
	 * @param value1 the first value.
	 * @param value2 the second value.
	 */
	public boolean compare(Object value1, Object value2) {

		if (value1 instanceof String && value2 instanceof String) {
			try {
				return ((String) value1).compareToIgnoreCase((String) value2) < 0;

			} catch (NullPointerException npe) {
				return false;
			}
		} else {
			return false;
		}
	}
}