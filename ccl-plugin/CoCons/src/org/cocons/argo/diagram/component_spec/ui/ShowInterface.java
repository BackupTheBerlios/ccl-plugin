/*
 * MShowInterface.java
 * Created on January 10, 2002, 7:15 PM
 * @version 1.0
 */
package org.cocons.argo.diagram.component_spec.ui;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import org.tigris.gef.base.*;
import org.tigris.gef.graph.*;
import org.argouml.ui.*;
import org.argouml.kernel.*;
import org.cocons.argo.diagram.interface_spec.*;
import org.cocons.argo.diagram.interface_spec.ui.*;
import org.argouml.ui.ProjectBrowser;
import org.cocons.argo.diagram.interface_spec.ui.CCLInterface_SpecDiagram;

public class ShowInterface{
    
    public static javax.swing.JMenu getJMenu() {
	javax.swing.JMenu menu = new javax.swing.JMenu("show interface");
	org.argouml.kernel.Project p = ProjectBrowser.TheInstance.getProject();
	for (java.util.Iterator it = p.getDiagrams().iterator(); it.hasNext();) {
	    Object d = it.next();
	    if (d instanceof CCLInterface_SpecDiagram)
		menu.add(new org.cocons.argo.diagram.component_spec.ui.ShowInterface.ShowInterfaceAction((CCLInterface_SpecDiagram)d));
	}
	
	return menu;
    }
    
    private static class ShowInterfaceAction extends org.argouml.ui.CmdCreateNode {
	private CCLInterface_SpecDiagram diagram;
	private MClass orig;
	
	public ShowInterfaceAction(CCLInterface_SpecDiagram d) {
	    super(MClassImpl.class, d.getName());
	    diagram = d;
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    Object target = pb.getDetailsTarget();
	    if (target instanceof MClass) {
		orig = (MClass)target;
	    } 
	}
	
        public void doIt() {
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    pb.setTarget(diagram);
	    super.doIt();
	}
	
	public Object makeNode() {
	    Object newNode = super.makeNode();
	    MClass InterfaceSpec =(MClass)newNode;
            System.err.println("makeNode() called");
	    InterfaceSpec.setName(orig.getName());
	    MStereotype stereotype = new MStereotypeImpl();
	    stereotype.setName("interface spec");
	    InterfaceSpec.setStereotype(stereotype);
	    for (java.util.Iterator it = orig.getFeatures().iterator(); it.hasNext(); ) {
		Object f = it.next();
		if (f instanceof MAttribute) {
		    MAttribute origAttr = (MAttribute)f;
		    MAttribute attr = InterfaceSpec.getFactory().createAttribute();
		    attr.setName(origAttr.getName());
		    attr.setType(origAttr.getType());
		    attr.setVisibility(origAttr.getVisibility());
		    InterfaceSpec.addFeature(attr);
		}
	    }
            return newNode;
        }
        
    }
}

