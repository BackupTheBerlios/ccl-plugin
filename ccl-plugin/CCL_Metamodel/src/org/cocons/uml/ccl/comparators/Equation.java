package org.cocons.uml.ccl.comparators;

/**
 * An equation (=).
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
	 * Compares to strings case insensitivly if they are  equal.
	 * Creation date: (26.12.2001 14:09:23)
	 * @return boolean
	 */
	public boolean compare(String value1, String value2) {
		return value1.compareToIgnoreCase(value2) == 0;
	}

	/**
	 * Returns a string describing this comparison.
	 * Creation date: (26.12.2001 14:25:36)
	 * @return java.lang.String the description.
	 */
	public String toString() {
		return "EQUAL";
	}
/**
 * bla.
 * Creation date: (27.12.2001 15:45:50)
 * @return java.lang.Object
 */
public Object clone() {
	return (Object) new Equation();
}/**
 * Insert the method's description here.
 * Creation date: (27.12.2001 16:00:12)
 * @return boolean
 * @param obj java.lang.Object
 */  
public boolean equals(Object obj) {

	boolean equals = false;

	if(obj instanceof Equation) {
		if(((Equation) obj).compare("test", "test") && obj.toString() == this.toString()) {
			equals = true;
		}
	}

	return equals;
}}