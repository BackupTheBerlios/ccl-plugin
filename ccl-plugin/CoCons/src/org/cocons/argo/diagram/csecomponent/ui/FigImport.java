/*
 * Class.java
 * Created on 10. Februar 2002, 23:42
 */
package org.cocons.argo.diagram.csecomponent.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.plaf.metal.MetalLookAndFeel;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;

import org.argouml.application.api.*;
import org.argouml.language.helpers.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.ui.*;

import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;

public class FigImport extends FigNodeModelElement{    
   
    ////////////////////////////////////////////////////////////////
    // instance variables
    
    FigRect _bigPort;
    FigRect _head;
  
    ////////////////////////////////////////////////////////////////
    // constructors
    public FigImport() {
        _bigPort = new FigRect(10,10,120,40,Color.cyan, Color.cyan);//this.addFig(new FigRect(10,10,120,40));
	_head    = new FigRect(10,10,120,40,Color.black, Color.white);
        _name.setBounds(60,20,00,0 );//(x,y,width,heigth)
	_name.setTextFilled(false);
        _name.setFilled(false);
        _name.setLineWidth(0);
        _name.setExpandOnly(false);
        addFig(_bigPort);
        addFig(_head);
	addFig(_name);        
    }
    public FigImport(GraphModel gm, Object node) {
        this();
        setOwner(node);
    }
    
    public String placeString() { return "Import"; }
    
    public Object clone() {
        FigImport figClone = (FigImport) super.clone();
        Vector v = figClone.getFigs();
        figClone._bigPort = (FigRect) v.elementAt(0);
        figClone._head = (FigRect) v.elementAt(1);
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
        return popUpActions;
    }
    
    public void setOwner(Object node) {
        super.setOwner(node);
        bindPort(node, _bigPort);
        if (node instanceof MElementImpl)
            ((MElementImpl)node).addMElementListener(this);
    } 
    public void setLineColor(Color col) { _bigPort.setLineColor(col); }
    public Color getLineColor() { return _bigPort.getLineColor(); }
    
    public void setFillColor(Color col) { _bigPort.setFillColor(col); }
    public Color getFillColor() { return _bigPort.getFillColor(); }
    
    public void setFilled(boolean f) { }
    public boolean getFilled() { return true; }
    
    public void setLineWidth(int w) { _bigPort.setLineWidth(w); }
    public int getLineWidth() { return _bigPort.getLineWidth(); }
    
 
    JList jList1 = new JList();   
    JToggleButton jToggleButton1 = new JToggleButton();  
    JSlider jSlider1 = new JSlider();  
    JButton jButton1 = new JButton();  
    JCheckBox jCheckBox1 = new JCheckBox();  
    ButtonGroup buttonGroup1 = new ButtonGroup();  
    JTable jTable1 = new JTable();    
    private void jbInit() throws Exception {
        jCheckBox1.setText("testbox1");
        jButton1.setText("Button1");
        jToggleButton1.setText("ToggleButton1");
  }
    
}/* end class FigImport*/



