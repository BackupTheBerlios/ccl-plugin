
// File: CCLBusiness_TypeDiagram.java
// Classes: CCLBusiness_TypeDiagram
// Original Author: jgusulde@cs.tu-berlin.de
// $Id: CCLBusiness_TypeDiagram.java,v 1.2 2001/11/05 21:05:15 fchabar Exp $

package org.cocons.argo.diagram.business_type.ui;

import java.util.*;
import java.awt.*;
import java.beans.*;
import javax.swing.*;

import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.behavior.common_behavior.*;

import org.tigris.gef.base.*;
import org.tigris.gef.ui.*;

import org.argouml.ui.*;
import org.argouml.uml.ui.*;
import org.argouml.uml.diagram.ui.*;
import org.argouml.uml.diagram.static_structure.*;
import org.argouml.uml.diagram.static_structure.ui.ClassDiagramRenderer;

import org.cocons.argo.diagram.ui.CCLDiagram;

public class CCLBusiness_TypeDiagram extends CCLDiagram {

  ////////////////
  // actions for toolbar
  // needs-more-work: should these be static?



	protected static Action _actionClass =
		new CmdCreateNode(MClassImpl.class, "Class");

	protected static Action _actionObject =
		new CmdCreateNode(MInstanceImpl.class, "Instance");

	protected static Action _actionInterface =
		new CmdCreateNode(MInterfaceImpl.class, "Interface");

	protected static Action _actionDepend =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MDependencyImpl.class,
					   "Dependency");

	protected static Action _actionAssoc =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MAssociationImpl.class,
					   "Association");

	protected static Action _actionLink =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MLinkImpl.class,
					   "Link");

	protected static Action _actionGeneralize =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MGeneralizationImpl.class,
					   "Generalization");


	protected static Action _actionRealize =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MAbstractionImpl.class,
					   "Realization");

	protected static Action _actionPackage =
		new CmdCreateNode(MPackageImpl.class, "Package");


  ////////////////////////////////////////////////////////////////
  // contructors
  protected static int _ClassDiagramSerial = 1;


  public CCLBusiness_TypeDiagram() {
    try { setName("class diagram " + _ClassDiagramSerial++); }
    catch (PropertyVetoException pve) { }
  }

  public CCLBusiness_TypeDiagram(MNamespace m) {
    this();
    setNamespace(m);
  }

  public void setNamespace(MNamespace m) {
    super.setNamespace(m);
    ClassDiagramGraphModel gm = new ClassDiagramGraphModel();
    gm.setNamespace(m);
    setGraphModel(gm);
    LayerPerspective lay = new LayerPerspectiveMutable(m.getName(), gm);
    setLayer(lay);
    ClassDiagramRenderer rend = new ClassDiagramRenderer(); // singleton
    lay.setGraphNodeRenderer(rend);
    lay.setGraphEdgeRenderer(rend);
  }

  /** initialize the toolbar for this diagram type */
  protected void initToolBar() {
    _toolBar = new ToolBar();
    _toolBar.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

//     _toolBar.add(Actions.Cut);
//     _toolBar.add(Actions.Copy);
//     _toolBar.add(Actions.Paste);
//     _toolBar.addSeparator();

    _toolBar.add(_actionSelect);
    _toolBar.add(_actionBroom);
    _toolBar.addSeparator();

    _toolBar.add(_actionPackage);
    _toolBar.add(_actionClass);
    _toolBar.add(_actionAssoc);
    _toolBar.add(_actionDepend);
    _toolBar.add(_actionGeneralize);
    _toolBar.addSeparator();

//     _toolBar.add(_actionObject);
//     _toolBar.add(_actionLink);
//     _toolBar.addSeparator();

    _toolBar.add(_actionInterface);
	_toolBar.add(_actionRealize);
    _toolBar.addSeparator();

    _toolBar.add(ActionAddAttribute.SINGLETON);
    _toolBar.add(ActionAddOperation.SINGLETON);
    // needs-more-work: remove attribute and operation?
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

} /* end class UMLClassDiagram */
