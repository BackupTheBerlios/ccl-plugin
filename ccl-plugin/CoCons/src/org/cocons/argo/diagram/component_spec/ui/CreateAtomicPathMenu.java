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

          MClassifier mc = null;
          for(Iterator it = inter.getAssociationEnds().iterator();it.hasNext();){
            MAssociationEnd mae = (MAssociationEnd) it.next();
            mc = (MClassifier)mae.getOppositeEnd().getType();
            if(Globals.curEditor().getGraphModel().getNodes().contains(mc)){
              break;
            }else{
              mc = null;
            }
          }
          if(mc==null || !(mc instanceof MClass) ||
                  !mc.getStereotype().getName().equals("comp spec")){
            return new JMenu();
          }

          for (Iterator it = inter.getFeatures().iterator(); it.hasNext(); ) {
            Object f = it.next();
            if (f instanceof MOperation) {
              MOperation origOper = (MOperation)f;
              menu.add(new CreateAtomicPathAction(inter,origOper,(MClass) mc));
            }
          }
        }

	return menu;
    }

    private static class CreateAtomicPathAction extends UMLAction {
	private MInterface inter;
	private MOperation oper;
        private MClass component;

	public CreateAtomicPathAction(MInterface mi,MOperation mo,MClass mc) {
	    super(mo.getName(),false);
            inter = mi;
            oper = mo;
            component = mc;
	}

        public void actionPerformed(ActionEvent ae) {
          // super.actionPerformed(ae);
          ProjectBrowser pb = ProjectBrowser.TheInstance;
          Project p = pb.getProject();
          try {
            Object target = pb.getDetailsTarget();
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
              MObject mo = new MObjectImpl();
              Layer lay = d.getLayer();
              FigNode pers = new FigAtomicObject(gm, mo);
              d.add(pers);
              mgm.addNode(mo);
              mo.setName("System");

              //Model und Fig für Componente anlegen
              MObject mo2 = new MObjectImpl();
              component.addInstance(mo2);
              FigNode pers2 = new FigAtomicObject(gm, mo2);
              d.add(pers2);
              mgm.addNode(mo2);
              mo2.setName("<<component>>");

              //Assoziation anlegen
              MStimulus ms = new MStimulusImpl();

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
	      mCallAction.setOperation(oper);
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
