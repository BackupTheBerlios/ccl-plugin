package org.cocons.argo.diagram.component_spec.ui;

/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2001
 * Company:
 * @author
 * @version 1.0
 */
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.beans.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.presentation.*;

import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.diagram.ui.ActionAddExistingNode;
import org.argouml.uml.ui.*;
import org.argouml.uml.diagram.sequence.ui.*;

import org.cocons.argo.diagram.ui.*;
import org.cocons.argo.diagram.atomic_invocation_path.ui.*;

public class CreateAtomicPathMenu {

    public static JMenu getJMenu() {
	JMenu menu = new JMenu("create Atomic Invocation Path Diagram");
	ProjectBrowser pb = ProjectBrowser.TheInstance;
        Object target = pb.getDetailsTarget();
        if(target instanceof MInterface){
          MInterface inter = (MInterface) target;
          for (Iterator it = inter.getFeatures().iterator(); it.hasNext(); ) {
            Object f = it.next();
            if (f instanceof MOperation) {
              MOperation origOper = (MOperation)f;
              menu.add(new CreateAtomicPathAction(inter,origOper));
            }
          }
        }

	return menu;
    }

    private static class CreateAtomicPathAction extends UMLAction {
	private MInterface inter;
	private MOperation oper;

	public CreateAtomicPathAction(MInterface mi,MOperation mo) {
	    super(mo.getName());
            inter = mi;
            oper = mo;
	}

        public void actionPerformed(ActionEvent ae) {
          // super.actionPerformed(ae);
          ProjectBrowser pb = ProjectBrowser.TheInstance;
          Project p = pb.getProject();
          try {
            Object target = ProjectBrowser.TheInstance.getDetailsTarget();
            if(target instanceof MClassifier){
              MClassifier mc = (MClassifier) target;
              MNamespace ns = mc.getNamespace();
              ArgoDiagram d = new CCLAtomicInvocationPathDiagram(ns);
              p.addMember(d);
              ProjectBrowser.TheInstance.getNavPane().addToHistory(d);
              ProjectBrowser.TheInstance.setTarget(d);
              d.setName("Atomic Invocation Path Diagram of Operation '" + oper.getName()
              +"' in Interface '" + inter.getName() +"'");

              GraphModel gm = d.getGraphModel();
              if (!(gm instanceof MutableGraphModel)) return;
              MutableGraphModel mgm = (MutableGraphModel) gm;

              //Model und Fig für System anlegen
              MObjectImpl mo = new MObjectImpl();
              Layer lay = d.getLayer();
              FigNode pers = new FigSeqObject(gm, mo);
              d.add(pers);
              mgm.addNode(mo);
              mo.setName("System");

              //Model und Fig für Componente anlegen
              MObjectImpl mo2 = new MObjectImpl();
              FigNode pers2 = new FigSeqObject(gm, mo2);
              d.add(pers2);
              mgm.addNode(mo2);
              mo2.setName("<<component>>"+inter.getName());

              //Assoziation anlegen
              MStimulusImpl ms = new MStimulusImpl();

              Object newEdge = mgm.connect(mo,mo2,MLinkImpl.class);
              MLink mLink = (MLink) newEdge;
              mLink.addStimulus(ms);

              Fig startPortFig = pers.getPortFig(mo);
              Fig destPortFig = pers2.getPortFig(mo2);
              FigEdge fe = (FigEdge) lay.presentationFor(newEdge);
              d.add(fe);
              fe.setSourcePortFig(startPortFig);
              fe.setSourceFigNode(pers);
              fe.setDestPortFig(destPortFig);
              fe.setDestFigNode(pers2);
              if(!(fe instanceof FigSeqLink)){return;}
              FigSeqLink figSekLink = (FigSeqLink) fe;
              figSekLink.mouseReleased(null);
              //Set Action for Stimulus
              MCallActionImpl mCallAction = new MCallActionImpl();
              mCallAction.setName(inter.getName()+"."+oper.getName()+"()");
              ms.setDispatchAction(mCallAction);

              pers.damage();
              pers2.damage();
              fe.damage();

            }
          }
          catch (PropertyVetoException pve) { }
          markNeedsSave();
          Actions.updateAllEnabled();
          super.actionPerformed(ae);
        }
    }
}