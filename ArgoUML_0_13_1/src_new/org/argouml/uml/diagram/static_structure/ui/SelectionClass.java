// Copyright (c) 1996-2002 The Regents of the University of California. All
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

// File: SelectionClass.java
// Classes: SelectionClass
// Original Author: jrobbins@ics.uci.edu
// $Id: SelectionClass.java,v 1.1 2003/07/12 18:28:34 layekers Exp $

package org.argouml.uml.diagram.static_structure.ui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Icon;

import ru.novosoft.uml.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.util.*;

import org.apache.log4j.Category;
import org.argouml.model.uml.UmlFactory;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.deployment.*;

public class SelectionClass extends SelectionWButtons {
    protected static Category cat = 
        Category.getInstance(SelectionClass.class);
    ////////////////////////////////////////////////////////////////
    // constants
    public static Icon inherit = 
        ResourceLoader.lookupIconResource("Generalization");

    public static Icon assoc = 
        ResourceLoader.lookupIconResource("Association");

    public static Icon compos = 
        ResourceLoader.lookupIconResource("CompositeAggregation");

    public static Icon selfassoc =
        ResourceLoader.lookupIconResource("SelfAssociation");

    ////////////////////////////////////////////////////////////////
    // instance variables
    protected boolean _useComposite = false;

    ////////////////////////////////////////////////////////////////
    // constructors

    /** Construct a new SelectionClass for the given Fig */
    public SelectionClass(Fig f) { super(f); }

    /** Return a handle ID for the handle under the mouse, or -1 if
     *  none. Needs-More-Work: in the future, return a Handle instance or
     *  null. <p>
     *  <pre>
     *   0-------1-------2
     *   |               |
     *   3               4
     *   |               |
     *   5-------6-------7
     * </pre>
     */
    public void hitHandle(Rectangle r, Handle h) {
        super.hitHandle(r, h);
        if (h.index != -1) return;
        if (!_paintButtons) return;
        Editor ce = Globals.curEditor();
        SelectionManager sm = ce.getSelectionManager();
        if (sm.size() != 1) return;
        ModeManager mm = ce.getModeManager();
        if (mm.includes(ModeModify.class) && _pressedButton == -1) return;
        int cx = _content.getX();
        int cy = _content.getY();
        int cw = _content.getWidth();
        int ch = _content.getHeight();
        int iw = inherit.getIconWidth();
        int ih = inherit.getIconHeight();
        int aw = assoc.getIconWidth();
        int ah = assoc.getIconHeight();
        int saw = selfassoc.getIconWidth();
        int sah = selfassoc.getIconHeight();

        if (hitAbove(cx + cw/2, cy, iw, ih, r)) {
            h.index = 10;
            h.instructions = "Add a superclass";
        }
        else if (hitBelow(cx + cw/2, cy + ch, iw, ih, r)) {
            h.index = 11;
            h.instructions = "Add a subclass";
        }
        else if (hitLeft(cx + cw, cy + ch/2, aw, ah, r)) {
            h.index = 12;
            h.instructions = "Add an associated class";
        }
        else if (hitRight(cx, cy + ch/2, aw, ah, r)) {
            h.index = 13;
            h.instructions = "Add an associated class";
        }
        else if (hitRight(cx, cy + ch - 10, saw, sah, r)) {
            h.index = 14;
            h.instructions = "Add a self association";
        }
        else {
            h.index = -1;
            h.instructions = "Move object(s)";
        }
    }


    /** Paint the handles at the four corners and midway along each edge
     * of the bounding box.  */
    public void paintButtons(Graphics g) {
        int cx = _content.getX();
        int cy = _content.getY();
        int cw = _content.getWidth();
        int ch = _content.getHeight();

        // The next two lines are necessary to get the GraphModel,
        // in the DeploymentDiagram there are no Generalizations
        Editor ce = Globals.curEditor();
        GraphModel gm = ce.getGraphModel();

        if (!(gm instanceof DeploymentDiagramGraphModel)) {
            paintButtonAbove(inherit, g, cx + cw/2, cy, 10);
            paintButtonBelow(inherit, g, cx + cw/2, cy + ch, 11);
        }
        if (_useComposite) {
            paintButtonLeft(compos, g, cx + cw, cy + ch/2, 12);
            paintButtonRight(compos, g, cx, cy + ch/2, 13);
            paintButtonRight(selfassoc, g, cx, cy + ch - 10, 14);
        }
        else {
            paintButtonLeft(assoc, g, cx + cw, cy + ch/2, 12);
            paintButtonRight(assoc, g, cx, cy + ch/2, 13);
            paintButtonRight(selfassoc, g, cx, cy + ch - 10, 14);
        }
    }


    public void dragHandle(int mX, int mY, int anX, int anY, Handle hand) {
        if (hand.index < 10) {
            _paintButtons = false;
            super.dragHandle(mX, mY, anX, anY, hand);
            return;
        }
        int cx = _content.getX(), cy = _content.getY();
        int cw = _content.getWidth(), ch = _content.getHeight();
        int newX = cx, newY = cy, newW = cw, newH = ch;
        Dimension minSize = _content.getMinimumSize();
        int minWidth = minSize.width, minHeight = minSize.height;
        Class edgeClass = null;
        Class nodeClass = ru.novosoft.uml.foundation.core.MClassImpl.class;
        int bx = mX, by = mY;
        boolean reverse = false;
        switch (hand.index) {
        case 10: //add superclass
            edgeClass = ru.novosoft.uml.foundation.core.MGeneralization.class;
            by = cy;
            bx = cx + cw/2;
            break;
        case 11: //add subclass
            edgeClass = ru.novosoft.uml.foundation.core.MGeneralization.class;
            reverse = true;
            by = cy + ch;
            bx = cx + cw/2;
            break;
        case 12: //add assoc
            edgeClass = ru.novosoft.uml.foundation.core.MAssociation.class;
            by = cy + ch/2;
            bx = cx + cw;
            break;
        case 13: // add assoc
            edgeClass = ru.novosoft.uml.foundation.core.MAssociation.class;
            reverse = true;
            by = cy + ch/2;
            bx = cx;
            break;
        case 14: // selfassociation
            // do not want to drag this
            break;
        default:
            cat.warn("invalid handle number");
            break;
        }
        if (edgeClass != null && nodeClass != null) {
            Editor ce = Globals.curEditor();
            ModeCreateEdgeAndNode m = new
                ModeCreateEdgeAndNode(ce, edgeClass, nodeClass, _useComposite);
            m.setup((FigNode)_content, _content.getOwner(), bx, by, reverse);
            ce.mode(m);
        }

    }


    public void buttonClicked(int buttonCode) {
        super.buttonClicked(buttonCode);
        MClass newNode = UmlFactory.getFactory().getCore().createClass();
        FigClass fc = (FigClass) _content;
        MClass cls = (MClass) fc.getOwner();

        Editor ce = Globals.curEditor();
        GraphModel gm = ce.getGraphModel();
        if (!(gm instanceof MutableGraphModel)) return;
        MutableGraphModel mgm = (MutableGraphModel) gm;

        if (!mgm.canAddNode(newNode)) return;
        GraphNodeRenderer renderer = ce.getGraphNodeRenderer();
        LayerPerspective lay = (LayerPerspective)
            ce.getLayerManager().getActiveLayer();
        Fig newFC = renderer.getFigNodeFor(gm, lay, newNode);

        Rectangle outputRect = new Rectangle(Math.max(0, fc.getX() - 200),
                                             Math.max(0, fc.getY() - 200),
                                             fc.getWidth() + 400,
                                             fc.getHeight() + 400);
        if (buttonCode == 10) {
            newFC.setLocation(fc.getX(), Math.max(0, fc.getY() - 200));
            outputRect.height = 200;
            lay.bumpOffOtherNodesIn(newFC, outputRect, false, false);
        }
        else if (buttonCode == 11) {
            newFC.setLocation(fc.getX(), fc.getY() + fc.getHeight() + 100);
            outputRect.y = fc.getY() + fc.getHeight() + 100;
            outputRect.height = 200;
            lay.bumpOffOtherNodesIn(newFC, outputRect, false, false);
        }
        else if (buttonCode == 12) {
            newFC.setLocation(fc.getX() + fc.getWidth() + 100, fc.getY());
            outputRect.x = fc.getX()+ fc.getWidth() + 100 ;
            outputRect.width = 200;
            lay.bumpOffOtherNodesIn(newFC, outputRect, false, true);
        }
        else if (buttonCode == 13) {
            newFC.setLocation(Math.max(0, fc.getX() - 200), fc.getY());
            outputRect.x = fc.getX() - 200;
            outputRect.width = 200;
            lay.bumpOffOtherNodesIn(newFC, outputRect, false, true);
        }
        
        // add the new node only if required, e.g. not when we add a 
        // self association
        if (buttonCode != 14) {
            ce.add(newFC);
            mgm.addNode(newNode);
        }
        FigPoly edgeShape = new FigPoly();
        if (buttonCode!=14) {
            Point fcCenter = fc.center();
            edgeShape.addPoint(fcCenter.x, fcCenter.y);
            Point newFCCenter = newFC.center();
            edgeShape.addPoint(newFCCenter.x, newFCCenter.y);
        }
        else {
            Point fcCenter = fc.center();
            Point centerRight = 
                new Point((int)(fcCenter.x + fc.getSize().getWidth()/2), 
                          fcCenter.y);

            int yoffset = (int)((fc.getSize().getHeight()/2));
            edgeShape.addPoint(fcCenter.x, fcCenter.y);
            edgeShape.addPoint(centerRight.x, centerRight.y);
            edgeShape.addPoint(centerRight.x + 30,
                               centerRight.y);
            edgeShape.addPoint(centerRight.x + 30,
                               centerRight.y + yoffset);
            edgeShape.addPoint(centerRight.x,
                               centerRight.y + yoffset);
        }
        Object newEdge = null;
        if (buttonCode == 10) newEdge = addSuperClass(mgm, cls, newNode);
        else if (buttonCode == 11) newEdge = addSubClass(mgm, cls, newNode);
        else if (buttonCode == 12) newEdge = addAssocClassRight(mgm, cls, newNode);
        else if (buttonCode == 13) newEdge = addAssocClassLeft(mgm, cls, newNode);
        else if (buttonCode == 14) newEdge = addAssocClassRight(mgm, cls, cls);

        FigEdge fe = (FigEdge) lay.presentationFor(newEdge);
        edgeShape.setLineColor(Color.black);
        edgeShape.setFilled(false);
        edgeShape._isComplete = true;
        fe.setFig(edgeShape);
        ce.getSelectionManager().select(fc);
    }

    public Object addSuperClass(MutableGraphModel mgm, MClass cls,
                                MClass newCls) {
        return mgm.connect(cls, newCls, MGeneralization.class);
    }

    public Object addSubClass(MutableGraphModel mgm, MClass cls,
                              MClass newCls) {
        return mgm.connect(newCls, cls, MGeneralization.class);
    }

    public Object addAssocClassRight(MutableGraphModel mgm, MClass cls,
                                     MClass newCls) {
        return mgm.connect(cls, newCls, MAssociation.class);
    }

    public Object addAssocClassLeft(MutableGraphModel mgm, MClass cls,
                                    MClass newCls) {
        return mgm.connect(newCls, cls, MAssociation.class);
    }

    ////////////////////////////////////////////////////////////////
    // event handlers


    public void mouseEntered(MouseEvent me) {
        super.mouseEntered(me);
        _useComposite = me.isShiftDown();
    }

} /* end class SelectionClass */
