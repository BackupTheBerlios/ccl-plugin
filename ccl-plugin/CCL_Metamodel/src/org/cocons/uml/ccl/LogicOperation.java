package org.cocons.uml.ccl;

/**
 * Interface describing a binary logic operation.
 * Creation date: (21.12.2001 01:30:42)
 * @author: Fadi Chabarek
 */
public interface LogicOperation {

	/**
	 * Applys the logic operation.
	 * Creation date: (21.12.2001 01:33:34)
	 * @return boolean the applyed value.
	 * @param bool1 boolean the first boolean parameter.
	 * @param bool2 boolean the second boolean parameter.
	 */
	boolean apply(boolean bool1, boolean bool2);
}