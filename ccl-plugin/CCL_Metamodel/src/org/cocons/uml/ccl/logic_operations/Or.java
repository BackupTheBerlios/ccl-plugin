package org.cocons.uml.ccl.logic_operations;

import org.cocons.uml.ccl.LogicOperation;

/**
 * The logical operation OR.
 * Creation date: (21.12.2001 20:02:22)
 * @author: Fadi Chabarek
 */
public class Or implements LogicOperation {

	/**
	 * Or constructor.
	 */
	protected Or() {
		super();
	}

	/**
	 * Applys the logic operation.
	 * Creation date: (21.12.2001 20:03:10)
	 * @return boolean bool1 OR bool2.
	 * @param bool1 boolean the first boolean parameter.
	 * @param bool2 boolean the second boolean parameter.
	 */
	public boolean apply(boolean bool1, boolean bool2) {
		return bool1 || bool2;
	}

	/**
	 * Compares two objects for equality. Returns a boolean that indicates
	 * whether this object is equivalent to the specified object. This method
	 * is used when an object is stored in a hashtable.
	 * @param obj the Object to compare with
	 * @return true if these Objects are equal; false otherwise.
	 * @see java.util.Hashtable
	 */
	public boolean equals(Object obj) {

		boolean equals = false;

		boolean t = true;
		boolean f = false;

		if (obj instanceof LogicOperation) {
			LogicOperation lo = (LogicOperation) obj;

			equals = true;

			equals = equals && lo.apply(t, t) == this.apply(t, t);
			equals = equals && lo.apply(t, f) == this.apply(t, f);
			equals = equals && lo.apply(f, t) == this.apply(f, t);
			equals = equals && lo.apply(f, f) == this.apply(f, f);

			equals = equals && lo.toString().equals(this.toString());

		}

		return equals;
	}

	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {

		return "OR";
	}
}