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
import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.diagram.ui.ActionAddExistingNode;
import org.argouml.uml.ui.*;

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

              //ActionAddExistingNode addNode = new ActionAddExistingNode("",mi);
              //addNode.actionPerformed(null);
              Action actionObject = new CmdCreateNode(MObjectImpl.class, "Object");
              actionObject.actionPerformed(null);
              Object o = ProjectBrowser.TheInstance.getDetailsTarget();
              if(!(o instanceof MObject)){System.out.println("--- CreateAtomicPathMenu.CreateAtomicPathAction.actionPerformed(): Object not found " + o );return;}
              MObject mo = (MObject) o;
              mo.setName("System");
              Action actionObject2 = new CmdCreateNode(MObjectImpl.class, "Object");
              actionObject2.actionPerformed(null);

            }
          }
          catch (PropertyVetoException pve) { }
          markNeedsSave();
          Actions.updateAllEnabled();
          super.actionPerformed(ae);
        }
    }
}