package org.cocons.argo.cognitive.critics;

import java.util.Vector;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.CoConTypes;

/**
 * Criticising modelelements that break rules set up from further defined
 * SetToValueIn-Contextbased constraints.
 * @see org.cocons.uml.ccl.MContextbasedConstraint
 * @see www.cocons.org
 * Creation date: (15.01.2002 12:56:50)
 * @author: Fadi Chabarek
 */
public class CrSetToValueIn extends CrCoCon {

	/**
	 * Constructs this Critic.
	 */
	public CrSetToValueIn() {
		super();
		// set headline
		setHeadline("Bruch eines SetToValueIn Cocons");

		// set description
		setDescription(
			"Das von einem SetToValueIn Cocon aufgestellte " + "kontextbasierendes Constraint wurde verletzt."); 
	}

	/**
	 * Predicate showing weather this critic found a problem in the
	 * argouml-model or not.
	 * @return boolean true if a SetToValueIn-Contextbased Constraint is violated.
	 */
	public boolean predicate(Object dm, org.argouml.cognitive.Designer dsgr) {

		if (dm instanceof MContextbasedConstraint) {
			MContextbasedConstraint cocon = (MContextbasedConstraint) dm;
			return predicate(cocon);
		}
		return NO_PROBLEM;
	}

	/**
	 * Checks weather the given Contextbased Constraint has the type SetToValueIn
	 * and if that's the case if it is violated within the argouml-model.
	 * Creation date: (15.01.2002 13:09:34)
	 * @return boolean true - if the given cocon is violated.
	 * @param cocon org.cocons.uml.ccl.MContextbasedConstraint a SetToValueInCocon
	 */
	private boolean predicate(MContextbasedConstraint cocon) {

		//the constraint is violated, if a model element of the target set
		// is not in the scoped set.

		if (cocon.getCoConType().equals(CoConTypes.SET_TO_VALUE_IN_TYPE)) {
			Vector targetSet = cocon.getTargetElements();
			Vector scopeSet = cocon.getScopedElements();

			// to avoid nullpointers
			if(targetSet == null) {
				return NO_PROBLEM;
			} 
			if(scopeSet == null) {
				if(targetSet.size() > 0) {
					return PROBLEM_FOUND;
				} else {
					return NO_PROBLEM;
				}
			}

			// the check
			for (int t = 0; t < targetSet.size(); t++) {
				if (!scopeSet.contains(targetSet.elementAt(t))) {
					return PROBLEM_FOUND;
				}
			}
		}

		return NO_PROBLEM;
	}
}