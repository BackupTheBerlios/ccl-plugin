package org.cocons.argo.diagram.constraint.ui;

import java.awt.*;
import java.util.*;
import java.beans.*;
import javax.swing.*;
import java.awt.event.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.argouml.uml.diagram.ui.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import org.cocons.uml.ccl.comparators.*;
import org.cocons.uml.ccl.*;
import org.cocons.uml.ccl.*;
import org.cocons.uml.ccl.util.ContextConditionFactory;
import org.cocons.uml.ccl.util.ConvertCoconsToSyntaxCheck;
import org.cocons.uml.ccl.util.SyntaxcheckOfCoconsFromBNF;

//import org.cocons.Message;

/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @author Nghia Dang Duc
 * @author Rolf Exner
 * @author redesigned and added Functionalities by Camara Lenuseni (c)2003
 * @version 1.1
 */

public class FigContextbasedConstraint extends FigNodeModelElement {
 
  ////////////////////////////////////////////////////////////////
  // instance variables

  /** UML does not really use ports, so just define one big one so
   *  that users can drag edges to or from any point in the icon. */
  //FigCircle _bigPort;
    protected FigRect _bigPort;

    protected FigPoly _triangle;
    protected FigLine _arrow;
    protected FigPoly _arrowhead;
    protected FigText _letter_i;

    // add other Figs here as needed
    protected FigGroup _scopeVec;
    protected FigGroup _targetVec;

    protected FigRect _scopePort;
    protected FigRect _targetPort;
    protected FigText _targetText;
    protected FigText _scopeText;
    protected FigText _cocontypeText;
    protected FigText _conditiontypeText;
    protected FigText _MUST_Text;
    protected FigText _BE_Text;
    protected FigText _attributeText;
    public MElementResidence resident = new MElementResidenceImpl();

  
    ////////////////////////////////////////////////////////////////
    // constructors

    public FigContextbasedConstraint() 
    {
  
        // Put this rectangle behind the rest, so it goes first
        _bigPort = new FigRect(5, 5, 40, 85, Color.gray, Color.gray);
        //_bigPort = new FigCircle(10, 10, 20, 30, Color.gray, Color.gray);

        //construction of the Scope-Set
        _scopePort = new FigRect(0,0,80,40, Color.gray, Color.pink);
        _scopePort.setLineWidth(1);
        _scopePort.setFilled(true);

        _scopeVec = new FigGroup();
        _scopeVec.setFilled(true);
        _scopeVec.setLineWidth(1);
        _scopeVec.addFig(_scopePort);

        _scopeText =  new FigText(120,5,16,15, Color.black,"TimesRoman", 10);
        _scopeText.setText("Enter Scope Set");
        _scopeText.setFilled(false);
        _scopeText.setEditable(false);
        _scopeText.setLineWidth(0);
        _scopeText.setWidth(80);

        //construction of the warning-sign
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

        //construction of the arrow with arrow-head
        _arrow = new FigLine(56,25,110,25);

        _arrowhead = new FigPoly(120,25);
        _arrowhead.addPoint(110,22);
        _arrowhead.addPoint(110,28);
        _arrowhead.addPoint(120,25);

        //construction of the Target-(Constraint-)Set
        _targetPort = new FigRect(0,0,80,40, Color.gray, Color.green);
        _targetPort.setLineWidth(1);
        _targetPort.setFilled(true);
        _targetPort.translate(120,0);

        _targetVec = new FigGroup();
        _targetVec.setFilled(true);
        _targetVec.setLineWidth(1);
        _targetVec.addFig(_targetPort);
        //_targetVec.translate(120,0);
        _targetText = new FigText(5,5,16,15, Color.black,"TimesRoman", 10);
        _targetText.setText("Enter target Set");
        _targetText.setFilled(false);
        _targetText.setEditable(false);
        _targetText.setLineWidth(0);
        _targetText.setWidth(85);
        
		//construction of the text-field for the "MUST" text
        _MUST_Text = new FigText (60, 7, 45, 15, Color.blue, "TimesRoman", 10);
        _MUST_Text.setText("MUST");
        _MUST_Text.setDisplayed(true);
        _MUST_Text.setEditable(false);
        _MUST_Text.setFilled(false);
        _MUST_Text.setLineWidth(0);
        _MUST_Text.setHeight(18);
        _MUST_Text.setExpandOnly(false);

	//construction of the text-field for the condition type
        _conditiontypeText = new FigText (96, 7, 45, 15, Color.magenta, "TimesRoman", 10);
        _conditiontypeText.setText("ONLY");
        _conditiontypeText.setDisplayed(true);
        _conditiontypeText.setEditable(false);
        _conditiontypeText.setFilled(false);
        _conditiontypeText.setLineWidth(0);
        _conditiontypeText.setHeight(18);
        _conditiontypeText.setExpandOnly(false);
        
        //construction of the text-field for the "BE" text
        _BE_Text = new FigText (160, 7, 45, 15, Color.yellow, "TimesRoman", 10);
        _BE_Text.setText("BE");
        _BE_Text.setDisplayed(true);
        _BE_Text.setEditable(false);
        _BE_Text.setFilled(false);
        _BE_Text.setLineWidth(0);
        _BE_Text.setHeight(18);
        _BE_Text.setExpandOnly(false);

		//construction of the text-field for the cocon-type
        _cocontypeText = new FigText (210, 7, 45, 15, Color.red, "TimesRoman", 10);
        _cocontypeText.setText("ACCESSIBLE TO");
        _cocontypeText.setDisplayed(true);
        _cocontypeText.setEditable(false);
        _cocontypeText.setFilled(false);
        _cocontypeText.setLineWidth(0);
        _cocontypeText.setHeight(18);
        _cocontypeText.setExpandOnly(false);
        
        _attributeText = new FigText (60, 30, 45, 15, Color.black, "TimesRoman", 10);
        _attributeText.setText("COCONAUTHOR: Camara L ");
        _attributeText.setDisplayed(true);
        _attributeText.setEditable(false);
        _attributeText.setFilled(false);
        _attributeText.setLineWidth(0);
        _attributeText.setHeight(18);
        _attributeText.setExpandOnly(false);

        // initialize any other Figs here

        // add Figs to the FigNode in back-to-front order

        addFig(_scopePort);
        //addFig(_scopeVec);
        addFig(_arrow);
        addFig(_arrowhead);
        addFig(_triangle);
        addFig(_letter_i);
        addFig(_targetPort);       
        addFig(_attributeText);
        addFig(_cocontypeText);
        addFig(_conditiontypeText);
        addFig(_MUST_Text);
        addFig(_BE_Text);
        addFig(_targetText);
        addFig(_scopeText);
        //addFig(_targetVec);
        modelChanged();
    }

    public FigContextbasedConstraint(GraphModel gm, Object node) {
        this();
        setOwner(node);
    }

    public String placeString() { return "new MContextbasedConstraint"; }

    public Object clone() {
        FigContextbasedConstraint figClone = (FigContextbasedConstraint) 
        super.clone();
        Vector v = figClone.getFigs();
        figClone._scopePort = (FigRect) v.elementAt(0);
        figClone._arrow = (FigLine) v.elementAt(1);
        figClone._arrowhead = (FigPoly) v.elementAt(2);
        figClone._triangle = (FigPoly) v.elementAt(3);
        figClone._letter_i = (FigText) v.elementAt(4);
        figClone._targetPort = (FigRect) v.elementAt(5);        
        figClone._attributeText = (FigText) v.elementAt(6);
        figClone._cocontypeText = (FigText) v.elementAt(7);
        figClone._conditiontypeText = (FigText) v.elementAt(8);
        figClone._MUST_Text = (FigText) v.elementAt(9);
        figClone._BE_Text = (FigText) v.elementAt(10);
        figClone._targetText = (FigText) v.elementAt(11);
        figClone._scopeText = (FigText) v.elementAt(12);
        
        return figClone;            
    }

  ////////////////////////////////////////////////////////////////
  // Fig accessors

    public Selection makeSelection() {
        return null;
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

  public void setLineWidth(int w) {   _triangle.setLineWidth(w);}
  public int getLineWidth() { return _triangle.getLineWidth(); }

  public Dimension getMinimumSize() {
    Dimension nameDim = _name.getMinimumSize();
    int w = nameDim.width;
    int h = nameDim.height + 65;
    return new Dimension(w, h);
  }

 protected void updateModel() 
 {
       MContextbasedConstraintImpl me = (MContextbasedConstraintImpl) getOwner();
      if (me == null) 
      	return;
      	_targetText.setText(me.getTargetSet());
      	_scopeText.setText(me.getScopeSet());
      	_conditiontypeText.setText(me.getConditionType());
      	_cocontypeText.setText(me.getCoConType2());      	
      	_attributeText.setText(me.getAttribute());
  }
  
  /*
  *CalculateSetBoxes()
  *function to give the boxes of Scope-Set and Target(Constraint)-Set the right size
  */
  protected void calculateSetBoxes()
  {    
    Dimension targetDim = _targetText.getSize();
    Dimension scopeDim = _scopeText.getSize();

    int newtargetWidth = Math.max((int)targetDim.getWidth(), 40);
    int newtargetHeight = Math.max((int)targetDim.getHeight(), 40);
    int newScopeWidth = Math.max((int)scopeDim.getWidth(), 40);
    int newScopeHeight = Math.max((int)scopeDim.getHeight(), 40);
    newtargetHeight = Math.max(newtargetHeight, newScopeHeight);
    newtargetWidth = Math.max(newScopeWidth, newtargetWidth);
    Dimension newDimension = new Dimension (newtargetWidth, newtargetHeight);
    _targetPort.setSize(newDimension);
    _scopePort.setSize(newDimension);

  }


  protected void modelChanged() 
  {
    super.modelChanged();
    calculateSetBoxes();
    calcBounds();
    Rectangle rect = getBounds();
    setBounds(rect.x, rect.y,(int)this.getWidth(),(int)this.getHeight());
  }

  public void setBounds(int x, int y, int w, int h)
  {
    calculateSetBoxes();
    calcBounds();
    Rectangle oldBounds = getBounds();
   
    // calculate new width
	 
	 int middle = 41; 
	 middle += Math.max(_attributeText.getWidth()+10, _conditiontypeText.getWidth()+ _cocontypeText.getWidth()+35) ;
     
      _targetPort.setLocation(x, y);
      _targetText.setLocation(x, y);
      _triangle.setLocation(x+_targetPort.getWidth(), y + _targetPort.getHalfHeight()-8);
      _letter_i.setLocation(x+_targetPort.getWidth(), y + _targetPort.getHalfHeight()-8);
      _attributeText.setLocation(x+ _targetPort.getWidth()+ 20, y + _targetPort.getHalfHeight() + 5);
          
      _MUST_Text.setLocation(x+_targetPort.getWidth()+ 20, y + _targetPort.getHalfHeight() - 18);
    if(! _conditiontypeText.getText().equals(""))
    	 	_conditiontypeText.setLocation(((int)_MUST_Text.getLocation().getX())+34, y + _targetPort.getHalfHeight() - 18);
    else
     _conditiontypeText.setLocation(((int)_MUST_Text.getLocation().getX())+6, y + _targetPort.getHalfHeight() - 18);
    
     _BE_Text.setLocation(((int)_conditiontypeText.getLocation().getX())+25, y + _targetPort.getHalfHeight() - 18);
     _cocontypeText.setLocation(((int)_BE_Text.getLocation().getX())+25, y + _targetPort.getHalfHeight() - 18);
      _arrow.setPoints(0, x + _targetPort.getWidth() + 16, y + _targetPort.getHalfHeight() );
      _arrow.setPoints(1, x + _targetPort.getWidth()+middle, y + _targetPort.getHalfHeight() );
      _arrowhead.setLocation(_arrow.getX2(),  y + _targetPort.getHalfHeight() - 3);
      _scopePort.setLocation((int)(_arrowhead.getLastPoint().getX()), y);
      _scopeText.setLocation(((int)_scopePort.getLocation().getX()), y);

      calcBounds(); //_x = x; _y = y; _w = w; _h = h;
      Rectangle newBounds = getBounds();
      updateEdges();
      firePropChange("bounds", oldBounds, newBounds);
      updateModel();
  }
  
  public void  KeyPressed(KeyEvent ke)
  {
  	super.keyPressed(ke);
  }
  
   public void  mouseClicked(MouseEvent me)
  {
  	super.mouseClicked(me);
  }
  
   public void  mouseExited(MouseEvent me)
  {
  	super.mouseExited(me);
  		this.updateModel();
  }
  
  public void  mouseEntered(MouseEvent me)
  {
  	super.mouseEntered(me);
  		this.updateModel();
  }
   
   public void  mousePressed(MouseEvent me)
  {
  	super.mousePressed(me);
  		this.updateModel();
  }
   
   public void  mouseReleased(MouseEvent me)
  {
   	super.mouseReleased(me);
   	this.setBounds((int)getBounds().getX(),(int)getBounds().getY(),(int)getBounds().getWidth(),(int)getBounds().getHeight());
   	this.updateModel();
  }
  



  public void calcBounds() {
      super.calcBounds();
  }
}