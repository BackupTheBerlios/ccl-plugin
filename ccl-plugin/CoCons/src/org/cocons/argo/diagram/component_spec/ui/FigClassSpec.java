
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
import org.argouml.language.helpers.*;
import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.ui.*;
import org.cocons.argo.diagram.ui.ContextViewPopUpMenu;

public class FigClassSpec extends FigNodeModelElement{

    ////////////////////////////////////////////////////////////////
    // constants
    
    private static final int ROWHEIGHT = 17; // min. 17, used to calculate y pos of FigText items in _attrVec and _operVec
    private static final int STEREOHEIGHT = 18;
    
    ////////////////////////////////////////////////////////////////
    // instance variables
    
    protected FigRect _bigPort;
    protected FigRect _cover;
    protected FigRect _stereoLineBlinder;
    public MElementResidence resident = new MElementResidenceImpl();
    
    ////////////////////////////////////////////////////////////////
    // constructors
    
    public FigClassSpec() {
	_bigPort = new FigRect(10, 10, 90, 40, Color.cyan, Color.cyan);
	_cover = new FigRect(10, 10, 90, 40, Color.black, Color.white);
	_name.setLineWidth(1);
	_name.setFilled(true);
	
	_stereo.setExpandOnly(true);
	_stereo.setFilled(true);
	_stereo.setLineWidth(1);
	_stereo.setEditable(false);
	_stereo.setDisplayed(true);
	
	_stereoLineBlinder = new FigRect(11, 10+STEREOHEIGHT, 58, 2, Color.white, Color.white);
	_stereoLineBlinder.setLineWidth(1);
	_stereoLineBlinder.setDisplayed(true);
	
	addFig(_bigPort);
	addFig(_cover);
	addFig(_stereo);
	addFig(_name);
	addFig(_stereoLineBlinder);
	
	Rectangle r = getBounds();
	setBounds(10, 10, 90, 40);
    }

    public FigClassSpec(GraphModel gm, Object node) {
	this();
	setOwner(node);
	MStereotype stereo = ((MModelElement) node).getStereotype();
	if (stereo == null){
	    stereo = new MStereotypeImpl();
	    ((MModelElement) node).setStereotype(stereo);
	}
	((MModelElement) node).getStereotype().setName("comp spec");
	
	if (node instanceof MClassifier && (((MClassifier)node).getName() != null))
	    _name.setText(((MModelElement)node).getName());
    }
    
    public String placeString() { return "new Class"; }
    
    
    public Object clone() {
	FigClassSpec figClone = (FigClassSpec) super.clone();
	Vector v = figClone.getFigs();
	figClone._bigPort = (FigRect) v.elementAt(0);
	figClone._cover = (FigRect) v.elementAt(1);
	figClone._stereo = (FigText) v.elementAt(2);
	figClone._name = (FigText) v.elementAt(3);
	figClone._stereoLineBlinder = (FigRect) v.elementAt(4);
	return figClone;
    }
    
    ////////////////////////////////////////////////////////////////
    // accessors
    
    public Selection makeSelection() {
	return new SelectionMoveClarifiers(this);
    }
    
    public Vector getPopUpActions(MouseEvent me) {
	Vector popUpActions = super.getPopUpActions(me);
	JMenu addMenu = new JMenu("Add");
	addMenu.add(ActionAddNote.SINGLETON);
	popUpActions.insertElementAt(addMenu,popUpActions.size() - 1);
	ContextViewPopUpMenu.getPopUpActions(popUpActions);
	return popUpActions;
    }
    
    public void setLineColor(Color col) { _cover.setLineColor(col); }
    public Color getLineColor() { return _cover.getLineColor(); }
    
    public void setFillColor(Color col) { _cover.setFillColor(col); }
    public Color getFillColor() { return _cover.getFillColor(); }
    
    public void setFilled(boolean f) { _cover.setFilled(f); }
    public boolean getFilled() { return _cover.getFilled(); }
    
    public void setLineWidth(int w) { _cover.setLineWidth(w); }
    public int getLineWidth() { return _cover.getLineWidth(); }
    
    public void setOwner(Object node) {
	super.setOwner(node);
	Object onlyPort = node;
	bindPort(onlyPort, _bigPort);
	modelChanged();
    }
    
    
    
    
    public Dimension getMinimumSize() {
	Dimension aSize = _name.getMinimumSize();
	int h = aSize.height;
	int w = aSize.width;
	if (aSize.height < 21)
	    aSize.height = 21;
	if (_stereo.isDisplayed()) {
	    aSize.width = Math.max(aSize.width, _stereo.getMinimumSize().width);
	    aSize.height += STEREOHEIGHT;
	}
	return aSize;
    }
    
    public void translate(int dx, int dy) {
	super.translate(dx, dy);
	Editor ce = Globals.curEditor();
	Selection sel = ce.getSelectionManager().findSelectionFor(this);
	if (sel instanceof SelectionClassSpec)
	    ((SelectionClassSpec)sel).hideButtons();
  }
    
    ////////////////////////////////////////////////////////////////
    // user interaction methods
    
    public void mousePressed(MouseEvent me) {
	super.mousePressed(me);
	boolean targetIsSet = false;
	Editor ce = Globals.curEditor();
	Selection sel = ce.getSelectionManager().findSelectionFor(this);
	if (sel instanceof SelectionClassSpec)
	    ((SelectionClassSpec)sel).hideButtons();
	
    }
    
    public void setEnclosingFig(Fig encloser) {
	super.setEnclosingFig(encloser);
	if (!(getOwner() instanceof MModelElement)) return;
	MModelElement me = (MModelElement) getOwner();
	MNamespace m = null;
	ProjectBrowser pb = ProjectBrowser.TheInstance;
	if ((encloser == null && me.getNamespace() == null) ||
	    (encloser != null && encloser.getOwner() instanceof MPackage)) {
	    if (encloser != null) {
		m = (MNamespace) encloser.getOwner();
	    } else if (pb.getTarget() instanceof UMLDiagram) {
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
	return;
    }
    
    protected void modelChanged() {
	super.modelChanged();
	Rectangle rect = getBounds();
	MClassifier cls = (MClassifier) getOwner();
	if (cls == null) 
	    return;
	if (cls.isAbstract()) _name.setFont(ITALIC_LABEL_FONT);
	else _name.setFont(LABEL_FONT);
	
	setBounds(rect.x, rect.y, rect.width, rect.height); // recalculates all bounds
    }
    
    public void renderingChanged() {
	super.renderingChanged();
	updateStereotypeText();
	modelChanged();
    }
    
    protected void updateStereotypeText() {
	MModelElement me = (MModelElement) getOwner();
	if (me == null)
	    return;
	Rectangle rect = getBounds();
	MStereotype stereo = me.getStereotype();
	if (stereo == null || stereo.getName() == null || stereo.getName().length() == 0) {
	    if (! _stereo.isDisplayed())
		return;
	    _stereoLineBlinder.setDisplayed(false);
	    _stereo.setDisplayed(false);
	    rect.y += STEREOHEIGHT;
	    rect.height -= STEREOHEIGHT;
	}
	else {
	    _stereo.setText(Notation.generateStereotype(this,stereo));
	    if (!_stereo.isDisplayed()) {
		_stereoLineBlinder.setDisplayed(true);
		_stereo.setDisplayed(true);
		rect.y -= STEREOHEIGHT;
		rect.height += STEREOHEIGHT;
	    }
	}
	setBounds(rect.x, rect.y, rect.width, rect.height);
    }
    
    /** sets the bounds, but the size will be at least the
	one returned by getMinimunSize(); if the required
	height is bigger, then the additional height is equally
	distributed among all figs, such that the cumulated
	height of all visible figs equals the demanded height
    */
    public void setBounds(int x, int y, int w, int h) {
	Rectangle oldBounds = getBounds();
	Dimension aSize = getMinimumSize();
	int newW = Math.max(w,aSize.width);
	int newH = h;
	int extra_each = 0; // extra height per displayed fig if requested height is greater than minimal
	int height_correction = 0; // height correction due to rounded division result, will be added to _name
	
	//first compute all nessessary height data
	if (newH < aSize.height) {
	    newH = aSize.height;
	} else if (newH > aSize.height) {
	    extra_each = newH - aSize.height;
	    int displayedFigs = 1; //this is for _name
	    
	    extra_each = extra_each / displayedFigs; // result might be rounded, so:
	    height_correction = (newH - aSize.height) - (extra_each * displayedFigs); // will be added to _name only
	}
	
	//now resize all sub-figs, including not displayed figs
	int height = _name.getMinimumSize().height;
	if (height < 21)
	    height = 21;
	height += extra_each+height_correction;
	int currentY = y;
	if (_stereo.isDisplayed())
	    currentY += STEREOHEIGHT;
	_name.setBounds(x,currentY,newW,height);
	_stereo.setBounds(x,y,newW,STEREOHEIGHT+1);
	_stereoLineBlinder.setBounds(x+1,y+STEREOHEIGHT,newW-2,2);
	currentY += height-1; // -1 for 1 pixel overlap
	
   	
	// set bounds of big box
	_bigPort.setBounds(x,y,newW,newH);
	
	calcBounds(); //_x = x; _y = y; _w = w; _h = h;
	updateEdges();
	firePropChange("bounds", oldBounds, getBounds());
    }
    
    
    
    /** returns the new size of the FigGroup (either attributes or operations)
	after calculation new bounds for all sub-figs, considering their
	minimal sizes; FigGroup need not be displayed; no update event is fired */
    protected Dimension getUpdatedSize(FigGroup fg, int x, int y, int w, int h) {
	int newW = w;
	int n = fg.getFigs().size()-1;
	int newH = Math.max(h,ROWHEIGHT*Math.max(1,n)+1);
	int step = (n>0) ? newH / n : 0; // width step between FigText objects
	
	//set new bounds for all included figs
	Enumeration figs = fg.elements();
	Fig bigPort = (Fig)figs.nextElement();
	Fig fi;
	int fw, yy = y;
	while (figs.hasMoreElements()) {
	    fi = (Fig)figs.nextElement();
	    fw = fi.getMinimumSize().width;
	    fi.setBounds(x+1,yy+1,fw,ROWHEIGHT-2);
	    if (newW < fw+2)
		newW = fw+2;
	    yy += step;
	}
	bigPort.setBounds(x,y,newW,newH); // rectangle containing all following FigText objects
	fg.calcBounds();
	return new Dimension(newW,newH);
    }
    
    private class MyFigText extends FigText
    {
	private Fig refFig;
	public MyFigText(int x, int y, int w, int h, Fig aFig) {super(x,y,w,h,true); refFig=aFig;}
	public void setLineWidth(int w) {super.setLineWidth(0);}
	public int getLineWidth() {return 1;} // don't dare to throw away these fakes!
	public boolean getFilled() {return true;}
	public Color getFillColor() {return refFig.getFillColor();}
	public Color getLineColor() {return refFig.getLineColor();}
    }
} /* end class FigClassSpec */














