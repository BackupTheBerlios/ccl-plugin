package org.cocons.argo.cognitive.critics;

import java.util.Vector;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.CoConTypes;

/**
 * Criticising modelelements that break rules set up from further defined
 * SetToValueIn-Contextbased constraints.
 * @see org.cocons.uml.ccl.MContextbasedConstraint
 * Creation date: (15.01.2002 12:56:50)
 * @author: Fadi Chabarek
 */
public class CrSetToValueIn extends CrCoCon {
	
	/**
	 * CrSetToValueIn constructor comment.
	 */
	public CrSetToValueIn() {
		super();
	}
    
	/**
	  * Returns true if a SetToValueIn-Contextbased Constraint is violated.
	  */
	public boolean predicate(Object dm, org.argouml.cognitive.Designer dsgr) {

		if (dm instanceof MContextbasedConstraint) {
			MContextbasedConstraint cocon = (MContextbasedConstraint) dm;
			if (cocon.getCoConType().equals(CoConTypes.SET_TO_VALUE_IN_TYPE)) {
				return predicate(cocon);
			}
		}
		return NO_PROBLEM;
	}
    
	/**
	 * Insert the method's description here.
	 * Creation date: (15.01.2002 13:09:34)
	 * @return boolean
	 * @param cocon org.cocons.uml.ccl.MContextbasedConstraint
	 */
	private boolean predicate(MContextbasedConstraint cocon) {

		//the constraint is broken, if a model element of the target set
		// is not in the scoped set. Fix: setting the model element's 
		// context property values appropriatly.

		Vector targetSet = cocon.getTargetElements();
		Vector scopeSet = cocon.getScopedElements();

		for (int t = 0; t < targetSet.size(); t++) {
			if (!scopeSet.contains(targetSet.elementAt(t))) {
				return PROBLEM_FOUND;
			}
		}

		return NO_PROBLEM;
	}
}