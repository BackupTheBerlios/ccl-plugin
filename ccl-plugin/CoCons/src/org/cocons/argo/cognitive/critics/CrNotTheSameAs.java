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

  // only for testing purpose
  MContextbasedConstraintImpl cocon = new MContextbasedConstraintImpl();
  static boolean gemacht = false;

 /* private void setUpCoCon() {
	ComparisonImpl sComp = new ComparisonImpl();
	ComparatorFactory cf = new ComparatorFactoryImpl();
	ContextConditionImpl targetSet = new ContextConditionImpl();
	ContextConditionImpl scopeSet = new ContextConditionImpl();
	ComparisonImpl tComp = new ComparisonImpl();
	// The example expressed in ccl:
	// ALL INTERFACES WHERE `Workflow' CONTAINS `Integrate Two Contracts'
	// MUST BE SetToValueIn IN
	// ALL ELEMENTS WITH `<<Configure>> Historization' = `To Local Logfile'
	// init
	cocon = new MContextbasedConstraintImpl();
	targetSet = new ContextConditionImpl();
	scopeSet = new ContextConditionImpl();
	tComp = new ComparisonImpl();
	sComp = new ComparisonImpl();
	cf = new ComparatorFactoryImpl();

	// 1) constructs cocon
	// target tree
	tComp.setTag("Workflow");
	tComp.setComparator(cf.produceComparatorWithType(cf.CONTAINS));
	tComp.setValue("PayWage");

	targetSet.setBaseClass(BaseClasses.COMPONENT);
	targetSet.setComparison(tComp);
	// scope tree
	sComp.setTag("OperationalArea");
	sComp.setComparator(cf.produceComparatorWithType(cf.CONTAINS));
	sComp.setValue("FieldService");

	scopeSet.setBaseClass(BaseClasses.COMPONENT);
	scopeSet.setComparison(sComp);

	Vector targetSetConditions = new Vector();
	targetSetConditions.addElement(targetSet);
	cocon.setTargetSetContextConditions(targetSetConditions);
	cocon.setCoConType(CoConTypes.NOT_THE_SAME_AS_TYPE);
	Vector scopeSetConditions = new Vector();
	scopeSetConditions.addElement(scopeSet);
	cocon.setScopeSetContextConditions(scopeSetConditions);
  }*/

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
	// this is only for testing purpose, uses hardcoded cocon
	//return predicate(cocon);


	//check if the given object is a context based constraint
	if (!(dm instanceof MContextbasedConstraintImpl)) {
	  return NO_PROBLEM;
	}
	//get ContextBasedConstraint and check if the type is correct
	MContextbasedConstraintImpl coCon = (MContextbasedConstraintImpl)dm;
	if (cocon.getCoConType().equals(CoConTypes.NOT_THE_SAME_AS_TYPE)) {
	  cocon.update();
	  Vector targetSet = cocon.getTargetElements();
	  Vector scopeSet = cocon.getScopedElements();
	  for (int t = 0; t < targetSet.size(); t++) {
	if (!scopeSet.contains(targetSet.elementAt(t))) {
	  return PROBLEM_FOUND;
	}
	  }
	}
	return NO_PROBLEM;

  }  

  /**
   * Checks weather the given Contextbased Constraint has the type SetToValueIn
   * and if that's the case if it is violated within the argouml-model.
   *
   * @return boolean true - if the given cocon is violated.
   * @param cocon org.cocons.uml.ccl.MContextbasedConstraint a SetToValueInCocon
   */
  protected boolean predicate(MContextbasedConstraint cocon) {

	// testing only
   /* if (!gemacht) {
	  setUpCoCon();
	  gemacht = true;
	}*/

	cocon.update();


	if (cocon.getCoConType().equals(CoConTypes.NOT_THE_SAME_AS_TYPE)) {
	  Vector targetSet = cocon.getTargetElements();
	  Vector scopeSet = cocon.getScopedElements();
	  for (int t = 0; t < targetSet.size(); t++) {
	if (scopeSet.contains(targetSet.elementAt(t))) {
		  // the constraint is violated
		  MModelElement violationElement = (MModelElement)targetSet.elementAt(t);
		  setDescription("The model element " + violationElement.getName() +
			" is associated both in the target and scope set " +
			"of a NotTheSameAs Contextbased Constraint.");
	  return PROBLEM_FOUND;
	}
	  }
	}
	return NO_PROBLEM;
  }      
}