package org.cocons.uml.ccl;






import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * A Comparison comparing model element's 
 * owned tagged values with the tag and the values of its own.
 */
public interface Comparison {

	/**
	 * Returns the tag (variable) from this condition.
	 */
	public String getTag();

	/**
	 * Returns a Comparator this comparison uses to compare values with its own.
	 * Creation date: (26.12.2001 13:35:24)
	 * @return org.cocons.uml.ccl.Comparison the comparison.
	 */
	public Comparator getComparator();

	/**
	* Shows if this comparison is negated.
	* Creation date: (09.02.2002 16:00:49)
	* @return boolean true if the comparison is negated.
	*/
	boolean isNegated();
	
	/**
	 * Checks whether the given model element is covered by this comparison.
	 * Creation date: (21.12.2001 00:36:03)
	 * @return boolean true, if the model element and its elementValue(s) compared to 
	 * the values of this comparison is satisfactory.
	 * @param elementValue MModelElement a modelElement.
	 */
	boolean covers(MModelElement elementValue); 
	
	/**
	* Returns the tagged value(s) (constant(s)) from this comparison.
	*/
	public Object getValue();
}