package org.cocons.uml.ccl;

import java.lang.reflect.Method;
import java.util.*;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.cocons.uml.*;

/**
 * Java implementation of the CCL ContextCondition metaclass.
 *
 * @author Martin Skinner
 * @version 1.0
 */

public class MContextConditionImpl extends MBaseImpl
       implements MContextCondition {

/**
 * Constructs a new ContextCondition instance.
 * Should never be referenced directly, only through the interface. <br>
 * <br>
 * MContextCondition td = new MContextConditionImpl();
 *
 */
  public MContextConditionImpl() {
  }

  // ///////////////////////////
  //
  //   Attribute baseClass
  //
  // ///////////////////////////
  protected String _baseClass;

  /**
   * Gets the value of the attribute BaseClass.
   *
   * @return current value of the BaseClass attribute
   */
  public String getBaseClass()
  {
     return _baseClass;
  }

  /**
   * Sets the value of the attribute BaseClass.
   *
   * @param new value of the BaseClass attribute
   */
  public void setBaseClass( String __arg )
  {
    _baseClass = __arg;
  }

  // ///////////////////////////
  //
  //   Attribute query
  //
  // ///////////////////////////
  MBooleanExpression _query;
  private final static Method _query_setMethod = getMethod1(MContextConditionImpl.class, "setQuery", MBooleanExpression.class);

  /**
   * Gets the value of the attribute Query.
   *
   * @return current value of the Query attribute
   */
  public MBooleanExpression getQuery()
  {
    checkExists();
    return _query;
  }

  /**
   * Sets the value of the attribute Query.
   *
   * @param new value of the Query attribute
   */
  public void setQuery(MBooleanExpression __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_query_setMethod, _query, __arg);
      fireAttrSet("query", _query, __arg);
      _query = __arg;
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  //   Attribute range
  //
  // ///////////////////////////
  MMultiplicity _range;
  private final static Method _range_setMethod = getMethod1(MContextConditionImpl.class, "setRange", MMultiplicity.class);

  /**
   * Gets the value of the attribute Range.
   *
   * @return current value of the Range attribute
   */
  public MMultiplicity getRange()
  {
    checkExists();
    return _range;
  }

  /**
   * Sets the value of the attribute Range.
   *
   * @param new value of the Range attribute
   */
  public void setRange(MMultiplicity __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_range_setMethod, _range, __arg);
      fireAttrSet("range", _range, __arg);
      _range = __arg;
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  //   Association restrictedStereotype(Stereotype)/restriction(ContextCondition)
  //
  // ///////////////////////////

  Collection _restrictedStereotypes = Collections.EMPTY_LIST;
  Collection _restrictedStereotypes_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _restrictedStereotype_setMethod = getMethod1(MContextConditionImpl.class, "setRestrictedStereotypes", Collection.class);
  private final static Method _restrictedStereotype_addMethod = getMethod1(MContextConditionImpl.class, "addRestrictedStereotype", MStereotype.class);
  private final static Method _restrictedStereotype_removeMethod = getMethod1(MContextConditionImpl.class, "removeRestrictedStereotype", MStereotype.class);

  /**
   * Gets all links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @return unmodifyable copy of the current RestrictedStereotypes collection
   */
  public Collection getRestrictedStereotypes() {
    checkExists();
    if (null == _restrictedStereotypes_ucopy)
    {
      _restrictedStereotypes_ucopy = ucopy(_restrictedStereotypes);
    }
    return _restrictedStereotypes_ucopy;
  }

  /**
   * Sets all links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg new collection of RestrictedStereotypes or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setRestrictedStereotypes(Collection __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      final boolean logForUndo = needUndo();
      Collection old = null;
      if (sendEvent || logForUndo)
      {
        old = getRestrictedStereotypes();
      }
      _restrictedStereotypes_ucopy = null;
      Collection __added = bagdiff(__arg,_restrictedStereotypes);
      Collection __removed = bagdiff(_restrictedStereotypes, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MStereotype o = (MStereotype)iter3.next();
        o.internalUnrefByRestriction(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MStereotype o = (MStereotype)iter4.next();
        o.internalRefByRestriction(this);
      }
      _restrictedStereotypes = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_restrictedStereotype_setMethod, old, getRestrictedStereotypes());
      }
      if (sendEvent)
      {
        fireBagSet("restrictedStereotype", old, getRestrictedStereotypes());
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * Adds a link to the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg RestrictedStereotype to be linked to this instance
   */
  public final void addRestrictedStereotype(MStereotype __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getRestrictedStereotypes();
      }
      if (null != _restrictedStereotypes_ucopy)
      {
        _restrictedStereotypes = new ArrayList(_restrictedStereotypes);
        _restrictedStereotypes_ucopy = null;
      }
      __arg.internalRefByRestriction(this);
      _restrictedStereotypes.add(__arg);
      logBagAdd(_restrictedStereotype_addMethod, _restrictedStereotype_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("restrictedStereotype", old, getRestrictedStereotypes(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg RestrictedStereotype to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeRestrictedStereotype(MStereotype __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getRestrictedStereotypes();
      }
      if (null != _restrictedStereotypes_ucopy)
      {
        _restrictedStereotypes = new ArrayList(_restrictedStereotypes);
        _restrictedStereotypes_ucopy = null;
      }
      if (!_restrictedStereotypes.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByRestriction(this);
      logBagRemove(_restrictedStereotype_removeMethod, _restrictedStereotype_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("restrictedStereotype", old, getRestrictedStereotypes(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * internal use only - should never be called directly.
   * @param __arg RestrictedStereotype to be referenced
   */
  public final void internalRefByRestrictedStereotype(MStereotype __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRestrictedStereotypes();
    }
    if (null != _restrictedStereotypes_ucopy)
    {
      _restrictedStereotypes = new ArrayList(_restrictedStereotypes);
      _restrictedStereotypes_ucopy = null;
    }
    _restrictedStereotypes.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("restrictedStereotype", old, getRestrictedStereotypes(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg RestrictedStereotype to be unreferenced
   */
  public final void internalUnrefByRestrictedStereotype(MStereotype __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRestrictedStereotypes();
    }
    if (null != _restrictedStereotypes_ucopy)
    {
      _restrictedStereotypes = new ArrayList(_restrictedStereotypes);
      _restrictedStereotypes_ucopy = null;
    }
    _restrictedStereotypes.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("restrictedStereotype", old, getRestrictedStereotypes(), __arg);
    }
  }

  // ///////////////////////////
  //
  //   Association refCondition(ContextCondition)
  //               / contextPropertyValue(TaggedValue)
  //
  // ///////////////////////////

  Collection _contextPropertyValues = Collections.EMPTY_LIST;
  Collection _contextPropertyValues_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _contextPropertyValue_setMethod = getMethod1(MContextConditionImpl.class, "setContextPropertyValues", Collection.class);
  private final static Method _contextPropertyValue_addMethod = getMethod1(MContextConditionImpl.class, "addContextPropertyValue", MTaggedValue.class);
  private final static Method _contextPropertyValue_removeMethod = getMethod1(MContextConditionImpl.class, "removeContextPropertyValue", MTaggedValue.class);

  /**
   * Gets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @return unmodifyable copy of the current ContextPropertyValues collection
   */
  public Collection getContextPropertyValues() {
    checkExists();
    if (null == _contextPropertyValues_ucopy)
    {
      _contextPropertyValues_ucopy = ucopy(_contextPropertyValues);
    }
    return _contextPropertyValues_ucopy;
  }

  /**
   * Sets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg new collection of ContextPropertyValues or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setContextPropertyValues(Collection __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      final boolean logForUndo = needUndo();
      Collection old = null;
      if (sendEvent || logForUndo)
      {
        old = getContextPropertyValues();
      }
      _contextPropertyValues_ucopy = null;
      Collection __added = bagdiff(__arg,_contextPropertyValues);
      Collection __removed = bagdiff(_contextPropertyValues, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MTaggedValue o = (MTaggedValue)iter3.next();
        o.internalUnrefByRefCondition(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MTaggedValue o = (MTaggedValue)iter4.next();
        o.internalRefByRefCondition(this);
      }
      _contextPropertyValues = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_contextPropertyValue_setMethod, old, getContextPropertyValues());
      }
      if (sendEvent)
      {
        fireBagSet("contextPropertyValue", old, getContextPropertyValues());
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * Adds a link to the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg ContextPropertyValue to be linked to this instance
   */
  public final void addContextPropertyValue(MTaggedValue __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getContextPropertyValues();
      }
      if (null != _contextPropertyValues_ucopy)
      {
        _contextPropertyValues = new ArrayList(_contextPropertyValues);
        _contextPropertyValues_ucopy = null;
      }
      __arg.internalRefByRefCondition(this);
      _contextPropertyValues.add(__arg);
      logBagAdd(_contextPropertyValue_addMethod, _contextPropertyValue_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("contextPropertyValue", old, getContextPropertyValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg ContextPropertyValue to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeContextPropertyValue(MTaggedValue __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getContextPropertyValues();
      }
      if (null != _contextPropertyValues_ucopy)
      {
        _contextPropertyValues = new ArrayList(_contextPropertyValues);
        _contextPropertyValues_ucopy = null;
      }
      if (!_contextPropertyValues.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByRefCondition(this);
      logBagRemove(_contextPropertyValue_removeMethod, _contextPropertyValue_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("contextPropertyValue", old, getContextPropertyValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyValue to be referenced
   */
  public final void internalRefByContextPropertyValue(MTaggedValue __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getContextPropertyValues();
    }
    if (null != _contextPropertyValues_ucopy)
    {
      _contextPropertyValues = new ArrayList(_contextPropertyValues);
      _contextPropertyValues_ucopy = null;
    }
    _contextPropertyValues.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("contextPropertyValue", old, getContextPropertyValues(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyValue to be unreferenced
   */
  public final void internalUnrefByContextPropertyValue(MTaggedValue __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getContextPropertyValues();
    }
    if (null != _contextPropertyValues_ucopy)
    {
      _contextPropertyValues = new ArrayList(_contextPropertyValues);
      _contextPropertyValues_ucopy = null;
    }
    _contextPropertyValues.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("contextPropertyValue", old, getContextPropertyValues(), __arg);
    }
  }

  // ///////////////////////////
  //
  // Association scopedConstraint(ContextbasedConstraint)
  //             / scopeSet(ContextCondition)
  //
  // ///////////////////////////

  Collection _scopedConstraints = Collections.EMPTY_LIST;
  Collection _scopedConstraints_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _scopedConstraint_setMethod = getMethod1(MContextConditionImpl.class, "setScopedConstraints", Collection.class);
  private final static Method _scopedConstraint_addMethod = getMethod1(MContextConditionImpl.class, "addScopedConstraint", MContextbasedConstraint.class);
  private final static Method _scopedConstraint_removeMethod = getMethod1(MContextConditionImpl.class, "removeScopedConstraint", MContextbasedConstraint.class);

  /**
   * Gets all the links of the association scopedConstraint(ContextbasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @return unmodifyable copy of the current ScopedConstraints collection
   */
  public Collection getScopedConstraints() {
    checkExists();
    if (null == _scopedConstraints_ucopy)
    {
      _scopedConstraints_ucopy = ucopy(_scopedConstraints);
    }
    return _scopedConstraints_ucopy;
  }

  /**
   * Sets all the links of the association scopedConstraint(ContextbasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @param __arg new collection of ScopedConstraints or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setScopedConstraints(Collection __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      final boolean logForUndo = needUndo();
      Collection old = null;
      if (sendEvent || logForUndo)
      {
        old = getScopedConstraints();
      }
      _scopedConstraints_ucopy = null;
      Collection __added = bagdiff(__arg,_scopedConstraints);
      Collection __removed = bagdiff(_scopedConstraints, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MContextbasedConstraint o = (MContextbasedConstraint)iter3.next();
        o.internalUnrefByScopeSet(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MContextbasedConstraint o = (MContextbasedConstraint)iter4.next();
        o.internalRefByScopeSet(this);
      }
      _scopedConstraints = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_scopedConstraint_setMethod, old, getScopedConstraints());
      }
      if (sendEvent)
      {
        fireBagSet("scopedConstraint", old, getScopedConstraints());
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * Adds a link to the association scopedConstraint(ContextbasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @param __arg ScopedConstraint to be linked to this instance
   */
  public final void addScopedConstraint(MContextbasedConstraint __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getScopedConstraints();
      }
      if (null != _scopedConstraints_ucopy)
      {
        _scopedConstraints = new ArrayList(_scopedConstraints);
        _scopedConstraints_ucopy = null;
      }
      __arg.internalRefByScopeSet(this);
      _scopedConstraints.add(__arg);
      logBagAdd(_scopedConstraint_addMethod, _scopedConstraint_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("scopedConstraint", old, getScopedConstraints(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association scopedConstraint(ContextbasedConstraint)
   * / scopeSet(ContextCondition).
   *
   * @param __arg ScopedConstraint to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeScopedConstraint(MContextbasedConstraint __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getScopedConstraints();
      }
      if (null != _scopedConstraints_ucopy)
      {
        _scopedConstraints = new ArrayList(_scopedConstraints);
        _scopedConstraints_ucopy = null;
      }
      if (!_scopedConstraints.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByScopeSet(this);
      logBagRemove(_scopedConstraint_removeMethod, _scopedConstraint_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("scopedConstraint", old, getScopedConstraints(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * internal use only - should never be called directly.
   * @param __arg ScopedConstraint to be referenced
   */
  public final void internalRefByScopedConstraint(MContextbasedConstraint __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getScopedConstraints();
    }
    if (null != _scopedConstraints_ucopy)
    {
      _scopedConstraints = new ArrayList(_scopedConstraints);
      _scopedConstraints_ucopy = null;
    }
    _scopedConstraints.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("scopedConstraint", old, getScopedConstraints(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ScopedConstraint to be unreferenced
   */
  public final void internalUnrefByScopedConstraint(MContextbasedConstraint __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getScopedConstraints();
    }
    if (null != _scopedConstraints_ucopy)
    {
      _scopedConstraints = new ArrayList(_scopedConstraints);
      _scopedConstraints_ucopy = null;
    }
    _scopedConstraints.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("scopedConstraint", old, getScopedConstraints(), __arg);
    }
  }
  // ///////////////////////////
  //
  // association constrainedSet(ContextCondition)
  //             / contextbasedConstraint(ContextbasedConstraint)
  //
  // ///////////////////////////

  Collection _contextbasedConstraints = Collections.EMPTY_LIST;
  Collection _contextbasedConstraints_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _contextbasedConstraint_setMethod = getMethod1(MContextConditionImpl.class, "setContextbasedConstraints", Collection.class);
  private final static Method _contextbasedConstraint_addMethod = getMethod1(MContextConditionImpl.class, "addContextbasedConstraint", MContextbasedConstraint.class);
  private final static Method _contextbasedConstraint_removeMethod = getMethod1(MContextConditionImpl.class, "removeContextbasedConstraint", MContextbasedConstraint.class);

  /**
   * Gets all the links of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @return unmodifyable copy of the current ContextbasedConstraints collection
   */
  public Collection getContextbasedConstraints() {
    checkExists();
    if (null == _contextbasedConstraints_ucopy)
    {
      _contextbasedConstraints_ucopy = ucopy(_contextbasedConstraints);
    }
    return _contextbasedConstraints_ucopy;
  }

  /**
   * Sets all the links of the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg new collection of ContextbasedConstraints or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setContextbasedConstraints(Collection __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      final boolean logForUndo = needUndo();
      Collection old = null;
      if (sendEvent || logForUndo)
      {
        old = getContextbasedConstraints();
      }
      _contextbasedConstraints_ucopy = null;
      Collection __added = bagdiff(__arg,_contextbasedConstraints);
      Collection __removed = bagdiff(_contextbasedConstraints, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MContextbasedConstraint o = (MContextbasedConstraint)iter3.next();
        o.internalUnrefByConstrainedSet(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MContextbasedConstraint o = (MContextbasedConstraint)iter4.next();
        o.internalRefByConstrainedSet(this);
      }
      _contextbasedConstraints = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_contextbasedConstraint_setMethod, old, getContextbasedConstraints());
      }
      if (sendEvent)
      {
        fireBagSet("contextbasedConstraint", old, getContextbasedConstraints());
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * Adds a link to the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg ContextbasedConstraint to be linked to this instance
   */
  public final void addContextbasedConstraint(MContextbasedConstraint __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getContextbasedConstraints();
      }
      if (null != _contextbasedConstraints_ucopy)
      {
        _contextbasedConstraints = new ArrayList(_contextbasedConstraints);
        _contextbasedConstraints_ucopy = null;
      }
      __arg.internalRefByConstrainedSet(this);
      _contextbasedConstraints.add(__arg);
      logBagAdd(_contextbasedConstraint_addMethod, _contextbasedConstraint_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("contextbasedConstraint", old, getContextbasedConstraints(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association constrainedSet(ContextCondition)
   * / contextbasedConstraint(ContextbasedConstraint).
   *
   * @param __arg ContextbasedConstraint to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeContextbasedConstraint(MContextbasedConstraint __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      if (__arg == null)
      {
        throw new NullPointerException();
      }
      final boolean sendEvent = needEvent();
      Collection old = null;
      if (sendEvent)
      {
        old = getContextbasedConstraints();
      }
      if (null != _contextbasedConstraints_ucopy)
      {
        _contextbasedConstraints = new ArrayList(_contextbasedConstraints);
        _contextbasedConstraints_ucopy = null;
      }
      if (!_contextbasedConstraints.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByConstrainedSet(this);
      logBagRemove(_contextbasedConstraint_removeMethod, _contextbasedConstraint_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("contextbasedConstraint", old, getContextbasedConstraints(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * internal use only - should never be called directly.
   * @param __arg ContextbasedConstraint to be referenced
   */
  public final void internalRefByContextbasedConstraint(MContextbasedConstraint __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getContextbasedConstraints();
    }
    if (null != _contextbasedConstraints_ucopy)
    {
      _contextbasedConstraints = new ArrayList(_contextbasedConstraints);
      _contextbasedConstraints_ucopy = null;
    }
    _contextbasedConstraints.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("contextbasedConstraint", old, getContextbasedConstraints(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextbasedConstraint to be unreferenced
   */
  public final void internalUnrefByContextbasedConstraint(MContextbasedConstraint __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getContextbasedConstraints();
    }
    if (null != _contextbasedConstraints_ucopy)
    {
      _contextbasedConstraints = new ArrayList(_contextbasedConstraints);
      _contextbasedConstraints_ucopy = null;
    }
    _contextbasedConstraints.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("contextbasedConstraint", old, getContextbasedConstraints(), __arg);
    }
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
    if ("query".equals(feature))
    {
      return getQuery();
    }
    if ("range".equals(feature))
    {
      return getRange();
    }
    if ("restrictedStereotype".equals(feature))
    {
      return getRestrictedStereotypes();
    }
    if ("contextPropertyValue".equals(feature))
    {
      return getContextPropertyValues();
    }
    if ("scopedConstraint".equals(feature))
    {
      return getScopedConstraints();
    }
    if ("contextbasedConstraint".equals(feature))
    {
      return getContextbasedConstraints();
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
    if ("query".equals(feature))
    {
      setQuery((MBooleanExpression)obj);
      return;
    }
    if ("range".equals(feature))
    {
      setRange((MMultiplicity)obj);
      return;
    }
    if ("restrictedStereotype".equals(feature))
    {
      setRestrictedStereotypes((Collection)obj);
      return;
    }
    if ("contextPropertyValue".equals(feature))
    {
      setContextPropertyValues((Collection)obj);
      return;
    }
    if ("scopedConstraint".equals(feature))
    {
      setScopedConstraints((Collection)obj);
      return;
    }
    if ("contextbasedConstraint".equals(feature))
    {
      setContextbasedConstraints((Collection)obj);
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
    if ("restrictedStereotype".equals(feature))
    {
      addRestrictedStereotype((MStereotype)obj);
      return;
    }
    if ("contextPropertyValue".equals(feature))
    {
      addContextPropertyValue((MTaggedValue)obj);
      return;
    }
    if ("scopedConstraint".equals(feature))
    {
      addScopedConstraint((MContextbasedConstraint)obj);
      return;
    }
    if ("contextbasedConstraint".equals(feature))
    {
      addContextbasedConstraint((MContextbasedConstraint)obj);
      return;
    }
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
    if ("restrictedStereotype".equals(feature))
    {
      removeRestrictedStereotype((MStereotype)obj);
      return;
    }
    if ("contextPropertyValue".equals(feature))
    {
      removeContextPropertyValue((MTaggedValue)obj);
      return;
    }
    if ("scopedConstraint".equals(feature))
    {
      removeScopedConstraint((MContextbasedConstraint)obj);
      return;
    }
    if ("contextbasedConstraint".equals(feature))
    {
      removeContextbasedConstraint((MContextbasedConstraint)obj);
      return;
    }
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
    // opposite role: restrictedStereotype this role: restriction
    if (_restrictedStereotypes.size() != 0)
    {
      setRestrictedStereotypes(Collections.EMPTY_LIST);
    }
    // opposite role: contextPropertyValue this role: refCondition
    if (_contextPropertyValues.size() != 0)
    {
      setContextPropertyValues(Collections.EMPTY_LIST);
    }
    // opposite role: scopedConstraint this role: scopeSet
    if (_scopedConstraints.size() != 0)
    {
      setScopedConstraints(Collections.EMPTY_LIST);
    }
    // opposite role: contextbasedConstraint this role: constrainedSet
    if (_contextbasedConstraints.size() != 0)
    {
      setContextbasedConstraints(Collections.EMPTY_LIST);
    }
    super.cleanup(scheduledForRemove);
  }

  /**
   * Gets the UML metaclass name of the instance.
   *
   * @return the metaclass name "ContextCondition"
   */
  public String getUMLClassName()
  {
    return "ContextCondition";
  }

}
