package org.cocons.uml.ccl;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;

import ru.novosoft.uml.foundation.core.MModelElement;

import org.cocons.uml.ccl.comparators.Equation;/**
 * A ValueComparison is an implementation of the interface comparison.
 * A Comparison has a tag as variable, a value as a constant value and
 * a comparator to compare the variable with that value.
 * Creation date: (26.12.2001 14:20:30)
 * @author: Fadi Chabarek
 */
public class ValueComparison implements Comparison {

	/**
	 * The comparison's tag.
	 */
	private String _tag;

	/**
	 * The comparison's value.
	 */
	private String _value;

	/**
	 * Weather this comparison is negated.
	 */
	private boolean _negated;

	/**
	 * Constructs a comparison implementation.
	 */
	public ValueComparison() {
		super();
		this.setNegated(false);
	}

	/**
	 * Returns the tag (variable) from this comparison.
	 */
	public String getTag() {
		return this._tag;
	}

	/**
	 * Sets the tag (variable) of this comparison.
	 * Creation date: (26.12.2001 14:20:30)
	 * @param tag java.lang.String the tag (variable)
	 */
	public void setTag(String tag) {
		this._tag = tag;
	}

	/**
	* Sets the boudary's value.
	* Creation date: (26.12.2001 14:20:30)
	* @param value java.lang.String
	*/
	public void setValue(String value) {
		this._value = value;
	}

	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {

	return
		this.getTag() + " " + 
			(isNegated() ? this.getComparator().toNegatedString() :
				this.getComparator().toString()) + " " + this.getValue().toString();  
			
	}

	/**
	 * The comparison's comparison between other tags and its own.
	 */
	private Comparator _comparator;

	/**
	* Returns a Comparison this comparison uses to compare values with its own.
	* Creation date: (26.12.2001 14:20:30)
	* @return org.cocons.uml.ccl.Comparison the comparison.
	*/
	public Comparator getComparator() {
		return this._comparator;
	}

	/**
	 * Sets the comparison used to compare values with the boudary value.
	 * Creation date: (26.12.2001 14:22:19)
	 * @param newComparison org.cocons.uml.ccl.Comparison the comparison.
	 */
	public void setComparator(Comparator newComparator) {
		_comparator = newComparator;
	}

	/**
	* Shows if this comparison is negated.
	* Creation date: (09.02.2002 16:02:55)
	* @return boolean true if the comparison is negated.
	*/
	public boolean isNegated() {
		return _negated;
	}

	/**
	* Sets this comparison as negated or not.
	* Creation date: (09.02.2002 16:02:44)
	* @param newNegated boolean if this comparison should be negated or not.
	*/
	public void setNegated(boolean newNegated) {
		_negated = newNegated;
	}

	/**
	 * Checks whether the given value lies within this comparison. 
	 * Creation date: (26.12.2001 14:20:30)
	 * @return boolean true, if an model element's taggedValue compared to the contained 
	 * values is satisfactory. The case that this comparison is negated is considered.
	 * @param modelElement MModelElement a model element with tagged value(s).
	 */
	public boolean covers(MModelElement modelElement) {

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

		Object[] taggedValues = modelElement.getTaggedValues().toArray();
		for (int i = 0; i < taggedValues.length; i++) {

			if (taggedValues[i] instanceof MContextPropertyValue) {
				elementValue = (MContextPropertyValue) taggedValues[i];

				// if the tag is equal, the element is only covered if all compared 
				// values are satisfactory.
				if (this.getTag().equals(elementValue.getContextPropertyTag().getTag())) {
					tagExisted = true;
					covers = 
						covers && 
						this.getComparator().compare(elementValue.getValue(), (String) this.getValue());
				}
			}

		}

		if (this.isNegated()) {
			covers = !covers;
		}

		// only if a matching tag existed the model element can be covered.
		return covers && tagExisted;
	}

	/**
	* Returns the tagged value (constant) from this comparison.
	*/
	public Object getValue() {
		return this._value;
	}
}