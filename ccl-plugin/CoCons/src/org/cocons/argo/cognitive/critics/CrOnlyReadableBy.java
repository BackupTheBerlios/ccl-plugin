package org.cocons.argo.cognitive.critics;

import org.argouml.uml.cognitive.critics.CrUML;
import org.argouml.cognitive.Designer;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.uml.ccl.MContextCondition;

/**
 * Title: UnReadableBy CoCon
 * Description: Implementation of the OnlyReadableBy Constraint
 * Copyright:    Copyright (c) 2001
 * Company: Technical University of Berlin, Dept. of Computer Science
 * @author Stefan Tang, Philipp Schumacher
 * @version 1.0
 */

public class CrOnlyReadableBy extends CrCoCon {

  public CrOnlyReadableBy() {


    // set headline
    setHeadline("Test critique");

    // set description
    setDescription("Yet another fucking critique");

    // makes the critique active
    addSupportedDecision(CrCoCon.decCONSTRAINT);

  }

  /**
   * This method checks the OnlyReadableBy Constraint.
   * Looks up all
   *
   * @return <code>true</code> if this critic is to be applied, <code>
   *         false </code> otherwise.
   */
  public boolean predicate(Object dm, Designer dsgr) {
    //check if the given object is a context based constraint
    if (!(dm instanceof MContextbasedConstraintImpl)) {
      return NO_PROBLEM;
    }
    //get ContextBasedConstraint and Sets
    MContextbasedConstraintImpl CoCon = (MContextbasedConstraintImpl)dm;
    MContextCondition constraintSet = CoCon.getConstrainedSet();
    MContextCondition scopeSet = CoCon.getScopeSet();

    //looks up all model elements in the constraint set



  return true;
  }
}