package org.cocons.uml.ccl;

import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * A context condition provides an indirect association to modelelements.
 * Therefore a context condition sets up conditions for model elements to
 * comply with.
 * Creation date: (02.01.2002 22:20:05)
 * @author: Fadi Chabarek
 */
public interface ContextCondition {
/**
 * Returns a String representing a base class, model elements must descend from
 * to comply this context condition.
 * Creation date: (02.01.2002 22:30:20)
 * @return java.lang.String the base class representation.
 */
public String getBaseClass();
/**
 * Returns the range of this context condition.
 * A range limits the number of model elements that can be selected
 * through a context condition.
 * Creation date: (02.01.2002 22:33:53)
 * @return ru.novosoft.uml.foundation.data_types.MMultiplicity the range.
 */
public MMultiplicity getRange();
/**
 * Checks if the conditional is complied with a given model element
 * and if the base class and the range fits.
 * Creation date: (02.01.2002 23:05:28)
 * @return boolean true if the model element complies this context condition.
 * @param modelElement ru.novosoft.uml.foundation.core.MModelElement
 */
public boolean isCompliedWith(MModelElement modelElement);
}
