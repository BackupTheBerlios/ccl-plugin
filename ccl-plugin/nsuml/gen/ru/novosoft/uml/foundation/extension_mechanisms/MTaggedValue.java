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

public interface MTaggedValue extends MModelElement
{
  // generating attributes
  // attribute: value
  String getValue();
  void setValue(String __arg);
  // attribute: tag
  String getTag();
  void setTag(String __arg);
  // generating associations
  // opposite role: stereotype this role: requiredTag
  MStereotype getStereotype();
  void setStereotype(MStereotype __arg);
  void internalRefByStereotype(MStereotype __arg);
  void internalUnrefByStereotype(MStereotype __arg);
  // opposite role: modelElement this role: taggedValue
  MModelElement getModelElement();
  void setModelElement(MModelElement __arg);
  void internalRefByModelElement(MModelElement __arg);
  void internalUnrefByModelElement(MModelElement __arg);
  /**
   * Gets all current values of the attribute DataValue.
   *
   * @return unmodifyable copy of the current DataValues collection
   */
  Collection getDataValues();
  /**
   * Sets all values of the attribute DataValue.
   *
   * @param __arg new collection of DataValues or Collections.EMPTY_LIST to
   *        remove all BaseClasses.
   */
  void setDataValues(Collection __arg);
  /**
   * Adds a value to the attribute DataValue.
   *
   * @param __arg DataValue to be added to this instance
   */
  void addDataValue(String __arg);
  /**
   * Removes a value from the attribute DataValue.
   *
   * @param __arg DataValue to be removed from this instance
   * @throws RuntimeException when __arg is not a DataValue of this instance
   */
  void removeDataValue(String __arg);
  /**
   * Gets all links of the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @return unmodifyable copy of the current ReferenceValues collection
   */
  Collection getReferenceValues();
  /**
   * Sets all links of the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @param __arg new collection of ReferenceValues or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setReferenceValues(Collection __arg);
  /**
   * Adds a link to the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @param __arg ReferenceValue to be linked to this instance
   */
  void addReferenceValue(MModelElement __arg);
  /**
   * Removes a link from the association referenceValue(ModelElement)
   * / referenceTag(taggedValue).
   *
   * @param __arg ReferenceValue to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeReferenceValue(MModelElement __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ReferenceValue to be referenced
   */
  void internalRefByReferenceValue(MModelElement __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ReferenceValue to be unreferenced
   */
  void internalUnrefByReferenceValue(MModelElement __arg);

  /**
   * Gets the link of the association type(TagDefinition)
   * / typedValue(TaggedValue)
   *
   * @return current Type of the instance
   */
  MTagDefinition getType();
  /**
   * Sets the link of the association type(TagDefinition)
   * / typedValue(TaggedValue)
   *
   * @param __arg new Type of the instance
   */
  void setType(MTagDefinition __arg);
/**
 * internal use only - should never be called directly
 * @param __arg Type to be referenced
 */
  void internalRefByType(MTagDefinition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg Type to be unreferenced
   */
  void internalUnrefByType(MTagDefinition __arg);

  /**
   * Gets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @return unmodifyable copy of the current RefConditions collection
   */
  Collection getRefConditions();
  /**
   * Sets all the links of the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg new collection of RefConditions or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setRefConditions(Collection __arg);
  /**
   * Adds a link to the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg RefCondition to be linked to this instance
   */
  void addRefCondition(MContextCondition __arg);
  /**
   * Removes a link from the association contextPropertyValue(TaggedValue)
   * / refCondition(ContextCondition).
   *
   * @param __arg RefCondition to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeRefCondition(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg RefCondition to be referenced
   */
  void internalRefByRefCondition(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg RefCondition to be unreferenced
   */
  void internalUnrefByRefCondition(MContextCondition __arg);
}
