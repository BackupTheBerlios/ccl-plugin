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

import org.cocons.uml.*;
import org.cocons.uml.ccl.*;

import java.lang.reflect.Method;

public class MStereotypeImpl extends MGeneralizableElementImpl implements MStereotype
{
  // ------------ code for class Stereotype -----------------
  // generating attributes
  // attribute: baseClass
  // attribute: baseClass
  /**
   *  @deprecated obsolete in UML 1.4
   *
  */
  public String getBaseClass()
  {
    if (this.getBaseClasses().size() >= 1)
    {
      // just return the first base class
      return (String)this.getBaseClasses().toArray()[0];
    }
    else
      return null;
  }

  /**
   *  @deprecated obsolete in UML 1.4
   *  Using this will remove all UML 1.4 base classes
   *  and replace them with a single UML1.3 base class
   *
  */
  public void setBaseClass(String __arg)
  {
    this.setBaseClasses(Collections.EMPTY_LIST);
    this.addBaseClass(__arg);
  }


  // attribute: icon
  private final static Method _icon_setMethod = getMethod1(MStereotypeImpl.class, "setIcon", String.class);
  String _icon;
  public final String getIcon()
  {
    checkExists();
    return _icon;
  }
  public final void setIcon(String __arg)
  {
    operationStarted();
    try
    {
      checkExists();
      logAttrSet(_icon_setMethod, _icon, __arg);
      fireAttrSet("icon", _icon, __arg);
      _icon = __arg;
    }
    finally
    {
      operationFinished();
    }
  }
  // generating associations
  // opposite role: stereotypeConstraint this role: constrainedElement2
  private final static Method _stereotypeConstraint_setMethod = getMethod1(MStereotypeImpl.class, "setStereotypeConstraints", Collection.class);
  private final static Method _stereotypeConstraint_addMethod = getMethod1(MStereotypeImpl.class, "addStereotypeConstraint", MConstraint.class);
  private final static Method _stereotypeConstraint_removeMethod = getMethod1(MStereotypeImpl.class, "removeStereotypeConstraint", MConstraint.class);
  Collection _stereotypeConstraint = Collections.EMPTY_LIST;
  Collection _stereotypeConstraint_ucopy = Collections.EMPTY_LIST;
  public final Collection getStereotypeConstraints()
  {
    checkExists();
    if (null == _stereotypeConstraint_ucopy)
    {
      _stereotypeConstraint_ucopy = ucopy(_stereotypeConstraint);
    }
    return _stereotypeConstraint_ucopy;
  }
  public final void setStereotypeConstraints(Collection __arg)
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
        old = getStereotypeConstraints();
      }
      _stereotypeConstraint_ucopy = null;
      Collection __added = bagdiff(__arg,_stereotypeConstraint);
      Collection __removed = bagdiff(_stereotypeConstraint, __arg);
      Iterator iter1 = __removed.iterator();
      while (iter1.hasNext())
      {
        MConstraint o = (MConstraint)iter1.next();
        o.internalUnrefByConstrainedStereotype(this);
      }
      Iterator iter2 = __added.iterator();
      while (iter2.hasNext())
      {
        MConstraint o = (MConstraint)iter2.next();
        o.internalRefByConstrainedStereotype(this);
      }
      _stereotypeConstraint = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_stereotypeConstraint_setMethod, old, getStereotypeConstraints());
      }
      if (sendEvent)
      {
        fireBagSet("stereotypeConstraint", old, getStereotypeConstraints());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void addStereotypeConstraint(MConstraint __arg)
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
        old = getStereotypeConstraints();
      }
      if (null != _stereotypeConstraint_ucopy)
      {
        _stereotypeConstraint = new ArrayList(_stereotypeConstraint);
        _stereotypeConstraint_ucopy = null;
      }
      __arg.internalRefByConstrainedStereotype(this);
      _stereotypeConstraint.add(__arg);
      logBagAdd(_stereotypeConstraint_addMethod, _stereotypeConstraint_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("stereotypeConstraint", old, getStereotypeConstraints(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void removeStereotypeConstraint(MConstraint __arg)
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
        old = getStereotypeConstraints();
      }
      if (null != _stereotypeConstraint_ucopy)
      {
        _stereotypeConstraint = new ArrayList(_stereotypeConstraint);
        _stereotypeConstraint_ucopy = null;
      }
      if (!_stereotypeConstraint.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByConstrainedStereotype(this);
      logBagRemove(_stereotypeConstraint_removeMethod, _stereotypeConstraint_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("stereotypeConstraint", old, getStereotypeConstraints(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefByStereotypeConstraint(MConstraint __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getStereotypeConstraints();
    }
    if (null != _stereotypeConstraint_ucopy)
    {
      _stereotypeConstraint = new ArrayList(_stereotypeConstraint);
      _stereotypeConstraint_ucopy = null;
    }
    _stereotypeConstraint.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("stereotypeConstraint", old, getStereotypeConstraints(), __arg);
    }
  }
  public final void internalUnrefByStereotypeConstraint(MConstraint __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getStereotypeConstraints();
    }
    if (null != _stereotypeConstraint_ucopy)
    {
      _stereotypeConstraint = new ArrayList(_stereotypeConstraint);
      _stereotypeConstraint_ucopy = null;
    }
    _stereotypeConstraint.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("stereotypeConstraint", old, getStereotypeConstraints(), __arg);
    }
  }
  // opposite role: extendedElement this role: stereotype
  private final static Method _extendedElement_setMethod = getMethod1(MStereotypeImpl.class, "setExtendedElements", Collection.class);
  private final static Method _extendedElement_addMethod = getMethod1(MStereotypeImpl.class, "addExtendedElement", MModelElement.class);
  private final static Method _extendedElement_removeMethod = getMethod1(MStereotypeImpl.class, "removeExtendedElement", MModelElement.class);
  Collection _extendedElement = Collections.EMPTY_LIST;
  Collection _extendedElement_ucopy = Collections.EMPTY_LIST;
  public final Collection getExtendedElements()
  {
    checkExists();
    if (null == _extendedElement_ucopy)
    {
      _extendedElement_ucopy = ucopy(_extendedElement);
    }
    return _extendedElement_ucopy;
  }
  public final void setExtendedElements(Collection __arg)
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
        old = getExtendedElements();
      }
      _extendedElement_ucopy = null;
      Collection __added = bagdiff(__arg,_extendedElement);
      Collection __removed = bagdiff(_extendedElement, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MModelElement o = (MModelElement)iter3.next();
        o.internalUnrefByStereotype(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MModelElement o = (MModelElement)iter4.next();
        o.internalRefByStereotype(this);
      }
      _extendedElement = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_extendedElement_setMethod, old, getExtendedElements());
      }
      if (sendEvent)
      {
        fireBagSet("extendedElement", old, getExtendedElements());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void addExtendedElement(MModelElement __arg)
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
        old = getExtendedElements();
      }
      if (null != _extendedElement_ucopy)
      {
        _extendedElement = new ArrayList(_extendedElement);
        _extendedElement_ucopy = null;
      }
      __arg.internalRefByStereotype(this);
      _extendedElement.add(__arg);
      logBagAdd(_extendedElement_addMethod, _extendedElement_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("extendedElement", old, getExtendedElements(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void removeExtendedElement(MModelElement __arg)
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
        old = getExtendedElements();
      }
      if (null != _extendedElement_ucopy)
      {
        _extendedElement = new ArrayList(_extendedElement);
        _extendedElement_ucopy = null;
      }
      if (!_extendedElement.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByStereotype(this);
      logBagRemove(_extendedElement_removeMethod, _extendedElement_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("extendedElement", old, getExtendedElements(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefByExtendedElement(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getExtendedElements();
    }
    if (null != _extendedElement_ucopy)
    {
      _extendedElement = new ArrayList(_extendedElement);
      _extendedElement_ucopy = null;
    }
    _extendedElement.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("extendedElement", old, getExtendedElements(), __arg);
    }
  }
  public final void internalUnrefByExtendedElement(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getExtendedElements();
    }
    if (null != _extendedElement_ucopy)
    {
      _extendedElement = new ArrayList(_extendedElement);
      _extendedElement_ucopy = null;
    }
    _extendedElement.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("extendedElement", old, getExtendedElements(), __arg);
    }
  }
  // opposite role: requiredTag this role: stereotype
  // obsolete in UML1.4
  /*
  private final static Method _requiredTag_setMethod = getMethod1(MStereotypeImpl.class, "setRequiredTags", Collection.class);
  private final static Method _requiredTag_addMethod = getMethod1(MStereotypeImpl.class, "addRequiredTag", MTaggedValue.class);
  private final static Method _requiredTag_removeMethod = getMethod1(MStereotypeImpl.class, "removeRequiredTag", MTaggedValue.class);
  Collection _requiredTag = Collections.EMPTY_LIST;
  Collection _requiredTag_ucopy = Collections.EMPTY_LIST;
  public final Collection getRequiredTags()
  {
    checkExists();
    if (null == _requiredTag_ucopy)
    {
      _requiredTag_ucopy = ucopy(_requiredTag);
    }
    return _requiredTag_ucopy;
  }
  public final void setRequiredTags(Collection __arg)
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
        old = getRequiredTags();
      }
      _requiredTag_ucopy = null;
      Collection __added = bagdiff(__arg,_requiredTag);
      Collection __removed = bagdiff(_requiredTag, __arg);
      Iterator iter5 = __removed.iterator();
      while (iter5.hasNext())
      {
        MTaggedValue o = (MTaggedValue)iter5.next();
        o.internalUnrefByStereotype(this);
      }
      Iterator iter6 = __added.iterator();
      while (iter6.hasNext())
      {
        MTaggedValue o = (MTaggedValue)iter6.next();
        o.internalRefByStereotype(this);
      }
      _requiredTag = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_requiredTag_setMethod, old, getRequiredTags());
      }
      if (sendEvent)
      {
        fireBagSet("requiredTag", old, getRequiredTags());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void addRequiredTag(MTaggedValue __arg)
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
        old = getRequiredTags();
      }
      if (null != _requiredTag_ucopy)
      {
        _requiredTag = new ArrayList(_requiredTag);
        _requiredTag_ucopy = null;
      }
      __arg.internalRefByStereotype(this);
      _requiredTag.add(__arg);
      logBagAdd(_requiredTag_addMethod, _requiredTag_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("requiredTag", old, getRequiredTags(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void removeRequiredTag(MTaggedValue __arg)
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
        old = getRequiredTags();
      }
      if (null != _requiredTag_ucopy)
      {
        _requiredTag = new ArrayList(_requiredTag);
        _requiredTag_ucopy = null;
      }
      if (!_requiredTag.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByStereotype(this);
      logBagRemove(_requiredTag_removeMethod, _requiredTag_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("requiredTag", old, getRequiredTags(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefByRequiredTag(MTaggedValue __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRequiredTags();
    }
    if (null != _requiredTag_ucopy)
    {
      _requiredTag = new ArrayList(_requiredTag);
      _requiredTag_ucopy = null;
    }
    _requiredTag.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("requiredTag", old, getRequiredTags(), __arg);
    }
  }
  public final void internalUnrefByRequiredTag(MTaggedValue __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRequiredTags();
    }
    if (null != _requiredTag_ucopy)
    {
      _requiredTag = new ArrayList(_requiredTag);
      _requiredTag_ucopy = null;
    }
    _requiredTag.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("requiredTag", old, getRequiredTags(), __arg);
    }
  }
  */
  // ///////////////////////////
  //
  //   UML 1.4 Compatibility
  //   Attribute baseClass[*]
  //
  // ///////////////////////////
  Collection _baseClasses = Collections.EMPTY_LIST;       // working copy
  Collection _baseClasses_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _baseClasses_setMethod = getMethod1(MStereotypeImpl.class, "setBaseClasses", Collection.class);
  private final static Method _baseClass_addMethod = getMethod1(MStereotypeImpl.class, "addBaseClass", String.class);
  private final static Method _baseClass_removeMethod = getMethod1(MStereotypeImpl.class, "removeBaseClass", String.class);

  /**
   * Gets all current values of the attribute BaseClass.
   *
   * @return unmodifyable copy of the current BaseClasses collection
   */
  public final Collection getBaseClasses() {
    checkExists();
    if (null == _baseClasses_ucopy)
    {
      _baseClasses_ucopy = ucopy(_baseClasses);
    }
    return _baseClasses_ucopy;
  }
  /**
   * Sets all values of the attribute BaseClass.
   *
   * @param __arg new collection of BaseClasses or Collections.EMPTY_LIST to
   *        remove all BaseClasses.
   */
  public final void setBaseClasses(Collection __arg)
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
        old = getBaseClasses();
      }
      _baseClasses_ucopy = null;
      _baseClasses = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_baseClasses_setMethod, old, getBaseClasses());
      }
      if (sendEvent)
      {
        fireBagSet("baseClass", old, getBaseClasses());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Adds a value to the attribute BaseClass.
   *
   * @param __arg BaseClass to be added to this instance
   */
  public void addBaseClass(String __arg)
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
        old = getBaseClasses();
      }
      if (null != _baseClasses_ucopy)
      {
        _baseClasses = new ArrayList(_baseClasses);
        _baseClasses_ucopy = null;
      }
      _baseClasses.add(__arg);
      logBagAdd(_baseClass_addMethod, _baseClass_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("baseClass", old, getBaseClasses(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a value from the attribute BaseClass.
   *
   * @param __arg BaseClass to be removed from this instance
   * @throws RuntimeException when __arg is not a BaseClass of this instance
   */
  public void removeBaseClass(String __arg)
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
        old = getBaseClasses();
      }
      if (null != _baseClasses_ucopy)
      {
        _baseClasses = new ArrayList(_baseClasses);
        _baseClasses_ucopy = null;
      }
      if (!_baseClasses.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      logBagRemove(_baseClass_removeMethod, _baseClass_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("baseClass", old, getBaseClasses(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }

  // ///////////////////////////
  //
  //   Association: owner(Stereotype) /
  //                definedTag(TagDefinition)
  //
  // ///////////////////////////
  private final static Method _definedTags_setMethod = getMethod1(MStereotypeImpl.class, "setDefinedTags", Collection.class);
  private final static Method _definedTag_addMethod = getMethod1(MStereotypeImpl.class, "addDefinedTag", MTagDefinition.class);
  private final static Method _definedTag_removeMethod = getMethod1(MStereotypeImpl.class, "removeDefinedTag", MTagDefinition.class);
  Collection _definedTags = Collections.EMPTY_LIST;
  Collection _definedTags_ucopy = Collections.EMPTY_LIST;
  /**
   * Gets all current links of the association owner(Stereotype)
   * / definedTag(TagDefinition).
   *
   * @return unmodifyable copy of the current DefinedTags collection
   */
  public final Collection getDefinedTags()
  {
    checkExists();
    if (null == _definedTags_ucopy)
    {
      _definedTags_ucopy = ucopy(_definedTags);
    }
    return _definedTags_ucopy;
  }
  /**
   * Sets all links of the association owner(Stereotype)
   *  / definedTag(TagDefinition).
   *
   * @param __arg new collection of DefinedTags or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public final void setDefinedTags(Collection __arg)
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
        old = getDefinedTags();
      }
      _definedTags_ucopy = null;
      Collection __added = bagdiff(__arg,_definedTags);
      Collection __removed = bagdiff(_definedTags, __arg);
      Iterator iter33 = __removed.iterator();
      while (iter33.hasNext())
      {
        MTagDefinition o = (MTagDefinition)iter33.next();
        o.internalUnrefByOwner(this);
      }
      Iterator iter34 = __added.iterator();
      while (iter34.hasNext())
      {
        MTagDefinition o = (MTagDefinition)iter34.next();
        o.internalRefByOwner(this);
      }
      _definedTags = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_definedTags_setMethod, old, getDefinedTags());
      }
      if (sendEvent)
      {
        fireBagSet("definedTag", old, getDefinedTags());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Adds a link to the association owner(Stereotype)
   *  / definedTag(TagDefinition).
   *
   * @param __arg DefinedTag to be linked to this instance
   */
  public final void addDefinedTag(MTagDefinition __arg)
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
        old = getDefinedTags();
      }
      if (null != _definedTags_ucopy)
      {
        _definedTags = new ArrayList(_definedTags);
        _definedTags_ucopy = null;
      }
      __arg.internalRefByOwner(this);
      _definedTags.add(__arg);
      logBagAdd(_definedTag_addMethod, _definedTag_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("definedTag", old, getDefinedTags(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * Removes a link from the association owner(Stereotype)
   *  / definedTag(TagDefinition).
   *
   * @param __arg DefinedTag to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeDefinedTag(MTagDefinition __arg)
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
        old = getDefinedTags();
      }
      if (null != _definedTags_ucopy)
      {
        _definedTags = new ArrayList(_definedTags);
        _definedTags_ucopy = null;
      }
      if (!_definedTags.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByOwner(this);
      logBagRemove(_definedTag_removeMethod, _definedTag_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("definedTag", old, getDefinedTags(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg DefinedTag to be referenced
   */
  public final void internalRefByDefinedTag(MTagDefinition __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getDefinedTags();
    }
    if (null != _definedTags_ucopy)
    {
      _definedTags = new ArrayList(_definedTags);
      _definedTags_ucopy = null;
    }
    _definedTags.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("definedTag", old, getDefinedTags(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg DefinedTag to be unreferenced
   */
  public final void internalUnrefByDefinedTag(MTagDefinition __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getDefinedTags();
    }
    if (null != _definedTags_ucopy)
    {
      _definedTags = new ArrayList(_definedTags);
      _definedTags_ucopy = null;
    }
    _definedTags.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("definedTag", old, getDefinedTags(), __arg);
    }
  }

  // ///////////////////////////
  //
  //   Association restrictedStereotype(Stereotype) /
  //               restriction(ContextCondition)
  //
  // ///////////////////////////

  Collection _restrictions = Collections.EMPTY_LIST;
  Collection _restrictions_ucopy = Collections.EMPTY_LIST; // unmodifyable copy

  // Static Methods
  private final static Method _restriction_setMethod = getMethod1(MStereotype.class, "setRestrictions", Collection.class);
  private final static Method _restriction_addMethod = getMethod1(MStereotype.class, "addRestriction", MContextCondition.class);
  private final static Method _restriction_removeMethod = getMethod1(MStereotype.class, "removeRestriction", MContextCondition.class);

  /**
   * Gets all current links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @return unmodifyable copy of the current Restrictions collection
   */
  public Collection getRestrictions() {
    checkExists();
    if (null == _restrictions_ucopy)
    {
      _restrictions_ucopy = ucopy(_restrictions);
    }
    return _restrictions_ucopy;
  }

  /**
   * Sets all links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg new collection of Restrictions or Collections.EMPTY_LIST to
   *        remove all links.
   */
  public void setRestrictions(Collection __arg)
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
        old = getRestrictions();
      }
      _restrictions_ucopy = null;
      Collection __added = bagdiff(__arg,_restrictions);
      Collection __removed = bagdiff(_restrictions, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MContextCondition o = (MContextCondition)iter3.next();
        o.internalUnrefByRestrictedStereotype(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MContextCondition o = (MContextCondition)iter4.next();
        o.internalRefByRestrictedStereotype(this);
      }
      _restrictions = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_restriction_setMethod, old, getRestrictions());
      }
      if (sendEvent)
      {
        fireBagSet("restriction", old, getRestrictions());
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
   * @param __arg Restriction to be linked to this instance
   */
  public final void addRestriction(MContextCondition __arg)
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
        old = getRestrictions();
      }
      if (null != _restrictions_ucopy)
      {
        _restrictions = new ArrayList(_restrictions);
        _restrictions_ucopy = null;
      }
      __arg.internalRefByRestrictedStereotype(this);
      _restrictions.add(__arg);
      logBagAdd(_restriction_addMethod, _restriction_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("restriction", old, getRestrictions(), __arg);
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
   * @param __arg Restriction to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  public final void removeRestriction(MContextCondition __arg)
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
        old = getRestrictions();
      }
      if (null != _restrictions_ucopy)
      {
        _restrictions = new ArrayList(_restrictions);
        _restrictions_ucopy = null;
      }
      if (!_restrictions.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByRestrictedStereotype(this);
      logBagRemove(_restriction_removeMethod, _restriction_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("restriction", old, getRestrictions(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg Restriction to be referenced
   */
  public final void internalRefByRestriction(MContextCondition __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRestrictions();
    }
    if (null != _restrictions_ucopy)
    {
      _restrictions = new ArrayList(_restrictions);
      _restrictions_ucopy = null;
    }
    _restrictions.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("restriction", old, getRestrictions(), __arg);
    }
  }
  /**
   * internal use only - should never be called directly.
   * @param __arg Restriction to be unreferenced
   */
  public final void internalUnrefByRestriction(MContextCondition __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getRestrictions();
    }
    if (null != _restrictions_ucopy)
    {
      _restrictions = new ArrayList(_restrictions);
      _restrictions_ucopy = null;
    }
    _restrictions.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("restriction", old, getRestrictions(), __arg);
    }
  }

  protected void cleanup(Collection scheduledForRemove)
  {
    // opposite role: stereotypeConstraint this role: constrainedElement2
    if (_stereotypeConstraint.size() != 0)
    {
      scheduledForRemove.addAll(_stereotypeConstraint);
      setStereotypeConstraints(Collections.EMPTY_LIST);
    }
    // opposite role: extendedElement this role: stereotype
    if (_extendedElement.size() != 0)
    {
      setExtendedElements(Collections.EMPTY_LIST);
    }
    // opposite role: requiredTag this role: stereotype
    /* obsolete in UML1.4
    if (_requiredTag.size() != 0)
    {
      scheduledForRemove.addAll(_requiredTag);
      setRequiredTags(Collections.EMPTY_LIST);
    }
    */
    // opposite role: definedTag this role: owner
    if (_definedTags.size() != 0)
    {
      setDefinedTags(Collections.EMPTY_LIST);
    }
    if (_baseClasses.size() != 0)
    {
      setBaseClasses(Collections.EMPTY_LIST);
    }
    if (_restrictions.size() != 0)
    {
      setBaseClasses(Collections.EMPTY_LIST);
    }
    super.cleanup(scheduledForRemove);
  }

  public String getUMLClassName()
  {
    return "Stereotype";
  }

  // Reflective API

  public Object reflectiveGetValue(String feature)
  {
/*
    if ("baseClass".equals(feature))
    {
      return getBaseClass();
    }
*/
    if ("icon".equals(feature))
    {
      return getIcon();
    }
    if ("stereotypeConstraint".equals(feature))
    {
      return getStereotypeConstraints();
    }
    if ("extendedElement".equals(feature))
    {
      return getExtendedElements();
    }
    /* obsolete in UML1.4
    if ("requiredTag".equals(feature))
    {
      return getRequiredTags();
    }
    */
    if ("definedTag".equals(feature))
    {
      return getDefinedTags();
    }
    if ("baseClass".equals(feature))
    {
      return getBaseClasses();
    }
    if ("restriction".equals(feature))
    {
      return getRestrictions();
    }
    return super.reflectiveGetValue(feature);
  }

  public void reflectiveSetValue(String feature, Object obj)
  {
/*
    if ("baseClass".equals(feature))
    {
      setBaseClass((String)obj);
      return;
    }
*/
    if ("icon".equals(feature))
    {
      setIcon((String)obj);
      return;
    }
    if ("stereotypeConstraint".equals(feature))
    {
      setStereotypeConstraints((Collection)obj);
      return;
    }
    if ("extendedElement".equals(feature))
    {
      setExtendedElements((Collection)obj);
      return;
    }
    /* obsolete in UML1.4
    if ("requiredTag".equals(feature))
    {
      setRequiredTags((Collection)obj);
      return;
    }
    */
    if ("definedTag".equals(feature))
    {
      setDefinedTags((Collection)obj);
      return;
    }
    if ("baseClass".equals(feature))
    {
      setBaseClasses((Collection)obj);
      return;
    }
    if ("restriction".equals(feature))
    {
      setRestrictions((Collection)obj);
      return;
    }
    super.reflectiveSetValue(feature, obj);
  }

  public void reflectiveAddValue(String feature, Object obj)
  {
    if ("stereotypeConstraint".equals(feature))
    {
      addStereotypeConstraint((MConstraint)obj);
      return;
    }
    if ("extendedElement".equals(feature))
    {
      addExtendedElement((MModelElement)obj);
      return;
    }
    /* obsolete in UML1.4
    if ("requiredTag".equals(feature))
    {
      addRequiredTag((MTaggedValue)obj);
      return;
    }
    */
    if ("definedTag".equals(feature))
    {
      addDefinedTag((MTagDefinition)obj);
      return;
    }
    if ("baseClass".equals(feature))
    {
      addBaseClass((String)obj);
      return;
    }
    if ("restriction".equals(feature))
    {
      addRestriction((MContextCondition)obj);
      return;
    }
    super.reflectiveAddValue(feature, obj);
  }

  public void reflectiveRemoveValue(String feature, Object obj)
  {
    if ("stereotypeConstraint".equals(feature))
    {
      removeStereotypeConstraint((MConstraint)obj);
      return;
    }
    if ("extendedElement".equals(feature))
    {
      removeExtendedElement((MModelElement)obj);
      return;
    }
    /* obsolete in UML1.4
    if ("requiredTag".equals(feature))
    {
      removeRequiredTag((MTaggedValue)obj);
      return;
    }
    */
    if ("definedTag".equals(feature))
    {
      removeDefinedTag((MTagDefinition)obj);
      return;
    }
    if ("baseClass".equals(feature))
    {
      removeBaseClass((String)obj);
      return;
    }
    if ("restriction".equals(feature))
    {
      removeRestriction((MContextCondition)obj);
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
    ret.addAll(getStereotypeConstraints());
    /* obsolete in UML1.4
    ret.addAll(getRequiredTags());
    */
    ret.addAll(getDefinedTags());
    return ret;
  }
}
