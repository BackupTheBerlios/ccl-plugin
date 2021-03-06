// Copyright (c) 1996-99 The Regents of the University of California. All
// Rights Reserved. Permission to use, copy, modify, and distribute this
// software and its documentation without fee, and without a written
// agreement is hereby granted, provided that the above copyright notice
// and this paragraph appear in all copies.  This software program and
// documentation are copyrighted by The Regents of the University of
// California. The software program and documentation are supplied "AS
// IS", without any accompanying services from The Regents. The Regents
// does not warrant that the operation of the program will be
// uninterrupted or error-free. The end-user understands that the program
// was developed for research purposes and is advised not to rely
// exclusively on the program for any reason.  IN NO EVENT SHALL THE
// UNIVERSITY OF CALIFORNIA BE LIABLE TO ANY PARTY FOR DIRECT, INDIRECT,
// SPECIAL, INCIDENTAL, OR CONSEQUENTIAL DAMAGES, INCLUDING LOST PROFITS,
// ARISING OUT OF THE USE OF THIS SOFTWARE AND ITS DOCUMENTATION, EVEN IF
// THE UNIVERSITY OF CALIFORNIA HAS BEEN ADVISED OF THE POSSIBILITY OF
// SUCH DAMAGE. THE UNIVERSITY OF CALIFORNIA SPECIFICALLY DISCLAIMS ANY
// WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
// MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE. THE SOFTWARE
// PROVIDED HEREUNDER IS ON AN "AS IS" BASIS, AND THE UNIVERSITY OF
// CALIFORNIA HAS NO OBLIGATIONS TO PROVIDE MAINTENANCE, SUPPORT,
// UPDATES, ENHANCEMENTS, OR MODIFICATIONS.

// File: FigPackage.java
// Classes: FigPackage
// Original Author: agauthie@ics.uci.edu
// $Id: FigPackage.java,v 1.1 2003/07/12 18:28:34 layekers Exp $


package org.argouml.uml.diagram.static_structure.ui;

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
import ru.novosoft.uml.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;

import org.apache.log4j.Category;
import org.argouml.application.api.*;
import org.argouml.kernel.*;

import org.argouml.uml.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.generator.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.ui.*;


/** Class to display graphics for a UML MState in a diagram. */

public class FigPackage extends FigNodeModelElement {
    protected static Category cat = Category.getInstance(FigPackage.class);

  ////////////////////////////////////////////////////////////////
  // constants

  public final int MARGIN = 2;
  public int x = 0;
  public int y = 0;
  public int width = 140;
  public int height = 100;
  public int indentX = 50;
  public int indentY = 20;
  public int textH = 20;
  protected int _radius = 20;

  ////////////////////////////////////////////////////////////////
  // instance variables

  FigText _body;


	/**
	 * Flags that indicates if the stereotype should be shown even if it is specified or not.
	 */
	protected	boolean _showStereotype	= true;

    /**
     * <p>A rectangle to blank out the line that would otherwise appear at the
     *   bottom of the stereotype text box.</p>
     */
	
    protected FigRect _stereoLineBlinder;


    /**
     * <p>Flag to indicate that we have just been created. This is to fix the
     *   problem with loading classes that have stereotypes already
     *   defined.</p>
     */

    private boolean _newlyCreated = false;

  ////////////////////////////////////////////////////////////////
  // constructors

  public FigPackage() {
    Color handleColor = Globals.getPrefs().getHandleColor();
    _bigPort = new FigRect(x, y, width, height, null, null) {
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.black);
			g.fillRect(_body.getX()+_shadowSize,_body.getY()+_body.getHeight(),_body.getWidth()-_shadowSize,_shadowSize);
			g.fillRect(_body.getX()+_body.getWidth(),_body.getY()+_shadowSize,_shadowSize,_body.getHeight());
			if (_stereo.getHeight() > _shadowSize)
				{
				g.fillRect(_stereo.getX()+_stereo.getWidth(),
						   _stereo.getY()+_shadowSize,
						   _shadowSize,
						   _stereo.getHeight());
				int blinderheight = (_name.getY()-1 - (_stereo.getY()+_stereo.getHeight()+1));
				if (blinderheight> 0)
					{
//					g.fillRect(_stereo.getX()+_stereo.getWidth(),
//							   _stereo.getY()+_stereo.getHeight(),
//							   _shadowSize,
//							   blinderheight);
					}
				}
			if (_name.getHeight() > _shadowSize)
				{
				g.fillRect(_name.getX()+_name.getWidth(),
						   _name.getY()+_shadowSize,
						   _shadowSize,
						   _name.getHeight()-_shadowSize);
				}
		}
    };

	//
	// Create a Body that reacts to double-clicks and jumps to a diagram.
	//
    _body = new FigText(x, y + textH, width, height - textH) {
		public void mouseClicked(MouseEvent me) {

			String lsDefaultName = "main";

			if (me.getClickCount() >= 2 )
				{
				MPackage lPkg = (MPackage) FigPackage.this.getOwner();
				if( lPkg != null )
					{
					MNamespace	lNS = lPkg;

					ProjectBrowser lPB = ProjectBrowser.TheInstance;
					Project lP = lPB.getProject();

					Vector diags = lP.getDiagrams();
					Enumeration diagEnum = diags.elements();
					UMLDiagram	lFirst =null;
					while ( diagEnum.hasMoreElements() ) 
						{
						UMLDiagram lDiagram = (UMLDiagram) diagEnum.nextElement();
						MNamespace	lDiagramNS = lDiagram.getNamespace();
						if ( (lNS == null && lDiagramNS == null)
							 || (lNS.equals(lDiagramNS)) )
							{
							/* save first */
							if( lFirst == null )
								{
								lFirst = lDiagram;
								}

							if( lDiagram.getName() != null 
								&& lDiagram.getName().startsWith(lsDefaultName) )
								{
								me.consume();
								super.mouseClicked(me);
								lPB.getNavPane().addToHistory(lDiagram);
								lPB.setTarget(lDiagram);
								lPB.select(lDiagram);
								return;
								}
							}
						}/*while*/

					/* if we get here then we didnt get the default diagram*/
					if( lFirst != null )
						{
						me.consume();
						super.mouseClicked(me);

						lPB.getNavPane().addToHistory(lFirst);
						lPB.setTarget(lFirst);
						lPB.select(lFirst);
						return;
						}
					else
						{/* try to create a new class diagram */
						me.consume();
						super.mouseClicked(me);
 						try
							{
                            String nameSpace;
                            if (lNS != null && lNS.getName() != null) 
                                nameSpace = lNS.getName();
                            else
                                nameSpace = "(anon)";
                            
                            String dialogText = 
                                "Add new class diagram to " + nameSpace +"?"; 
							int option = JOptionPane.
							showConfirmDialog(null, 
                                              dialogText,
                                              "Add new class diagram?",
											  JOptionPane.YES_NO_OPTION
											  );
							if (option == JOptionPane.YES_OPTION) 
								{
								ArgoDiagram lNew = new UMLClassDiagram(lNS);
								String diagramName = lsDefaultName+"_"+lNew.getName();

								lP.addMember(lNew);
								
								lPB.getNavPane().addToHistory(lNew);
								lPB.setTarget(lNew);
								lPB.select(lNew);	
								/* change prefix */
								lNew.setName(diagramName);
								}
							}
						catch( Exception ex)
							{}

						return;
						}/*if new*/

					}/*if package */
				}/* if doubleclicks */
			super.mouseClicked(me);
		}
	};

    _body.setEditable(false);

    _name.setBounds(x, y, width - indentX, textH + 2);
    _name.setJustification(FigText.JUSTIFY_LEFT);

    _bigPort.setFilled(false);
    _bigPort.setLineWidth(0);


	// Set properties of the stereotype box. Make it 1 pixel higher than
	// before, so it overlaps the name box, and the blanking takes out both
	// lines. Initially not set to be displayed, but this will be changed
	// when we try to render it, if we find we have a stereotype.
	
	_stereo.setExpandOnly(true);
	_stereo.setFilled(true);
	_stereo.setLineWidth(1);
	_stereo.setEditable(false);
	_stereo.setHeight(STEREOHEIGHT+1);
	_stereo.setDisplayed(false);
	
	// A thin rectangle to overlap the boundary line between stereotype
	// and name. This is just 2 pixels high, and we rely on the line
	// thickness, so the rectangle does not need to be filled. Whether to
	// display is linked to whether to display the stereotype.
	
	_stereoLineBlinder = new FigRect(11, 10+STEREOHEIGHT, 58, 2,
									 Color.white, Color.white);
	_stereoLineBlinder.setLineWidth(1);
	_stereoLineBlinder.setDisplayed(false);
	
	// Mark this as newly created. This is to get round the problem with
	// creating figs for loaded classes that had stereotypes. They are
	// saved with their dimensions INCLUDING the stereotype, but since we
	// pretend the stereotype is not visible, we add height the first time
	// we render such a class. This is a complete fudge, and really we
	// ought to address how class objects with stereotypes are saved. But
	// that will be hard work.
	
	_newlyCreated = true;

    // add Figs to the FigNode in back-to-front order
    addFig(_bigPort);
	addFig(_stereo);
    addFig(_name);
	addFig(_stereoLineBlinder);
    addFig(_body);

    setBlinkPorts(false); //make port invisble unless mouse enters
    Rectangle r = getBounds();
    setBounds(r.x, r.y, r.width, r.height);
    updateEdges();
  }

  public FigPackage(GraphModel gm, Object node) {
    this();
    setOwner(node);

    // If this figure is created for an existing package node in the
    // metamodel, set the figure's name according to this node. This is
    // used when the user click's on 'add to diagram' in the navpane.
    // Don't know if this should rather be done in one of the super
    // classes, since similar code is used in FigClass.java etc.
    // Andreas Rueckert <a_rueckert@gmx.net>
    if (node instanceof MPackage && (((MPackage)node).getName() != null))
        _name.setText(((MModelElement)node).getName());
  }

  public String placeString() { return "new Package"; }

  public Object clone() {
    FigPackage figClone = (FigPackage) super.clone();
    Vector v = figClone.getFigs();
    figClone._bigPort = (FigRect) v.elementAt(0);
	figClone._stereo = (FigText) v.elementAt(1);
    figClone._name = (FigText) v.elementAt(2);
	figClone._stereoLineBlinder = (FigRect) v.elementAt(3);
    figClone._body = (FigText) v.elementAt(4);
    return figClone;
  }

  ////////////////////////////////////////////////////////////////
  // Fig accessors

  public void setLineColor(Color col) {
    super.setLineColor(col);
    _stereo.setLineColor(col);
    _name.setLineColor(col);
    _body.setLineColor(col);
	_stereoLineBlinder.setLineColor(_stereoLineBlinder.getFillColor());
  }
 public Color getLineColor() { return _body.getLineColor(); }

  public void setFillColor(Color col) {
    super.setFillColor(col);
    _stereo.setFillColor(col);
    _name.setFillColor(col);
    _body.setFillColor(col);
	_stereoLineBlinder.setLineColor(col);
  }
  public Color getFillColor() { return _body.getFillColor(); }

  public void setFilled(boolean f) {
    _stereo.setFilled(f);
    _name.setFilled(f);
    _body.setFilled(f);
  }
  public boolean getFilled() { return _body.getFilled(); }

  public void setLineWidth(int w) {
    _stereo.setLineWidth(w);
    _name.setLineWidth(w);
    _body.setLineWidth(w);
  }
  public int getLineWidth() { return _body.getLineWidth(); }


  ////////////////////////////////////////////////////////////////

  public void renderingChanged() {
    super.renderingChanged();
//REMOVED called in modelChanged    updateStereotypeText();
    modelChanged();
  }
    protected void updateStereotypeText() {
        MModelElement me = (MModelElement) getOwner();
		
        if (me == null) 
			{
			return;
			}
		
		Rectangle   rect   = getBounds();
        MStereotype stereo = me.getStereotype();
		
		/* check if stereotype is defined */
        if ((stereo == null) ||
            (stereo.getName() == null) ||
            (stereo.getName().length() == 0)) 
			{
            if (_stereo.isDisplayed()) 
				{
                _stereoLineBlinder.setDisplayed(false);
                _stereo.setDisplayed(false);
//                rect.y      += STEREOHEIGHT;
//                rect.height -= STEREOHEIGHT;
				}
			}
        else 
			{
			/* we got stereotype */
            _stereo.setText(Notation.generateStereotype(this,stereo));
			
			if( !_showStereotype )
				{
				_stereoLineBlinder.setDisplayed(false);
				_stereo.setDisplayed(false);
				}

            else if ( !_stereo.isDisplayed() ) 
				{
				if( _showStereotype )
					{
					_stereoLineBlinder.setDisplayed(true);
					_stereo.setDisplayed(true);
					
					// Only adjust the stereotype height if we are not newly
					// created. This gets round the problem of loading classes with
					// stereotypes defined, which have the height already including
					// the stereotype.
					
					if( !_newlyCreated ) 
						{
//						rect.y      -= STEREOHEIGHT;
//						rect.height += STEREOHEIGHT;
						}
					}
				}
			}
		
        // Whatever happened we are no longer newly created, so clear the
        // flag. Then set the bounds for the rectangle we have defined.
		
        _newlyCreated = false;
		setBounds(rect.x, rect.y, rect.width, rect.height);
    }

  ////////////////////////////////////////////////////////////////
  // user interaction methods

  public void setEnclosingFig(Fig encloser) {
    Fig oldEncloser = getEnclosingFig();
    super.setEnclosingFig(encloser);
    if (!(getOwner() instanceof MModelElement)) return;
    MModelElement me = (MModelElement) getOwner();
    MNamespace m = null;
    ProjectBrowser pb = ProjectBrowser.TheInstance;
    try {
       // If moved into an Package
        if (encloser != null && oldEncloser != encloser &&
	    encloser.getOwner() instanceof MPackage) {
            me.setNamespace((MNamespace) encloser.getOwner());
        }

        // If default Namespace is not already set
        if (me.getNamespace() == null &&
	    pb.getTarget() instanceof UMLDiagram) {
	  m = (MNamespace) ((UMLDiagram)pb.getTarget()).getNamespace();
          me.setNamespace(m);
        }
    }
    catch (Exception e) {
        cat.error("could not set package due to:"+e + "' at "+encloser, e);
    }
  }

  ////////////////////////////////////////////////////////////////
  // accessor methods

  public boolean getUseTrapRect() { return true; }

  public Dimension getMinimumSize() {
	  // Use "aSize" to build up the minimum size. Start with the size of the
	  // name compartment and build up.
	  
	  Dimension aSize = _name.getMinimumSize();
	  
	  int w = aSize.width + indentX;
	  int h = aSize.height+ height- textH;

	  // Ensure that the minimum height of the name compartment is at least
	  // 21 pixels (hardcoded).

	  if (aSize.height < 21) 
		  {
		  aSize.height = 21;
		  }
	  
	  int minWidth = Math.max(0, w +1 + _shadowSize);
	  if (aSize.width < minWidth) 
		  {
		  aSize.width = minWidth;
		  }

	  // If we have a stereotype displayed, then allow some space for that
	  // (width and height)
	  
	  if (_stereo.isDisplayed()) 
		  {
		  aSize.width = Math.max(aSize.width,
								 _stereo.getMinimumSize().width);
		  aSize.height += STEREOHEIGHT;
		  }
      // we want at least some of the package body to be displayed
      aSize.height = Math.max(aSize.height, 60);
	  // And now aSize has the answer
        return aSize;
  }


    /** 
     * <p>Sets the bounds, but the size will be at least the one returned by
     *   {@link #getMinimumSize()}.</p> 
     *
     * <p>If the required height is bigger, then the additional height is
     *   equally distributed among all figs (i.e. compartments), such that the
     *   cumulated height of all visible figs equals the demanded height<p>.
     *
     * <p>Some of this has "magic numbers" hardcoded in. In particular there is
     *   a knowledge that the minimum height of a name compartment is 21
     *   pixels.</p> 
     *
     * @param x  Desired X coordinate of upper left corner
     *
     * @param y  Desired Y coordinate of upper left corner
     *
     * @param w  Desired width of the FigClass
     *
     * @param h  Desired height of the FigClass
     */
  public void setBounds(int x, int y, int w, int h) {
	  // Save our old boundaries (needed later), and get minimum size
	  // info. "aSize will be used to maintain a running calculation of our
	  // size at various points.
	  	  
	  Rectangle oldBounds = getBounds();
	  Dimension aSize = getMinimumSize();
	  
	  int newW = Math.max(w,aSize.width);
	  int newH = h;
	  
	  int extra_each = 0;
	  int height_correction = 0;
	  
	  // First compute all nessessary height data. Easy if we want less than
	  // the minimum
	  
	  if (newH <= aSize.height)
		  {	  
	      // Just use the mimimum
	      newH = aSize.height;		  
		  } 

	  // Now resize all sub-figs, including not displayed figs. Start by the
	  // name. We override the getMinimumSize if it is less than our view (21
	  // pixels hardcoded!). Add in the shared extra, plus in this case the
	  // correction.
	  
	  int height = _name.getMinimumSize().height;
	  
	  if (height < 21) 
		  {
		  height = 21;
		  }
	  	  
	  // Now sort out the stereotype display. If the stereotype is displayed,
	  // move the upper boundary of the name compartment up and set new
	  // bounds for the name and the stereotype compatments and the
	  // stereoLineBlinder that blanks out the line between the two
	  
	  int currentY = y;
	  
	  if (_stereo.isDisplayed()) 
		  {
		  currentY += STEREOHEIGHT;
		  }
	  
	  _name.setBounds(  x, currentY, newW-indentX, height);
	  _stereo.setBounds(x, y,        newW-indentX, STEREOHEIGHT + 1);
	  _stereoLineBlinder.setBounds(x + 1,y + STEREOHEIGHT,newW - 2-indentX,2);
	  	  
	  // Advance currentY to where the start of the body box is,
	  // remembering that it overlaps the next box by 1 pixel. Calculate the
	  // size of the attribute box, and update the Y pointer past it if it is
	  // displayed.
	  
	  currentY += height - 1;  // -1 for 1 pixel overlap
	  _body.setBounds(x, currentY, newW, newH + y - currentY);

	  // set bounds of big box
	  
	  _bigPort.setBounds(x,y,newW,newH);
	  
	  // Now force calculation of the bounds of the figure, update the edges
	  // and trigger anyone who's listening to see if the "bounds" property
	  // has changed.
	  
	  calcBounds();
	  updateEdges();
	  firePropChange("bounds", oldBounds, getBounds());
  }

  /**
    * Build a collection of menu items relevant for a right-click popup menu on a Package.
    *
    * @param     me     a mouse event
    * @return          a collection of menu items
    */
  public Vector getPopUpActions(MouseEvent me) {
    Vector popUpActions = super.getPopUpActions(me);
    MPackage mclass = (MPackage) getOwner();

    ArgoJMenu modifierMenu = new ArgoJMenu("Modifiers");

    modifierMenu.addCheckItem(new ActionModifier("Abstract", "isAbstract", "isAbstract", "setAbstract", mclass));
    modifierMenu.addCheckItem(new ActionModifier("Leaf", "isLeaf", "isLeaf", "setLeaf", mclass));
    modifierMenu.addCheckItem(new ActionModifier("Root", "isRoot", "isRoot", "setRoot", mclass));

    popUpActions.insertElementAt(modifierMenu, popUpActions.size() - 1);


    ArgoJMenu showMenu = new ArgoJMenu("Show");

	if ( !_showStereotype  )
		  {
		  showMenu.add(new UMLAction ("Show Stereotype", UMLAction.NO_ICON) {
			  public void actionPerformed(ActionEvent ae) {
				  _showStereotype = true;
				  renderingChanged();
				  damage();
			  }
		  });
		  }
	else 
		{
		  showMenu.add(new UMLAction ("Hide Stereotype", UMLAction.NO_ICON) {
			  public void actionPerformed(ActionEvent ae) {
				  _showStereotype = false;
				  renderingChanged();
				  damage();
			  }
		  });
		  }

    popUpActions.insertElementAt(showMenu, popUpActions.size() - 1);



    return popUpActions;
  }

 
} /* end class FigPackage */



