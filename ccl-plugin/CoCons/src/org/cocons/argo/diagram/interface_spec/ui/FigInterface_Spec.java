// Author: shicathy

package org.cocons.argo.diagram.interface_spec.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.application.api.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;

import org.cocons.argo.diagram.business_type.ui.KnownBusinessTypes;
import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;

public class FigInterface_Spec extends FigInterface {

  protected FigRect _stereoLineBlinder = new FigRect(8, 13, 2, 64, Color.white, Color.white);
  ////////////////////////////////////////////////////////////////
  // constructors

  public FigInterface_Spec() {
    super();
    _stereoFake.setDisplayed(false);
    _stereo.setExpandOnly(true);
    _stereo.setFilled(true);
    _stereo.setLineWidth(1);
    _stereo.setEditable(false);
    _stereo.setHeight(18);
    _stereo.setDisplayed(true);
    _stereoLineBlinder.setLineWidth(2);
    //_stereoLineBlinder.setFilled(true);
    _stereoLineBlinder.setDisplayed(true);
    addFig(_stereo);
    addFig(_stereoLineBlinder);
  }

  public FigInterface_Spec(GraphModel gm, Object node) {
    super(gm,node);
    _stereoFake.setDisplayed(false);
    _stereo.setExpandOnly(true);
    _stereo.setFilled(true);
    _stereo.setLineWidth(1);
    _stereo.setEditable(false);
    _stereo.setHeight(18);
    _stereo.setDisplayed(true);
    _stereoLineBlinder.setLineWidth(2);
    //_stereoLineBlinder.setFilled(true);
    _stereoLineBlinder.setDisplayed(true);
    addFig(_stereo);
    addFig(_stereoLineBlinder);
  }

  ////////////////////////////////////////////////////////////////
  // accessors

  public Selection makeSelection() {
     return null;
  }

  public void setFilled(boolean f) {
	//super.setFilled(f);
	//_stereo.setFilled(false);  //f
	//_name.setFilled(false);   //f
  }

  public void setLineWidth(int w) {
	//super.setLineWidth(w);
	//_stereo.setLineWidth(0); //1
	//_name.setLineWidth(0);
  }

  public void setLineColor(Color c) {
   // super.setLineColor(c);
   // _stereoFake.setLineWidth(0);
    //_name.setLineWidth(0);
  }

  public void setFillColor(Color c){
  }
  protected void updateStereotypeText() {
    MModelElement me = (MModelElement) getOwner();
    if (me == null) return;
    MStereotype stereo = me.getStereotype();
    if (stereo == null || stereo.getName() == null || stereo.getName().length() == 0) {
	if (! _stereo.isDisplayed()) return;
	Rectangle oldBounds = getBounds();
	//_stereoLineBlinder.setDisplayed(false);
	_stereo.setDisplayed(false);
	setBounds(oldBounds.x, oldBounds.y + _stereo.getMinimumSize().height, oldBounds.width, oldBounds.height- _stereo.getMinimumSize().height);
	calcBounds();
	firePropChange("bounds", oldBounds, getBounds());

	return;
    }
    else {
	Rectangle oldBounds = getBounds();
	// String stereoStr = stereo.getName();
	// _stereo.setText("<<" + stereoStr + ">>");
	_stereo.setText(Notation.generateStereotype(this, stereo));
	if (!_stereo.isDisplayed()) {
	    //_stereoLineBlinder.setDisplayed(true);
	    //_stereoLineBlinder.setBounds(oldBounds.x, oldBounds.y, oldBounds.width, 2);
	    _stereo.setDisplayed(true);
	    _stereo.setBounds(oldBounds.x, oldBounds.y -  _stereo.getMinimumSize().height, oldBounds.width,  _stereo.getMinimumSize().height);
	}
	_stereo.calcBounds();
	calcBounds();
	Rectangle rect = getBounds();
	setBounds(rect.x, rect.y, rect.width, rect.height);
	firePropChange("bounds", oldBounds, getBounds());
    }
  }

  public void renderingChanged() {
    super.renderingChanged();
    updateStereotypeText();
    modelChanged();
  }

  public void setBounds(int x, int y, int w, int h) {
    super.setBounds(x,y,w,h);
    Rectangle oldBounds = getBounds();
    Enumeration figs = _figs.elements();
    int maxW = w;
    int cumulatedHeight = 0;
    figs.nextElement(); // jump over _bigPort
    figs.nextElement(); // jump over _outline
    while (figs.hasMoreElements()) {
      Fig f = (Fig) figs.nextElement();
      if (f.isDisplayed()) {
        maxW = Math.max(f.getMinimumSize().width, maxW);
        cumulatedHeight += f.getMinimumSize().height;
      }
    }
    if (_stereo.isDisplayed()) {
      _stereo.setBounds(x, y, maxW, _stereo.getMinimumSize().height+1);
      y += _stereo.getMinimumSize().height;
    }
    if (_stereoLineBlinder != null && _stereoLineBlinder.isDisplayed()) {
      _stereoLineBlinder.setBounds(x + 1, _stereo.getY() + _stereo.getHeight() -2, maxW - 2, 4 );
    }
  }
}
