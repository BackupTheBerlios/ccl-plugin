package org.cocons.argo.cognitive.critics;

import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.CoConTypes; 

import java.util.Collection;

/**
* Critic, that checks 'TheSameAs' Cocons.<br>
* See further informations at our
* <a href="http://www.cocons.org/publications/CCL_technical_report.pdf">technical report</a>.<br>
* Creation date: (03.03.2002 14:52:13)
* @author: Fadi Chabarek
*/
public class CrTheSameAs extends CrCoCon {

	/**
	 * Constructs this Critic.
	 */
	public CrTheSameAs() {
		super();
		setHeadline("TheSameAs Contextbased Constraint violated");
		setDescription(
			"TheSameAs CoCons: Their target set must contain the same elements"
				+ "as their scope set. The CoCon's context condition(s) must apply both"
				+ "to all elements in the target and to all elements in the scope set. If two "
				+ "context conditions are used to specify both the target and the scope set,"
				+ "than the target context condition must also apply to the scope context"
				+ "condition and vice versa."); 
	}
	/**
	 * Checks weather a cocon contains in its target set the same elements
	 * as in its scope set.
	 * Creation date: (03.03.2002 14:53:43)
	 * @return boolean PROBLEM - if that is not the case
	 * @param cocon org.cocons.uml.ccl.MContextbasedConstraint the cocon defining the scope and target set.
	 */
	public boolean predicate(MContextbasedConstraint cocon) {

		if (cocon.getCoConType().equals(CoConTypes.THE_SAME_AS)) {
			Collection targetSet = cocon.getTargetElements();
			Collection scopeSet = cocon.getScopedElements();

			if (!(targetSet.containsAll(scopeSet) && scopeSet.containsAll(targetSet))) {
				return PROBLEM_FOUND;
			}
		}

		return NO_PROBLEM;
	}
}