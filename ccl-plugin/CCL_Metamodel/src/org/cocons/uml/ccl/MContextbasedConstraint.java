package org.cocons.uml.ccl;

import java.util.Vector;
import ru.novosoft.uml.foundation.core.MConstraint;
import org.cocons.uml.ccl.ccldata.CoCon;

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
	 * Sets the context condition(s) for the target set. Calling
         * this method with parameter null will reset the target set.
         *
	 * @param conditions the ContextConditions, a vector containing
         *        elements of type ContextCondition
	 */
	public void setTargetSetContextCondition(Vector conditions);

	/**
	 * Sets the context condition(s) for the scope set. Calling
         * this method with parameter null will reset the scope set.
         *
	 * @param conditions the ContextConditions, a vector containing
         *        elements of type ContextCondition
	 */
	public void setScopeSetContextCondition(Vector conditions);

	/**
	 * Returns the scope' context condition(s).
	 *
	 * @return ContextCondition the scope's context condition(s), a vector
         *         containing elements of type ContextCondition.
	 */
	public Vector getScopeSetContextConditions();

	/**
	* Returns the target context condition(s).
	*
	 * @return ContextCondition the target context condition(s), a vector
         *         containing elements of type ContextCondition.
	*/
	public Vector getTargetSetContextConditions();

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

	/** Ensures XML-Body is in sync with modelled CoCon */
	public void syncBody();

	/** Returns XML representation for this CoCon's contents */
	public String getXMLRepresentation();

	/** Returns intermediate class representation */
	public CoCon getIMClassRepresentation();

	/** Initializes cocon from intermediate classes  */
	public void initializeFromIMClass( CoCon cocon );


}

