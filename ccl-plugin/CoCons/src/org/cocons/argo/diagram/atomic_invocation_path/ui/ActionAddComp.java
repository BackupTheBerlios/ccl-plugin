package org.cocons.argo.diagram.atomic_invocation_path.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.diagram.ui.ActionAddExistingNode;
import org.argouml.uml.ui.*;
import org.argouml.uml.diagram.sequence.ui.*;

import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;

/**
 * Überschrift:
 * Beschreibung:
 * Copyright:     Copyright (c) 2002
 * Organisation:
 * @author oetker
 * @version 1.0
 */

public class ActionAddComp extends UMLAction {

    protected ArgoDiagram _diagram;
    protected JPopupMenu _jp;
    protected Component _c;

    public ActionAddComp(Component c, ArgoDiagram d) {
	    super("Object");
        _c = c;
		_diagram = d;
	}


  public void actionPerformed(ActionEvent e) {
    _jp  = new JPopupMenu("Add Component");
	MNamespace ns = ProjectBrowser.TheInstance.getProject().getCurrentNamespace();
    Collection models = ns.getOwnedElements();
	Vector nodes = _diagram.getNodes();
	Vector comps = new Vector();
	for (Iterator it = nodes.iterator(); it.hasNext();) {
		Object o = it.next();
		if (o instanceof MObject) {
		   MObject obj = (MObject)o;
		   comps.addAll(obj.getClassifiers());
		}
	}
    for(Iterator mi = models.iterator();mi.hasNext();){
      Object o = mi.next();
      if (o instanceof MClass){
        MClass comp = (MClass)o;
        if (comp.getStereotype().getName().equals("comp spec")
            && comp.getName()!=null && !comps.contains(comp)){
		    MObject obj = new MObjectImpl();
		    comp.addInstance(obj);
			obj.setName("<<component>>");
          _jp.add(new ActionAddExistingNode(comp.getName(),obj));
        }
      }
    }
    _jp.show(_c,100,100);
  }
}