package org.cocons.argo.cognitive.critics;

import org.argouml.cognitive.critics.Critic;



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

public class CrConstrainedReadability extends Critic {

  /**
   * Constructs a ConstrainedReadabilityCritic.

   * More work: Reading Properties from file, for changability reasons.

   */
  public CrConstrainedReadability() {
    super();
    this.setDescription(
      "Observes Modelelements associated to ContextbasedContraints "
    + "with the type 'UnReadable' defined by the Component Constraint Language.\n\n"
    + "Therefore a scoped modelelement is criticized for reading a constrained "
    + "modelelement, if the scoping and constraining ContextbasedConstraint has "
    + "the type 'UnReadable'.\n\n"
    + "Exemplary you could define in a Constraint Diagram that \n"
    + "ALL CLASSES WHERE ´Personal Data´ EQUALS ´Yes ´ MUST BE UNREADABLE BY "
    + "THE COMPONENT ´Data Warehouse´.\n\n"
    + "Thus Reading a class with 'Personal Data' the DataWarehouse would raise an"
    + "alarm by this critic");

    this.setExpertEmail("info@cocons.org <info@cocons.org>");
    this.setHeadline("Must Unreadable By");
    this.setMoreInfoURL("http://www.cocons.org");

  }

}