package org.cocons.uml.ccl.comparators;

import java.util.Vector;
import org.cocons.uml.ccl.Comparator;

/**
 * A Factory producing comparators.
 * Creation date: (26.12.2001 15:54:24)
 * @author: Fadi Chabarek
 */
public class ComparatorFactoryImpl implements ComparatorFactory {

	/**
	 * Constructs the factory.
	 */
	public ComparatorFactoryImpl() {
		super();
	}

	/**
	  * Returns all available types.
	  * Creation date: (26.12.2001 16:54:05)
	  * @return int[] an array of operation types that are available.
	  */
	public int[] getAvailableTypes() {

		int[] types = {ComparatorFactory.EQUAL, ComparatorFactory.LESS, ComparatorFactory.CONTAINS};

		return types;
	}

	/**
	 * Produces all available Comparators.
	 * Creation date: (26.12.2001 18:29:55)
	 * @return org.cocons.uml.ccl.Comparator[] all avaiable comparators.
	 */
	public org.cocons.uml.ccl.Comparator[] produceAllAvailableComparators() {

		int[] types = getAvailableTypes();
		Vector typesV = new Vector();
		Comparator[] comparatorTypes;

		for (int i = 0; i < types.length; i++) {
			typesV.addElement(this.produceComparatorWithType(types[i]));
		}

		comparatorTypes = new Comparator[typesV.size()];
		for (int i = 0; i < typesV.size(); i++) {
			comparatorTypes[i] = (Comparator) typesV.elementAt(i);
		}

		return comparatorTypes;
	}

	/**
	  * produces a comparator.
	  * @param operationType int the comparator type.
	  * @return the requested comparator.
	  */
	public Comparator produceComparatorWithType(int operationType) {

		Comparator com = null;

		switch (operationType) {
			case EQUAL :
				{
					com = new Equation();
					break;
				}
			case LESS :
				{
					com = new Less();
					break;
				}
			case CONTAINS :
				{
					com = new Contains();
					break;
				}
		}

		return com;
	}
}