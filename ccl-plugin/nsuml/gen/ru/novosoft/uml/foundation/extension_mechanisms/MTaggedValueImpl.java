/* Novosoft UML API for Java. Version 0.4.19
 * Copyright (C) 1999, 2000, NovoSoft.
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Library General Public
 * License as published by the Free Software Foundation; either
 * version 2 of the License, or (at your option) any later version.
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Library General Public License for more details.
 *
 * You should have received a copy of the GNU Library General Public
 * License along with this library; if not, write to the
 * Free Software Foundation, Inc., 59 Temple Place - Suite 330,
 * Boston, MA  02111-1307, USA. The text of license can be also found
 * at http://www.gnu.org/copyleft/lgpl.html
 */

package ru.novosoft.uml.foundation.extension_mechanisms;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.use_cases.*;
import ru.novosoft.uml.behavior.state_machines.*;
import ru.novosoft.uml.behavior.activity_graphs.*;
import ru.novosoft.uml.model_management.*;

import org.cocons.uml.ccl.*;

import java.lang.reflect.Method;

public class MTaggedValueImpl extends MModelElementImpl implements MTaggedValue
{
  // ------------ code for class TaggedValue -----------------
  /**
   * @deprecated  No longer available in UML 1.4
   */
  public final String getValue()
  {
    MTagDefinition td = getType();
    if (td == null)
      return null;
    else if (td.getTagType() != "UML::DataTypes::String" || td.getOwner()!=null)
        throw new java.lang.RuntimeException ("can't modify non-String TaggedValue with UML1.3 methods.");
    else if (!td.getMultiplicity().equals(MMultiplicity.M1_1))
      return null;
    if (this.getDataValues().size() != 1)
      return null;
    return (String)(this.getDataValues().toArray()[0]);
  }
  private MNamespace getNamespaceOfContainer()
  {
    // get the container
    MModelElement m = this.getModelElementContainer();
    if (this.getModelElementContainer() == null)
      throw new java.lang.RuntimeException ("tagged value has no container!.");
    // get the container of the container
    m = m.getModelElementContainer();
    // if it is not a namespace, keep going up
    while ((m!=null) && !(m instanceof MNamespace))
      m = m.getModelElementContainer();
    if (m==null)
      return null;
    else
      return (MNamespace)m;
  }

  /**
   * @deprecated  No longer available in UML 1.4
   */
  public final void setValue(String __arg)
  {
    MTagDefinition td = getType();
    if (td == null)
    {
      // create a UML1.3 compatability TagDefinition
      td = new MTagDefinitionImpl();
      td.setNamespace(this.getNamespaceOfContainer());
      td.setTagType("UML::DataTypes::String");
      td.setMultiplicity(MMultiplicity.M1_1);
      this.setType(td);
    }
    else
    {
      if (!td.getTagType().equals("UML::DataTypes::String"))
        throw new java.lang.RuntimeException ("can't modify non-String TaggedValue with UML1.3 methods.");
      if (!td.getMultiplicity().equals(MMultiplicity.M1_1))
        throw new java.lang.RuntimeException ("can't modify a multiple-value TaggedValue with UML1.3 methods.");
    }
    this.setDataValues(Collections.EMPTY_LIST);
    this.addDataValue(__arg);
  }
  /**
   * @deprecated  No longer available in UML 1.4
   */
  public final String getTag()
  {
    MTagDefinition td = getType();
    if (td == null)
      return null;
    else if (td.getTagType() != "UML::DataTypes::String" || td.getOwner()!=null)
        throw new java.lang.RuntimeException ("can't modify non-String TaggedValue with UML1.3 methods.");
    else if (!td.getMultiplicity().equals(MMultiplicity.M1_1))
      return null;
    return td.getName();
  }

  /**
   * @deprecated  No longer available in UML 1.4
   */
  public final void setTag(String __arg)
  {
    MTagDefinition td = getType();
    if (td == null)
    {
      // create a UML1.3 compatability TagDefinition
      td = new MTagDefinitionImpl();
      td.setNamespace(this.getNamespaceOfContainer());
      td.setTagType("UML::DataTypes::String");
      td.setMultiplicity(MMultiplicity.M1_1);
      this.setType(td);
    }
    else
    {
      if (td.getTagType() != "UML::DataTypes::String")
        throw new java.lang.RuntimeException ("can't modify non-String TaggedValue with UML1.3 methods.");
      if (!td.getMultiplicity().equals(MMultiplicity.M1_1))
        throw new java.lang.RuntimeException ("can't modify a multiple-value TaggedValue with UML1.3 methods.");
      if (td.getOwner()!=null)
        throw new java.lang.RuntimeException ("can't modify a stereotype TaggedValue with UML1.3 methods.");
    }
    td.setName(__arg);
  }

  private final static Method _modelElement_setMethod = getMethod1(MTaggedValueImpl.class, "setModelElement", MModelElement.class);
  MModelElement _modelElement;
  public final MModelElement getModelElement()
  {
    checkExists();
    return _modelElement;
  }
  public final void setModelElement(MModelElement __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MModelElement __saved = _modelElement;
      if (_modelElement != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByTaggedValue(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByTaggedValue(this);
        }
        logRefSet(_modelElement_setMethod, __saved, __arg);
        fireRefSet("modelElement", __saved, __arg);
        _modelElement = __arg;
        this.setModelElementContainer(_modelElement, "modelElement");
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefByModelElement(MModelElement __arg)
  {
    MModelElement __saved = _modelElement;
    if (_modelElement != null)
    {
      _modelElement.removeTaggedValue(this);
    }
    fireRefSet("modelElement", __saved, __arg);
    _modelElement = __arg;
    this.setModelElementContainer(_modelElement, "modelElement");
  }
  public final void internalUnrefByModelElement(MModelElement __arg)
  {
    fireRefSet("modelElement", _modelElement, null);
    _modelElement = null;
    this.setModelElementContainer(null, null);
  }

  // ///////////////////////////
  //
  //   UML 1.4 Compatibility
  //   Attribute dataValue[*]
  //
  // ///////////////////////////
  Collection _dataValues = Collections.EMPTY_LIST;       // working copy
  Collection _dataValues_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _dataValue_setMethod = getMethod1(MTaggedValueImpl.class, "setDataValues", Collection.class);
  private final static Method _dataValue_addMethod = getMethod1(MTaggedValueImpl.class, "addDataValue", String.class);
  private final static Method _dataValue_removeMethod = getMethod1(MTaggedValueImpl.class, "removeDataValue", String.class);
  /**
   * Gets all current values of the attribute DataValue.
   *
   * @return unmodifyable copy of the current DataValues collection
   */
  public final Collection getDataValues() {
    checkExists();
    if (null == _dataValues_ucopy)
    {
      _dataValues_ucopy = ucopy(_dataValues);
    }
    return _dataValues_ucopy;
  }
  /**
   * Sets all values of the attribute DataValue.
   *
   * @param __arg new collection of DataValues or Collections.EMPTY_LIST to
   *        remove all BaseClasses.
   */
  public final void setDataValues(Collection __arg)
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
        old = getDataValues();
      }
      _dataValues_ucopy = null;
      _dataValues = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_dataValue_setMethod, old, getDataValues());
      }
      if (sendEvent)
      {
        fireBagSet("dataValue", old, getDataValues());
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * Adds a value to the attribute DataValue.
   *
   * @param __arg DataValue to be added to this instance
   */
  public void addDataValue(String __arg)
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
        old = getDataValues();
      }
      if (null != _dataValues_ucopy)
      {
        _dataValues = new ArrayList(_dataValues);
        _dataValues_ucopy = null;
      }
      _dataValues.add(__arg);
      logBagAdd(_dataValue_addMethod, _dataValue_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("dataValue", old, getDataValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  /**
   * Removes a value from the attribute DataValue.
   *
   * @param __arg DataValue to be removed from this instance
   * @throws RuntimeException when __arg is not a DataValue of this instance
   */
  public void removeDataValue(String __arg)
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
        old = getDataValues();
      }
      if (null != _dataValues_ucopy)
      {
        _dataValues = new ArrayList(_dataValues);
        _dataValues_ucopy = null;
      }
      if (!_dataValues.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      logBagRemove(_dataValue_removeMethod, _dataValue_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("dataValue", old, getDataValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  //   Association referenceValue(ModelElement)/referenceTag(taggedValue)
  //
  // ///////////////////////////

  Collection _referenceValues = Collections.EMPTY_LIST;
  Collection _referenceValues_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _referenceValue_setMethod = getMethod1(MTaggedValueImpl.class, "setReferenceValues", Collection.class);
  private final static Method _referenceValue_addMethod = getMethod1(MTaggedValueImpl.class, "addReferenceValue", MModelElement.class);
  private final static Method _referenceValue_removeMethod = getMethod1(MTaggedValueImpl.class, "removeReferenceValue", MModelElement.class);

  /**
   * Gets all links of the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @return unmodifyable copy of the current ReferenceValues collection
   */
  public Collection getReferenceValues() {
    checkExists();
    if (null == _referenceValues_ucopy)
    {
      _referenceValues_ucopy = ucopy(_referenceValues);
    }
    return _referenceValues_ucopy;
  }

  /**
   * Sets all links of the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @param __arg new collection of ReferenceValues or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setReferenceValues(Collection __arg)
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
        old = getReferenceValues();
      }
      _referenceValues_ucopy = null;
      Collection __added = bagdiff(__arg,_referenceValues);
      Collection __removed = bagdiff(_referenceValues, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MModelElement o = (MModelElement)iter3.next();
        o.internalUnrefByReferenceTag(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MModelElement o = (MModelElement)iter4.next();
        o.internalRefByReferenceTag(this);
      }
      _referenceValues = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_referenceValue_setMethod, old, getReferenceValues());
      }
      if (sendEvent)
      {
        fireBagSet("referenceValue", old, getReferenceValues());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Adds a link to the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @param __arg ReferenceValue to be linked to this instance
   */
  public final void addReferenceValue(MModelElement __arg)
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
        old = getReferenceValues();
      }
      if (null != _referenceValues_ucopy)
      {
        _referenceValues = new ArrayList(_referenceValues);
        _referenceValues_ucopy = null;
      }
      __arg.internalRefByReferenceTag(this);
      _referenceValues.add(__arg);
      logBagAdd(_referenceValue_addMethod, _referenceValue_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("referenceValue", old, getReferenceValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @param __arg ReferenceValue to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeReferenceValue(MModelElement __arg)
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
        old = getReferenceValues();
      }
      if (null != _referenceValues_ucopy)
      {
        _referenceValues = new ArrayList(_referenceValues);
        _referenceValues_ucopy = null;
      }
      if (!_referenceValues.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByReferenceTag(this);
      logBagRemove(_referenceValue_removeMethod, _referenceValue_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("referenceValue", old, getReferenceValues(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ReferenceValue to be referenced
   */
  public final void internalRefByReferenceValue(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getReferenceValues();
    }
    if (null != _referenceValues_ucopy)
    {
      _referenceValues = new ArrayList(_referenceValues);
      _referenceValues_ucopy = null;
    }
    _referenceValues.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("referenceValue", old, getReferenceValues(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ReferenceValue to be unreferenced
   */
  public final void internalUnrefByReferenceValue(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getReferenceValues();
    }
    if (null != _referenceValues_ucopy)
    {
      _referenceValues = new ArrayList(_referenceValues);
      _referenceValues_ucopy = null;
    }
    _referenceValues.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("referenceValue", old, getReferenceValues(), __arg);
    }
  }

  // ///////////////////////////
  //
  //   Association: type(TagDefinition) /
  //                typedValue(TaggedValue)
  //
  // ///////////////////////////
  // Static Methods
  private final static Method _type_setMethod = getMethod1(MTaggedValueImpl.class, "setType", MTagDefinition.class);

  MTagDefinition _type;
  /**
   * Gets the link of the association type(TagDefinition)
   * / typedValue(TaggedValue)
   *
   * @return current Type of the instance
   */
  public final MTagDefinition getType()
  {
    checkExists();
    return _type;
  }
  /**
   * Sets the link of the association type(TagDefinition)
   * / typedValue(TaggedValue)
   *
   * @param __arg new Type of the instance
   */
  public final void setType(MTagDefinition __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MTagDefinition __saved = _type;
      if (_type != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByTypedValue(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByTypedValue(this);
        }
        logRefSet(_type_setMethod, __saved, __arg);
        fireRefSet("type", __saved, __arg);
        _type = __arg;
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg Type to be referenced
   */
  public final void internalRefByType(MTagDefinition __arg)
  {
    MTagDefinition __saved = _type;
    if (_type != null)
    {
      _type.removeTypedValue(this);
    }
    fireRefSet("type", __saved, __arg);
    _type = __arg;
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg Type to be unreferenced
   */
  public final void internalUnrefByType(MTagDefinition __arg)
  {
    fireRefSet("type", _type, null);
    _type = null;
  }

  // ///////////////////////////
  //
  // association contextPropertyValue(TaggedValue)
  //             / refCondition(ContextCondition)
  //
  // ///////////////////////////

  Collection _refConditions = Collections.EMPTY_LIST;
  Collection _refConditions_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _refCondition_setMethod = getMethod1(MTaggedValueImpl.class, "setRefConditions", Collection.class);
  private final static Method _refCondition_addMethod = getMethod1(MTaggedValueImpl.class, "addRefCondition", MContextCondition.class);
  private final static Method _refCondition_removeMethod = getMethod1(MTaggedValueImpl.class, "removeRefCondition", MContextCondition.class);

  /**
   * Gets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @return unmodifyable copy of the current RefConditions collection
   */
  public Collection getRefConditions()
  {
    checkExists();
    if (null == _refConditions_ucopy)
    {
      _refConditions_ucopy = ucopy(_refConditions);
    }
    return _refConditions_ucopy;
  }

  /**
   * Sets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg new collection of RefConditions or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setRefConditions(Collection __arg)
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
        old = getRefConditions();
      }
      _refConditions_ucopy = null;
      Collection __added = bagdiff(__arg,_refConditions);
      Collection __removed = bagdiff(_refConditions, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MContextCondition o = (MContextCondition)iter3.next();
        o.internalUnrefByContextPropertyValue(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MContextCondition o = (MContextCondition)iter4.next();
        o.internalRefByContextPropertyValue(this);
      }
      _refConditions = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_refCondition_setMethod, old, getRefConditions());
      }
      if (sendEvent)
      {
        fireBagSet("refCondition", old, getRefConditions());
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
   * @param __arg RefCondition to be linked to this instance
   */
  public final void addRefCondition(MContextCondition __arg)
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
        old = getRefConditions();
      }
      if (null != _refConditions_ucopy)
      {
        _refConditions = new ArrayList(_refConditions);
        _refConditions_ucopy = null;
      }
      __arg.internalRefByContextPropertyValue(this);
      _refConditions.add(__arg);
      logBagAdd(_refCondition_addMethod, _refCondition_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("refCondition", old, getRefConditions(), __arg);
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
   * @param __arg RefCondition to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeRefCondition(MContextCondition __arg)
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
        old = getRefConditions();
      }
      if (null != _refConditions_ucopy)
      {
        _refConditions = new ArrayList(_refConditions);
        _refConditions_ucopy = null;
      }
      if (!_refConditions.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByContextPropertyValue(this);
      logBagRemove(_refCondition_removeMethod, _refCondition_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("refCondition", old, getRefConditions(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg RefCondition to be referenced
   */
  public final void internalRefByRefCondition(MContextCondition __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRefConditions();
    }
    if (null != _refConditions_ucopy)
    {
      _refConditions = new ArrayList(_refConditions);
      _refConditions_ucopy = null;
    }
    _refConditions.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("refCondition", old, getRefConditions(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg RefCondition to be unreferenced
   */
  public final void internalUnrefByRefCondition(MContextCondition __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRefConditions();
    }
    if (null != _refConditions_ucopy)
    {
      _refConditions = new ArrayList(_refConditions);
      _refConditions_ucopy = null;
    }
    _refConditions.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("refCondition", old, getRefConditions(), __arg);
    }
  }

  protected void cleanup(Collection scheduledForRemove)
  {
    // attribute: dataValue
    if (_dataValues.size()  != 0 )
    {
      setDataValues(Collections.EMPTY_LIST);
    }
    // opposite role: modelElement this role: taggedValue
    if (_modelElement != null )
    {
      setModelElement(null);
    }
    // opposite role: type this role: typedValue
    if (_type != null )
    {
      setType(null);
    }
    // opposite role: referenceValue this role:referenceTag
    if (_referenceValues.size() != 0)
    {
      setReferenceValues(Collections.EMPTY_LIST);
    }
    // opposite role: refCondition this role: contextPropertyValue
    if (_refConditions.size() != 0 )
    {
      setRefConditions(Collections.EMPTY_LIST);
    }

    super.cleanup(scheduledForRemove);
  }

  public String getUMLClassName()
  {
    return "TaggedValue";
  }

  // Reflective API

  public Object reflectiveGetValue(String feature)
  {
    if ("dataValue".equals(feature))
    {
      return getDataValues();
    }
    if ("referenceValue".equals(feature))
    {
      return getReferenceValues();
    }
    if ("modelElement".equals(feature))
    {
      return getModelElement();
    }

    if ("type".equals(feature))
    {
      return getType();
    }
    if ("refCondition".equals(feature))
    {
      return getRefConditions();
    }
    return super.reflectiveGetValue(feature);
  }

  public void reflectiveSetValue(String feature, Object obj)
  {
    if ("dataValue".equals(feature))
    {
      setDataValues((Collection) obj);
      return;
    }
    if ("referenceValue".equals(feature))
    {
      setReferenceValues((Collection)obj);
      return;
    }
    if ("modelElement".equals(feature))
    {
      setModelElement((MModelElement) obj);
      return;
    }
    if ("type".equals(feature))
    {
      setType((MTagDefinition) obj);
      return;
    }
    if ("refCondition".equals(feature))
    {
      setRefConditions((Collection) obj);
      return;
    }
    super.reflectiveSetValue(feature, obj);
  }

  public void reflectiveAddValue(String feature, Object obj)
  {
    if ("dataValue".equals(feature))
    {
      addDataValue((String) obj);
      return;
    }
    if ("referenceValue".equals(feature))
    {
      addReferenceValue((MModelElement) obj);
      return;
    }
    if ("refCondition".equals(feature))
    {
      addRefCondition((MContextCondition) obj);
      return;
    }

    super.reflectiveAddValue(feature, obj);
  }

  public void reflectiveRemoveValue(String feature, Object obj)
  {
    if ("dataValue".equals(feature))
    {
      removeDataValue((String) obj);
      return;
    }
    if ("referenceValue".equals(feature))
    {
      removeReferenceValue((MModelElement) obj);
      return;
    }
    if ("refCondition".equals(feature))
    {
      removeRefCondition((MContextCondition) obj);
      return;
    }

    super.reflectiveRemoveValue(feature, obj);
  }

  public Object reflectiveGetValue(String feature, int pos)
  {

    return super.reflectiveGetValue(feature, pos);
  }

  public void reflectiveSetValue(String feature, int pos, Object obj)
  {

    super.reflectiveSetValue(feature, pos, obj);
  }

  public void reflectiveAddValue(String feature, int pos, Object obj)
  {

    super.reflectiveAddValue(feature, pos, obj);
  }

  public void reflectiveRemoveValue(String feature, int pos)
  {

    super.reflectiveRemoveValue(feature, pos);
  }
  public Collection getModelElementContents()
  {
    Collection ret = super.getModelElementContents();
    return ret;
  }
  /** Gets all the data values as a single string.
   *  Returns the values in the following format:
   *  "{'value1','value2',...}"
   *
   */
public String getDataValuesAsString()
{
  Iterator i = getDataValues().iterator();
  String s = null;
  while (i.hasNext())
  {
    String curValue = "\'" + (String)i.next()+"\'";
    if (s == null)
      s = "{" + curValue;
    else
      s = s + "," + curValue;
  }
  return s+"}";
}

public String toString()
{
  return "TaggedValue: \'"+ getName() + "\' = \'" + getDataValuesAsString()+"\'";
}

}
