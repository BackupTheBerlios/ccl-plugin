package org.cocons.uml.ccl.comparators;

import org.cocons.uml.ccl.Comparator;

/*
 * A Factory producing comparators.
 */
public interface ComparatorFactory {

	/*
	 * The Type of an equation.
	 */
	public final static int EQUAL = 1;

	/*
	 * The Type of the comparator less.
	 */
	public final static int LESS = 2;

	/*
	 * The Type of the comparator contains.
	 */
	public final static int CONTAINS = 3;

	/**
	 * produces a comparator.
	 * @param operationType int the comparator type.
	 * @return the requested comparator.
	 */
	public Comparator produceComparatorWithType(int operationType);

	/**
	* Returns all available comparator types.
	* Creation date: (26.12.2001 16:54:00)
	* @return int[] array of comparator types.
	*/
	public int[] getAvailableTypes();

	/**
	* Produces all available comparators.
	* Creation date: (26.12.2001 18:29:02)
	* @return org.cocons.uml.ccl.Comparator[] all avaiable comparators.
	*/
	Comparator[] produceAllAvailableComparators();
}