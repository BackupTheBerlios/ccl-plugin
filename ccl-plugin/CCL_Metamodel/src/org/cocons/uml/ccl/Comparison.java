package org.cocons.uml.ccl;

import org.cocons.uml.ccl.context_property1_3.*;

import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import ru.novosoft.uml.MBase;

public interface Comparison {

	/**
	 * Returns the tag (variable) from this condition.
	 */
	public String getTag();

	/**
	* Returns the tagged value (constant) from this condition.
	*/
	public String getValue();

	/**
	 * Checks whether the given value lies within this comparison.
	 * Creation date: (21.12.2001 00:36:03)
	 * @return boolean true, if the elementValue compared to the contained values is satisfactory.
	 * @param elementValue MContextPropertyValue a tagged value contained by a ccl word.
	 */
	boolean covers(MContextPropertyValue elementValue);


	/**
	 * Returns a Comparator this comparison uses to compare values with its own.
	 * Creation date: (26.12.2001 13:35:24)
	 * @return org.cocons.uml.ccl.Comparison the comparison.
	 */
	public Comparator getComparator();}