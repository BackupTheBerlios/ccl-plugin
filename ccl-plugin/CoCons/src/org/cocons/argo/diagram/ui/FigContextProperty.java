// File: FigContextProperty.java
// Classes: FigContextProperty
// Original Author: jgusulde
// $Id: FigContextProperty.java,v 1.1 2001/11/07 10:30:43 jgusulde Exp $

package org.cocons.argo.diagram.ui;

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


public class FigContextProperty
  extends FigNodeModelElement {

  ////////////////////////////////////////////////////////////////
  // instance variables

  /** UML does not really use ports, so just define one big one so
   *  that users can drag edges to or from any point in the icon. */
  FigRect _bigPort;

  /* corners */
  FigPoly _topleft;
  FigPoly _topright;
  FigPoly _bottomleft;
  FigPoly _bottomright;

  // add other Figs here aes needed


  ////////////////////////////////////////////////////////////////
  // constructors

  public FigContextProperty() {
    // Put this rectangle behind the rest, so it goes first
    //_bigPort = new FigRect(5, 5, 30, 85, Color.gray, Color.gray);
    _bigPort = new FigRect(10, 10, 90, 30, Color.gray, Color.gray);
    _bigPort.setFillColor(Color.yellow);
    _bigPort.setFilled(true);

    _topleft = new FigPoly(10,10);
    _topleft.addPoint(16,10);
    _topleft.addPoint(10,16);
    _topleft.addPoint(10,10);
    _topleft.setFillColor(Color.yellow);
    _topleft.setFilled(true);

    _topright = new FigPoly(90,10);
    _topright.addPoint(84,10);
    _topright.addPoint(90,16);
    _topright.addPoint(90,10);
    _topright.setFillColor(Color.yellow);
    _topright.setFilled(true);

    _bottomleft = new FigPoly(10,30);
    _bottomleft.addPoint(16,30);
    _bottomleft.addPoint(10,24);
    _bottomleft.addPoint(10,30);
    _bottomleft.setFillColor(Color.yellow);
    _bottomleft.setFilled(true);

    _bottomright = new FigPoly(90,30);
    _bottomright.addPoint(84,30);
    _bottomright.addPoint(90,24);
    _bottomright.addPoint(90,30);
    _bottomright.setFillColor(Color.yellow);
    _bottomright.setFilled(true);

/*    _stereo.setBounds(60, 7, 45, 15);
    _stereo.setExpandOnly(false);
    _stereo.setFilled(false);
    _stereo.setLineWidth(0);
    _stereo.setEditable(false);
    _stereo.setHeight(18);
    _stereo.setDisplayed(false);
*/
    _name.setBounds(13, 13, 87, 21);
// --------------------------------------------------
    _name.setText("test");
// --------------------------------------------------
    _name.setTextFilled(false);
    //_name.setFillColor(Color.yellow);
    _name.setFilled(false);
    _name.setLineWidth(0);
    _name.setExpandOnly(false);
    // initialize any other Figs here

    // add Figs to the FigNode in back-to-front order

    addFig(_name);
    addFig(_bigPort);
    addFig(_topleft);
    addFig(_topright);
    addFig(_bottomleft);
    addFig(_bottomright);

    //addFig(_stereo);

  }

  public FigContextProperty(GraphModel gm, Object node) {
    this();
    setOwner(node);
  }

  public String placeString() { return "new MContextbasedConstraint"; }

  public Object clone() {
    FigContextProperty figClone = (FigContextProperty) super.clone();
    Vector v = figClone.getFigs();
    figClone._name = (FigText) v.elementAt(0);
    figClone._bigPort = (FigRect) v.elementAt(1);
    figClone._topleft = (FigPoly) v.elementAt(2);
    figClone._topright = (FigPoly) v.elementAt(3);
    figClone._bottomleft = (FigPoly) v.elementAt(4);
    figClone._bottomright = (FigPoly) v.elementAt(5);

    return figClone;
  }

  ////////////////////////////////////////////////////////////////
  // Fig accessors

  public Selection makeSelection() {
    return new SelectionNodeClarifiers(this);
  }

  public void setOwner(Object node) {
    super.setOwner(node);
    bindPort(node, _bigPort);
  }

  /** Returns true if this Fig can be resized by the user. */
  public boolean isResizable() { return true; }

  public void setLineColor(Color col) {
    //_triangle.setLineColor(col);
    _topleft.setLineColor(col);
    _topright.setLineColor(col);
    _bottomleft.setLineColor(col);
    _bottomright.setLineColor(col);
    _bigPort.setLineColor(col);
  }

  public Color getLineColor() { return _topleft.getLineColor(); }

  public void setFillColor(Color col) {
    _topleft.setFillColor(col);
    _topright.setFillColor(col);
    _bottomleft.setFillColor(col);
    _bottomright.setFillColor(col);
    _bigPort.setFillColor(col);
  }
  public Color getFillColor() { return _bigPort.getFillColor(); }

  public void setFilled(boolean f) {  }
  public boolean getFilled() { return true; }

  public void setLineWidth(int w) {
    _bigPort.setLineWidth(w);
  }
  public int getLineWidth() { return _bigPort.getLineWidth(); }

  public Dimension getMinimumSize() {
    Dimension nameDim = _name.getMinimumSize();
    int w = nameDim.width;
    int h = nameDim.height;
    return new Dimension(w+6, h+6);
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
    int new_height = 6; // height of constant figs
    new_height = new_height + _name.getHeight();
    int new_width = 6; // width of constant figs
    new_width = new_width + _name.getWidth();
// needs more work ???
    setBounds(rect.x-(new_width-rect.width)/2, rect.y-(new_height-rect.height), new_width, new_height);
  }

  public void setBounds(int x, int y, int w, int h)
  {
    Rectangle oldBounds = getBounds();
    int wt = _name.getWidth();
    wt = Math.max(wt,w);
    int ht = _name.getHeight();
    ht = Math.max(ht,h);

    _bigPort.setBounds(x,y,wt+6,ht+6);
    _topleft.setLocation(x, y);
    _topright.setLocation(x+wt+6, y);
    _bottomleft.setLocation(x, y+ht+6);
    _bottomright.setLocation(x+wt+6, y+ht+6);

    _name.setLocation(x+3, y+3);

    calcBounds(); //_x = x; _y = y; _w = w; _h = h;
    Rectangle newBounds = getBounds();
    updateEdges();
    firePropChange("bounds", oldBounds, newBounds);
  }

  public void textEdited(){
// needs more work !!!
    // use MTaggedValue to set text
    MTaggedValue mtv = (MTaggedValue) getOwner();
    if(mtv == null) return;

    _name.setText(mtv.getTag() +":" + mtv.getType() + mtv.getValue());
  }
}