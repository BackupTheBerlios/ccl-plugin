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
/**
 * Criticising modelelements that break rules set up from further defined
 * SetToValueIn-Contextbased constraints.
 * @see org.cocons.uml.ccl.MContextbasedConstraint
 * @see www.cocons.org
 *
 * @author: Stefan Tang, Fadi Chabarek
 */
public class CrNotTheSameAs extends CrCoCon {

	/**
	 * A context based constraint, describing:
	 * ALL INTERFACES WHERE `Workflow' CONTAINS `Integrate Two Contracts'
	 * MUST BE SetToValueIn IN
	 * ALL ELEMENTS WITH `<<Configure>> Historization' = `To Local Logfile'
	 */
	MContextbasedConstraintImpl cocon = new MContextbasedConstraintImpl();

	/**
	 * The cocon's target context condition, describing
	 * ALL INTERFACES WHERE `Workflow' CONTAINS `Integrate Two Contracts'
	 */
	ContextConditionImpl targetSet = new ContextConditionImpl();

	/**
	 * The cocon's scope context condition, describing
	 * ALL ELEMENTS WITH `<<Configure>> Historization' = `To Local Logfile'
	 */
	ContextConditionImpl scopeSet = new ContextConditionImpl();

	/**
	 * A comparison of the target context condition, describing
	 * `Workflow' CONTAINS `Integrate Two Contracts'
	 */
	ComparisonImpl tComp = new ComparisonImpl();

	/**
	 * A comparison of the scope context condition, describing
	 * `<<Configure>> Historization' = `To Local Logfile'
	 */
	ComparisonImpl sComp = new ComparisonImpl();

	/**
	 * A factory producing comparisons.
	 */
	ComparatorFactory cf = new ComparatorFactoryImpl();


	/**
		 * Sets the CoCon up for this test.
		 * Creation date: (15.01.2002 18:08:56)
		 */
	private void setUpCoCon() {

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
		tComp.setTag("'Workflow'");
		tComp.setComparator(cf.produceComparatorWithType(cf.CONTAINS));
		tComp.setValue("`Pay Wages'");

		targetSet.setBaseClass(BaseClasses.INTERFACE);
		targetSet.setComparison(tComp);

		// scope tree
		sComp.setTag("`Operational Area'");
		sComp.setComparator(cf.produceComparatorWithType(cf.CONTAINS));
		sComp.setValue("`Field Service'");

		scopeSet.setBaseClass(BaseClasses.ELEMENT);
		scopeSet.setComparison(sComp);

                Vector targetSetConditions = new Vector();
                targetSetConditions.addElement(targetSet);
		cocon.setTargetSetContextConditions(targetSetConditions);
		cocon.setCoConType(CoConTypes.NOT_THE_SAME_AS_TYPE);
                Vector scopeSetConditions = new Vector();
                scopeSetConditions.addElement(scopeSet);
		cocon.setScopeSetContextConditions(scopeSetConditions);

	}

	/**
	 * Constructs this Critic.
	 */
	public CrNotTheSameAs() {
		super();

		setUpCoCon();

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

		return predicate(cocon);
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

		if (cocon.getCoConType().equals(CoConTypes.NOT_THE_SAME_AS_TYPE)) {
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
}