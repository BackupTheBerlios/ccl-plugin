package org.cocons.argo.cognitive.critics;

import java.util.Vector;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.CoConTypes;
import org.cocons.uml.ccl.ComparisonImpl;
import org.cocons.uml.ccl.ContextConditionImpl;
import org.cocons.uml.ccl.Comparison;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.uml.ccl.ContextCondition;
import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.BaseClasses;
import org.cocons.uml.ccl.comparators.ComparatorFactory;
import ru.novosoft.uml.foundation.core.MModelElement;

/**
 * The design critic that supervises the NotTheSameAs Contextbased Constraint.
 *
 * @see org.cocons.uml.ccl.MContextbasedConstraint
 * @see www.cocons.org
 *
 * @author: Stefan Tang, Fadi Chabarek
 */
public class CrNotTheSameAs extends CrCoCon {

  /**
   * Constructs this Critic.
   */
  public CrNotTheSameAs() {
	super();
	// set headline
	setHeadline("NotTheSameAs Contextbased Constraint violated");
	// set description
	setDescription("A model element is associated both in the target and scope set " +
	  "of a NotTheSameAs Contextbased Constraint.");
  }

  /**
   * Predicate showing weather this critic found a problem in the
   * argouml-model or not.
   *
   * @return boolean true if a SetToValueIn-Contextbased Constraint is violated.
   */
  public boolean predicate(Object dm, org.argouml.cognitive.Designer dsgr) {

	//check if the given object is a context based constraint
	if (!(dm instanceof MContextbasedConstraintImpl)) {
	  return NO_PROBLEM;
	}
	//get ContextBasedConstraint and check if the type is correct
	MContextbasedConstraintImpl cocon = (MContextbasedConstraintImpl)dm;
        // do this check incase a cocon has just been instantiated
        // and no type has been set
        if (cocon.getCoConType()==null) {
          return NO_PROBLEM;
        }
	if (cocon.getCoConType().equals(CoConTypes.NOT_THE_SAME_AS_TYPE)) {
	  cocon.update();
	  Vector targetSet = cocon.getTargetElements();
	  Vector scopeSet = cocon.getScopedElements();
	  // check for null first!
          if ((targetSet!=null) && (scopeSet!=null)) {
            for (int t = 0; t < targetSet.size(); t++) {
	      if (!scopeSet.contains(targetSet.elementAt(t))) {
	        return PROBLEM_FOUND;
	      }
            }
          }
	}
	return NO_PROBLEM;

  }

  protected boolean predicate(MContextbasedConstraint cocon) {
    return NO_PROBLEM;
  }

}