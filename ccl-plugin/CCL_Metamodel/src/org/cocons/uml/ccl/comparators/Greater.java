package org.cocons.uml.ccl.comparators;

/**
 * A comparator that checks whether a value is greater than another (>).
 * Creation date: (28.12.2001 01:46:14)
 * @author: Fadi Chabarek
 */
public class Greater implements org.cocons.uml.ccl.Comparator {

	/**
	 * Constructs this comparator.
	 */
	public Greater() {
		super();
	}

	/**
		 * Returns a String that represents the value of this object.
		 * @return a string representation of the receiver
		 */
	public String toString() {
		return "GREATER THEN";
	}
	/**
	 * Compares to Strings if the first one is greater than the other.
	 * Creation date: (09.02.2002 15:34:37)
	 * @param value1 the first value.
	 * @param value2 the second value.
	 * @return boolean true if the first value is greater than the second and both are unequal null.
	 */
	public boolean compare(Object value1, Object value2) {

		if (value1 instanceof String && value2 instanceof String) {
			try {

				return ((String) value1).compareToIgnoreCase((String) value2) > 0;

			} catch (NullPointerException npe) {
				return false;
			}
		} else {
			return false;
		}
	}
}