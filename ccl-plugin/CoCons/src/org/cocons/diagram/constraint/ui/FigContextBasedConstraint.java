package org.cocons.diagram.constraint.ui;

import java.awt.*;
import org.argouml.uml.diagram.ui.*;
import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;



/**
 * Title:        ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2000
 * Company:      University of California
 * @author
 * @version 0.9
 */

public class FigContextBasedConstraint extends FigEdgeModelElement {

  ////////////////////////////////////////////////////////////////
  // constructors

  public FigContextBasedConstraint() {
    addPathItem(_stereo, new PathConvPercent(this, 50, 10));
    ArrowHeadTriangle endArrow = new ArrowHeadTriangle();
    endArrow.setFillColor(Color.white);
    setDestArrowHead(endArrow);
    setBetweenNearestPoints(true);
  }

  public FigContextBasedConstraint(Object edge) {
    this();
    setOwner(edge);
  }

  protected boolean canEdit(Fig f) { return false; }

  ////////////////////////////////////////////////////////////////
  // event handlers

  /** This is called aftern any part of the UML MModelElement has
   *  changed. This method automatically updates the name FigText.
   *  Subclasses should override and update other parts. */
  protected void modelChanged() {
    // do not set _name
    updateStereotypeText();
  }



} /* end class FigContextBasedConstraint */

