package org.cocons.argo.cognitive.critics;

import org.argouml.cognitive.Decision;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.critics.Critic;

import org.cocons.uml.ccl.MContextbasedConstraint;import java.util.Collection;import org.cocons.uml.ccl.util.SetCalculator;/**
 * Title: CoCons
 * Description: Abstract Critic subclass that defines and registers
 * the CONSTRAINT-category of design decision that the critics can
 * address. In contrast to the CrUML-class this class can be placed in a plugin
 * without placing static variables in the UMLCognitiveResourceBundle to define
 * the headline of this DesignCritic.
 *
 * TODO: ResourceBundles instead of setHeadline and setDescription resprectivly
 *		, maybe better extending CrUML instead of Critic.
 *
 * @see org.argouml.cognitive.Designer
 * @see org.argouml.cognitive.DecisionModel
 * @see org.argouml.uml.cognitive.critics.UMLCognitiveResourceBundle
 * @see org.argouml.uml.cognitive.critics.CrUML
 *
 * Copyright:    Copyright (c) 2001
 * Company: TU Berlin, CIS
 * @author Fadi Chabarek
 * @version 1.0
 *
 */

public abstract class CrCoCon extends Critic {

  /**
   * Contains a Contraint-Decision
   */
  public static final Decision decCONSTRAINT = new
	 Decision("Constraint", 5);

  /**
   *  The more info url
   */
  public static final String MORE_INFO_URL = "www.cocons.org";

   /** Static initializer for this class. Called when the class is
	*  loaded (which is before any subclass instances are instanciated).
	*  The decision will now be considered by the designer, so that
	*  extending classes just have to add the Contraint-Decision to their
	*  supported Decisions.
	*/
  static {
	Designer d = Designer.theDesigner();
	d.startConsidering(decCONSTRAINT);
  }

  /**
   * Constructs a CrCoCon.
   */
  public CrCoCon() {
	// makes the critique active
	addSupportedDecision(CrCoCon.decCONSTRAINT);

	setMoreInfoURL(MORE_INFO_URL);
  }    

  /**
   * Returns true if a Contextbased Constraint is violated.
   */
  public boolean predicate(Object dm, Designer dsgr) {

	if(dm instanceof MContextbasedConstraint) {
		return predicate((MContextbasedConstraint) dm);
	}
	  
	return NO_PROBLEM;	  
  }    

  

	/**
	 * The set calculator used for set operations on target and scope set.
	 */
	private SetCalculator setCalculator;/**
 * Returns the set of model elements that are both, in the target set and in the scope set.
 * Creation date: (03.03.2002 15:11:07)
 * @param MContextbasedConstraint the cocon providing target and scope set.
 * @return java.util.Collection the intersection between target and scope. The elements of the collection
 * are from type MModelElement.
 */
public Collection getIntersectedTargetScopeSet(MContextbasedConstraint cocon) {

	return setCalculator.calculateIntersection(cocon.getTargetElements(), cocon.getScopedElements());
}/**
 * Returns the set of model elements that are in the target set and in the scope set.
 * Creation date: (03.03.2002 15:11:07)
 * @param MContextbasedConstraint the cocon providing target and scope set.
 * @return java.util.Collection the unification between target and scope. The elements of the collection
 * are from type MModelElement.
 */
public Collection getUnifiedTargetScopeSet(MContextbasedConstraint cocon) {
	return setCalculator.calculateUnification(cocon.getTargetElements(), cocon.getScopedElements());
}/**
 * Returns true if a Contextbased Constraint is violated.
 * Creation date: (03.03.2002 14:57:30)
 * @return boolean true if the Cocon ist violated.
 * @param cocon org.cocons.uml.ccl.MContextbasedConstraint the Cocon.
 */
protected abstract boolean predicate(MContextbasedConstraint cocon);}