package org.cocons.argo.diagram.ui;

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
import org.cocons.uml.ccl.context_property1_3.*;
import org.cocons.argo.util.*;

import java.lang.Thread;
import org.argouml.ui.*;
import org.w3c.dom.Notation;

/**
 * Title:        CCL-Plugin for ArgoUML
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:      Technische Universität Berlin
 * @author hyshosha@gmx.de ; hasihola@cs.tu-berlin.de
 * @version 1.0
 */

public class FigContextProperty
  extends FigNodeModelElement implements MouseListener, MouseMotionListener{

  ////////////////////////////////////////////////////////////////
  // instance variables

  private FigTerminator _killer;
  private boolean _killed = false;
  private ModelIterator _modelIterator = ModelIterator.SINGLETON;
  private MContextPropertyValueImpl _myOwner;
	private MTaggedValue _badLoadedOwner;

  FigRect _bigPort;
  /* corners */
  FigPoly _topleft;
  FigPoly _topright;
  FigPoly _bottomleft;
  FigPoly _bottomright;

  ////////////////////////////////////////////////////////////////
  // constructors

  public FigContextProperty() {
	  _badLoadedOwner = null;

    _bigPort = new FigRect(10, 10, 90, 30, Color.blue, Color.yellow);
    _bigPort.setFillColor(Color.yellow);
    _bigPort.setFilled(true);

    _topleft = new FigPoly(Color.blue,Color.yellow);
    _topleft.addPoint(16,11);
    _topleft.addPoint(10,17);
    _topleft.addPoint(10,11);

    _topright = new FigPoly(Color.blue,Color.yellow);
    _topright.addPoint(99,11);
    _topright.addPoint(99,17);
    _topright.addPoint(93,11);

    _bottomleft = new FigPoly(Color.blue,Color.yellow);
    _bottomleft.addPoint(11,39);
    _bottomleft.addPoint(17,39);
    _bottomleft.addPoint(11,33);

    _bottomright = new FigPoly(Color.blue,Color.yellow);
    _bottomright.addPoint(92,39);
    _bottomright.addPoint(99,32);
    _bottomright.addPoint(99,39);

    _name.setBounds(14, 14, 82, 20);
    _name.setFilled(false);
    _name.setLineWidth(0);
    _name.setExpandOnly(false);
    _name.setEditable(false);
    _name.setJustification(FigText.JUSTIFY_LEFT);

    addFig(_bigPort);
    addFig(_name);
    addFig(_topleft);
    addFig(_topright);
    addFig(_bottomleft);
    addFig(_bottomright);

  }

  public FigContextProperty(GraphModel gm, Object node) {
    this();
	 _badLoadedOwner = null;
	 System.out.println("FigContextProperty ctor with node");
    setOwner(node);
    ((MContextPropertyValueImpl)node).internalRefToMyFigure(this);
    _myOwner = (MContextPropertyValueImpl)node;
    _name.setText(((MContextPropertyValueImpl)node).getContextPropertyTag().getName());
    modelChanged();
    _killer = new FigTerminator(this);
  }

  ////////////////////////////////////////////////////////////////
  // Fig accessors

  public void actualizeEntries() {
    if (_myOwner.getValueVisibility()) {
      String stereo = _myOwner.getStereoString();
      if (!_myOwner.getFigureOrientation()) {
        if (stereo.equals(""))
          _name.setText(_myOwner.getContextPropertyTag().getTag()+" : "+_myOwner.getValueString_Horizontal());
        else
          _name.setText("<<"+stereo+">> "+_myOwner.getContextPropertyTag().getTag()+" : "+_myOwner.getValueString_Horizontal());
      }
      else {
        if (stereo.equals(""))
          _name.setText(_myOwner.getContextPropertyTag().getTag()+" : "+_myOwner.getValueString_Vertical());
        else
          _name.setText("<<"+stereo+">> "+_myOwner.getContextPropertyTag().getTag()+" : "+_myOwner.getValueString_Vertical());
      }
    }
    else _name.setText(_myOwner.getContextPropertyTag().getTag());
    modelChanged();
  }

  public Selection makeSelection() {
    callFocus();
    return(null);
  }

  public void setOwner(Object node) {
	  if( node == null )
		  { System.out.println("FigContextProperty.setOwner(null)"); }
	  else if( node instanceof MTaggedValue )
		  {
			  System.out.println("FigContextProperty.setOwner() with MTaggedValue!");
			  _badLoadedOwner = (MTaggedValue)node;
		  }
	  else
		  {
			  _badLoadedOwner = null;
			  if (!_killed) {
				  super.setOwner(node);
				  bindPort(node, _bigPort);
			  }
		  }
  }

  public boolean isResizable() { return false; }

  public void setLineColor(Color col) {
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
    int w = _name.getWidth();
    int h = _name.getHeight();
    return new Dimension(w+10, Math.max(h+10,30));
  }

  protected void modelChanged() {
    if (!_killed) {
      // move the figs
      calcBounds();
      Rectangle rect = getBounds();
      // calculate new height
      int new_height = 0;
      new_height = new_height + _name.getHeight();

      int new_width = 10; // vorn und hinten soll noch etwas Platz sein
      new_width = new_width + _name.getWidth();

      MContextPropertyValueImpl owner = (MContextPropertyValueImpl)this.getOwner();
      if (owner.hasSelectedValues()) {
        this.setFillColor(Color.yellow);
        this.setLineColor(Color.blue);
        this.setTextColor(Color.black);
      }
      else {
        this.setFillColor(Color.lightGray);
        this.setLineColor(Color.blue);
        this.setTextColor(Color.red);
      }

      setBounds(rect.x, rect.y, new_width, new_height);
    }
  }

  public void setBounds(int x, int y, int w, int h) {

    Rectangle oldBounds = getBounds();
    int wt = _name.getWidth();
    wt = Math.max(wt,w);
    int ht = _name.getHeight();
    ht = Math.max(ht,30);

    _bigPort.setBounds(x,y,wt,ht);
    _topleft.setLocation( x , (y+1) );
    _topright.setLocation( x+wt-7 , (y+1) );
    _bottomleft.setLocation( (x+1) , y+ht-7 );
    _bottomright.setLocation( x+wt-(7+1) , y+ht-(7+1) );

    _name.setLocation(x+6, y+4);

    calcBounds(); //_x = x; _y = y; _w = w; _h = h;
    Rectangle newBounds = getBounds();
    updateEdges();
    firePropChange("bounds", oldBounds, newBounds);
  }

  public void delete() {
    _killer.killIt();
    _myOwner.getReferencedModelElement().removeTaggedValue(_myOwner);
    super.delete();
  }

  public void destroyMe() {
    _killed = true;
    this.delete();
  }

  public void kill() {
    _killed = true;
    super.delete();
  }

  public void startKiller() {
    _killer.start();
  }

  public void setColor(Color color) {
    setFillColor(color);
  }

  public void callFocus() {
    MessageContainer messCon = new MessageContainer();
    messCon.setMessage("focus gained");
    messCon.setObject(_myOwner);
    messCon.setString(_myOwner.getContextPropertyTag().getTag());
    _modelIterator.changeObservable(messCon);
  }

  // ...implements MouseListener
  public void mouseExited(MouseEvent me) {}
  public void mouseEntered(MouseEvent me) {}
  public void mouseReleased(MouseEvent me) {}
  public void mousePressed(MouseEvent me) {}

  private boolean _okay = false;
  public void mouseClicked(MouseEvent me) {
    if (me.getClickCount()==2) {
      _okay = !_okay;
      if (_okay) {
        _myOwner.negateValueVisibility();
        actualizeEntries();
        modelChanged();
      }
    }
    else callFocus();
  }
  // ...implements MouseMotionListener
  public void mouseDragged(MouseEvent me) {
    callFocus();
  }
  public void mouseMoved(MouseEvent me) {}


	public MTaggedValue getBadLoadedOwner()
	{ return _badLoadedOwner; }

  //////////////////////////////////////////////////////////////////////////////
  // Helper-Class FigTerminator
  // (removes the Context Property, if the referenced Model Element was deleted)
  class FigTerminator extends Thread {

    private FigContextProperty _figure;
    private boolean _start = true;
    private boolean _online;
    private boolean _killed = false;
    private boolean _go_on = true;
    private String _uuid_fig;
    private MContextPropertyValueImpl _owner;

    public FigTerminator(FigContextProperty figure) {
      super();
      _figure = figure;
      _online = false;
    }

    public void run() {
      _online = true;
      _killed = false;
      _go_on = true;
      if (_start) {
        _owner = (MContextPropertyValueImpl)_figure.getOwner();
        _uuid_fig = _owner.getUUID();
        _start = false;
      }
      try {
        while(_online) {
          this.sleep(500);
          _owner.forceTagAndValueConsistency();
          if (_figure.getFigEdges().size() == 0)  {
            // das referenzierte Modellobject wurde gelöscht
            _figure.kill();
            ProjectBrowser pb = ProjectBrowser.TheInstance;
            pb.getNavPane().forceUpdate();
            //destroy(); // new, but stops with error-message
            super.stop(); // deprecated, but stops without error-message
          }
          else if (_figure.getFigEdges().size() == 1)  {
            // die Kante zwischen Objekt-Figure und CP-Figure wurde gelöscht
            _owner.getReferencedModelElement().removeTaggedValue(_owner);
            _figure.kill();
            ProjectBrowser pb = ProjectBrowser.TheInstance;
            pb.getNavPane().forceUpdate();
            //destroy(); // new, but stops with error-message
            super.stop(); // deprecated, but stops without error-message
          }
          else {}
        }
        _killed = true;
      }
      catch(InterruptedException e) {}
    }

    public void killIt() {
      _online = false;
      while(!_killed) {}
    }

  }
  // Helper-Class FigTerminator
  //////////////////////////////////////////////////////////////////////////////

}
