/*
 * FigCseComponent.java
 * Created on 31. Januar 2002, 22:22
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
import org.argouml.language.helpers.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.ui.*;
import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;


/** Class to display graphics for a UML Class in a diagram. */

public class FigCseComponent extends FigNodeModelElement {
    
    Fig _Export;
    Fig _Body;
    Fig _Import;
    FigText _word_Body;
    
    ////////////////////////////////////////////////////////////////
    // constructors
    
    public FigCseComponent() {
        
        
        _Import= new FigImport();  //(0,0,120,40)
       
        _Body   =new FigBody(null);//(0,0,120,80);
        _Body.translate(0,40);
        
        _word_Body= new FigText(60,60,16,15,Color.black,"TimesRoman",18);
        
        _word_Body.setText("BODY");
        
        _word_Body.setFilled(false);
        
        
        
        _word_Body.setEditable(false);
        
        _word_Body.setLineWidth(0);
        
        _word_Body.setWidth(21);
        
        
       _Export  =new FigExport(null);
       _Export.translate(0,100);
       
   
        _name.setBounds(60,30,45,15);
        _name.setTextFilled(false);
        _name.setFilled(false);
        _name.setLineWidth(0);
        
        addFig(_Import);
        addFig(_Body);
        addFig(_word_Body);
        addFig(_Export);
	addFig(_name);
    }
       
    
    public FigCseComponent(GraphModel gm, Object node) {
        this();
        setOwner(node);
    }
    
    public String placeString() { return "new csecomponent"; }
    
    public Object clone() {
        FigCseComponent figClone = (FigCseComponent) super.clone();
       Vector v = figClone.getFigs();
       figClone._Import = (FigRect) v.elementAt(0);
       figClone._Body = (FigRect) v.elementAt(1);
       figClone._Export=(FigRect)v.elementAt(2);
        figClone._name = (FigText) v.elementAt(0);
        return figClone;
    }
    
    ////////////////////////////////////////////////////////////////
    // Fig accessors
    
    
    public Selection makeSelection() {
        return null ; //new SelectionMoveClarifiers(this);
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
     
    }
    
    
    public void setLineColor(Color col) { _Body.setLineColor(col); }
    public Color getLineColor() { return _Body.getLineColor(); }
    
    public void setFillColor(Color col) { _Body.setFillColor(col); }
    public Color getFillColor() { return _Body.getFillColor(); }
    
    public void setFilled(boolean f) { }
    public boolean getFilled() { return true; }
    
    public void setLineWidth(int w) { _Body.setLineWidth(w); }
    public int getLineWidth() { return _Body.getLineWidth(); }
    
   
    public Dimension getMinimumSize() {
    Dimension nameDim = _name.getMinimumSize();
    int w = nameDim.width;
    int h = nameDim.height + 65;
    return new Dimension(w, h);
    }
         
    class NewClass {}
    static final long serialVersionUID = 4928213949795787107L;

}/* end class FigCseComponent */











 