package org.cocons.argo.diagram.component_spec.ui;

/**
 * Title: CopyAsComponentInstance
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company: TU-Berlin, CIS
 * @author Sundui Baatarjav
 * @author Simon Nasri
 * @version 1.0
 */
import java.util.*;
import javax.swing.*;
import java.awt.event.*;

import ru.novosoft.uml.behavior.common_behavior.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.tigris.gef.util.*;

import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.argouml.cognitive.*;
import org.argouml.uml.diagram.deployment.*;
import org.argouml.uml.diagram.deployment.ui.*;
import org.cocons.argo.diagram.ui.CmdCreateNodeStereotype;


//import org.cocons.argo.diagram.component_spec.ui.*;

public class CopyAsComponentInstance {

    public static JMenu getJMenu() {
	JMenu menu = new JMenu("copy to DeploymentDiagram as ComponentInstance");
	Project p = ProjectBrowser.TheInstance.getProject();
	for (Iterator it = p.getDiagrams().iterator(); it.hasNext();) {
	    Object d = it.next();
	    if (d instanceof UMLDeploymentDiagram)
		menu.add(new CopyAction((UMLDeploymentDiagram)d));
	}

	return menu;
    }

    private static class CopyAction extends org.argouml.ui.CmdCreateNode {
	private UMLDeploymentDiagram diagram; //
        private MClass orig; // MClass

	public CopyAction(UMLDeploymentDiagram d) {

	   super(MComponentInstanceImpl.class, d.getName() );
            diagram = d;
            ProjectBrowser pb = ProjectBrowser.TheInstance;
            Object target = pb.getDetailsTarget();
	    if (target instanceof MClass) {
		orig = (MClass)target;

		System.err.println("--------------------------------"+target.getClass());
	    }
	}
 	public void doIt() {
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    pb.setTarget(diagram);
	    super.doIt();
	}

	public Object makeNode() {
            Object newNode = super.makeNode();
            MComponentInstance compspecType =(MComponentInstance)newNode; // neue ComponentInstance.
	    System.err.println("makeNode() called");
	    compspecType.setName(orig.getName()); // Name ist gesetzt.
	    MStereotype stereotype = new MStereotypeImpl(); // new Stereotype.
	    stereotype.setName("comp spec");  // Sterotype Name auf "comp spec" gesetzt.
	    compspecType.setStereotype(stereotype); // Stereotyp setzen.
	    /*for (Iterator it = orig.getFeatures().iterator(); it.hasNext(); ) {
		Object f = it.next();
		if (f instanceof MAttribute) {
		    MAttribute origAttr = (MAttribute)f;
		    MAttribute attr = compspecType.getFactory().createAttribute();
		    attr.setName(origAttr.getName());
		    attr.setType(origAttr.getType());
		    attr.setVisibility(origAttr.getVisibility());
		    compspecType.addFeature(attr);
		}
	    }
*/
	    return newNode;
	}

    }
}
