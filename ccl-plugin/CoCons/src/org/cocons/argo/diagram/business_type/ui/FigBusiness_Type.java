// File: FigBusiness_Type.java
// Classes: FigBusiness_Type
// Original Author: jgusulde
// $Id: FigBusiness_Type.java,v 1.8 2001/12/17 10:58:42 oetker Exp $

package org.cocons.argo.diagram.business_type.ui;

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
import org.argouml.uml.diagram.static_structure.ui.FigClass;
import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;

public class FigBusiness_Type extends FigNodeModelElement {

  ////////////////////////////////////////////////////////////////
  // instance variables

  protected FigText _attr;
  protected FigRect _bigPort;
  protected FigRect _stereoLineBlinder;
  public MElementResidence resident = new MElementResidenceImpl();

  ////////////////////////////////////////////////////////////////
  // constructors

  public FigBusiness_Type() {
    _bigPort = new FigRect(10, 10, 90, 30, Color.cyan, Color.cyan);

    _name.setLineWidth(1);
    _name.setFilled(true);

    _attr = new FigText(10, 30, 90, 21, true);
    _attr.setFilled(true);
    _attr.setLineWidth(1);
    _attr.setFont(LABEL_FONT);
    _attr.setTextColor(Color.black);
    _attr.setJustification(FigText.JUSTIFY_LEFT);

    _stereo.setExpandOnly(true);
    _stereo.setFilled(true);
    _stereo.setLineWidth(1);
    _stereo.setEditable(false);
    _stereo.setHeight(18);
    _stereo.setDisplayed(true);

    _stereoLineBlinder = new FigRect(10, 15, 2, 60, Color.white, Color.white);
    _stereoLineBlinder.setLineWidth(2);
    _stereoLineBlinder.setDisplayed(true);

    addFig(_bigPort);
    addFig(_stereo);
    addFig(_name);
    addFig(_stereoLineBlinder);
    addFig(_attr);

    Rectangle r = getBounds();
    setBounds(r.x, r.y, r.width, r.height);
  }

  public FigBusiness_Type(GraphModel gm, Object node) {
    this();
    setOwner(node);
    MStereotype stereo = ((MModelElement) node).getStereotype();
    if (stereo == null){
	stereo = new MStereotypeImpl();
	((MModelElement) node).setStereotype(stereo);
    }
    ((MModelElement) node).getStereotype().setName("type");

    if (node instanceof MClassifier && (((MClassifier)node).getName() != null))
	_name.setText(((MModelElement)node).getName());
  }

  public String placeString() { return "new Class"; }

  public Object clone() {
    FigBusiness_Type figClone = (FigBusiness_Type) super.clone();
    Vector v = figClone.getFigs();
    figClone._bigPort = (FigRect) v.elementAt(0);
    figClone._name = (FigText) v.elementAt(1);
    figClone._attr = (FigText) v.elementAt(2);
    return figClone;
  }

  ////////////////////////////////////////////////////////////////
  // accessors

  public Selection makeSelection() {
    return new SelectionBusiness_Type(this);
  }

  public Vector getPopUpActions(MouseEvent me) {

    Vector popUpActions = super.getPopUpActions(me);
    JMenu addMenu = new JMenu("Add");
    addMenu.add(ActionAddAttribute.SINGLETON);
    JMenu copyAsInfoMenu = CopyAsInfoMenu.getJMenu();
    popUpActions.insertElementAt(copyAsInfoMenu, popUpActions.size() - 1);
    popUpActions.insertElementAt(addMenu, popUpActions.size() - 1);
    ContextViewPopUpMenu.getPopUpActions(popUpActions);
    return popUpActions;
  }

  public void setOwner(Object node) {
    super.setOwner(node);
    Object onlyPort = node; //this kngl should be in the GraphModel
    bindPort(onlyPort, _bigPort);
  }

  public FigText getAttributeFig() { return _attr; }

  /**
   * Returns the status of the attribute field.
   * @return true if the attributes are visible, false otherwise
   */
  // created by Eric Lefevre 13 Mar 1999
  public boolean isAttributeVisible() {  return _attr.isDisplayed(); }

  // created by Eric Lefevre 13 Mar 1999
  public void setAttributeVisible(boolean isVisible) {
    Rectangle rect = getBounds();
    if ( _attr.isDisplayed() ) {
      if ( !isVisible ) {
        damage();
        int h = _attr.getBounds().height;
        _attr.setDisplayed(false);
        setBounds(rect.x, rect.y, rect.width, rect.height - h -1);
      }
    }
    else {
      if ( isVisible ) {
        int h = _attr.getBounds().height;
        _attr.setDisplayed(true);
        setBounds(rect.x, rect.y, rect.width, rect.height + h);
        damage();
      }
    }
  }

  // modified by Eric Lefevre 13 Mar 1999
  public Dimension getMinimumSize() {
    Dimension nameMin = _name.getMinimumSize();
    int h = nameMin.height;
    int w = nameMin.width;
    if (_attr.isDisplayed()){
      Dimension attrMin =_attr.getMinimumSize();
      h += attrMin.height;
      w = Math.max(w, attrMin.width);
    }
    return new Dimension(w,h);
  }

  public void setFillColor(Color lColor) {
    super.setFillColor(lColor);
    _stereoLineBlinder.setLineColor(lColor);
  }

  public void setLineColor(Color lColor) {
    super.setLineColor(lColor);
    _stereoLineBlinder.setLineColor(_stereoLineBlinder.getFillColor());
  }

  public void translate(int dx, int dy) {
    super.translate(dx, dy);
    Editor ce = Globals.curEditor();
    Selection sel = ce.getSelectionManager().findSelectionFor(this);
    if (sel instanceof SelectionBusiness_Type)
      ((SelectionBusiness_Type)sel).hideButtons();
  }

  ////////////////////////////////////////////////////////////////
  // user interaction methods

  public void mousePressed(MouseEvent me) {
    super.mousePressed(me);
    Editor ce = Globals.curEditor();
    Selection sel = ce.getSelectionManager().findSelectionFor(this);
    if (sel instanceof SelectionBusiness_Type)
      ((SelectionBusiness_Type)sel).hideButtons();
  }

  public void setEnclosingFig(Fig encloser) {
    super.setEnclosingFig(encloser);
    if (!(getOwner() instanceof MModelElement)) return;
    MModelElement me = (MModelElement) getOwner();
    MNamespace m = null;
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    if ((encloser == null && me.getNamespace() == null )
    ||  (encloser != null && encloser.getOwner() instanceof MPackage)) {
      if (encloser != null && (encloser.getOwner() instanceof MPackage)) {
        m = (MNamespace) encloser.getOwner();
      } else if ( pb.getTarget() instanceof UMLDiagram ) {
	m = (MNamespace) ((UMLDiagram)pb.getTarget()).getNamespace();
      }
      try {
        me.setNamespace(m);
      } catch (Exception e) {
        Argo.log.error("could not set package", e);
      }
    }

    // The next if-clause is important for the Deployment-diagram
    // it detects if the enclosing fig is a component, in this case
    // the ImplementationLocation will be set for the owning MClass
    if (encloser != null && (encloser.getOwner() instanceof MComponentImpl)) {
      MComponent component = (MComponent) encloser.getOwner();
      MClass cl = (MClass) getOwner();
      resident.setImplementationLocation(component);
      resident.setResident(cl);
    }
    else {
      resident.setImplementationLocation(null);
      resident.setResident(null);
    }

  }


  ////////////////////////////////////////////////////////////////
  // internal methods

  protected void textEdited(FigText ft) throws PropertyVetoException {
    super.textEdited(ft);
    MClassifier cls = (MClassifier) getOwner();
    if (cls == null) return;
    if (ft == _attr) {
      //System.out.println("\n\n\n Edited Attr");
      String s = ft.getText();
      ParserDisplay.SINGLETON.parseAttributeCompartment(cls, s);
    }
  }

  protected void modelChanged() {
    super.modelChanged();
    MClassifier cls = (MClassifier) getOwner();
    if (cls == null) return;
    // String clsNameStr = Notation.generate(this, cls.getName());
    Collection strs = MMUtil.SINGLETON.getAttributes(cls);
    String attrStr = "";
    if (strs != null) {
	Iterator iter = strs.iterator();
      while (iter.hasNext()) {
	    MStructuralFeature sf = (MStructuralFeature) iter.next();
	    // sf.addMElementListener(this);
	    attrStr += Notation.generate(this, sf);
	    if (iter.hasNext())
	      attrStr += "\n";
      }
    }
    _attr.setText(attrStr);

    if (cls.isAbstract()) _name.setFont(ITALIC_LABEL_FONT);
    else _name.setFont(LABEL_FONT);

    calcBounds();
    Rectangle rect = getBounds();
    setBounds(rect.x, rect.y, rect.width, rect.height);
    firePropChange("bounds", rect, getBounds());

  }


  protected void updateStereotypeText() {
    MModelElement me = (MModelElement) getOwner();
    if (me == null) return;
    MStereotype stereo = me.getStereotype();
    if (stereo == null || stereo.getName() == null || stereo.getName().length() == 0) {
	if (! _stereo.isDisplayed()) return;
	Rectangle oldBounds = getBounds();
	_stereoLineBlinder.setDisplayed(false);
	_stereo.setDisplayed(false);
	setBounds(oldBounds.x, oldBounds.y + _stereo.getMinimumSize().height, oldBounds.width, oldBounds.height- _stereo.getMinimumSize().height);
	calcBounds();
	firePropChange("bounds", oldBounds, getBounds());

	return;
    }
    else {
	Rectangle oldBounds = getBounds();
	_stereo.setText(Notation.generateStereotype(this, stereo));
	if (!_stereo.isDisplayed()) {
	    _stereoLineBlinder.setDisplayed(true);
	    _stereoLineBlinder.setBounds(oldBounds.x, oldBounds.y, oldBounds.width, 2);
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

    public void setBounds(int x, int y, int w, int h) {

	Rectangle oldBounds = getBounds();
	Enumeration figs = _figs.elements();

	int maxW = w;
	int cumulatedHeight = 0;
	figs.nextElement(); // jump over _bigPort
	while (figs.hasMoreElements()) {
	  Fig f = (Fig) figs.nextElement();
	  if (f.isDisplayed()) {
	      maxW = Math.max(f.getMinimumSize().width, maxW);
	      cumulatedHeight += f.getMinimumSize().height;
	  }
	}
	if (_stereoLineBlinder.isDisplayed())
	    cumulatedHeight -= _stereoLineBlinder.getMinimumSize().height;

	int extra_each = h - cumulatedHeight;
	int noExtraFigs = 1; //this is the bigPort
        if (_stereo.isDisplayed())
	    noExtraFigs++;
        if (_stereoLineBlinder.isDisplayed())
	    noExtraFigs++;
	extra_each = extra_each / (getDisplayedFigs().size()- noExtraFigs);
	Vector mutableFigs = new Vector(_figs);
	mutableFigs.remove(_stereo);
	mutableFigs.remove(_stereoLineBlinder);
	mutableFigs.remove(_bigPort);

	figs = mutableFigs.elements();

	int currentY = y;

	// handle _stereo
	if (_stereo.isDisplayed()) {
	    _stereo.setBounds(x, currentY, maxW, _stereo.getMinimumSize().height+1 );
	    currentY += _stereo.getMinimumSize().height; //--pjs--
	}

	// handle _stereoLineBlinder
	if (_stereoLineBlinder.isDisplayed()) {
	    _stereoLineBlinder.setBounds(x + 1, _stereo.getY() + _stereo.getHeight() -2, maxW - 2, 4 );
	}

	while (figs.hasMoreElements()) {
	  Fig f = (Fig) figs.nextElement();
	  if (f.isDisplayed()) {
          // extra_each caused class icons to grow vertically each time
          // the diagram was saved and reloaded. I replaced it with 1
          // which gives the text a little room in the class icon. pjs
	      int height =  f.getMinimumSize().height + 1; //extra_each;
	      int overlap = 0;
	      if (_stereo.isDisplayed())
		  overlap =  (getDisplayedFigs().size() > 4 ? 1 : 0);
	      else  overlap = (getDisplayedFigs().size() > 3 ? 1 :0 );
	      f.setBounds(x, currentY, maxW,  height + overlap);
	      currentY += height;
	  }
	}
	_bigPort.setBounds(x, y, maxW, currentY - y);


	calcBounds(); //_x = x; _y = y; _w = w; _h = h;
	updateEdges();
	firePropChange("bounds", oldBounds, getBounds());
    }

    public void renderingChanged() {
        super.renderingChanged();
	updateStereotypeText();
	modelChanged();
    }



} /* end class FigBusiness_Type */
