package org.cocons.uml.ccl;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * A ComparisonImpl is an implementation of the interface comparison.
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
	 * Constructs a comparison implementation.
	 */
	public ComparisonImpl() {
		super();
	}

	/**
	 * Checks whether the given value lies within this comparison. A comparison without value or tag
	 * or comparison operation is no restrictivness so the preposition would be true
	 * and thus the comparison covers the element value.
	 * Creation date: (26.12.2001 14:20:30)
	 * @return boolean true, if the elementValue compared to the contained values is satisfactory.
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
			covers = covers && this.getComparator().compare(this.getValue(), elementValue.getValue());
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
		* Insert the method's description here.
		* Creation date: (26.12.2001 14:20:30)
		* @param tag java.lang.String
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
	private Comparator _comparator;	/**
	 * Returns a Comparison this comparison uses to compare values with its own.
	 * Creation date: (26.12.2001 14:20:30)
	 * @return org.cocons.uml.ccl.Comparison the comparison.
	 */
	public Comparator getComparator() {
		return this._comparator;
	}	/**
	 * Sets the comparison used to compare values with the boudary value.
	 * Creation date: (26.12.2001 14:22:19)
	 * @param newComparison org.cocons.uml.ccl.Comparison the comparison.
	 */
	public void setComparator(Comparator newComparator) {
		_comparator = newComparator;
	}}