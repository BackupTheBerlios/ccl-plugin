package org.cocons.uml.ccl.util;

import org.cocons.uml.ccl.ccldata.CoConSetData;
import org.cocons.uml.ccl.ContextCondition;

/**
 * Interface to the Parser who parses the XML Data Object
 * into the ContextCondition trees.
 *
 * @author Stefan Tang, Fadi Chabarek, Philip Schumacher
 * @version $Revision 1.1$
 */
public interface XMLDataToContextConditionParser {

  /**
   * Parses a set from the XML Data Object into the
   * ContextCondition tree.
   *
   * @param target the ContextCondition in XML Data
   */
  public ContextCondition generateContextCondition(CoConSetData set);

}