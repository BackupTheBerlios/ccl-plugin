
package org.cocons.argo.diagram.ui;

import java.beans.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;

import org.argouml.kernel.*;
import org.argouml.ui.*;
import org.argouml.uml.ui.*;
import org.cocons.argo.diagram.business_type.ui.*;


public class ActionCCLBusiness_TypeDiagram extends UMLAction {
  public ActionCCLBusiness_TypeDiagram() {
    super("CCLBusiness_TypeDiagramm");
  }

  public void actionPerformed(ActionEvent ae) {
    Project p = ProjectBrowser.TheInstance.getProject();
    try {
      Object target = ProjectBrowser.TheInstance.getDetailsTarget();
      MNamespace ns = p.getCurrentNamespace();
      if (target instanceof MPackage) ns = (MNamespace) target;
      ArgoDiagram d  = new CCLBusiness_TypeDiagram(ns);
      p.addMember(d);
      ProjectBrowser.TheInstance.getNavPane().addToHistory(d);
      ProjectBrowser.TheInstance.setTarget(d);
    }
    catch (PropertyVetoException pve) { }
    markNeedsSave();
    Actions.updateAllEnabled();
    super.actionPerformed(ae);
  }
} 
