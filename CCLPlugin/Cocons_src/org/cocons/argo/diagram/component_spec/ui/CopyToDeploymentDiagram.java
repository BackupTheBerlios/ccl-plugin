package org.cocons.argo.diagram.component_spec.ui;

/**
 * Title: CopyToDeploymentDiagram
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company: TU-Berlin, CIS
 * @author Sundui Baatarjav
 * @author Simo Nasri
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
import org.argouml.uml.diagram.deployment.*;
import org.argouml.uml.diagram.deployment.ui.*;
import org.cocons.argo.diagram.ui.CmdCreateNodeStereotype; // erweiterung an CmdCreateNode.

//import org.cocons.argo.diagram.component_spec.ui.*;

public class CopyToDeploymentDiagram {

    public static JMenu getJMenu() {
	JMenu menu = new JMenu("copy to DeploymentDiagram as ComponentType"); // Aenderung an String.
	Project p = ProjectBrowser.TheInstance.getProject();
	for (Iterator it = p.getDiagrams().iterator(); it.hasNext();) {
	    Object d = it.next();
	    if (d instanceof UMLDeploymentDiagram) // CCLComponent_SpecDiageramm.
		menu.add(new CopyAsCompSpecAction((UMLDeploymentDiagram)d)); ///  unter aendern.
	}

	return menu;
    }

    private static class CopyAsCompSpecAction extends org.argouml.ui.CmdCreateNode { //
	private UMLDeploymentDiagram diagram; //UMLDeploymentDiagram diagram;
	private MClass orig; //MClass

	public CopyAsCompSpecAction(UMLDeploymentDiagram d) {

         super(MComponentImpl.class, d.getName() ); // Name der DeploymentDiagram.
            diagram = d;
            ProjectBrowser pb = ProjectBrowser.TheInstance;
	    Object target = pb.getDetailsTarget(); //
	    if (target instanceof MClass) {
		orig = (MClass)target;
	    } else {

		System.err.println("----------------------------"+target.getClass());
	    }

	}
 	public void doIt() {
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    pb.setTarget(diagram);
	    super.doIt();
	}

	public Object makeNode() {
            Object newNode = super.makeNode();
            MComponent compspecType =(MComponent)newNode; // neuer Component erzeugt.
	    System.err.println("makeNode() called");
	    compspecType.setName(orig.getName());  // Name wird gesetzt.
	    MStereotype stereotype = new MStereotypeImpl(); // New Stereotyp erzeugt.
	    stereotype.setName("comp spec");  // Sterotype Name auf "comp spec" gesetzt.
	    compspecType.setStereotype(stereotype);
	    for (Iterator it = orig.getFeatures().iterator(); it.hasNext(); ) {
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

	    return newNode;
	}

    }
}
