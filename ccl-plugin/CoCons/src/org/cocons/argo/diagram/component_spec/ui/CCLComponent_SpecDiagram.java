/*
 * CCLComponent_SpecDiagram.java
 * @version 1.0
 */

package org.cocons.argo.diagram.component_spec.ui;

import java.util.*;
import java.awt.*;
import java.beans.*;
import javax.swing.*;

import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;
import org.tigris.gef.ui.*;

import org.argouml.ui.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.*;
import org.argouml.uml.diagram.static_structure.ui.*;

import org.cocons.argo.diagram.ui.*;
import org.cocons.argo.diagram.component_spec.*;
import org.cocons.uml.ccl.*;

public class CCLComponent_SpecDiagram extends CCLDiagram {

    ////////////////
    // actions for toolbar

    protected static Action _actionClassSpec;
    protected static Action _actionInterfaceDep;
    
    protected static Action _actionImport =
	new CmdSetMode(ModeCreatePolyEdge.class,
		       "edgeClass", MDependencyImpl.class,
		       "Import");
    protected static Action _actionExport =

	new CmdSetMode(ModeCreatePolyEdge.class,
		       "edgeClass", MAssociationImpl.class,
		       "Export");

    ////////////////////////////////////////////////////////////////
    // contructors

    protected static int _Component_SpecDiagramSerial = 1;
    public CCLComponent_SpecDiagram() {
	try { setName("component specification diagram " + _Component_SpecDiagramSerial++); }
	catch (PropertyVetoException pve) { }
    }

    public CCLComponent_SpecDiagram(MNamespace m) {
	this();
	setNamespace(m);
    }

    public void setNamespace(MNamespace m) {
	super.setNamespace(m);
	Component_SpecDiagramGraphModel gm = new Component_SpecDiagramGraphModel();
	gm.setNamespace(m);
	setGraphModel(gm);
	LayerPerspective lay = new LayerPerspectiveMutable(m.getName(), gm);
	setLayer(lay);
	Component_SpecDiagramRenderer rend = new Component_SpecDiagramRenderer(); // singleton
	lay.setGraphNodeRenderer(rend);
	lay.setGraphEdgeRenderer(rend);
    }



    protected MStereotype findStereotype(String name) {
	MStereotype st = new MStereotypeImpl();
	st.setNamespace(getNamespace());
	st.setName(name);
	return st;
    }

    /** initialize the toolbar for this diagram type */
    protected void initToolBar() {
	_toolBar = new ToolBar();
	_toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	_toolBar.add(_actionSelect);
	_toolBar.add(_actionBroom);
	_toolBar.addSeparator();

	_actionClassSpec = new CmdCreateNodeStereotype(MClassImpl.class,"CompSpec",

						       findStereotype("comp spec") );

        _actionInterfaceDep = new ActionAddInterfaceSpec(_toolBar,getNamespace());

        //new CmdCreateNodeStereotype(MInterfaceImpl.class,"InterfaceSpec",
        //                                     findStereotype("interface spec"));

	_toolBar.add(_actionClassSpec);
	_toolBar.add(_actionInterfaceDep);
	_toolBar.add(_actionImport);
	_toolBar.add(_actionExport);
        _toolBar.addSeparator();
        
        _toolBar.add(ActionManageContextPropertyTags.SINGLETON);
        _toolBar.add(ActionInfoContextPropertyTags.SINGLETON);
        _toolBar.add(ActionIdentifyContextProperty.SINGLETON);
	_toolBar.add(ActionShowAllContextPropertyValues.SINGLETON);
	_toolBar.add(ActionHideAllContextPropertyValues.SINGLETON);
        _toolBar.addSeparator();
        
        _toolBar.add(ActionAddContextProperty.SINGLETON);
        _toolBar.addSeparator();
        
        _toolBar.add(ActionAddNote.SINGLETON);
        _toolBar.addSeparator();
        
        _toolBar.add(_actionRectangle);
	_toolBar.add(_actionRRectangle);
	_toolBar.add(_actionCircle);
	_toolBar.add(_actionLine);
	_toolBar.add(_actionText);
	_toolBar.add(_actionPoly);
	_toolBar.add(_actionSpline);
	_toolBar.add(_actionInk);
	_toolBar.addSeparator();

	_toolBar.add(_diagramName);
    }

} /* end class CCLComponent_SpecDiagram */
