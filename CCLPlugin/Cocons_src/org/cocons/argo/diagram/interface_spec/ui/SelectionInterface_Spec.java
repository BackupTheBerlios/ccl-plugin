

package org.cocons.argo.diagram.interface_spec.ui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Icon;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.data_types.*;

import org.tigris.gef.base.*;
import org.tigris.gef.presentation.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.util.*;

import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.deployment.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.cocons.uml.ccl.*;

public class SelectionInterface_Spec extends SelectionWButtons {
  ////////////////////////////////////////////////////////////////
  // constants
  public static Icon assoc = ResourceLoader.lookupIconResource("Association");
  public static Icon compos = ResourceLoader.lookupIconResource("CompositeAggregation");

  ////////////////////////////////////////////////////////////////
  // instance variables
  protected boolean _useComposite = false;

  ////////////////////////////////////////////////////////////////
  // constructors

  /** Construct a new SelectionClass for the given Fig */
  public SelectionInterface_Spec(Fig f) { super(f); }

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
    int aw = assoc.getIconWidth();
    int ah = assoc.getIconHeight();
    if (hitLeft(cx + cw, cy + ch/2, aw, ah, r)) {
      h.index = 12;
      h.instructions = "Add an associated class";
    }
    else if (hitRight(cx, cy + ch/2, aw, ah, r)) {
      h.index = 13;
      h.instructions = "Add an associated class";
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
    if (_useComposite) {
      paintButtonLeft(compos, g, cx + cw, cy + ch/2, 12);
      paintButtonRight(compos, g, cx, cy + ch/2, 13);
    }
    else {
      paintButtonLeft(assoc, g, cx + cw, cy + ch/2, 12);
      paintButtonRight(assoc, g, cx, cy + ch/2, 13);
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
    Class nodeClass = MClassImpl.class;
    int bx = mX, by = mY;
    boolean reverse = false;
    switch (hand.index) {
    case 12: //add assoc
      edgeClass = ru.novosoft.uml.foundation.core.MAssociationImpl.class;
      by = cy + ch/2;
      bx = cx + cw;
      break;
    case 13: // add assoc
      edgeClass = ru.novosoft.uml.foundation.core.MAssociationImpl.class;
      reverse = true;
      by = cy + ch/2;
      bx = cx;
      break;
    default:
      System.out.println("invalid handle number");
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

//---------------------------------------------------------
// needs a lot of work
  public void buttonClicked(int buttonCode) {
    super.buttonClicked(buttonCode);
    MClass newNode = new MClassImpl();
    FigInterface_Spec fc = (FigInterface_Spec) _content;
    //FigClass fc = (FigClass) _content;
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
   if (buttonCode == 12) {
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
    ce.add(newFC);
    mgm.addNode(newNode);

    FigPoly edgeShape = new FigPoly();
    Point fcCenter = fc.center();
    edgeShape.addPoint(fcCenter.x, fcCenter.y);
    Point newFCCenter = newFC.center();
    edgeShape.addPoint(newFCCenter.x, newFCCenter.y);
    Object newEdge = null;
    if (buttonCode == 12) newEdge = addAssocClassRight(mgm, cls, newNode);
    else if (buttonCode == 13) newEdge = addAssocClassLeft(mgm, cls, newNode);
    FigEdge fe = (FigEdge) lay.presentationFor(newEdge);
    edgeShape.setLineColor(Color.black);
    edgeShape.setFilled(false);
    edgeShape._isComplete = true;
    fe.setFig(edgeShape);
    ce.getSelectionManager().select(fc);
  }



  public Object addAssocClassRight(MutableGraphModel mgm, MClass cls,
			    MClass newCls) {
    return mgm.connect(cls, newCls, MAssociationImpl.class);
  }

  public Object addAssocClassLeft(MutableGraphModel mgm, MClass cls,
			    MClass newCls) {
    return mgm.connect(newCls, cls, MAssociationImpl.class);
  }

  ////////////////////////////////////////////////////////////////
  // event handlers

  public void paintButtonAbove(Icon i, Graphics g, int x, int y, int hi) {
  }

  public void paintButtonBelow(Icon i, Graphics g, int x, int y, int hi) {
  }


  public void mouseEntered(MouseEvent me) {
    super.mouseEntered(me);
    _useComposite = me.isShiftDown();
  }

} /* end class SelectionClass */
