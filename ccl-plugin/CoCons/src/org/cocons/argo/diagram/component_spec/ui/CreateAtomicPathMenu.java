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
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.cocons.argo.diagram.ui.*;
import org.cocons.argo.diagram.atomic_invocation_path.ui.*;
import org.argouml.uml.ui.*;
import java.beans.*;

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
            if(target instanceof MInterface){
              MInterface mi = (MInterface) target;
              MNamespace ns = mi.getNamespace();
              System.out.println("-----------" + target +"------"+ ns);
              ArgoDiagram d = new CCLAtomicInvocationPathDiagram(ns);
              p.addMember(d);
              ProjectBrowser.TheInstance.getNavPane().addToHistory(d);
              ProjectBrowser.TheInstance.setTarget(d);
              d.setName("Atomic Invocation Path Diagram of Operation '" + oper.getName()
              +"' in Interface '" + inter.getName() +"'");
              //Action actionObject = new CmdCreateNode(MObjectImpl.class, "Object");
              //actionObject.actionPerformed(new ActionEvent());
            }
          }
          catch (PropertyVetoException pve) { }
          markNeedsSave();
          Actions.updateAllEnabled();
          super.actionPerformed(ae);
        }
    }
}