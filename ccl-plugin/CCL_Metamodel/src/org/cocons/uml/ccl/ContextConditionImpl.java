package org.cocons.uml.ccl;

import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * A context condition provides an indirect association to modelelements.
 * Therefore a context condition sets up conditions for model elements to
 * comply with.
 * Creation date: (02.01.2002 22:41:05)
 * @author: Fadi Chabarek
 */
public class ContextConditionImpl extends ConditionImpl implements ContextCondition {

	/**
	 * The base class of this context condition.
	 */
	private String _baseClass;

	/**
	 * The range of this context condition.
	 */
	private String _range;
	
	/**
	 * Constructs a context condition.
	 */
	public ContextConditionImpl() {
		super();
	}
	
	/**
	 * Returns a String representing a base class, model elements must descend from
	 * to comply this context condition.
	 * Creation date: (02.01.2002 22:41:05)
	 * @return java.lang.String the base class representation.
	 */
	public String getBaseClass() {
		return _baseClass;
	}

	/**
	 * Checks if the conditional is complied with a given model element
	 * and if the base class and the range fits.
	 * Creation date: (02.01.2002 23:05:28)
	 * @return boolean true if the model element complies this context condition.
	 * @param modelElement ru.novosoft.uml.foundation.core.MModelElement
	 */
	public boolean isCompliedWith(MModelElement modelElement) {

		//The now possible range is All that's no restriction, so I don't need to check this.

		// check base class
		if (!BaseClasses.objectMatchsType(modelElement, this.getRange())) {
			return false;
		};

		return super.isCompliedWith(modelElement);
	}
	
	/**
	 * Sets the base class of this context condition.
	 * Creation date: (02.01.2002 22:44:54)
	 * @param new_baseClass String the base class.
	 */
	public void setBaseClass(java.lang.String new_baseClass) {
		_baseClass = new_baseClass;
	}

	/**
	 * Returns a String that represents the value of this object.
	 * @return a string representation of the receiver
	 */
	public String toString() {
		return getRange() + " " + getBaseClass() + " WHERE  " + super.toString();
	}
	
	/**
	 * Returns the range of this context condition.
	 * A range limits the number of model elements that can be selected
	 * through a context condition.
	 * Creation date: (02.01.2002 22:33:53)
	 * @return String the range.
	 */
	public java.lang.String getRange() {
		return _range;
	} 
	
	/**
	  * Checks recursivly if this conditional tree is valid. A valid part (condition)
	  * must have a comparison xor two childs and must be a tree (i.e. has no circles).
	  * Additional the range and the base class must be defined via CCLConstants or
	  * BaseClasses.
	  * Creation date: (23.12.2001 11:43:56)
	  * @return boolean if every tree node is valid.
	  */
	public synchronized boolean isValid() {
		
		boolean bcValid = isBaseClassValid();
		boolean rValid = isRangeValid();
		boolean valid = super.isValid();
		
		return isBaseClassValid() && isRangeValid() && super.isValid();
	} 
	
	/**
	* Sets the range of this context condition.
	* Creation date: (02.01.2002 22:44:54)
	* @param new_range String the new range.
	*/
	public void setRange(String new_range) {
		_range = new_range;
	}
/**
 * Checks weather the context condition's base class is valid.
 * Creation date: (08.02.2002 13:37:45)
 * @return boolean true - if the base class is defined in BaseClasses.
 * @see org.cocons.uml.ccl.BaseClasses
 */
private boolean isBaseClassValid() {

	boolean valid = false;

	if(this.getBaseClass() == null) {
		return false;
	}

	String[] types = BaseClasses.getAllAvailableTypes();

	for (int i = 0; i < types.length; i++){
		valid = valid || types[i].compareToIgnoreCase(this.getBaseClass()) == 0;
	}
	
	return valid;
}/**
 * Checks weather the context condition's range is valid.
 * Creation date: (08.02.2002 13:37:45)
 * @return boolean true - if the range is given through an (long) integer or one 
 * of its defined keywords such as ALL.
 * @see org.cocons.uml.ccl.CCLConstants
 */
private boolean isRangeValid() {

	boolean valid = true;

	if(getRange() == null) {
		return false;
	} 

	try {
		Long.parseLong(getRange());
	} catch (NumberFormatException nfe) {
		valid = false;
	}

	valid = valid || getRange().compareToIgnoreCase(CCLConstants.INDIRECT_RANGE_ALL) == 0;

	return valid;
}}