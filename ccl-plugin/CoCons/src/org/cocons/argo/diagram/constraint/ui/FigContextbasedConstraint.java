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
import org.cocons.uml.ccl.util.ContextConditionFactory;
import org.cocons.uml.ccl.util.ConvertCoconsToSyntaxCheck;


/**
 * Title:        CoCons
 * Description:  CoCons CCL Metamodel Library
 * Copyright:    Copyright (c) 2001
 * Company:      TU Berlin, CIS
 * @author Martin Skinner
 * @author Nghia Dang Duc
 * @author Rolf Exner, Soner Dastan
 * @version 1.1
 */

public class FigContextbasedConstraint extends FigNodeModelElement {
  private String nameString;
  private boolean updateCoconType;
  private boolean updateTargetDirect;
  private boolean updateScopeDirect;
  private boolean updateTargetIndirect;
  private boolean updateScopeIndirect;

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
    protected FigText _coconstypeText;
    protected FigText _attributeText;
    public MElementResidence resident = new MElementResidenceImpl();


    protected Vector mScops = new Vector();
    protected Vector mConsts = new Vector();
    ////////////////////////////////////////////////////////////////
    // constructors

    public FigContextbasedConstraint() {
         nameString = "hallo";


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
        _coconstypeText = new FigText (60, 7, 45, 15, Color.black, "TimesRoman", 10);
        _coconstypeText.setText("MUST BE");
        _coconstypeText.setDisplayed(true);
        _coconstypeText.setEditable(false);
        _coconstypeText.setFilled(false);
        _coconstypeText.setLineWidth(0);
        _coconstypeText.setHeight(18);
        _coconstypeText.setExpandOnly(false);

        //construction of the text-field for details
        _name.setBounds(60, 30, 45, 15);
        _name.setTextFilled(false);
        _name.setEditable(true);
        _name.setFilled(false);
        _name.setLineWidth(0);
        _name.setExpandOnly(false);
        _name.setDisplayed(false);

        _attributeText = new FigText (60, 30, 45, 15, Color.black, "TimesRoman", 10);
        _attributeText.setText("Attribute: ");
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
        addFig(_name);
        addFig(_attributeText);
        addFig(_coconstypeText);
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
        figClone._attributeText = (FigText) v.elementAt(7);
        figClone._targetText = (FigText) v.elementAt(8);
        figClone._scopeText = (FigText) v.elementAt(9);
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

  protected void updateTargetText() {
      MContextbasedConstraint me = (MContextbasedConstraint) getOwner();
      if (me == null) return;
      String newNameString = me.getName();
      System.out.println(nameString);
      System.out.println(newNameString);
      if (nameString != null){
        if(nameString.equals(newNameString) ){
          updateTargetDirect = false;
          updateTargetIndirect = false;
        }
        else{
          updateTargetDirect = true;
          updateTargetIndirect = true;
          nameString = newNameString;
        }
      }
      else {
        updateTargetDirect = true;
        updateTargetIndirect = true;
        nameString = me.getName();
      }


      String cocons = me.getName();
      if (cocons == null || me.getName() == null || me.getName().length() == 0)
      {
          if (! _targetText.isDisplayed()) return;
          _targetText.setDisplayed(false);
          return;
      }
      else
      {
          String targetText = me.getName();
          StringTokenizer st = new StringTokenizer(targetText,";");
          Vector s = new Vector();
          while (st.hasMoreTokens()) {
               s.addElement(st.nextToken());
          }

          _targetText.setText((s.get(0)).toString());

          if (!_targetText.isDisplayed()) {
              _targetText.setDisplayed(true);
          }
      }
    }

    protected void updateCoConsTypeText() {
        MContextbasedConstraint me = (MContextbasedConstraint) getOwner();
        if (me == null) return;

              String newNameString = me.getName();
      if (nameString != null){
        if(nameString.equals(newNameString) ){
          updateCoconType = false;
        }
        else{
          updateCoconType = true;
          nameString = newNameString;
        }
      }
      else {
        updateCoconType = true;
        nameString = me.getName();
      }


        String cocons = me.getName();
        if (cocons == null || me.getName() == null || me.getName().length() == 0)
        {
            if (! _coconstypeText.isDisplayed()) return;
            _coconstypeText.setDisplayed(false);
            return;
        }
        else
        {
            String type = me.getName();
            StringTokenizer st = new StringTokenizer(type,";");
            Vector s = new Vector();
            while (st.hasMoreTokens()) {
                 s.addElement(st.nextToken());
            }

            _coconstypeText.setText((s.get(1)).toString());

            if (!_coconstypeText.isDisplayed()) {
                _coconstypeText.setDisplayed(true);
            }
        }
  }
  protected void updateScopeText() {
      MContextbasedConstraint me = (MContextbasedConstraint) getOwner();
      if (me == null) return;

      String newNameString = me.getName();
      if (nameString != null){
        if(nameString.equals(newNameString) ){
          updateScopeDirect = false;
          updateScopeIndirect = false;
        }
        else{
          updateScopeDirect = true;
          updateScopeIndirect = true;
          nameString = newNameString;
        }
      }
      else {
        updateScopeDirect = true;
        updateScopeIndirect = true;
        nameString = me.getName();
      }




      String cocons = me.getName();
      if (cocons == null || me.getName() == null || me.getName().length() == 0)
      {
          if (! _scopeText.isDisplayed()) return;
          _scopeText.setDisplayed(false);
          return;
      }
      else
      {
          String scopeText = me.getName();
          StringTokenizer st = new StringTokenizer(scopeText,";");
          Vector s = new Vector();
          while (st.hasMoreTokens()) {
               s.addElement(st.nextToken());
          }

          _scopeText.setText((s.get(2)).toString());

          if (!_scopeText.isDisplayed()) {
              _scopeText.setDisplayed(true);
          }
      }
  }

  protected void updateAttributeText() {
      MContextbasedConstraint me = (MContextbasedConstraint) getOwner();
      if (me == null) return;
      String cocons = me.getName();
      if (cocons == null || me.getName() == null || me.getName().length() == 0)
      {
          if (! _attributeText.isDisplayed()) return;
          _attributeText.setDisplayed(false);
          return;
      }
      else
      {
          String attributeText = me.getName();
          StringTokenizer st = new StringTokenizer(attributeText,";");
          Vector s = new Vector();
          while (st.hasMoreTokens()) {
               s.addElement(st.nextToken());
          }

          _attributeText.setText((s.get(3)).toString());

          if (!_attributeText.isDisplayed()) {
              _attributeText.setDisplayed(true);
          }
      }
  }


 protected void updateModel() {

      MContextbasedConstraintImpl me = (MContextbasedConstraintImpl) getOwner();
      if (me == null) return;

      ConvertCoconsToSyntaxCheck convert = new ConvertCoconsToSyntaxCheck();

      String coconString = _targetText.getText();
      coconString = coconString + " " + _coconstypeText.getText();
      coconString = coconString + " " + _scopeText.getText();
      coconString = convert(coconString);
      //System.out.println(coconString);

      ContextConditionFactory ccf = new ContextConditionFactory(coconString);

      if (!ccf.isValidTarget(_targetText.getText())){
        _targetText.setFilled(true);
        _targetText.setFillColor(Color.red);
        //System.out.println("isValid in Target: " + ccf.isValidTarget());
      }
      else{
        _targetText.setFillColor(Color.white);
        _targetText.setFilled(false);
        //System.out.println("isValid in Target: " + ccf.isValidTarget());
      }

      if (! ccf.isValidScope(_scopeText.getText())){
          _scopeText.setFillColor(Color.red);
          _scopeText.setFilled(true);
          //System.out.println("isValid in Scope: " + ccf.isValidScope());
      }
      else{
         _scopeText.setFillColor(Color.white);
         _scopeText.setFilled(false);
         //System.out.println("isValid in Scope: " + ccf.isValidScope());
      }

      //THE VALUES OF THE COCON ARE READ FROM THE COCONFACTORY

      if (ccf.isValid()){
        String coConType = ccf.getCoConType();
        //System.out.println(coConType);

        Vector targetDirectElements = new Vector();
        targetDirectElements = ccf.getTargetDirectAssoziations();
        System.out.println(targetDirectElements);

        Vector scopeDirectElements = new Vector();
        scopeDirectElements = ccf.getScopeDirectAssoziations();
        System.out.println(scopeDirectElements);

        Vector targetIndirectElements = new Vector();
        targetIndirectElements = ccf.getTargetIndirectAssoziations();
        System.out.println(targetIndirectElements);

        Vector scopeIndirectElements = new Vector();
        scopeIndirectElements = ccf.getScopeIndirectAssoziations();
        System.out.println(scopeIndirectElements);

        System.out.println("vor setdirect: " + me.getTargetElements());
        if(updateTargetDirect){
          updateTargetDirect = false;
          me.setTargetSetDirectElements(targetDirectElements);
        }
        System.out.println("nach setdirect: " + me.getTargetElements());

        if(updateScopeDirect){
          updateScopeDirect = false;
          me.setScopeSetDirectElements(scopeDirectElements);
        }

        if(updateTargetIndirect){
          updateTargetIndirect = false;
          me.setTargetSetContextConditions(targetIndirectElements);
        }

        if(updateScopeIndirect){
          updateScopeIndirect = false;
          me.setScopeSetContextConditions(scopeIndirectElements);
        }

        if(updateCoconType){
          updateCoconType = false;
          me.setCoConType(coConType);
        }
      }

  }

  /*
  *CalculateSetBoxes()
  *function to give the boxes of Scope-Set and Target(Constraint)-Set the right size
  */
  protected void calculateSetBoxes(){
    //System.out.println("calculateBoxes");
    updateTargetText();
    updateCoConsTypeText();
    updateScopeText();
    updateAttributeText();


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
    //System.out.println("modelChanged");
    super.modelChanged();
    //calculate the size of targetSetBox and ScopeSetBox
    calculateSetBoxes();
    calcBounds();
    Rectangle rect = getBounds();

    // calculate new height
    int new_height = _targetPort.getHeight();
    // calculate new width
    int new_width = 41; // width of constant figs
    if (_coconstypeText.isDisplayed() )
      new_width = new_width+ Math.max(_attributeText.getWidth(),_coconstypeText.getWidth());
    else
      new_width = new_width+_attributeText.getWidth();
    new_width = new_width + (2 * _targetPort.getWidth());

    //figure will be resized and rearanged
    setBounds(rect.x-(new_width-rect.width)/2, rect.y-(new_height-rect.height), new_width, new_height);
  }

  public void setBounds(int x, int y, int w, int h){
    //System.out.println("setBounds");
    calculateSetBoxes();
    calcBounds();
    Rectangle oldBounds = getBounds();
    // calculate new height
    h = _targetPort.getHeight();

    // calculate new width
    int new_width = 41; // width of constant figs
    if (_coconstypeText.isDisplayed() )
      new_width = new_width+ Math.max(_attributeText.getWidth(),_coconstypeText.getWidth());
    else
      new_width = new_width+_attributeText.getWidth();

      w = new_width + (2 * _targetPort.getWidth());

      int textBoxWidth = _targetPort.getWidth(); //By "CalculateTextBoxes" it is sure that size of _targetPort and _scopePort is equal

      int coconTypeWidth = _attributeText.getWidth();

      _targetPort.setLocation(x, y);
      _targetText.setLocation(x, y);
      _triangle.setLocation(x+textBoxWidth, y + _targetPort.getHalfHeight()-8);
      _letter_i.setLocation(x+textBoxWidth, y + _targetPort.getHalfHeight()-8);
      _attributeText.setLocation(x+ w / 2 - _attributeText.getWidth() / 2, y + _targetPort.getHalfHeight() + 5);
      if (_coconstypeText.isDisplayed() )
        _coconstypeText.setLocation(x+ w / 2 - _coconstypeText.getWidth()/2, y + _targetPort.getHalfHeight() - 18);
      _arrow.setPoints(0, x + textBoxWidth + 16, y + _targetPort.getHalfHeight() );
      _arrow.setPoints(1, x + w - textBoxWidth - 10, y + _targetPort.getHalfHeight() );
      _arrowhead.setLocation(x + w - textBoxWidth - 10,  y + _targetPort.getHalfHeight() - 3);
      _scopePort.setLocation(x + w -textBoxWidth, y);
      _scopeText.setLocation(x + w -textBoxWidth, y);

      calcBounds(); //_x = x; _y = y; _w = w; _h = h;
      Rectangle newBounds = getBounds();
      updateEdges();
      firePropChange("bounds", oldBounds, newBounds);
      System.out.println("jetzt wird updateModel aufgerufen");
      updateModel();
  }

  public void calcBounds() {
      super.calcBounds();
  }
}
