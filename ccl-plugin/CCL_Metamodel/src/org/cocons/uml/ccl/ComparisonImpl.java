package org.cocons.uml.ccl;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * A ComparisonImpl is an implementation of the interface comparison.
 * A Comparison has a tag as variable, a value as a constant value and
 * a comparator to compare the variable with that value.
 * Creation date: (26.12.2001 14:20:30)
 * @author: Fadi Chabarek
 */
public class ComparisonImpl implements Comparison {

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
	public ComparisonImpl() {
		super();
		this.setNegated(false);
	}

	/**
	 * Checks whether the given value lies within this comparison. A comparison without value or tag
	 * or comparison operation is no restrictivness so the preposition would be true
	 * and thus the comparison covers the element value, also if this comparison is negated.
	 * Creation date: (26.12.2001 14:20:30)
	 * @return boolean true, if the elementValue compared to the contained values is satisfactory.
	 * The case that this comparison is negated is considered.
	 * @param elementValue MContextPropertyValue a tagged value contained by a ccl word.
	 */
	public boolean covers(MContextPropertyValue elementValue) {

		boolean covers = true;

		if (elementValue == null || elementValue.getContextPropertyTag() == null) {
			return false;
		}

		// to avoid nullpointerexceptions...
		if (this.getTag() != null && this.getValue() != null && this.getComparator() != null) {
			covers = covers && this.getTag().equals(elementValue.getContextPropertyTag().getTag());
			covers = covers && this.getComparator().compare(elementValue.getValue(), this.getValue());
			if (this.isNegated()) {
				covers = !covers;
			}
		}
		return covers;
	}

	/**
	 * Returns the tag (variable) from this condition.
	 */
	public String getTag() {
		return this._tag;
	}

	/**
	* Returns the tagged value (constant) from this condition.
	*/
	public String getValue() {
		return this._value;
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

		return this.getTag() + " " + this.getComparator() + " " + this.getValue();
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
}