package org.cocons.uml.ccl;

import java.util.Vector;
import ru.novosoft.uml.foundation.core.MConstraint;
import org.cocons.uml.ccl.ccldata.CoConData;

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

}