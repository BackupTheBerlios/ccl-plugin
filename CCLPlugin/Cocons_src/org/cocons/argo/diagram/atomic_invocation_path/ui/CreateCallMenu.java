package org.cocons.argo.diagram.atomic_invocation_path.ui;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;

import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.presentation.*;

import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.diagram.sequence.ui.*;

import org.cocons.argo.diagram.atomic_invocation_path.AtomicInvocationPathDiagramGraphModel;

/**
 * Überschrift:
 * Beschreibung:
 * Copyright:     Copyright (c) 2002
 * Organisation:
 * @author oetker
 * @version 1.0
 */

public class CreateCallMenu {

    public static JMenu getJMenu() {
	JMenu menu = new JMenu("add Invocation");
	AtomicInvocationPathDiagramGraphModel gm =
	    (AtomicInvocationPathDiagramGraphModel) Globals.curEditor().getGraphModel();
	MNamespace ns = gm.getNamespace();
	Collection models = ns.getOwnedElements();
	for (Iterator it = models.iterator(); it.hasNext();) {
	    Object o = it.next();
	    if (o instanceof MInterface) {
		MInterface mi = (MInterface)o;
		if (mi.getStereotype().getName().equals("interface spec")) {
		    JMenu subMenu = new JMenu(mi.getName());
		    menu.add(subMenu);
		    for (Iterator ops = mi.getFeatures().iterator(); ops.hasNext(); ) {
			Object tmp = ops.next();
			if (tmp instanceof MOperation) {
			    MOperation oper = (MOperation) tmp;
			    subMenu.add(new CreateCallAction(oper, mi));
			}
		    }
		}
	    }
	}
	return menu;
    }

    private static class CreateCallAction extends UMLAction {
	private MObject src;
	private MObject dst;
	private MOperation oper;
	private MInterface inter;
	private MClassifier comp;

	public CreateCallAction(MOperation o, MInterface mi) {
	    super(o.getName());
	    oper = o;
	    inter = mi;
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    Object target = pb.getDetailsTarget();
	    src = (MObject)target;
	}

	public void actionPerformed(ActionEvent ae) {
	    Editor ce = Globals.curEditor();
	    GraphModel gm = ce.getGraphModel();
	    if (!(gm instanceof MutableGraphModel)) return;
	    MutableGraphModel mgm = (MutableGraphModel) gm;
            comp = null;
            for(Iterator it = inter.getAssociationEnds().iterator();it.hasNext();){
                MAssociationEnd mae = (MAssociationEnd) it.next();
                comp = (MClassifier)mae.getOppositeEnd().getType();
		if((comp instanceof MClass) &&
		   comp.getStereotype().getName().equals("comp spec"))
		    break;
		else
		    comp = null;
            }
	    if (comp == null) {
		System.out.println("Error: no Component found for Interface '" +
				   inter.getName() + "'");
		super.actionPerformed(ae);
		return;
	    }
	    dst = null;
	    for (Iterator it = mgm.getNodes().iterator(); it.hasNext();) {
		Object o = it.next();
		if (o instanceof MObject) {
		    MObject obj = (MObject)o;
		    if (obj.getClassifiers().contains(comp))
			dst = obj;
		}
	    }

	    Layer lay = ce.getLayerManager().getActiveLayer();
	    if (dst == null) {
				//Model und Fig für Ziel-Komponente anlegen
		dst = new MObjectImpl();
		comp.addInstance(dst);
		FigNode dstFig = new FigAtomicObject(gm, dst);
		lay.add(dstFig);
		mgm.addNode(dst);
		dst.setName("<<component>>");
	    }
	    //Assoziation anlegen
	    MStimulus ms = new MStimulusImpl();

	    FigAtomicObject srcFig = (FigAtomicObject)lay.presentationFor(src);
	    FigAtomicObject dstFig = (FigAtomicObject)lay.presentationFor(dst);
	    Object newEdge = mgm.connect(src,dst,MLinkImpl.class);
	    MLink mLink = (MLink) newEdge;
	    mLink.addStimulus(ms);

	    FigPoly edgeShape = new FigPoly();
	    Point fcCenter = srcFig.center();
	    int yPos = (int)srcFig.getPortFig(src).getBounds().getHeight();
	    yPos += (int)srcFig.getPortFig(src).getBounds().getY();
	    edgeShape.addPoint(fcCenter.x,yPos);

	    Point newFCCenter = dstFig.center();
	    edgeShape.addPoint(newFCCenter.x, yPos);

	    FigSeqLink fe = (FigSeqLink) lay.presentationFor(newEdge);

	    edgeShape.setLineColor(Color.black);
	    edgeShape.setFilled(false);
	    edgeShape._isComplete = true;
	    fe.setFig(edgeShape);

		fe.setSourcePortFig( srcFig.getPortFig(src) );
		fe.setDestPortFig( dstFig.getPortFig(dst));

	    fe.addFigSeqStimulusWithAction();


	    lay.add(fe);
	    //Set Action for Stimulus
	    MCallActionImpl mCallAction = new MCallActionImpl();
	    mCallAction.setName(inter.getName()+"."+oper.getName()+"()");
	    mCallAction.setOperation(oper);
	    ms.setDispatchAction(mCallAction);
		//src.getNamespace().addOwnedElement(oper);

	    srcFig.damage();
	    dstFig.damage();
	    fe.damage();
	    markNeedsSave();
	    Actions.updateAllEnabled();
	    super.actionPerformed(ae);
	}
    }
}
