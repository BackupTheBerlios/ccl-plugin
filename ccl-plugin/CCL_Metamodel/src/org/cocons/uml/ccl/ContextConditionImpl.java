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
	private MMultiplicity _range;
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
 * Returns the range of this context condition.
 * A range limits the number of model elements that can be selected
 * through a context condition. 
 * Creation date: (02.01.2002 22:41:05)
 * @return ru.novosoft.uml.foundation.data_types.MMultiplicity the range.
 */
public MMultiplicity getRange() {
	return _range;
}
/**
 * Checks if the conditional is complied with a given model element
 * and if the base class and the range fits.
 * Creation date: (02.01.2002 23:05:28)
 * @return boolean true if the model element complies this context condition.
 * @param modelElement ru.novosoft.uml.foundation.core.MModelElement
 */
public boolean isCompliedWith(MModelElement modelElement) {
	
	// TODO: check range and base class.
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
 * Sets the range of this context condition.
 * Creation date: (02.01.2002 22:44:54)
 * @param new_range MMultiplicity the new range.
 */
public void setRange(MMultiplicity new_range) {
	_range = new_range;
}
/**
 * Returns a String that represents the value of this object.
 * @return a string representation of the receiver
 */
public String toString() {
	return getRange() +  " " + getBaseClass() + " WHERE  " + super.toString();
}
}