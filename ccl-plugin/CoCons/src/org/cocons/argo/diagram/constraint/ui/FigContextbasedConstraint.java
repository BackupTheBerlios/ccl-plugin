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
import ru.novosoft.uml.foundation.data_types.MMultiplicity;
import org.cocons.uml.ccl.comparators.*;
import org.cocons.uml.ccl.*;
import org.cocons.uml.ccl.*;


/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @author Nghia Dang Duc
 * @author Rolf Exner
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

    // add other Figs here aes needed
    protected FigGroup _scopeVec;
    protected FigGroup _targetVec;

    protected FigRect _scopePort;
    protected FigRect _targetPort;
    protected FigText _targetText;
    protected FigText _scopeText;
    public MElementResidence resident = new MElementResidenceImpl();

    protected Vector mScops = new Vector();
    protected Vector mConsts = new Vector();
    ////////////////////////////////////////////////////////////////
    // constructors

    public FigContextbasedConstraint() {
        // Put this rectangle behind the rest, so it goes first
        _bigPort = new FigRect(5, 5, 40, 85, Color.gray, Color.gray);
        //_bigPort = new FigCircle(10, 10, 20, 30, Color.gray, Color.gray);

        //construction of the Scope-Set
        _scopePort = new FigRect(0,0,80,40, Color.gray, Color.white);
        _scopePort.setLineWidth(1);
        _scopePort.setFilled(true);

        _scopeVec = new FigGroup();
        _scopeVec.setFilled(true);
        _scopeVec.setLineWidth(1);
        _scopeVec.addFig(_scopePort);

        _scopeText =  new FigText(120,5,16,15, Color.black,"TimesRoman", 10);
        _scopeText.setText("Enter Scope Set");
        _scopeText.setFilled(false);
        _scopeText.setEditable(true);
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
        _targetPort = new FigRect(0,0,80,40, Color.gray, Color.white);
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
        _targetText.setEditable(true);
        _targetText.setLineWidth(0);
        _targetText.setWidth(85);

        //construction of the text-field for the cocon-type
        _stereo.setBounds(60, 7, 45, 15);
        _stereo.setExpandOnly(false);
        _stereo.setFilled(false);
        _stereo.setLineWidth(0);
        _stereo.setEditable(true);
        _stereo.setHeight(18);
        _stereo.setDisplayed(false);

        //construction of the text-field for details
        _name.setBounds(60, 30, 45, 15);
        _name.setTextFilled(false);
        _name.setEditable(true);
        _name.setFilled(false);
        _name.setLineWidth(0);
        _name.setExpandOnly(false);
        // initialize any other Figs here

        // add Figs to the FigNode in back-to-front order

        addFig(_scopePort);
        //addFig(_scopeVec);
        addFig(_arrow);
        addFig(_arrowhead);
        addFig(_triangle);
        addFig(_letter_i);
        addFig(_targetPort);
        addFig(_name);
        addFig(_stereo);
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
        FigContextbasedConstraint figClone = (FigContextbasedConstraint) super.clone();
        Vector v = figClone.getFigs();

        figClone._scopePort = (FigRect) v.elementAt(0);
        figClone._arrow = (FigLine) v.elementAt(1);
        figClone._arrowhead = (FigPoly) v.elementAt(2);
        figClone._triangle = (FigPoly) v.elementAt(3);
        figClone._letter_i = (FigText) v.elementAt(4);
        figClone._targetPort = (FigRect) v.elementAt(5);
        figClone._name = (FigText) v.elementAt(6);
        figClone._stereo = (FigText) v.elementAt(7);
        figClone._targetText = (FigText) v.elementAt(8);
        figClone._scopeText = (FigText) v.elementAt(9);

        return figClone;
    }

  ////////////////////////////////////////////////////////////////
  // Fig accessors

    public Selection makeSelection() {
        return null;
    }
/*
    public Vector getPopUpActions(MouseEvent me) {
        Vector popUpActions = super.getPopUpActions(me);
        JMenu addMenu = new JMenu("Add");

        addMenu.add(ActionAddAttribute.SINGLETON);
        addMenu.add(ActionAddOperation.SINGLETON);
        addMenu.add(ActionAddNote.SINGLETON);

        popUpActions.insertElementAt(addMenu, popUpActions.size() - 1);
        JMenu showMenu = new JMenu("Show");

        if(_attrVec.isDisplayed() && _operVec.isDisplayed())
            showMenu.add(ActionCompartmentDisplay.HideAllCompartments);
        else if(!_attrVec.isDisplayed() && !_operVec.isDisplayed())
            showMenu.add(ActionCompartmentDisplay.ShowAllCompartments);

        if (_attrVec.isDisplayed())
            showMenu.add(ActionCompartmentDisplay.HideAttrCompartment);
        else
            showMenu.add(ActionCompartmentDisplay.ShowAttrCompartment);

        if (_operVec.isDisplayed())
            showMenu.add(ActionCompartmentDisplay.HideOperCompartment);
        else
            showMenu.add(ActionCompartmentDisplay.ShowOperCompartment);

        popUpActions.insertElementAt(showMenu, popUpActions.size() - 1);
        return popUpActions;
    }
*/
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


  protected void updateModel() {
    MContextbasedConstraint me = (MContextbasedConstraint) getOwner();
    if (me == null) return;

    me.setCoConType("hier muﬂ noch die Checkbox ausgelesen werden...");

    /*
    * Read the Target-Set Text-Box and commit it to the Owner
    */

    String targetString = _targetText.getText();
    Vector compoString = new Vector();
    StringTokenizer st = new StringTokenizer(targetString);
    Vector conditionStrings = new Vector();
    Vector indirectAssoziations = new Vector();
    Vector directAssoziations = new Vector();
    int act = 0;

    // fill compoString with the plain text in the targetSet
    while (st.hasMoreTokens()) {
	compoString.addElement(st.nextToken());
    }

    // fill conditionStrings with the Vectors with the conditions

    for (int k = 0; k < compoString.size(); k++){
      if (compoString.get(k).toString().equals("or") || compoString.get(k).toString().equals("OR")){
        act = k;
        Vector helpString = new Vector();
        for (int i = act; i < k; i++){
          helpString.addElement(compoString.get(i));
        }
        conditionStrings.addElement(helpString);
      }
    }

    //compute the conditions and set the Target-Set
    for (int i = 0; i < conditionStrings.size(); i++){
      Vector actVect = (Vector) conditionStrings.get(i);

      //if indirect assoziation
      if (actVect.get(0).toString().equals("all") || actVect.get(0).toString().equals("ALL")){
        ContextCondition indirectCondition = buildConditionTree(actVect);
        //fill the Vector conditionTrees with all the indirect Assoziation Trees
        indirectAssoziations.addElement(indirectCondition);
      }
      //if direct assoziation
      else{
        //me.setTargetSetDirectElements(actVect);
        for (int j = 0; j < actVect.size(); j++){
          //fill the Vector directAssoziations with all the direct Elements
          directAssoziations.addElement( actVect.get(j));
        }
      }
    }
    //Now all Assoziations lay in the Vectors directAssoziations and indirectAssoziations

    //The direct Assoziations are ready for commit:
    me.setTargetSetDirectElements(directAssoziations);
    //The indirect Assoziations must be a Tree of the type ContextCondition:

    //... to Do: Built Tree out of the conditions and commit


   /*
    * Read the Scope-Set Text-Box and commit it to the Owner
    */

    //Needs more work

    //falls keine indirekte Assoziation besteht, wird als Parameter "null" ¸bergeben
  }


  protected ContextCondition buildConditionTree(Vector compoString){

    ContextConditionImpl target = new ContextConditionImpl();
    ComparatorFactoryImpl comparatorFactory = new ComparatorFactoryImpl();

    MMultiplicity range = new MMultiplicity( (compoString.get(0)).toString());
    String baseClass = (compoString.get(1)).toString();

    ComparisonImpl b = new ComparisonImpl();
    String condition = "";
    String value = "";
    for (int i = 3; i < compoString.size(); i++) {
      if (((compoString.get(i)).toString()).equals("=") ||((compoString.get(i)).toString()).equals("EQUALS")) {
        b.setComparator(comparatorFactory.produceComparatorWithType(ComparatorFactory.EQUAL));
        for(int j = 3; j < i; j++){
            condition = condition + compoString.get(j) + " ";
        }
        for(int h = i+1; h < compoString.size(); h++){
          value =value + compoString.get(h) + " ";
        }
      }
    }

    target.setRange(range);
    target.setBaseClass(baseClass);
    target.setComparison(b);
    return target;
  }



  /*
  *CalculateSetBoxes()
  *function to give the boxes of Scope-Set and Target(Constraint)-Set the right size
  */
  protected void calculateSetBoxes(){

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


  protected void modelChanged() {

    super.modelChanged();
    //calculate the size of targetSetBox and ScopeSetBox
    calculateSetBoxes();
    calcBounds();
    Rectangle rect = getBounds();

    // calculate new height
    int new_height = _targetPort.getHeight();
    // calculate new width
    int new_width = 41; // width of constant figs
    if (_stereo.isDisplayed() )
      new_width = new_width+ Math.max(_name.getWidth(),_stereo.getWidth());
    else
      new_width = new_width+_name.getWidth();
    new_width = new_width + (2 * _targetPort.getWidth());

    //figure will be resized and rearanged
    setBounds(rect.x-(new_width-rect.width)/2, rect.y-(new_height-rect.height), new_width, new_height);
  }

  public void setBounds(int x, int y, int w, int h){
    calculateSetBoxes();
    calcBounds();
    Rectangle oldBounds = getBounds();
    // calculate new height
    h = _targetPort.getHeight();

    // calculate new width
    int new_width = 41; // width of constant figs
    if (_stereo.isDisplayed() )
      new_width = new_width+ Math.max(_name.getWidth(),_stereo.getWidth());
    else
      new_width = new_width+_name.getWidth();

      w = new_width + (2 * _targetPort.getWidth());

      int textBoxWidth = _targetPort.getWidth(); //By "CalculateTextBoxes" it is sure that size of _targetPort and _scopePort is equal

      int coconTypeWidth = _name.getWidth();

      _targetPort.setLocation(x, y);
      _targetText.setLocation(x, y);
      _triangle.setLocation(x+textBoxWidth, y + _targetPort.getHalfHeight()-8);
      _letter_i.setLocation(x+textBoxWidth, y + _targetPort.getHalfHeight()-8);
      _name.setLocation(x+ w / 2 - _name.getWidth() / 2, y + _targetPort.getHalfHeight() + 5);
      if (_stereo.isDisplayed() )
        _stereo.setLocation(x+ w / 2 - _stereo.getWidth()/2, y + _targetPort.getHalfHeight() - 18);
      _arrow.setPoints(0, x + textBoxWidth + 16, y + _targetPort.getHalfHeight() );
      _arrow.setPoints(1, x + w - textBoxWidth - 10, y + _targetPort.getHalfHeight() );
      _arrowhead.setLocation(x + w - textBoxWidth - 10,  y + _targetPort.getHalfHeight() - 3);
      _scopePort.setLocation(x + w -textBoxWidth, y);
      _scopeText.setLocation(x + w -textBoxWidth, y);

      calcBounds(); //_x = x; _y = y; _w = w; _h = h;
      Rectangle newBounds = getBounds();
      updateEdges();
      firePropChange("bounds", oldBounds, newBounds);

  }

  public void calcBounds() {
      super.calcBounds();
  }
}