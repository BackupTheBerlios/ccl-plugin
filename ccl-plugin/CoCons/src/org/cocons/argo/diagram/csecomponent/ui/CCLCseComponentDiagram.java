/*
 * CCLCseComponent.java
 * Created on 23. Januar 2002, 19:00
 */

package org.cocons.argo.diagram.csecomponent.ui;

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
import org.cocons.argo.diagram.csecomponent.*;
import org.cocons.uml.ccl.*;


public class CCLCseComponentDiagram extends CCLDiagram{

    protected static Action _actionCseComponent =
		new org.argouml.ui.CmdCreateNode(MClassImpl.class, "CseComponent");
    
    protected static Action _actionConnector =
		new org.argouml.ui.CmdCreateNode(MInterfaceImpl.class, "Connector");
    
    
    protected static Action _actionDep =
	new CmdSetMode(ModeCreatePolyEdge.class,
		       "edgeClass", MDependencyImpl.class,
		       "Dependency");
    
    
    
    static protected int _CseComponentDiagramSerial=1;
 
    public CCLCseComponentDiagram() {
	try { setName("cse component diagram " + _CseComponentDiagramSerial++); }
	catch (PropertyVetoException pve) { }
    }
    
    public CCLCseComponentDiagram(MNamespace m) {
	this();
	setNamespace(m);
    }
    
    public void setNamespace(MNamespace m) {
	super.setNamespace(m);
	CseComponentDiagramGraphModel gm = new CseComponentDiagramGraphModel();
	gm.setNamespace(m);
	setGraphModel(gm);
	LayerPerspective lay = new LayerPerspectiveMutable(m.getName(), gm);
	setLayer(lay);
	CseComponentDiagramRenderer rend = new CseComponentDiagramRenderer(); // singleton
	lay.setGraphNodeRenderer(rend);
	lay.setGraphEdgeRenderer(rend);
    }
    
    /** initialize the toolbar for this diagram type */
    protected void initToolBar() {
	_toolBar = new ToolBar();
	_toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
	
	_toolBar.add(_actionSelect);
	_toolBar.add(_actionBroom);
	_toolBar.addSeparator();
		
        _toolBar.add(_actionCseComponent);
        _toolBar.add(_actionConnector);
        _toolBar.add(_actionDep);
	_toolBar.addSeparator();
	
        _toolBar.add(ActionManageContextPropertyTags.SINGLETON);
        _toolBar.add(ActionInfoContextPropertyTags.SINGLETON);
        _toolBar.add(ActionIdentifyContextProperty.SINGLETON);
	_toolBar.add(ActionShowAllContextPropertyValues.SINGLETON);
	_toolBar.add(ActionHideAllContextPropertyValues.SINGLETON);
        _toolBar.addSeparator();
        
        _toolBar.add(ActionAddContextProperty.SINGLETON);
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
    
} //end class CCLCseComponent
 
