/*
 * ActionAddContextProperty.java
 *
 * Created on 11. November 2001, 16:31
 */
/**
 * * @author  shicathy
 * @version 0.1
 */

package org.cocons.argo.diagram.ui;

import org.argouml.uml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.*;
import org.argouml.ui.*;
import ru.novosoft.uml.foundation.core.*;
import java.awt.event.*;
import org.cocons.uml.ccl.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

// -------------- additional imports ----------------
import java.awt.*;
import java.util.*;
import org.argouml.uml.diagram.static_structure.ui.*;
import org.argouml.uml.diagram.ui.*;
import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.presentation.*;

import org.cocons.argo.diagram.ui.FigContextProperty;
// --------------------------------------------------

public class ActionAddContextProperty extends UMLAction {
// --- im Wesentlichen ist das eine Adaption von ActionAddNote ---

    ////////////////////////////////////////////////////////////////
    // static variables

    public static ActionAddContextProperty SINGLETON = new ActionAddContextProperty();

     ////////////////////////////////////////////////////////////////
    // constructors

    public ActionAddContextProperty() { super("ContextProperty"); }

    ////////////////////////////////////////////////////////////////
    // main methods

    public void actionPerformed(ActionEvent ae) {
/*

        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Project p = pb.getProject();
        Object target = pb.getDetailsTarget();

        // #############################################
        //if (!(target instanceof MTaggedValue)) return;
        //MTaggedValue mcp = (MTaggedValue) target;
        // #############################################

        MModelElement objectWithContextProperty = null;

        if (!(target instanceof MClassifier)) return;
        if (target instanceof MClassifier)
          objectWithContextProperty = (MClassifier)target;

	Editor ce = Globals.curEditor();
	GraphModel gm = ce.getGraphModel();
	GraphNodeRenderer renderer = ce.getGraphNodeRenderer();
	Layer lay = ce.getLayerManager().getActiveLayer();

        MTaggedValueImpl contextPropertyOwner = new MTaggedValueImpl();
        contextPropertyOwner.setNamespace(p.getModel());
        contextPropertyOwner.setName("unassigned");
        contextPropertyOwner.setValue("no values");
        FigContextProperty contextProperty = new FigContextProperty(gm,contextPropertyOwner);
        //FigContextProperty contextProperty = new FigContextProperty();

	// place the note a few pixels right of the selected figure
	Fig f = null;  // The figure for the associated object.
	Rectangle targetBounds=null;  // The bounds of this figure.
        Vector figs = ce.getSelectionManager().getFigs();  // Get all the figures of the current diagram.
        int size = figs.size();
        for (int i = 0; i < size; i++) {  // Now search the figure for the active element
	    f = (Fig)figs.elementAt(i);
	    Object owner = f.getOwner();  // Get the owner of the current figure.
	    if((owner instanceof MModelElement) && (owner == target)) {  // If this is the figure,
		targetBounds = f.getBounds();   // get the bounds of it.
		// Place the contextProperty right of the figure,
                contextProperty.setLocation(targetBounds.x + targetBounds.width + 80, targetBounds.y);
		// And finish the search.
		break;
	    }
        }
        lay.add(contextProperty);

	// Add a link from note to associated figure
	//

        Rectangle contextPropertyBounds = contextProperty.getBounds();

	// Simulate a mouseclick in the middle of the figure to get a port to connect
	// the link to.
        Object startPort = contextProperty.deepHitPort( contextPropertyBounds.x + contextPropertyBounds.width/2, contextPropertyBounds.y + contextPropertyBounds.height/2);
	Fig startPortFigure = contextProperty.getPortFig(startPort);

	MutableGraphModel mgm = (MutableGraphModel)gm;

	if (f instanceof FigNode) {
	    FigNode destFigNode = (FigNode)f;

	    // Place the port in the middle of the figure.
	    Object foundPort = destFigNode.deepHitPort(targetBounds.x + targetBounds.width/2, targetBounds.y + targetBounds.height/2);

	    if (foundPort != null) {
		Fig destPortFig = destFigNode.getPortFig(foundPort);
		FigEdgeNote fe = new FigEdgeNote();
                // -------------------------------------------------
                ArrowHeadQualifier arrow = new ArrowHeadQualifier();
                arrow.setLineColor(Color.blue);
                arrow.setFillColor(Color.yellow);
                //fe.setSourceArrowHead(arrow);
                fe.setDestArrowHead(arrow);
                fe.setLineColor(Color.blue);
                // -------------------------------------------------
		fe.setSourcePortFig( startPortFigure);

                fe.setSourceFigNode( contextProperty);
		fe.setDestPortFig( destPortFig);
		fe.setDestFigNode( (FigNode)f);
		// Compute the route for this edge. That methods basically adds a snap point at
		// the edge of the figures, so you can mode the edge at the edge of the figures.
		fe.computeRoute();
                // Add the edge to the current layer.
		lay.add(fe);
		lay.sendToBack(fe);
		// set the new edge in place
                contextProperty.addFigEdge(fe);
		destFigNode.addFigEdge(fe);
                contextProperty.updateEdges();
		destFigNode.updateEdges();
		ce.damaged(fe);
                contextProperty.damage();
		f.damage();
	    }
	}

        // #############################################
        super.actionPerformed(ae);
*/
    }

    public boolean shouldBeEnabled() {
        ProjectBrowser pb = ProjectBrowser.TheInstance;
        Object target = pb.getDetailsTarget();
        return super.shouldBeEnabled() && target instanceof MClass;
    }
} /* end class ActionAddContextProperty */
