package org.cocons.argo.cognitive.critics;


import org.argouml.cognitive.critics.Critic;
import org.argouml.cognitive.Designer;

import ru.novosoft.uml.foundation.core.MModelElement;

import java.util.Vector;

import org.cocons.uml.ccl.MContextbasedConstraint;


/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Fadi Chabarek
 * @version 1.0
 *
 * ArgoUml Design critic to observe ContextbasedContraints with the type
 * 'UnReadable' defined by the CCL.
 * Therefore a scoped modelelement is criticized for reading a constrained
 * modelelement, if the scoping and constraining ContextbasedConstraint has
 * the type 'UnReadable'.
 *
 */

public class CrUnReadableBy extends CrCoCon {

	////////////////////////  Decriptionelements //////////////////////////////
	public static final String EXPERT_EMAIL = "info@cocons.org <info@cocons.org>";
	public static final String HEADLINE = "Must Unreadable By";
	public static final String MORE_INFO_URL = "http://www.cocons.org";
	public static final String DESCRIPTION_EN =
	"Observes Modelelements associated to ContextbasedContraints "
    + "with the type 'UnReadable' defined by the Component Constraint Language.\n\n"
    + "Therefore a scoped modelelement is criticized for reading a constrained "
    + "modelelement, if the scoping and constraining ContextbasedConstraint has "
    + "the type 'UnReadable'.\n\n"
    + "Exemplary you could define in a Constraint Diagram that \n"
    + "ALL CLASSES WHERE ´Personal Data´ EQUALS ´Yes ´ MUST BE UNREADABLE BY "
    + "THE COMPONENT ´Data Warehouse´.\n\n"
    + "Thus Reading a class with 'Personal Data' the DataWarehouse would raise an"
    + "alarm by this critic";


  /**
   * Constructs a ConstrainedReadabilityCritic.
   * More work: Reading Properties from file, for changability reasons.
   */
  public CrUnReadableBy() {
    super();


    setExpertEmail(EXPERT_EMAIL);
    setHeadline(HEADLINE);
    setMoreInfoURL(MORE_INFO_URL);
    setDescription(DESCRIPTION_EN);


    addSupportedDecision(CrCoCon.decCONSTRAINT);

  }

  public boolean predicate(Object dm, Designer dsgr) {

    /*MContextbasedConstraint cocon = null;

    if(!(dm instanceof MContextbasedConstraint)) {
      return NO_PROBLEM;
    } else {
        cocon = (MContextbasedConstraint) dm;

        Vector constrainedElements =
          cocon.getScopeSet().getConditionedModelElements();

        Vector scopedElements =
          cocon.getConstrainedSet().getConditionedModelElements();

        MModelElement modelElement = null;


    }*/
    return false;
  }




}