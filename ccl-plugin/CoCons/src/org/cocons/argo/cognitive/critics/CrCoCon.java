package org.cocons.argo.cognitive.critics;

import org.argouml.cognitive.Decision;
import org.argouml.cognitive.Designer;
import org.argouml.cognitive.critics.Critic;

/**
 * Title: CoCons
 * Description: Abstract Critic subclass that defines and registers
 * the CONSTRAINT-category of design decision that the critics can
 * address. In contrast to the CrUML-class this class can be placed in a plugin
 * without placing static variables in the UMLCognitiveResourceBundle to define
 * the headline of this DesignCritic.
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
  public abstract boolean predicate(Object dm, Designer dsgr);

}