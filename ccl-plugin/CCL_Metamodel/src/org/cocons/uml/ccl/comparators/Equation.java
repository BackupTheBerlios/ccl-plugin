package org.cocons.uml.ccl.comparators;

import java.util.Collection; 

/**
* An equation (=) for strings or for all elements of a collection
* (usable for value comparisons and set comparisons as well).
* Creation date: (26.12.2001 14:09:23)
* @author: Fadi Chabarek
*/
public class Equation implements org.cocons.uml.ccl.Comparator, Cloneable {

	/**
	 * Constructs an equation.
	 */
	protected Equation() {
		super();
	}

	/**
	 * Returns a string describing this comparison.
	 * Creation date: (26.12.2001 14:25:36)
	 * @return java.lang.String the description.
	 */
	public String toString() {
		return "EQUALS";
	}

	/**
	 * clones this object.
	 * Creation date: (27.12.2001 15:45:50)
	 * @return java.lang.Object the clone.
	 */
	public Object clone() {
		return (Object) new Equation();
	}

	/**
	* Checks if another object is equal to this one.
	* Creation date: (27.12.2001 16:00:12)
	* @return boolean if it's equal.
	* @param obj java.lang.Object the other object.
	*/
	public boolean equals(Object obj) {

		boolean equals = false;

		if (obj instanceof Equation) {
			if (((Equation) obj).compare("test", "test") && obj.toString() == this.toString()) {
				equals = true;
			}
		}

		return equals;
	}
    
	/**
	 * Compares two strings case insensitivly if they are  equal or two collections if
	 * all of their elements are equal.
	 * Creation date: (26.12.2001 14:09:23)
	 * @return boolean true if both values are equal and both of them are unequal null.
	 */
	public boolean compare(Object value1, Object value2) {

		try {

			// for value comparisons
			if (value1 instanceof String && value2 instanceof String) {
				return ((String) value1).compareToIgnoreCase((String) value2) == 0;

			} else
				if (value1 instanceof Collection && value2 instanceof Collection) {

					// for set comparisons
					return ((Collection) value1).containsAll((Collection) value2)
						&& ((Collection) value2).containsAll((Collection) value1); 
				}

		} catch (NullPointerException npe) {
		}
		return false;
	}
}