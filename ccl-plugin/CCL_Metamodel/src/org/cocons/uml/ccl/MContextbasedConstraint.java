package org.cocons.uml.ccl;

import ru.novosoft.uml.foundation.core.*;

/**
 * Interface to a CCL ContextbasedConstraint metaclass.
 *
 * @author Martin Skinner
 * @version 1.0
 */
public interface MContextbasedConstraint extends MConstraint {
  // Fields
  /**
   * Gets the value of the attribute Priority.
   *
   * @return current value of the Priority attribute
   */
  public Integer getPriority();
  /**
   * Sets the value of the attribute Priority.
   *
   * @param __arg value to set the Priority to
   */
  public void setPriority(Integer __arg);
  /**
   * Gets the link of the association scopeSet(ContextCondition)
   * / scopedConstraint(ContextbasedConstraint).
   *
   * @return current ScopeSet of the instance
   */
  MContextCondition getScopeSet();
  /**
   * Sets the link of the association scopeSet(ContextCondition)
   * / scopedConstraint(ContextbasedConstraint).
   *
   * @param __arg new ScopeSet of the instance
   */
  void setScopeSet(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopeSet to be referenced
   */
  void internalRefByScopeSet(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopeSet to be unreferenced
   */
  void internalUnrefByScopeSet(MContextCondition __arg);
  /**
   * Gets the link of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @return current ConstrainedSet of the instance
   */
  MContextCondition getConstrainedSet();
  /**
   * Sets the link of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg new ConstrainedSet of the instance
   */
  void setConstrainedSet(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ConstrainedSet to be referenced
   */
  void internalRefByConstrainedSet(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ConstrainedSet to be unreferenced
   */
  void internalUnrefByConstrainedSet(MContextCondition __arg);
}
