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
	 * Compares to Strings if one is less then the other.
	 * Creation date: (28.12.2001 01:46:14)
	 * @return boolean true if value1 is less then value2 and both values are unequal null.
	 * @param value1 the first value.
	 * @param value2 the second value.
	 */
	public boolean compare(String value1, String value2) {

		try {
			return value1.compareToIgnoreCase(value2) < 0;

		} catch (NullPointerException npe) {
			return false;
		}
	}

	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {
		return "LESS THEN";
	}
}