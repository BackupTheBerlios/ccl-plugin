package org.cocons.uml.ccl;

import java.util.Vector;
import org.cocons.uml.ccl.ccldata.CoConData;
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
   * Sets the CCL data object that defines the functionality of this CoCon.
   *
   * @param xmlCCL the CCL data object.
   */
  public void setXMLCCL(CoConData xmlCCL);

  /**
   * Returns the CCL data object that defines this CoCon.
   *
   * @return the CCL data object.
   */
  public CoConData getXMLCCL();

	/**
	 * Returns the scope' context condition.
	 * Creation date: (15.01.2002 14:38:23)
	 * @return org.cocons.uml.ccl.ContextCondition the scope's context condition.
	 */
	ContextCondition getScopeContextCondition();

	/**
	* Returns the target context condition.
	* Creation date: (15.01.2002 14:37:44)
	* @return org.cocons.uml.ccl.ContextCondition the target context condition.
	*/
	ContextCondition getTargetContextCondition();
}