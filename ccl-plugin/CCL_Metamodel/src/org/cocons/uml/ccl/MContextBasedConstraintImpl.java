package org.cocons.uml.ccl;

import java.lang.reflect.*;
import java.util.*;
import org.cocons.uml.*;
import ru.novosoft.uml.foundation.core.*;

/**
 * Java implementation of the CCL ContextbasedConstraint metaclass.
 *
 * @author Martin Skinner
 * @version 1.0
 */

public class MContextbasedConstraintImpl extends MConstraintImpl
                                         implements MContextbasedConstraint {

/**
 * Constructs a new ContextbasedConstraint instance.
 * Should never be referenced directly, only through the interface. <br>
 * <br>
 * MContextbasedConstraint cbc = new MContextbasedConstraintImpl();
 *
 */
  public MContextbasedConstraintImpl() {
  }
  // ///////////////////////////
  //
  //   Attribute Priority
  //
  // ///////////////////////////
  Integer _priority=null;
  private final static Method _priority_setMethod = getMethod1(MContextbasedConstraintImpl.class, "setPriority", Integer.class);

  /**
   * Gets the value of the attribute Priority.
   *
   * @return current value of the Priority attribute
   */
  public Integer getPriority()
  {
    checkExists();
    return _priority;
  }
  /**
   * Sets the value of the attribute Priority.
   *
   * @param __arg value to set the Priority to
   */
  public void setPriority(Integer __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_priority_setMethod, _priority, __arg);
      fireAttrSet("priority", _priority, __arg);
      _priority = __arg;
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  // association scopeSet(ContextCondition)
  //             / scopedConstraint(ContextbasedConstraint)
  //
  // ///////////////////////////
  // Static Methods
  private final static Method _scopeSet_setMethod = getMethod1(MContextbasedConstraintImpl.class, "setScopeSet", MContextCondition.class);

  MContextCondition _scopeSet;
  /**
   * Gets the link of the association scopeSet(ContextCondition)
   * / scopedConstraint(ContextbasedConstraint).
   *
   * @return current ScopeSet of the instance
   */
  public final MContextCondition getScopeSet()
  {
    checkExists();
    return _scopeSet;
  }
  /**
   * Sets the link of the association scopeSet(ContextCondition)
   * / scopedConstraint(ContextbasedConstraint).
   *
   * @param __arg new ScopeSet of the instance
   */
  public final void setScopeSet(MContextCondition __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MContextCondition __saved = _scopeSet;
      if (_scopeSet != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByScopedConstraint(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByScopedConstraint(this);
        }
        logRefSet(_scopeSet_setMethod, __saved, __arg);
        fireRefSet("scopeSet", __saved, __arg);
        _scopeSet = __arg;
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopeSet to be referenced
   */
  public final void internalRefByScopeSet(MContextCondition __arg)
  {
    MContextCondition __saved = _scopeSet;
    if (_scopeSet != null)
    {
      _scopeSet.removeScopedConstraint(this);
    }
    fireRefSet("scopeSet", __saved, __arg);
    _scopeSet = __arg;
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopeSet to be unreferenced
   */
  public final void internalUnrefByScopeSet(MContextCondition __arg)
  {
    fireRefSet("scopeSet", _scopeSet, null);
    _scopeSet = null;
  }

  // ///////////////////////////
  //
  // association constrainedSet(ContextCondition)
  //             / contextbasedConstraint(ContextbasedConstraint)
  //
  // ///////////////////////////
  // Static Methods
  private final static Method _constrainedSet_setMethod = getMethod1(MContextbasedConstraintImpl.class, "setConstrainedSet", MContextCondition.class);

  MContextCondition _constrainedSet;
  /**
   * Gets the link of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @return current ConstrainedSet of the instance
   */
  public final MContextCondition getConstrainedSet()
  {
    checkExists();
    return _constrainedSet;
  }
  /**
   * Sets the link of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg new ConstrainedSet of the instance
   */
  public final void setConstrainedSet(MContextCondition __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MContextCondition __saved = _constrainedSet;
      if (_constrainedSet != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByContextbasedConstraint(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByContextbasedConstraint(this);
        }
        logRefSet(_constrainedSet_setMethod, __saved, __arg);
        fireRefSet("constrainedSet", __saved, __arg);
        _constrainedSet = __arg;
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ConstrainedSet to be referenced
   */
  public final void internalRefByConstrainedSet(MContextCondition __arg)
  {
    MContextCondition __saved = _scopeSet;
    if (_constrainedSet != null)
    {
      _constrainedSet.removeScopedConstraint(this);
    }
    fireRefSet("constrainedSet", __saved, __arg);
    _constrainedSet = __arg;
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ConstrainedSet to be unreferenced
   */
  public final void internalUnrefByConstrainedSet(MContextCondition __arg)
  {
    fireRefSet("constrainedSet", _constrainedSet, null);
    _constrainedSet = null;
  }

  // ///////////////////////////
  //
  //   Reflective API
  //
  // ///////////////////////////
  /**
   * Gets the value of an attribute or the link of an association using the
   * reflective API. If the multiplicity of the attribute or value is > 1,
   * then an unmodifiable collection containing all values/links will be
   * returned.
   *
   * @param feature name of attribute or association
   * @return current state of the feature
   * @throws IllegalArgumentException when feature is not specified for this instance
   */
  public Object reflectiveGetValue(String feature)
  {
    if ("priority".equals(feature))
    {
      return getPriority();
    }
    if ("scopeSet".equals(feature))
    {
      return getScopeSet();
    }
    if ("constrainedSet".equals(feature))
    {
      return getConstrainedSet();
    }
    return super.reflectiveGetValue(feature);
  }

  /**
   * Sets the value of an attribute or the link of an association using the
   * reflective API. If the multiplicity of the attribute or value is > 1,
   * then obj must be a collection containing all values/links to be set.
   *
   * @param feature name of attribute or association
   * @param obj new state to be set
   * @throws IllegalArgumentException when feature is not specified for this instance
   */
  public void reflectiveSetValue(String feature, Object obj)
  {
    if ("priority".equals(feature))
    {
      setPriority((Integer)obj);
      return;
    }
    if ("scopeSet".equals(feature))
    {
      setScopeSet((MContextCondition)obj);
      return;
    }
    if ("constrainedSet".equals(feature))
    {
      setConstrainedSet((MContextCondition)obj);
      return;
    }
    super.reflectiveSetValue(feature, obj);
  }

  /**
   * Adds a value to an attribute or a link to an association using the
   * reflective API. Only valid for attributes and associations with
   * multiplicity > 1
   *
   * @param feature name of attribute or association
   * @param obj new value/link to be set
   * @throws IllegalArgumentException when feature is not specified for this instance
   */
  public void reflectiveAddValue(String feature, Object obj)
  {
    super.reflectiveAddValue(feature, obj);
  }

  /**
   * Removes a value or link from a (attribute or association) using the
   * reflective API. Only valid for attributes and associations with
   * multiplicity > 1
   *
   * @param feature name of attribute or association
   * @param obj new value/link to be set
   * @throws IllegalArgumentException when feature is not specified for this instance
   */
  public void reflectiveRemoveValue(String feature, Object obj)
  {
    super.reflectiveRemoveValue(feature, obj);
  }

  // ///////////////////////////
  //
  //   Aux. Methods
  //
  // ///////////////////////////
  /**
   * internal use only - should never be called directly.
   * Assures that all links are removed before
   * discarding this instance.
   *
   * @param scheduledForRemove collection of objects to be removed
   */
  protected void cleanup(Collection scheduledForRemove)
  {
    // opposite role: scopeSet this role: scopedConstraint
    if (_scopeSet != null )
    {
      setScopeSet(null);
    }
    // opposite role: constrainedSet this role: contextbasedConstraint
    if (_constrainedSet != null )
    {
      setConstrainedSet(null);
    }
    super.cleanup(scheduledForRemove);
  }

  /**
   * returns the UML metaclass name of the instance.
   *
   * @return the metaclass name "ContextbasedConstraint"
   */
  public String getUMLClassName()
  {
    return "ContextbasedConstraint";
  }

}