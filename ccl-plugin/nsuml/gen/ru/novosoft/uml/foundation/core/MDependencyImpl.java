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

import java.lang.reflect.Method;

public class MDependencyImpl extends MRelationshipImpl implements MDependency
{
  // ------------ code for class Dependency -----------------
  // generating attributes
  // generating associations
  // opposite role: supplier this role: supplierDependency
  private final static Method _supplier_setMethod = getMethod1(MDependencyImpl.class, "setSuppliers", Collection.class);
  private final static Method _supplier_addMethod = getMethod1(MDependencyImpl.class, "addSupplier", MModelElement.class);
  private final static Method _supplier_removeMethod = getMethod1(MDependencyImpl.class, "removeSupplier", MModelElement.class);
  Collection _supplier = Collections.EMPTY_LIST;
  Collection _supplier_ucopy = Collections.EMPTY_LIST;
  public final Collection getSuppliers()
  {
    checkExists();
    if (null == _supplier_ucopy)
    {
      _supplier_ucopy = ucopy(_supplier);
    }
    return _supplier_ucopy;
  }
  public final void setSuppliers(Collection __arg)
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
        old = getSuppliers();
      }
      _supplier_ucopy = null;
      Collection __added = bagdiff(__arg,_supplier);
      Collection __removed = bagdiff(_supplier, __arg);
      Iterator iter1 = __removed.iterator();
      while (iter1.hasNext())
      {
        MModelElement o = (MModelElement)iter1.next();
        o.internalUnrefBySupplierDependency(this);
      }
      Iterator iter2 = __added.iterator();
      while (iter2.hasNext())
      {
        MModelElement o = (MModelElement)iter2.next();
        o.internalRefBySupplierDependency(this);
      }
      _supplier = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_supplier_setMethod, old, getSuppliers());
      }
      if (sendEvent)
      {
        fireBagSet("supplier", old, getSuppliers());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void addSupplier(MModelElement __arg)
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
        old = getSuppliers();
      }
      if (null != _supplier_ucopy)
      {
        _supplier = new ArrayList(_supplier);
        _supplier_ucopy = null;
      }
      __arg.internalRefBySupplierDependency(this);
      _supplier.add(__arg);
      logBagAdd(_supplier_addMethod, _supplier_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("supplier", old, getSuppliers(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void removeSupplier(MModelElement __arg)
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
        old = getSuppliers();
      }
      if (null != _supplier_ucopy)
      {
        _supplier = new ArrayList(_supplier);
        _supplier_ucopy = null;
      }
      if (!_supplier.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefBySupplierDependency(this);
      logBagRemove(_supplier_removeMethod, _supplier_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("supplier", old, getSuppliers(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefBySupplier(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getSuppliers();
    }
    if (null != _supplier_ucopy)
    {
      _supplier = new ArrayList(_supplier);
      _supplier_ucopy = null;
    }
    _supplier.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("supplier", old, getSuppliers(), __arg);
    }
  }
  public final void internalUnrefBySupplier(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getSuppliers();
    }
    if (null != _supplier_ucopy)
    {
      _supplier = new ArrayList(_supplier);
      _supplier_ucopy = null;
    }
    _supplier.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("supplier", old, getSuppliers(), __arg);
    }
  }
  // opposite role: client this role: clientDependency
  private final static Method _client_setMethod = getMethod1(MDependencyImpl.class, "setClients", Collection.class);
  private final static Method _client_addMethod = getMethod1(MDependencyImpl.class, "addClient", MModelElement.class);
  private final static Method _client_removeMethod = getMethod1(MDependencyImpl.class, "removeClient", MModelElement.class);
  Collection _client = Collections.EMPTY_LIST;
  Collection _client_ucopy = Collections.EMPTY_LIST;
  public final Collection getClients()
  {
    checkExists();
    if (null == _client_ucopy)
    {
      _client_ucopy = ucopy(_client);
    }
    return _client_ucopy;
  }
  public final void setClients(Collection __arg)
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
        old = getClients();
      }
      _client_ucopy = null;
      Collection __added = bagdiff(__arg,_client);
      Collection __removed = bagdiff(_client, __arg);
      Iterator iter3 = __removed.iterator();
      while (iter3.hasNext())
      {
        MModelElement o = (MModelElement)iter3.next();
        o.internalUnrefByClientDependency(this);
      }
      Iterator iter4 = __added.iterator();
      while (iter4.hasNext())
      {
        MModelElement o = (MModelElement)iter4.next();
        o.internalRefByClientDependency(this);
      }
      _client = new ArrayList(__arg);
      if (logForUndo)
      {
        logBagSet(_client_setMethod, old, getClients());
      }
      if (sendEvent)
      {
        fireBagSet("client", old, getClients());
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void addClient(MModelElement __arg)
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
        old = getClients();
      }
      if (null != _client_ucopy)
      {
        _client = new ArrayList(_client);
        _client_ucopy = null;
      }
      __arg.internalRefByClientDependency(this);
      _client.add(__arg);
      logBagAdd(_client_addMethod, _client_removeMethod, __arg);
      if (sendEvent)
      {
        fireBagAdd("client", old, getClients(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void removeClient(MModelElement __arg)
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
        old = getClients();
      }
      if (null != _client_ucopy)
      {
        _client = new ArrayList(_client);
        _client_ucopy = null;
      }
      if (!_client.remove(__arg))
      {
        throw new RuntimeException("removing not added object");
      }
      __arg.internalUnrefByClientDependency(this);
      logBagRemove(_client_removeMethod, _client_addMethod, __arg);
      if (sendEvent)
      {
        fireBagRemove("client", old, getClients(), __arg);
      }
    }
    finally
    {
      operationFinished();
    }
  }
  public final void internalRefByClient(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getClients();
    }
    if (null != _client_ucopy)
    {
      _client = new ArrayList(_client);
      _client_ucopy = null;
    }
    _client.add(__arg);
    if (sendEvent)
    {
      fireBagAdd("client", old, getClients(), __arg);
    }
  }
  public final void internalUnrefByClient(MModelElement __arg)
  {
    final boolean sendEvent = needEvent();
    Collection old = null;
    if (sendEvent)
    {
      old = getClients();
    }
    if (null != _client_ucopy)
    {
      _client = new ArrayList(_client);
      _client_ucopy = null;
    }
    _client.remove(__arg);
    if (sendEvent)
    {
      fireBagRemove("client", old, getClients(), __arg);
    }
  }
  protected void cleanup(Collection scheduledForRemove)
  {
    // opposite role: supplier this role: supplierDependency
    if (_supplier.size() != 0)
    {
      setSuppliers(Collections.EMPTY_LIST);
    }
    // opposite role: client this role: clientDependency
    if (_client.size() != 0)
    {
      setClients(Collections.EMPTY_LIST);
    }
    super.cleanup(scheduledForRemove);
  }

  public String getUMLClassName()
  {
    return "Dependency";
  }

  // Reflective API

  public Object reflectiveGetValue(String feature)
  {
    if ("supplier".equals(feature))
    {
      return getSuppliers();
    }
    if ("client".equals(feature))
    {
      return getClients();
    }

    return super.reflectiveGetValue(feature);
  }

  public void reflectiveSetValue(String feature, Object obj)
  {
    if ("supplier".equals(feature))
    {
      setSuppliers((Collection)obj);
      return;
    }
    if ("client".equals(feature))
    {
      setClients((Collection)obj);
      return;
    }

    super.reflectiveSetValue(feature, obj);
  }

  public void reflectiveAddValue(String feature, Object obj)
  {
    if ("supplier".equals(feature))
    {
      addSupplier((MModelElement)obj);
      return;
    }
    if ("client".equals(feature))
    {
      addClient((MModelElement)obj);
      return;
    }

    super.reflectiveAddValue(feature, obj);
  }

  public void reflectiveRemoveValue(String feature, Object obj)
  {
    if ("supplier".equals(feature))
    {
      removeSupplier((MModelElement)obj);
      return;
    }
    if ("client".equals(feature))
    {
      removeClient((MModelElement)obj);
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
}