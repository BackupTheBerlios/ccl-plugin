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

public interface MConstraint extends MModelElement
{
  // generating attributes
  // attribute: body
  MBooleanExpression getBody();
  void setBody(MBooleanExpression __arg);
  // generating associations
  // opposite role: constrainedStereotype this role: stereotypeConstraint
  MStereotype getConstrainedStereotype();
  void setConstrainedStereotype(MStereotype __arg);
  void internalRefByConstrainedStereotype(MStereotype __arg);
  void internalUnrefByConstrainedStereotype(MStereotype __arg);
  // opposite role: constrainedElement this role: constraint
  List getConstrainedElements();
  void setConstrainedElements(List __arg);
  void addConstrainedElement(MModelElement __arg);
  void removeConstrainedElement(MModelElement __arg);
  void addConstrainedElement(int __pos, MModelElement __arg);
  void removeConstrainedElement(int __pos);
  void setConstrainedElement(int __pos, MModelElement __arg);
  MModelElement getConstrainedElement(int __pos);
  /**
   * Gets all links of the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @return unmodifyable copy of the current ContextPropertyTags
   */
  Collection getContextPropertyTags();
  /**
   * Sets all links of the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg new collection of ContextPropertyTags or Collections.EMPTY_LIST to
   *        remove all links.
   */
  void setContextPropertyTags(Collection _p0);
  /**
   * Adds a link to the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg ContextPropertyTag to be linked to this instance
   */
  void addContextPropertyTag(MContextPropertyTag __arg);
  /**
   * Removes a link from the association valueValidation(Constraint)
   *             / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg ContextPropertyTag to be unlinked from this instance
   * @throws RuntimeException when __arg is not linked to this instance
   */
  void removeContextPropertyTag(MContextPropertyTag __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyTag to be referenced
   */
  void internalRefByContextPropertyTag(MContextPropertyTag __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ContextPropertyTag to be unreferenced
   */
  void internalUnrefByContextPropertyTag(MContextPropertyTag __arg);

}
