package org.cocons.uml.ccl;

import java.util.*;
import java.lang.reflect.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.core.*;
import org.cocons.uml.*;

/**
 * Java implementation of the CCL ContextPropertyTag metaclass.
 *
 * @author Martin Skinner
 * @version 1.0
 */

public class MContextPropertyTagImpl extends MTagDefinitionImpl
                                     implements MContextPropertyTag {

  public MContextPropertyTagImpl() {
  }

  // ///////////////////////////
  //
  // Association valueValidation(Constraint)
  //             / contextPropertyTag(ContextPropertyTag)
  //
  // ///////////////////////////
  // Static Methods
  private final static Method _valueValidation_setMethod = getMethod1(MContextPropertyTagImpl.class, "setValueValidation", MConstraint.class);

  MConstraint _valueValidation;
  /**
   * Gets the link of the association valueValidation(Constraint)
   * / contextPropertyTag(ContextPropertyTag).
   *
   * @return current ValueValidation of the instance
   */
  public final MConstraint getValueValidation()
  {
    checkExists();
    return _valueValidation;
  }
  /**
   * Sets the link of the association valueValidation(Constraint)
   * / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg new ValueValidation of the instance
   */
  public final void setValueValidation(MConstraint __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MConstraint __saved = _valueValidation;
      if (_valueValidation != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByContextPropertyTag(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByContextPropertyTag(this);
        }
        logRefSet(_valueValidation_setMethod, __saved, __arg);
        fireRefSet("valueValidation", __saved, __arg);
        _valueValidation = __arg;
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ValueValidation to be referenced
   */
  public final void internalRefByValueValidation(MConstraint __arg)
  {
    MConstraint __saved = _valueValidation;
    if (_valueValidation != null)
    {
      _valueValidation.removeContextPropertyTag(this);
    }
    fireRefSet("valueValidation", __saved, __arg);
    _valueValidation = (MConstraint)__arg;
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ValueValidation to be unreferenced
   */
  public final void internalUnrefByValueValidation(MConstraint __arg)
  {
    fireRefSet("valueValidation", _valueValidation, null);
    _valueValidation = null;
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
    if ("valueValidation".equals(feature))
    {
      return getValueValidation();
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
    if ("valueValidation".equals(feature))
    {
      setValueValidation((MConstraint)obj);
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
    // opposite role: valueValidation this role: contextPropertyTag
    if (_valueValidation != null )
    {
      setValueValidation(null);
    }
    super.cleanup(scheduledForRemove);
  }

  /**
   * Gets the UML metaclass name of the instance.
   *
   * @return the metaclass name "ContextPropertyTag"
   */
  public String getUMLClassName()
  {
    return "ContextPropertyTag";
  }

}