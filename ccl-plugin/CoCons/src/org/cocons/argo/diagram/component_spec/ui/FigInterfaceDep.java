package org.cocons.argo.diagram.component_spec.ui;

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
import org.argouml.ui.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.ui.*;
import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;


/** Class to display graphics for a UML Interface in a diagram. */

public class FigInterfaceDep extends FigNodeModelElement {
    
    ////////////////////////////////////////////////////////////////
    // constants
    
    public final int MARGIN = 2;
    public int x = 0;
    public int y = 0;
    public int width = 30;
    public int height = 30;
    
    ////////////////////////////////////////////////////////////////
    // instance variables
    
    FigCircle _bigPort;
    FigCircle _head;
    
    ////////////////////////////////////////////////////////////////
    // constructors
    public FigInterfaceDep() {
	_bigPort = new FigCircle(x, y, width, height, Color.cyan, Color.cyan);
	_head    = new FigCircle(x, y, width, height, Color.black, Color.white);
	/*
	  _stereo.setBounds(10, 10, 35, 30);
	  _stereo.setExpandOnly(false);
	  _stereo.setFilled(false);
	  _stereo.setLineWidth(0);
	  _stereo.setEditable(false);
	  _stereo.setHeight(18);
	  _stereo.setDisplayed(false);
	*/
	_name.setBounds(60,0,0,0 );
	_name.setTextFilled(false);
	_name.setFilled(false);
	_name.setLineWidth(0);
	_name.setExpandOnly(false);
	
	addFig(_bigPort);
	addFig(_head);
	addFig(_name);
	//addFig(_stereo);
	
    }
    
    public FigInterfaceDep(GraphModel gm, Object node) {
    this();
    setOwner(node);
    }
    
    //public String placeString() { return "new Interface"; }
    
    public Object clone() {
	FigInterfaceDep figClone = (FigInterfaceDep) super.clone();
	Vector v = figClone.getFigs();
	figClone._bigPort = (FigCircle) v.elementAt(0);
	figClone._head = (FigCircle) v.elementAt(1);
	figClone._name = (FigText) v.elementAt(2);
	return figClone;
    }
    
    ////////////////////////////////////////////////////////////////
    // Fig accessors
    
    public Selection makeSelection() {
	return new SelectionMoveClarifiers(this);
    }
    
    public boolean isResizable() { return false; }
    
    public Vector getPopUpActions(MouseEvent me) {
	Vector popUpActions = super.getPopUpActions(me);
	JMenu addMenu = new JMenu("Add");
	addMenu.add(ActionAddNote.SINGLETON);
	popUpActions.insertElementAt(addMenu,popUpActions.size() - 1);
	ContextViewPopUpMenu.getPopUpActions(popUpActions);
	return popUpActions;
    }
    public void setOwner(Object node) {
	super.setOwner(node);
	bindPort(node, _bigPort);
	// if it is a UML meta-model object, register interest in any change events
	if (node instanceof MElementImpl)
	    ((MElementImpl)node).addMElementListener(this);
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
    
    public void setLineColor(Color col) { _head.setLineColor(col); }
    public Color getLineColor() { return _head.getLineColor(); }
    
    public void setFillColor(Color col) { _head.setFillColor(col); }
    public Color getFillColor() { return _head.getFillColor(); }
    
    public void setFilled(boolean f) { }
    public boolean getFilled() { return true; }
    
    public void setLineWidth(int w) { _head.setLineWidth(w); }
    public int getLineWidth() { return _head.getLineWidth(); }
    
    static final long serialVersionUID = 4928213949795787107L;
    
    
} /* end class FigInterfaceDep */




