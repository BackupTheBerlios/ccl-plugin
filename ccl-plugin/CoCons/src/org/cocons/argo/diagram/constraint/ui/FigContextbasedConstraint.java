package org.cocons.argo.diagram.constraint.ui;

import java.awt.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.diagram.ui.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.cocons.uml.ccl.*;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @version 1.0
 */

public class FigContextbasedConstraint
  extends FigNodeModelElement {

  ////////////////////////////////////////////////////////////////
  // instance variables

  /** UML does not really use ports, so just define one big one so
   *  that users can drag edges to or from any point in the icon. */
  FigCircle _bigPort;

  /* Put in the things for the "person" in the FigActor */
  Fig _scope;
  Fig _constrained;
  FigPoly _triangle;
  FigLine _arrow;
  FigPoly _arrowhead;
  FigText _letter_i;

  // add other Figs here aes needed


  ////////////////////////////////////////////////////////////////
  // constructors

  public FigContextbasedConstraint() {
    // Put this rectangle behind the rest, so it goes first
    //_bigPort = new FigRect(5, 5, 30, 85, Color.gray, Color.gray);
    _bigPort = new FigCircle(10, 10, 20, 30, Color.gray, Color.gray);

    _scope = new FigContextCondition();

    _triangle = new FigPoly(50,10);
    _triangle.addPoint(60,30);
    _triangle.addPoint(40,30);
    _triangle.addPoint(50,10);

    _letter_i = new FigText(43,10,16,15, Color.black,"TimesRoman", 12);
    _letter_i.setText("i");
    _letter_i.setFilled(false);
    _letter_i.setEditable(false);
    _letter_i.setLineWidth(0);
    _letter_i.setWidth(21);

    _arrow = new FigLine(56,25,110,25);

    _arrowhead = new FigPoly(120,25);
    _arrowhead.addPoint(110,22);
    _arrowhead.addPoint(110,28);
    _arrowhead.addPoint(120,25);

    _constrained = new FigContextCondition(null);
    _constrained.translate(120,0);

    _stereo.setBounds(60, 7, 45, 15);
    _stereo.setExpandOnly(false);
    _stereo.setFilled(false);
    _stereo.setLineWidth(0);
    _stereo.setEditable(false);
    _stereo.setHeight(18);
    _stereo.setDisplayed(false);

    _name.setBounds(60, 30, 45, 15);
    _name.setTextFilled(false);
    _name.setFilled(false);
    _name.setLineWidth(0);
    _name.setExpandOnly(false);
    // initialize any other Figs here

    // add Figs to the FigNode in back-to-front order
    addFig(_scope);
    addFig(_arrow);
    addFig(_arrowhead);
    addFig(_triangle);
    addFig(_letter_i);
    addFig(_constrained);

    addFig(_name);
    addFig(_stereo);

  }

  public FigContextbasedConstraint(GraphModel gm, Object node) {
    this();
    setOwner(node);
  }

  public String placeString() { return "new MContextbasedConstraint"; }

  public Object clone() {
    FigContextbasedConstraint figClone = (FigContextbasedConstraint) super.clone();
    Vector v = figClone.getFigs();
    figClone._triangle = (FigPoly) v.elementAt(0);
    figClone._name = (FigText) v.elementAt(1);
    return figClone;
  }

  ////////////////////////////////////////////////////////////////
  // Fig accessors

  public Selection makeSelection() {
    return null;
    // return new SelectionActor(this);
  }

  public void setOwner(Object node) {
    super.setOwner(node);
    bindPort(node, _bigPort);
  }

  /** Returns true if this Fig can be resized by the user. */
  public boolean isResizable() { return false; }

//   public Selection makeSelection() {
//     return new SelectionMoveClarifiers(this);
//   }

  public void setLineColor(Color col) {
    _triangle.setLineColor(col);
  }
  public Color getLineColor() { return _triangle.getLineColor(); }

  public void setFillColor(Color col) { _triangle.setFillColor(col); }
  public Color getFillColor() { return _triangle.getFillColor(); }

  public void setFilled(boolean f) { _triangle.setFilled(f); }
  public boolean getFilled() { return _triangle.getFilled(); }

  public void setLineWidth(int w) {
    _triangle.setLineWidth(w);
  }
  public int getLineWidth() { return _triangle.getLineWidth(); }

  public Dimension getMinimumSize() {
    Dimension nameDim = _name.getMinimumSize();
    int w = nameDim.width;
    int h = nameDim.height + 65;
    return new Dimension(w, h);
  }

  protected void updateStereotypeText() {
    MModelElement me = (MModelElement) getOwner();
    if (me == null) return;
    MStereotype stereo = me.getStereotype();
    if (stereo == null || stereo.getName() == null || stereo.getName().length() == 0)
    {
    	if (! _stereo.isDisplayed()) return;
    	_stereo.setDisplayed(false);
    	return;
    }
    else
    {
    	String stereoStr = stereo.getName();
    	_stereo.setText("<<" + stereoStr + ">>");
    	if (!_stereo.isDisplayed()) {
    	    _stereo.setDisplayed(true);
    	}
    }
  }

  protected void modelChanged() {
    super.modelChanged();
    // move the figs
    calcBounds();
    Rectangle rect = getBounds();
    // calculate new height
    int new_height = 38; // height of constant figs
    if (_constrained != null)
      new_height = Math.max(new_height,_constrained.getHeight());
    if (_scope != null)
      new_height = Math.max(new_height,_scope.getHeight());
    // calculate new width
    int new_width = 35; // width of constant figs

    if (_stereo.isDisplayed() )
      new_width = new_width+ Math.max(_name.getWidth(),_stereo.getWidth());
    else
      new_width = new_width+_name.getWidth();

    if (_constrained != null)
      new_width = new_width + _constrained.getWidth();
    if (_scope != null)
      new_width = new_width + _scope.getWidth();

    setBounds(rect.x-(new_width-rect.width)/2, rect.y-(new_height-rect.height), new_width, new_height);
  }

  public void setBounds(int x, int y, int w, int h)
  {
    Rectangle oldBounds = getBounds();
    int wc = _constrained.getWidth();
    int ws = _scope.getWidth();

    int wt = _name.getWidth();
    if (_stereo.isDisplayed() )
      wt = Math.max(wt,_stereo.getWidth());

    int origin_y = _arrow.getY();
    int origin_x = x + w / 2;
    if (_stereo.isDisplayed())
      wt = Math.max(wt, _stereo.getWidth());

    _constrained.setLocation(x, origin_y- _constrained.getHalfHeight());
    _triangle.setLocation(x+wc,origin_y-15);
    _letter_i.setLocation(x+wc,origin_y-15);
    _name.setLocation(origin_x - _name.getWidth()/2,origin_y+5);
    if (_stereo.isDisplayed() )
      _stereo.setLocation(origin_x - _stereo.getWidth()/2,origin_y-18);
    _arrow.setPoints(0,x+wc+16,origin_y);
    _arrow.setPoints(1,origin_x+wt/2+5,origin_y);
    _arrowhead.setLocation(origin_x+wt/2+5,origin_y-3);
    _scope.setLocation(x+w-ws, origin_y- _scope.getHalfHeight());

  	calcBounds(); //_x = x; _y = y; _w = w; _h = h;
    Rectangle newBounds = getBounds();
  	updateEdges();
  	firePropChange("bounds", oldBounds, newBounds);
  }
}