package org.cocons.argo.cognitive.critics;

import org.argouml.uml.cognitive.critics.CrUML;
import org.argouml.cognitive.Designer;


import java.util.Vector;
import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;

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
	setDescription("Test critique");

	// makes the critique active
	addSupportedDecision(CrCoCon.decCONSTRAINT);

  }  

  /**
   * This method checks the OnlyReadableBy Constraint.
   * @return <code>true</code> if this critic is to be applied, <code>
   *         false </code> otherwise.
   */
  public boolean predicate(Object dm, Designer dsgr) {
	/*//check if the given object is a context based constraint
	if (!(dm instanceof MContextbasedConstraintImpl)) {
	  return NO_PROBLEM;
	}

	//get ContextBasedConstraint and check if the type is correct
	MContextbasedConstraintImpl CoCon = (MContextbasedConstraintImpl)dm;
	if (CoCon.getCoConType()!=MContextbasedConstraintImpl.TYPE_ONLY_READABLE_BY) {
	  return NO_PROBLEM;
	}

	//get ConstrainedElements
	MContextCondition constrainedCondition = CoCon.getConstrainedSet();
	Vector constrainedElements = CoCon.getConstrainedModelElements();
	getScopedElements
   	MContextCondition scopedCondition = CoCon.getScopeSet();
	Vector scopedElements = CoCon.getScopedModelElements();

	//look up all associations and check if any constraint is violated
	Project project = ProjectBrowser.TheInstance.getProject();*/


	return true;
  }      
}