package org.cocons.argo.cognitive.critics;

import org.cocons.argo.cognitive.critics.CrCoCon;
import org.argouml.cognitive.Designer;

import org.cocons.uml.ccl.ContextCondition;
import java.util.Vector;
import ru.novosoft.uml.foundation.core.*;
import org.argouml.ui.ProjectBrowser;
import org.argouml.kernel.Project;
import org.cocons.uml.ccl.CoConTypes;

import org.cocons.uml.ccl.MContextbasedConstraint;/**
 * The design critique that checks the NotAllowedToExistIn CoCon.
 *
 * @author Stefan Tang
 * @version $Revision 1.1$
 */
public class CrNotAllowedToExistIn extends CrCoCon {

  public CrNotAllowedToExistIn() {
	setHeadline("NotallowedToExistIn CoCon");
	setDescription("An element in the target set is also in the " +
		"scope set, or vice versa.");
  }  



  public boolean predicate(MContextbasedConstraint coCon) {
	
	if (!coCon.getCoConType().equals(CoConTypes.NOT_ALLOWED_TO_EXIST_IN)) {
	  return NO_PROBLEM;
	}

	// get all scope and target elements
	Vector scopeSet = coCon.getScopedElements();
	Vector targetSet = coCon.getTargetElements();

	// critic: test if any element from target set is in the scope set
	for (int i=0; i<scopeSet.size(); i++) {
	  MModelElement scopeElement = (MModelElement)scopeSet.elementAt(i);
	  for (int j=0; j<targetSet.size(); j++) {
		MModelElement targetElement = (MModelElement)targetSet.elementAt(j);
		if (targetElement.equals(scopeElement)) {
		  return PROBLEM_FOUND;
		}
	  }
	}

	// no problem found -> good night
	return NO_PROBLEM;
  }    }