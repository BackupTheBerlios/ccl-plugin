package ru.novosoft.uml.foundation.extension_mechanisms;

import ru.novosoft.uml.foundation.core.MModelElementImpl;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.cocons.uml.*;

import java.util.*;
import java.lang.reflect.Method;

/**
 * Java implementation of the UML TagDefinition metaclass
 * Includes support for a subset of the UML 1.4 specification as well as the
 * CCL specification.
 * @author Martin Skinner
 * @version 1.0
 */
public class MTagDefinitionImpl extends MModelElementImpl
                                implements MTagDefinition {
  /**
   * Constructs a new TagDefinition instance.
   * Should never be referenced directly, only through the interface. <br>
   * <br>
   * MTagDefinition td = new MTagDefinitionImpl();
   *
   */
  public MTagDefinitionImpl() {
  }

  // ///////////////////////////
  //
  //   Attribute tagType
  //
  // ///////////////////////////
  private final static Method _tagType_setMethod = getMethod1(MTagDefinitionImpl.class, "setTagType", String.class);
  String _tagType;
  /**
   * Gets the value of the attribute TagType.
   *
   * @return current value of the TagType attribute
   */
  public final String getTagType()
  {
    checkExists();
    return _tagType;
  }
  /**
   * Sets the value of the attribute TagType.
   *
   * @param __arg value to set the TagType to.
   */
  public final void setTagType(String __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_tagType_setMethod, _tagType, __arg);
      fireAttrSet("tagType", _tagType, __arg);
      _tagType = __arg;
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  //   Attribute Multiplicity
  //
  // ///////////////////////////
  private final static Method _multiplicity_setMethod = getMethod1(MTagDefinitionImpl.class, "setMultiplicity", MMultiplicity.class);
  MMultiplicity _multiplicity;
  /**
   * Gets the value of the attribute Multiplicity.
   *
   * @return current value of the Multiplicity attribute
   */
  public final MMultiplicity getMultiplicity()
  {
    checkExists();
    return _multiplicity;
  }
  /**
   * Sets the value of the attribute Multiplicity.
   *
   * @param __arg value to set the Multiplicity to. May be one of the
   *              predefined Multiplicity constants.
   * @see MMultiplicity
   */
  public final void setMultiplicity(MMultiplicity __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_multiplicity_setMethod, _multiplicity, __arg);
      fireAttrSet("multiplicity", _multiplicity, __arg);
      _multiplicity = __arg;
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  //   Association: type(TagDefinition) /
  //                typedValue(TaggedValue)
  //
  // ///////////////////////////
  private final static Method _typedValues_setMethod = getMethod1(MTagDefinitionImpl.class, "setTypedValues", Collection.class);
  private final static Method _typedValues_addMethod = getMethod1(MTagDefinitionImpl.class, "addTypedValue", MTaggedValue.class);
  private final static Method _typedValues_removeMethod = getMethod1(MTagDefinitionImpl.class, "removeTypedValue", MTaggedValue.class);
  Collection _typedValues = Collections.EMPTY_LIST;
  Collection _typedValues_ucopy = Collections.EMPTY_LIST;
  /**
   * Gets all the links of the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @return unmodifyable copy of the current TypedValues collection
   */
  public final Collection getTypedValues()
  {
    checkExists();
    if (null == _typedValues_ucopy)
    {
      _typedValues_ucopy = ucopy(_typedValues);
    }
    return _typedValues_ucopy;
  }
  /**
   * Sets all the links of the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @param __arg new collection of TypedValues or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public final void setTypedValues(Collection __arg)
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
        old = getTypedValues();
      }
      _typedValues_ucopy = null;
      Collection __added = bagdiff(__arg,_typedValues);
      Collection __removed = bagdiff(_typedValues, __arg);
      Iterator iter33 = __removed.iterator();
      while (iter33.hasNext())
      {
        MTaggedValue o = (MTaggedValue)iter33.next();
        o.internalUnrefByType(this);
      }
      Iterator iter34 = __added.iterator();
      while (iter34.hasNext())
      {
        MTaggedValue o = (MTaggedValue)iter34.next();
        o.internalRefByType(this);
      }
      _typedValues = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_typedValues_setMethod, old, getTypedValues());
      }
      if (sendEvent)
      {
        fireBagSet("typedValue", old, getTypedValues());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Adds a link to the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @param __arg TypedValue to be linked to this instance
   */
  public final void addTypedValue(MTaggedValue __arg)
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
        old = getTypedValues();
      }
      if (null != _typedValues_ucopy)
      {
        _typedValues = new ArrayList(_typedValues);
        _typedValues_ucopy = null;
      }
      __arg.internalRefByType(this);
      _typedValues.add(__arg);
      logBagAdd(_typedValues_addMethod, _typedValues_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("typedValue", old, getTypedValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association type(TagDefinition)
   * / typedValue(TaggedValue).
   *
   * @param __arg TypedValue to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeTypedValue(MTaggedValue __arg)
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
        old = getTypedValues();
      }
      if (null != _typedValues_ucopy)
      {
        _typedValues = new ArrayList(_typedValues);
        _typedValues_ucopy = null;
      }
      if (!_typedValues.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByType(this);
      logBagRemove(_typedValues_removeMethod, _typedValues_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("typedValue", old, getTypedValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg TypedValue to be referenced
   */
  public final void internalRefByTypedValue(MTaggedValue __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getTypedValues();
    }
    if (null != _typedValues_ucopy)
    {
      _typedValues = new ArrayList(_typedValues);
      _typedValues_ucopy = null;
    }
    _typedValues.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("typedValue", old, getTypedValues(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg DefinedTag to be unreferenced
   */
  public final void internalUnrefByTypedValue(MTaggedValue __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getTypedValues();
    }
    if (null != _typedValues_ucopy)
    {
      _typedValues = new ArrayList(_typedValues);
      _typedValues_ucopy = null;
    }
    _typedValues.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("typedValue", old, getTypedValues(), __arg);
    }
  }

  // ///////////////////////////
  //
  //   Association: owner(Stereotype) /
  //                definedTag(TagDefinition)
  //
  // ///////////////////////////
  // Static Methods
  private final static Method _owner_setMethod = getMethod1(MTagDefinitionImpl.class, "setOwner", MStereotype.class);

  MStereotype _owner;
  /**
   * Gets the link of the association owner(Stereotype)
   * / definedTag(TagDefinition).
   *
   * @return current owner of the instance
   */
  public final MStereotype getOwner()
  {
    checkExists();
    return _owner;
  }
  /**
   * Sets the link of the association owner(Stereotype)
   * / definedTag(TagDefinition).
   *
   * @param __arg new owner of the instance
   */
  public final void setOwner(MStereotype __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MStereotype __saved = _owner;
      if (_owner != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByDefinedTag(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByDefinedTag(this);
        }
        logRefSet(_owner_setMethod, __saved, __arg);
        fireRefSet("owner", __saved, __arg);
        _owner = __arg;
        setModelElementContainer(_owner, "owner");
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg Owner to be referenced
   */
  public final void internalRefByOwner(MStereotype __arg)
  {
    MStereotype __saved = _owner;
    if (_owner != null)
    {
      _owner.removeDefinedTag(this);
    }
    fireRefSet("owner", __saved, __arg);
    _owner = __arg;
    setModelElementContainer(_owner, "owner");
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg Owner to be unreferenced
   */
  public final void internalUnrefByOwner(MStereotype __arg)
  {
    fireRefSet("owner", _owner, null);
    _owner = null;
    setModelElementContainer(_owner, null);
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
    if ("tagType".equals(feature))
    {
      return getTagType();
    }
    if ("multiplicity".equals(feature))
    {
      return getMultiplicity();
    }
    if ("typedValue".equals(feature))
    {
      return getTypedValues();
    }
    if ("owner".equals(feature))
    {
      return getOwner();
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
    if ("tagType".equals(feature))
    {
      setTagType((String)obj);
      return;
    }
    if ("multiplicity".equals(feature))
    {
      setMultiplicity((MMultiplicity)obj);
      return;
    }
    if ("typedValue".equals(feature))
    {
      setTypedValues((Collection)obj);
      return;
    }
    if ("owner".equals(feature))
    {
      setOwner((MStereotype)obj);
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
    if ("typedValue".equals(feature))
    {
      addTypedValue((MTaggedValue)obj);
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
    if ("typedValue".equals(feature))
    {
      removeTypedValue((MTaggedValue)obj);
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
    // opposite role: typedValue this role: type
    if (_typedValues.size() != 0)
    {
      setTypedValues(Collections.EMPTY_LIST);
    }
    super.cleanup(scheduledForRemove);
  }

  /**
   * Gets the UML metaclass name of the instance.
   *
   * @return the metaclass name "TagDefinition"
   */
  public String getUMLClassName()
  {
    return "TagDefinition";
  }

}