package org.cocons.uml.ccl;

import java.util.*;
import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.cocons.uml.*;

/**
 * Interface to a CCL ContextCondition metaclass.
 *
 * @author Martin Skinner
 * @version 1.0
 */

public interface MContextCondition extends MBase {
  /**
   * Gets the value of the attribute BaseClass.
   *
   * @return current value of the BaseClass attribute
   */
  public String getBaseClass();
  /**
   * Sets the value of the attribute BaseClass.
   *
   * @param new value of the BaseClass attribute
   */
  public void setBaseClass( String __arg );
  /**
   * Gets the value of the attribute Query.
   *
   * @return current value of the Query attribute
   */
  public MBooleanExpression getQuery();
  /**
   * Sets the value of the attribute Query.
   *
   * @param new value of the Query attribute
   */
  public void setQuery(MBooleanExpression _arg);
  /**
   * Gets the value of the attribute Range.
   *
   * @return current value of the Range attribute
   */
  public MMultiplicity getRange();
  /**
   * Sets the value of the attribute Range.
   *
   * @param new value of the Range attribute
   */
  public void setRange(MMultiplicity _arg);

  // association restrictedStereotype(Stereotype)
  //             / restriction(ContextCondition)
  /**
   * Gets all links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @return unmodifyable copy of the current RestrictedStereotypes collection
   */
  Collection getRestrictedStereotypes();
  /**
   * Sets all links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg new collection of RestrictedStereotypes or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setRestrictedStereotypes(Collection __arg);
  /**
   * Adds a link to the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg RestrictedStereotype to be linked to this instance
   */
  void addRestrictedStereotype(MStereotype __arg);
  /**
   * Removes a link from the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg RestrictedStereotype to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeRestrictedStereotype(MStereotype __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg RestrictedStereotype to be referenced
   */
  void internalRefByRestrictedStereotype(MStereotype __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg RestrictedStereotype to be unreferenced
   */
  void internalUnrefByRestrictedStereotype(MStereotype __arg);

  // association contextPropertyValue(TaggedValue)
  //             / refCondition(ContextCondition)
  /**
   * Gets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @return unmodifyable copy of the current ContextPropertyValues collection
   */
  Collection getContextPropertyValues();
  /**
   * Sets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg new collection of ContextPropertyValues or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setContextPropertyValues(Collection __arg);
  /**
   * Adds a link to the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg ContextPropertyValue to be linked to this instance
   */
  void addContextPropertyValue(MTaggedValue __arg);
  /**
   * Removes a link from the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg ContextPropertyValue to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeContextPropertyValue(MTaggedValue __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyValue to be referenced
   */
  void internalRefByContextPropertyValue(MTaggedValue __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyValue to be unreferenced
   */
  void internalUnrefByContextPropertyValue(MTaggedValue __arg);

  // association scopedConstraint(ContextBasedConstraint)
  //             / scopeSet(ContextCondition)
  /**
   * Gets all the links of the association scopedConstraint(ContextBasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @return unmodifyable copy of the current ScopedConstraints collection
   */
  Collection getScopedConstraints();
  /**
   * Sets all the links of the association scopedConstraint(ContextBasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @param __arg new collection of ScopedConstraints or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setScopedConstraints(Collection __arg);
  /**
   * Adds a link to the association scopedConstraint(ContextbasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @param __arg ScopedConstraint to be linked to this instance
   */
  void addScopedConstraint(MContextbasedConstraint __arg);
  /**
   * Removes a link from the association scopedConstraint(ContextbasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @param __arg ScopedConstraint to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeScopedConstraint(MContextbasedConstraint __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopedConstraint to be referenced
   */
  void internalRefByScopedConstraint(MContextbasedConstraint __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopedConstraint to be unreferenced
   */
  void internalUnrefByScopedConstraint(MContextbasedConstraint __arg);
  // association constrainedSet(ContextCondition)
  //             / contextbasedConstraint(ContextbasedConstraint)
  /**
   * Gets all the links of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @return unmodifyable copy of the current ContextbasedConstraints collection
   */
  Collection getContextbasedConstraints();
  /**
   * Sets all the links of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg new collection of ContextbasedConstraints or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setContextbasedConstraints(Collection __arg);
  /**
   * Adds a link to the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg ContextbasedConstraint to be linked to this instance
   */
  void addContextbasedConstraint(MContextbasedConstraint __arg);
  /**
   * Removes a link from the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg ContextbasedConstraint to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeContextbasedConstraint(MContextbasedConstraint __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextbasedConstraint to be referenced
   */
  void internalRefByContextbasedConstraint(MContextbasedConstraint __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextbasedConstraint to be unreferenced
   */
  void internalUnrefByContextbasedConstraint(MContextbasedConstraint __arg);

  /**
   * Updates the conditioned model elements. Selects all conditioned elements
   * and adds them to the conditionedModelElements.
   */
  public void updateConditionedModelElements();

  /**
   * Returns all the model elements that are bound by this condition.
   * @return A vector containing elements of type MModelElement
   */
  public Vector getConditionedModelElements();
}
