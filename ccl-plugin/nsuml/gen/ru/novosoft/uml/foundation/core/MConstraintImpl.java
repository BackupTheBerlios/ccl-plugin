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

package ru.novosoft.uml.foundation.core;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.behavior.collaborations.*;
import ru.novosoft.uml.behavior.use_cases.*;
import ru.novosoft.uml.behavior.state_machines.*;
import ru.novosoft.uml.behavior.activity_graphs.*;
import ru.novosoft.uml.model_management.*;

import org.cocons.uml.ccl.*;

import java.lang.reflect.Method;

public class MConstraintImpl extends MModelElementImpl implements MConstraint
{
  // ------------ code for class Constraint -----------------
  // generating attributes
  // attribute: body
  private final static Method _body_setMethod = getMethod1(MConstraintImpl.class, "setBody", MBooleanExpression.class);
  MBooleanExpression _body;
  public final MBooleanExpression getBody()
  {
    checkExists();
    return _body;
  }
  public final void setBody(MBooleanExpression __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_body_setMethod, _body, __arg);
      fireAttrSet("body", _body, __arg);
      _body = __arg;
    }
    finally
    {
      operationFinished();
    }
  }
  // generating associations
  // opposite role: constrainedStereotype this role: stereotypeConstraint
  private final static Method _constrainedStereotype_setMethod = getMethod1(MConstraintImpl.class, "setConstrainedStereotype", MStereotype.class);
  MStereotype _constrainedStereotype;
  public final MStereotype getConstrainedStereotype()
  {
    checkExists();
    return _constrainedStereotype;
  }
  public final void setConstrainedStereotype(MStereotype __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      MStereotype __saved = _constrainedStereotype;
      if (_constrainedStereotype != __arg)
      {
        if (__saved != null)
        {
          __saved.internalUnrefByStereotypeConstraint(this);
        }
        if (__arg != null)
        {
          __arg.internalRefByStereotypeConstraint(this);
        }
        logRefSet(_constrainedStereotype_setMethod, __saved, __arg);
        fireRefSet("constrainedStereotype", __saved, __arg);
        _constrainedStereotype = __arg;
        setModelElementContainer(_constrainedStereotype, "constrainedStereotype");
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefByConstrainedStereotype(MStereotype __arg)
  {
    MStereotype __saved = _constrainedStereotype;
    if (_constrainedStereotype != null)
    {
      _constrainedStereotype.removeStereotypeConstraint(this);
    }
    fireRefSet("constrainedStereotype", __saved, __arg);
    _constrainedStereotype = __arg;
    setModelElementContainer(_constrainedStereotype, "constrainedStereotype");
  }
  public final void internalUnrefByConstrainedStereotype(MStereotype __arg)
  {
    fireRefSet("constrainedStereotype", _constrainedStereotype, null);
    _constrainedStereotype = null;
    setModelElementContainer(null, null);
  }
  // opposite role: constrainedElement this role: constraint
  private final static Method _constrainedElement_setMethod = getMethod1(MConstraintImpl.class, "setConstrainedElements", List.class);
  private final static Method _constrainedElement_removeMethod = getMethod1(MConstraintImpl.class, "removeConstrainedElement", int.class);
  private final static Method _constrainedElement_addMethod = getMethod2(MConstraintImpl.class, "addConstrainedElement", int.class, MModelElement.class);
  private final static Method _constrainedElement_listSetMethod = getMethod2(MConstraintImpl.class, "setConstrainedElement", int.class, MModelElement.class);
  List _constrainedElement = Collections.EMPTY_LIST;
  List _constrainedElement_ucopy = Collections.EMPTY_LIST;
  public final List getConstrainedElements()
  {
    checkExists();
    if (null == _constrainedElement_ucopy)
    {
      _constrainedElement_ucopy = ucopy(_constrainedElement);
    }
    return _constrainedElement_ucopy;
  }
  public final void setConstrainedElements(List __arg)
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
      List old = null;
      if (sendEvent || logForUndo)
      {
        old = getConstrainedElements();
      }
      _constrainedElement_ucopy = null;
      Collection __added = bagdiff(__arg,_constrainedElement);
      Collection __removed = bagdiff(_constrainedElement, __arg);
      Iterator iter1 = __removed.iterator();
      while (iter1.hasNext())
      {
        MModelElement o = (MModelElement)iter1.next();
        o.internalUnrefByConstraint(this);
      }
      Iterator iter2 = __added.iterator();
      while (iter2.hasNext())
      {
        MModelElement o = (MModelElement)iter2.next();
        o.internalRefByConstraint(this);
      }
      _constrainedElement = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_constrainedElement_setMethod, old, getConstrainedElements());
      }
      if (sendEvent)
      {
        fireListSet("constrainedElement", old, getConstrainedElements());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void addConstrainedElement(MModelElement __arg)
  {
    addConstrainedElement(_constrainedElement.size(), __arg);
  }
  public final void removeConstrainedElement(MModelElement __arg)
  {
    if (__arg == null)
    {
      throw new NullPointerException();
    }
    int __pos = _constrainedElement.indexOf(__arg);
    removeConstrainedElement(__pos);
  }
  public final void addConstrainedElement(int __pos, MModelElement __arg)
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
      List old = null;
      if (sendEvent)
      {
        old = getConstrainedElements();
      }
      if (null != _constrainedElement_ucopy)
      {
        _constrainedElement = new ArrayList(_constrainedElement);
        _constrainedElement_ucopy = null;
      }
      _constrainedElement.add(__pos, __arg);
      __arg.internalRefByConstraint(this);
      logListAdd(_constrainedElement_addMethod, _constrainedElement_removeMethod, __arg, __pos);
      if (sendEvent)
      {
        fireListAdd("constrainedElement", old, getConstrainedElements(), __arg, __pos);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void removeConstrainedElement(int __pos)
  {
    operationStarted();
    try
    {
      checkExists();
      final boolean sendEvent = needEvent();
      List old = null;
      if (sendEvent)
      {
        old = getConstrainedElements();
      }
      if (null != _constrainedElement_ucopy)
      {
        _constrainedElement = new ArrayList(_constrainedElement);
        _constrainedElement_ucopy = null;
      }
      MModelElement __arg = (MModelElement)_constrainedElement.remove(__pos);
      __arg.internalUnrefByConstraint(this);
      logListRemove(_constrainedElement_removeMethod, _constrainedElement_addMethod, __arg, __pos);
      if (sendEvent)
      {
        fireListRemove("constrainedElement", old, getConstrainedElements(), __arg, __pos);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void setConstrainedElement(int __pos, MModelElement __arg)
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
      List old = null;
      if (sendEvent)
      {
        old = getConstrainedElements();
      }
      if (null != _constrainedElement_ucopy)
      {
        _constrainedElement = new ArrayList(_constrainedElement);
        _constrainedElement_ucopy = null;
      }
      MModelElement __old = (MModelElement)_constrainedElement.get(__pos);
      __old.internalUnrefByConstraint(this);
      __arg.internalRefByConstraint(this);
      _constrainedElement.set(__pos,__arg);
      logListSet(_constrainedElement_listSetMethod, __old, __arg, __pos);
      if (sendEvent)
      {
        fireListItemSet("constrainedElement", old, getConstrainedElements(), __old, __arg, __pos);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final MModelElement getConstrainedElement(int __pos)
  {
    checkExists();
    return (MModelElement)_constrainedElement.get(__pos);
  }

  // ///////////////////////////
  //
  // Association valueValidation(Constraint)
  //             / contextPropertyTag(ContextPropertyTag)
  //
  // ///////////////////////////
  private final static Method _contextPropertyTags_setMethod = getMethod1(MConstraintImpl.class, "setContextPropertyTags", Collection.class);
  private final static Method _contextPropertyTags_addMethod = getMethod1(MConstraintImpl.class, "addContextPropertyTag", MContextPropertyTag.class);
  private final static Method _contextPropertyTags_removeMethod = getMethod1(MConstraintImpl.class, "removeContextPropertyTag", MContextPropertyTag.class);
  Collection _contextPropertyTags = Collections.EMPTY_LIST;
  Collection _contextPropertyTags_ucopy = Collections.EMPTY_LIST;

  /**
   * Gets all links of the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @return unmodifyable copy of the current ContextPropertyTags
   */
  public final Collection getContextPropertyTags()
  {
    checkExists();
    if (null == _contextPropertyTags_ucopy)
    {
      _contextPropertyTags_ucopy = ucopy(_contextPropertyTags);
    }
    return _contextPropertyTags_ucopy;
  }
  /**
   * Sets all links of the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg new collection of ContextPropertyTags or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public final void setContextPropertyTags(Collection __arg)
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
        old = getContextPropertyTags();
      }
      _contextPropertyTags_ucopy = null;
      Collection __added = bagdiff(__arg,_contextPropertyTags);
      Collection __removed = bagdiff(_contextPropertyTags, __arg);
      Iterator iter33 = __removed.iterator();
      while (iter33.hasNext())
      {
        MContextPropertyTag o = (MContextPropertyTag)iter33.next();
        o.internalUnrefByValueValidation(this);
      }
      Iterator iter34 = __added.iterator();
      while (iter34.hasNext())
      {
        MContextPropertyTag o = (MContextPropertyTag)iter34.next();
        o.internalRefByValueValidation(this);
      }
      _contextPropertyTags = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_contextPropertyTags_setMethod, old, getContextPropertyTags());
      }
      if (sendEvent)
      {
        fireBagSet("contextPropertyTag", old, getContextPropertyTags());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Adds a link to the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg ContextPropertyTag to be linked to this instance
   */
  public final void addContextPropertyTag(MContextPropertyTag __arg)
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
        old = getContextPropertyTags();
      }
      if (null != _contextPropertyTags_ucopy)
      {
        _contextPropertyTags = new ArrayList(_contextPropertyTags);
        _contextPropertyTags_ucopy = null;
      }
      __arg.internalRefByValueValidation(this);
      _contextPropertyTags.add(__arg);
      logBagAdd(_contextPropertyTags_addMethod, _contextPropertyTags_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("contextPropertyTag", old, getContextPropertyTags(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg ContextPropertyTag to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeContextPropertyTag(MContextPropertyTag __arg)
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
        old = getContextPropertyTags();
      }
      if (null != _contextPropertyTags_ucopy)
      {
        _contextPropertyTags = new ArrayList(_contextPropertyTags);
        _contextPropertyTags_ucopy = null;
      }
      if (!_contextPropertyTags.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByValueValidation(this);
      logBagRemove(_contextPropertyTags_removeMethod, _contextPropertyTags_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("contextPropertyTag", old, getContextPropertyTags(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyTag to be referenced
   */
  public final void internalRefByContextPropertyTag(MContextPropertyTag __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getContextPropertyTags();
    }
    if (null != _contextPropertyTags_ucopy)
    {
      _contextPropertyTags = new ArrayList(_contextPropertyTags);
      _contextPropertyTags_ucopy = null;
    }
    _contextPropertyTags.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("contextPropertyTag", old, getContextPropertyTags(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyTag to be unreferenced
   */
  public final void internalUnrefByContextPropertyTag(MContextPropertyTag __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getContextPropertyTags();
    }
    if (null != _contextPropertyTags_ucopy)
    {
      _contextPropertyTags = new ArrayList(_contextPropertyTags);
      _contextPropertyTags_ucopy = null;
    }
    _contextPropertyTags.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("contextPropertyTag", old, getContextPropertyTags(), __arg);
    }
  }

  protected void cleanup(Collection scheduledForRemove)
  {
    // opposite role: stereotypeConstraint this role: stereotypeConstraint
    if (_constrainedStereotype != null )
    {
      setConstrainedStereotype(null);
    }
    // opposite role: constrainedElement this role: constraint
    if (_constrainedElement.size() != 0)
    {
      setConstrainedElements(Collections.EMPTY_LIST);
    }
    // opposite role: contextPropertyTag this role: valueValidation
    if (_contextPropertyTags.size() != 0)
    {
      setContextPropertyTags(Collections.EMPTY_LIST);
    }

    super.cleanup(scheduledForRemove);
  }

  public String getUMLClassName()
  {
    return "Constraint";
  }

  // Reflective API

  public Object reflectiveGetValue(String feature)
  {
    if ("body".equals(feature))
    {
      return getBody();
    }
    if ("constrainedStereotype".equals(feature))
    {
      return getConstrainedStereotype();
    }
    if ("constrainedElement".equals(feature))
    {
      return getConstrainedElements();
    }
    if ("contextPropertyTag".equals(feature))
    {
      return getContextPropertyTags();
    }
    return super.reflectiveGetValue(feature);
  }

  public void reflectiveSetValue(String feature, Object obj)
  {
    if ("body".equals(feature))
    {
      setBody((MBooleanExpression)obj);
      return;
    }
    if ("constrainedStereotype".equals(feature))
    {
      setConstrainedStereotype((MStereotype)obj);
      return;
    }
    if ("constrainedElement".equals(feature))
    {
      setConstrainedElements((List)obj);
      return;
    }
    if ("contextPropertyTag".equals(feature))
    {
      setContextPropertyTags((Collection)obj);
      return;
    }
    super.reflectiveSetValue(feature, obj);
  }

  public void reflectiveAddValue(String feature, Object obj)
  {
    if ("constrainedElement".equals(feature))
    {
      addConstrainedElement((MModelElement)obj);
      return;
    }
    if ("contextPropertyTag".equals(feature))
    {
      addContextPropertyTag((MContextPropertyTag)obj);
      return;
    }

    super.reflectiveAddValue(feature, obj);
  }

  public void reflectiveRemoveValue(String feature, Object obj)
  {
    if ("constrainedElement".equals(feature))
    {
      removeConstrainedElement((MModelElement)obj);
      return;
    }
    if ("contextPropertyTag".equals(feature))
    {
      removeContextPropertyTag((MContextPropertyTag)obj);
      return;
    }

    super.reflectiveRemoveValue(feature, obj);
  }

  public Object reflectiveGetValue(String feature, int pos)
  {
    if ("constrainedElement".equals(feature))
    {
      return getConstrainedElement(pos);
    }

    return super.reflectiveGetValue(feature, pos);
  }

  public void reflectiveSetValue(String feature, int pos, Object obj)
  {
    if ("constrainedElement".equals(feature))
    {
      setConstrainedElement(pos, (MModelElement)obj);
      return;
    }

    super.reflectiveSetValue(feature, pos, obj);
  }

  public void reflectiveAddValue(String feature, int pos, Object obj)
  {
    if ("constrainedElement".equals(feature))
    {
      addConstrainedElement(pos, (MModelElement)obj);
      return;
    }

    super.reflectiveAddValue(feature, pos, obj);
  }

  public void reflectiveRemoveValue(String feature, int pos)
  {
    if ("constrainedElement".equals(feature))
    {
      removeConstrainedElement(pos);
      return;
    }

    super.reflectiveRemoveValue(feature, pos);
  }

  public Collection getModelElementContents()
  {
    Collection ret = super.getModelElementContents();
    return ret;
  }
}
