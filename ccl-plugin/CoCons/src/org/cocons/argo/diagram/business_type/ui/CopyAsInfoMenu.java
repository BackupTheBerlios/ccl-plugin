package org.cocons.argo.diagram.business_type.ui;

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
import org.cocons.argo.diagram.interface_spec.*;
import org.cocons.argo.diagram.interface_spec.ui.*;

public class CopyAsInfoMenu {

    public static JMenu getJMenu() {
	JMenu menu = new JMenu("copy as Infotype");
	Project p = ProjectBrowser.TheInstance.getProject();
	for (Iterator it = p.getDiagrams().iterator(); it.hasNext();) {
	    Object d = it.next();
	    if (d instanceof CCLInterface_SpecDiagram)
		menu.add(new CopyAsInfoAction((CCLInterface_SpecDiagram)d));
	}

	return menu;
    }

    private static class CopyAsInfoAction extends CmdCreateNode {
	private CCLInterface_SpecDiagram diagram;
	private MClass orig;

	public CopyAsInfoAction(CCLInterface_SpecDiagram d) {
	    super(MClassImpl.class, d.getName());
	    diagram = d;
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    Object target = pb.getDetailsTarget();
	    if (target instanceof MClass) {
		orig = (MClass)target;
	    } else {
		System.err.println("!!!!!!! target ist kein MClass,sondern "+target.getClass());
	    }
	}

	public void doIt() {
	    ProjectBrowser pb = ProjectBrowser.TheInstance;
	    pb.setTarget(diagram);
	    super.doIt();
	}

	public Object makeNode() {
	    Object newNode = super.makeNode();
	    MClass infoType =(MClass)newNode;
System.err.println("makeNode() called");
	    infoType.setName(orig.getName());
	    MStereotype stereotype = new MStereotypeImpl();
	    stereotype.setName("info type");
	    infoType.setStereotype(stereotype);
	    for (Iterator it = orig.getFeatures().iterator(); it.hasNext(); ) {
		Object f = it.next();
		if (f instanceof MAttribute) {
		    MAttribute origAttr = (MAttribute)f;
		    MAttribute attr = infoType.getFactory().createAttribute();
		    attr.setName(origAttr.getName());
		    attr.setType(origAttr.getType());
		    attr.setVisibility(origAttr.getVisibility());
		    infoType.addFeature(attr);
		}
	    }

	    MTaggedValue tv = new MTaggedValueImpl();
	    tv.setModelElement(infoType);
	    tv.setTag("belongs to");
	    tv.setValue(orig.getName());

//	    Interface_SpecDiagramGraphModel model =(//		(Interface_SpecDiagramGraphModel)diagram.getGraphModel();
//		model.addNode(infoType);

	    return newNode;
	}

    }
}