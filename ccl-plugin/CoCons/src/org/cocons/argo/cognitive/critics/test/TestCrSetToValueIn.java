package org.cocons.argo.cognitive.critics.test;

import org.cocons.argo.util.ModelIterator;
import org.cocons.argo.cognitive.critics.CrSetToValueIn;
import org.cocons.uml.ccl.comparators.ComparatorFactoryImpl;
import org.cocons.uml.ccl.comparators.ComparatorFactory;
import org.cocons.uml.ccl.context_property1_3.*;
import org.cocons.uml.ccl.Comparison;
import org.cocons.uml.ccl.ComparisonImpl;
import org.cocons.uml.ccl.ContextCondition;
import org.cocons.uml.ccl.ContextConditionImpl;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.uml.ccl.BaseClasses;
import org.cocons.uml.ccl.CoConTypes;
import ru.novosoft.uml.foundation.core.MModelElement;
import ru.novosoft.uml.foundation.core.MClass;
import ru.novosoft.uml.foundation.core.MInterface;
import ru.novosoft.uml.MFactoryImpl;
import ru.novosoft.uml.MFactory;
import java.util.Vector;
import ru.novosoft.uml.foundation.core.MNamespaceImpl;
import java.beans.PropertyVetoException;
import org.argouml.kernel.Project;
/**
 * Insert the type's description here.
 * Creation date: (15.01.2002 15:24:35)
 * @author: Fadi Chabarek
 */
public class TestCrSetToValueIn extends junit.framework.TestCase {
	MContextbasedConstraintImpl cocon = new MContextbasedConstraintImpl();
	ContextConditionImpl targetSet = new ContextConditionImpl();
	ContextConditionImpl scopeSet = new ContextConditionImpl();
	ComparisonImpl tComp = new ComparisonImpl();
	ComparisonImpl sComp = new ComparisonImpl();

	ComparatorFactory cf = new ComparatorFactoryImpl();
	
	MContextPropertyValueImpl twoContract = new MContextPropertyValueImpl();
	MContextPropertyValueImpl logfile = new MContextPropertyValueImpl();
	MContextPropertyTag workflow = new MContextPropertyTagImpl();
	MContextPropertyTag history = new MContextPropertyTagImpl();

	MContextPropertyValueImpl anotherValue = new MContextPropertyValueImpl();
	MContextPropertyTag anotherTag = new MContextPropertyTagImpl();
	Project project = new Project();
/**
 * TestCrSetToValueIn constructor comment.
 * @param name java.lang.String
 */
public TestCrSetToValueIn(String name) {
	super(name);
}
/**
 * Starts the application.
 * @param args an array of command-line arguments
 */
public static void main(java.lang.String[] args) {
	junit.swingui.TestRunner.run(AllTest.class);
}
/**
 * Sets the test up.
 * Creation date: (15.01.2002 18:04:12)
 */
public void setUp() {

	setUpCoCon();
	setUpProject();	

}
/**
 * Sets the CoCon up for this test.
 * Creation date: (15.01.2002 18:08:56)
 */
private void setUpCoCon() {
	// init
	cocon = new MContextbasedConstraintImpl();
	targetSet = new ContextConditionImpl();
	scopeSet = new ContextConditionImpl();
	tComp = new ComparisonImpl();
	sComp = new ComparisonImpl();

	cf = new ComparatorFactoryImpl();
	
	twoContract = new MContextPropertyValueImpl();
	logfile = new MContextPropertyValueImpl();
	workflow = new MContextPropertyTagImpl();
	history = new MContextPropertyTagImpl();

	anotherValue = new MContextPropertyValueImpl();
	anotherTag = new MContextPropertyTagImpl();

	// 1) constructs cocon
	anotherTag.setTag("`Workflow'");
	anotherValue.setValue("'X'");
	anotherValue.setContextPropertyTag(anotherTag);

	
	// target tree
	workflow.setTag("`Workflow'");
	twoContract.setValue("`Integrate Two Contracts'");
	twoContract.setContextPropertyTag(workflow);	
	
	tComp.setTag(workflow.getTag());
	tComp.setComparator(cf.produceComparatorWithType(cf.CONTAINS));
	tComp.setValue(twoContract.getValue());

	targetSet.setBaseClass(BaseClasses.INTERFACE);
	targetSet.setComparison(tComp);
	
	// scope tree
	history.setTag("`<<Configure>> Historization'");
	logfile.setValue("`To Local Logfile'");
	logfile.setContextPropertyTag(history);

	sComp.setTag(logfile.getTag());
	sComp.setComparator(cf.produceComparatorWithType(cf.EQUAL));
	sComp.setValue(logfile.getValue());

	scopeSet.setBaseClass(BaseClasses.ELEMENT);
	scopeSet.setComparison(sComp);

	cocon.setTargetContextCondition(targetSet);
	cocon.setCoConType(CoConTypes.SET_TO_VALUE_IN_TYPE);
	cocon.setScopeContextCondition(scopeSet);
}
/**
 * Sets the project up for this test.
 * Creation date: (15.01.2002 18:09:18)
 */
private void setUpProject() {
	
	project = new Project();
	MNamespaceImpl model = new MNamespaceImpl();
			
	// generate four model elements that follow the constraint rules.
	MFactory factory = new MFactoryImpl();
	MModelElement[] elements = new MModelElement[4];
	
	// two elements with the given context property value:
	elements[0] = factory.createInterface();
	elements[1] = factory.createInterface();

	
	elements[0].addTaggedValue(workflow);
	elements[0].addTaggedValue(logfile);

	// and two not fitting targets
	elements[2] = factory.createInterface();
	elements[3] = factory.createClass();


	for (int i = 0; i < elements.length; i++){
		model.addOwnedElement(elements[i]);
	}

	try {
		project.addModel(model);
	} catch (PropertyVetoException pve) {
		fail("Failure while building up the example project. Reason: " + pve); 	
	}			
}
/**
 * Tests the critic with an example expressing:
 * Every remote procedure call (RPC) belonging to the 
 * workflow `Integrate Two Contracts' must be recorded in a log-file"
 * Creation date: (15.01.2002 15:26:29)
 */
public void testWithExamples() {


	// The example expressed in ccl:
	// ALL INTERFACES WHERE `Workflow' CONTAINS `Integrate Two Contracts'
	// MUST BE SetToValueIn IN 
	// ALL ELEMENTS WITH `<<Configure>> Historization' = `To Local Logfile'

	
	// tests the predicate method with all elements of the project.	

	CrSetToValueIn critic = new CrSetToValueIn();
	Vector iterator = new ModelIterator().getAllModelElements(project);

	for (int i = 0; i < iterator.size(); i++){
		assertTrue(! critic.predicate(iterator, null));
	}
	
}
}
