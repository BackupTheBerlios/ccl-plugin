package org.cocons.uml.ccl;

import java.util.Vector;

import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.comparators.ComparatorFactory;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue; 
/**
* A SetComparison is an implementation of the interface comparison.
* A Comparison has a tag as variable, and a set of values as constant values 
* and a comparator to compare the variable with that value.
* Creation date: (26.12.2001 14:20:30)
* @author: Fadi Chabarek
*/
public class SetComparison implements Comparison {

	/**
	 * The set of values to be compared.
	 */
	private java.util.Vector _values;

	/**
	 * The contained tag.
	 */
	private String _tag;

	/**
	 * If this comparison is negated.
	 */
	private boolean _negated;

	/**
	 * A comparator to compare the contained values.
	 */
	private Comparator _comparator;

	/**
	 * Constructs a comparison over sets.
	 */
	public SetComparison() {
		super();
		this.setNegated(false);
		this.setValue(new Vector());
		this.setTag("");

	}

	/**
	 * Checks via the comparator whether the given model element is covered by this comparison.
	 * Creation date: (11.02.2002 21:17:12)
	 * @return boolean true, if the model element and its elementValues that fit (at least one),
	 * match the comparison's tag compared to the values of this comparison are satisfactory. 
	 * @param modelElement MModelElement a modelElement.
	 */
	public boolean covers(ru.novosoft.uml.foundation.core.MModelElement modelElement) {

		boolean covers = true;
		boolean tagExisted = false;

		// to avoid nullpointer-exceptions
		if (modelElement == null
			|| modelElement.getTaggedValues() == null
			|| this.getTag() == null
			|| this.getValue() == null
			|| this.getComparator() == null) {
			return false;
		}

		// for every context property value of the element
		MContextPropertyValue elementValue = null;

		// the assambled element values
		Vector eValues = new Vector();

		Object[] taggedValues = modelElement.getTaggedValues().toArray();
		for (int i = 0; i < taggedValues.length; i++) {

			if (taggedValues[i] instanceof MContextPropertyValue) {
				elementValue = (MContextPropertyValue) taggedValues[i];

				String tag = elementValue.getContextPropertyTag().getTag();

				// if the tag is equal, the element is only covered if all compared values are satisfactory.
				if (this.getTag().equals(elementValue.getContextPropertyTag().getTag())) {
					tagExisted = true;

					// assamble the values.
					eValues.addElement(elementValue.getValue());
				}
			}

		}

		covers = covers && this.getComparator().compare(eValues, this.getValue());

		if (this.isNegated()) {
			covers = !covers;
		}

		// only if a matching tag existed the model element can be covered.
		return covers && tagExisted;
	}

	/**
	 * Returns a Comparator this comparison uses to compare values with its own.
	 * Creation date: (11.02.2002 21:17:12)
	 * @return org.cocons.uml.ccl.Comparison the comparison.
	 */
	public Comparator getComparator() {
		return _comparator;
	}

	/**
	 * Returns the tag (variable) from this condition.
	 */
	public String getTag() {
		return _tag;
	}

	/**
	* Returns the tagged value(s) (constant(s)) from this comparison.
	* @return Vector the tagged value(s), its elements are from type String.
	*/
	public Object getValue() {
		return _values;
	}

	/**
	* Shows if this comparison is negated.
	* Creation date: (11.02.2002 21:17:12)
	* @return boolean true if the comparison is negated.
	*/
	public boolean isNegated() {
		return _negated;
	}

	/**
	 * Sets the comparison as negated.
	 * Creation date: (11.02.2002 21:36:59)
	 * @param newNegated boolean if this comparison is negated.
	 */
	public void setNegated(boolean newNegated) {
		_negated = newNegated;
	}

	/**
	* Sets the tag (variable) of this comparison.
	* Creation date: (11.02.2002 21:38:04)
	* @param newTag java.lang.String the tag
	*/
	public void setTag(String newTag) {
		_tag = newTag;
	}

	/**
	* Sets the set of values for this comparison
	* Creation date: (11.02.2002 21:36:41)
	* @param newValues java.util.Vector set of values, elements are Strings.
	*/
	public void setValue(Vector newValues) {
		_values = newValues;
	}

	/**
	* Sets the contained comparator.
	* Creation date: (11.02.2002 22:04:11)
	* @param newComparator org.cocons.uml.ccl.Comparator the comparator.
	*/
	public void setComparator(Comparator newComparator) {
		_comparator = newComparator;
	}
}