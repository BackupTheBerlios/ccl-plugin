package org.cocons.uml.ccl.logic_operations;

/**
 * The logic operation AND.
 * Creation date: (28.12.2001 01:28:47)
 * @author: Fadi Chabarek
 */
public class And implements org.cocons.uml.ccl.LogicOperation {
/**
 * Constructs the logic operation AND.
 */
public And() {
	super();
}
	/**
	 * Applys the logic operation AND.
	 * Creation date: (28.12.2001 01:28:47)
	 * @return boolean the applyed value.
	 * @param bool1 boolean the first boolean parameter.
	 * @param bool2 boolean the second boolean parameter.
	 */
public boolean apply(boolean bool1, boolean bool2) {
	return bool1 && bool2;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return "AND";
}
}