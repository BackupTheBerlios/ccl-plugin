/*
 * FigConnector.java
 * Created on 11. Februar 2002, 14:21
 */

package org.cocons.argo.diagram.csecomponent.ui;

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



public class FigConnector extends FigNodeModelElement {
    
    ////////////////////////////////////////////////////////////////
    // constants
    
    public final int MARGIN = 2;
    public int x = 10;
    public int y = 10;
    public int width = 300;
    public int height = 5;
    
    ////////////////////////////////////////////////////////////////
    // instance variables
    
    FigRect _connect;
    FigRect _head;
    
    ////////////////////////////////////////////////////////////////
    // constructors
    
    public FigConnector() {
        _connect = new FigRect(x, y, width, height, Color.cyan, Color.cyan);
        _head    = new FigRect(x, y, width, height, Color.black, Color.white);
	
	_name.setBounds(60,0,0,0 );
	_name.setTextFilled(false);
        _name.setFilled(false);
        _name.setLineWidth(0);
        _name.setExpandOnly(false);
	
        addFig(_connect);
        addFig(_head);
	addFig(_name);        
    }
    public FigConnector(GraphModel gm, Object node) {
        this();
        setOwner(node);
    }
    
 
    
    public Object clone() {
        FigConnector figClone = (FigConnector) super.clone();
        Vector v = figClone.getFigs();
        figClone._connect = (FigRect) v.elementAt(0);
        figClone._head = (FigRect) v.elementAt(1);
        figClone._name = (FigText) v.elementAt(2);
        return figClone;
    }
    
    ////////////////////////////////////////////////////////////////
    // Fig accessors
    
    
    public Selection makeSelection() {
        return null;
    }
    public boolean isResizable() { return false; }
    
    
    
    public void setOwner(Object node) {
        super.setOwner(node);
        bindPort(node, _bigPort);
    }
   
    
    public void setLineColor(Color col) { _head.setLineColor(col); }
    public Color getLineColor() { return _head.getLineColor(); }
    
    public void setFillColor(Color col) { _head.setFillColor(col); }
    public Color getFillColor() { return _head.getFillColor(); }
    
    public void setFilled(boolean f) { }
    public boolean getFilled() { return true; }
    
    public void setLineWidth(int w) { _head.setLineWidth(w); }
    public int getLineWidth() { return _head.getLineWidth(); }
    
    
}/* end class FigConnector */



