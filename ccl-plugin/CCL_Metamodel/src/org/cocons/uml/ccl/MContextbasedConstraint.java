package org.cocons.uml.ccl;

import java.util.Vector;

import ru.novosoft.uml.foundation.core.MConstraint;

/**
 * The interface that defines a Contextbased Constraint (CoCon).
 *
 * @author Stefan Tang, Fadi Chabarek, Philip Schumacher
 * @version $Revision 1.1$
 */
public interface MContextbasedConstraint extends MConstraint {

	/**
	 * Returns all model elements that are in the target set,
	 * regardless if they are bind directly via MConstraint or indirectly
	 * via the context condition.
	 *
	 * @return A vector containing all model elements that are in the target set.
	 */
	public Vector getTargetElements();

	/**
	 * Returns all model elements that are in the scope set,
	 * regardless if they are bind directly via MConstraint or indirectly
	 * via the context condition.
	 *
	 * @return A vector containing all model elements that are scoped.
	 */
	public Vector getScopedElements();

	/**
	 * Gets the type of this Contextbased Constraint.
	 *
	 * @return the CoCon type.
	 */
	public String getCoConType();

	/**
	 * Sets the type of this Contextbased Constraint.
	 *
	 * @param type the CoCon type.
	 */
	public void setCoConType(String type);

	/**
	 * Sets the context condition for the target set.
	 *
	 * @param contextCondition the target set context condition.
	 */
	public void setTargetSetContextCondition(ContextCondition contextCondition);

	/**
	 * Sets the context condition for the scope set.
	 *
	 * @param contextCondition the scope set context condition.
	 */
	public void setScopeSetContextCondition(ContextCondition contextCondition);

	/**
	 * Returns the scope' context condition.
	 *
	 * @return ContextCondition the scope's context condition.
	 */
	public ContextCondition getScopeSetContextCondition();

	/**
	* Returns the target context condition.
	*
	* @return ContextCondition the target context condition.
	*/
	public ContextCondition getTargetSetContextCondition();

		/**
		 * Sets the direct associated elements for the target set.
		 *
		 * @param directElements the vector that contains the direct
		 *        elements for the target set. Each element is a String,
		 *        the name of the direct associated element.
		 */
		public void setTargetSetDirectElements(Vector directElements);

		/**
		 * Sets the direct associated elements for the scope set.
		 *
		 * @param directElements the vector that contains the direct
		 *        elements for the scope set. Each element is a String,
		 *        the name of the direct associated element.
		 */
		public void setScopeSetDirectElements(Vector directElements);

		/**
		 * Returns the complete CCL String that defines this CoCon.
		 *
		 * @return the CCL String that defines this CoCon, returns null
		 *         if the CoCon hasn't been initialized yet.
		 */
		public String toString();

		/**
		 * Returns the part of the CCL String that defines the target set.
		 *
		 * @return the CCL String that defines the target set.
		 */
		public String getTargetSetCCLString();

		/**
		 * Returns the part of the CCL String that defines the scope set.
		 *
		 * @return the CCL String that defines the scope set.
		 */
		public String getScopeSetCCLString();
}