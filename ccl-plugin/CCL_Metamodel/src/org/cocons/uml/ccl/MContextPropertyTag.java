package org.cocons.uml.ccl;

import org.cocons.uml.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.core.*;
/**
 * Interface to a CCL ContextPropertyTag metaclass.
 *
 * @author Martin Skinner
 * @version 1.0
 */

public interface MContextPropertyTag extends MTagDefinition {
  /**
   * Gets the link of the association valueValidation(Constraint)
   * / contextPropertyTag(ContextPropertyTag).
   *
   * @return current ValueValidation of the instance
   */
  MConstraint getValueValidation();
  /**
   * Sets the link of the association valueValidation(Constraint)
   * / contextPropertyTag(ContextPropertyTag).
   *
   * @param __arg new ValueValidation of the instance
   */
  void setValueValidation(MConstraint __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ValueValidation to be referenced
   */
  void internalRefByValueValidation(MConstraint __arg);
  /**
   * internal use only - should never be called directly.
   * @param __arg ValueValidation to be unreferenced
   */
  void internalUnrefByValueValidation(MConstraint __arg);
}