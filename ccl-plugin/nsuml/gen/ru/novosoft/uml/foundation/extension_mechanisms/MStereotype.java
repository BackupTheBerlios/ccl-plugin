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


public interface MStereotype extends MGeneralizableElement
{
  // generating attributes
  // attribute: baseClass
  /**
   *  @deprecated obsolete in UML 1.4
   *
  */
  String getBaseClass();
  /**
   *  @deprecated obsolete in UML 1.4
   *
  */
  void setBaseClass(String __arg);

  // attribute: icon
  String getIcon();
  void setIcon(String __arg);
  // generating associations
  // opposite role: stereotypeConstraint this role: constrainedElement2
  Collection getStereotypeConstraints();
  void setStereotypeConstraints(Collection __arg);
  void addStereotypeConstraint(MConstraint __arg);
  void removeStereotypeConstraint(MConstraint __arg);
  void internalRefByStereotypeConstraint(MConstraint __arg);
  void internalUnrefByStereotypeConstraint(MConstraint __arg);
  // opposite role: extendedElement this role: stereotype
  Collection getExtendedElements();
  void setExtendedElements(Collection __arg);
  void addExtendedElement(MModelElement __arg);
  void removeExtendedElement(MModelElement __arg);
  void internalRefByExtendedElement(MModelElement __arg);
  void internalUnrefByExtendedElement(MModelElement __arg);
  // opposite role: requiredTag this role: stereotype
  /* obsolete in UML1.3
  Collection getRequiredTags();
  void setRequiredTags(Collection __arg);
  void addRequiredTag(MTaggedValue __arg);
  void removeRequiredTag(MTaggedValue __arg);
  void internalRefByRequiredTag(MTaggedValue __arg);
  void internalUnrefByRequiredTag(MTaggedValue __arg);
  */
  /**
   * Gets all current values of the attribute BaseClass.
   *
   * @return unmodifyable copy of the current BaseClasses collection
   */
  Collection getBaseClasses();
  /**
   * Sets all values of the attribute BaseClass.
   *
   * @param __arg new collection of BaseClasses or Collections.EMPTY_LIST to
   *        remove all BaseClasses.
   */
  void setBaseClasses(Collection __arg);
  /**
   * Adds a value to the attribute BaseClass.
   *
   * @param __arg BaseClass to be added to this instance
   */
  void addBaseClass(String __arg);
  /**
   * Removes a value from the attribute BaseClass.
   *
   * @param __arg BaseClass to be removed from this instance
   * @throws RuntimeException when __arg is not a BaseClass of this instance
   */
  void removeBaseClass(String __arg);

  /**
   * Gets all current links of the association owner(Stereotype)
   * / definedTag(TagDefinition).
   *
   * @return unmodifyable copy of the current DefinedTags collection
   */
  Collection getDefinedTags();
  /**
   * Sets all links of the association owner(Stereotype)
   *  / definedTag(TagDefinition).
   *
   * @param __arg new collection of DefinedTags or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setDefinedTags(Collection __arg);
  /**
   * Adds a link to the association owner(Stereotype)
   *  / definedTag(TagDefinition).
   *
   * @param __arg DefinedTag to be linked to this instance
   */
  void addDefinedTag(MTagDefinition __arg);
  /**
   * Removes a link from the association owner(Stereotype)
   *  / definedTag(TagDefinition).
   *
   * @param __arg DefinedTag to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeDefinedTag(MTagDefinition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg DefinedTag to be referenced
   */
  void internalRefByDefinedTag(MTagDefinition __arg);
  /**
   * internal use only - should never be called directly
   * @param __arg DefinedTag to be unreferenced
   */
  void internalUnrefByDefinedTag(MTagDefinition __arg);

  /**
   * Gets all current links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @return unmodifyable copy of the current Restrictions collection
   */
  Collection getRestrictions();
  /**
   * Sets all links of the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg new collection of Restrictions or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setRestrictions(Collection __arg);
  /**
   * Adds a link to the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg Restriction to be linked to this instance
   */
  void addRestriction(MContextCondition __arg);
  /**
   * Removes a link from the association restrictedStereotype(Stereotype)
   * / restriction(ContextCondition).
   *
   * @param __arg Restriction to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeRestriction(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg Restriction to be referenced
   */
  void internalRefByRestriction(MContextCondition __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg Restriction to be unreferenced
   */
  void internalUnrefByRestriction(MContextCondition __arg);

}
