
// $Id: CCLBusiness_TypeDiagram.java,v 1.12 2002/01/31 19:00:05 hasihola Exp $

package org.cocons.argo.diagram.business_type.ui;

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
import org.cocons.argo.diagram.business_type.*;
import org.cocons.uml.ccl.*;

public class CCLBusiness_TypeDiagram extends CCLDiagram {


  ////////////////
  // actions for toolbar

	protected static Action _actionBusiness_Type;
//    		new CmdCreateNodeStereotype(MClassImpl.class, "Business Type", new MStereotypeImpl());
//new CmdCreateNodeStereotype(MClassImpl.class,
//          "business type", findStereotype("type") );

	protected static Action _actionPackage =
		new CmdCreateNodeStereotype(MPackageImpl.class, "Package",new MStereotypeImpl());

        // ----- hyshosha@gmx.de -----
	// protected static Action _actionContextP =
	// 	new CmdCreateNodeStereotype(MTaggedValueImpl.class, "ContextProperty",new MStereotypeImpl());
        // ---------------------------

	protected static Action _actionDepend =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MDependencyImpl.class,
					   "Dependency");

	protected static Action _actionAssoc =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MAssociationImpl.class,
					   "Association");

	protected static Action _actionGeneralize =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MGeneralizationImpl.class,
					   "Generalization");


  ////////////////////////////////////////////////////////////////
  // contructors
  protected static int _ClassDiagramSerial = 1;


  public CCLBusiness_TypeDiagram() {
    _actionBusiness_Type =
      new CmdCreateNodeStereotype(MClassImpl.class,
               "BusinessType", findStereotype("type") );
    try { setName("Business_Type diagram " + _ClassDiagramSerial++); }
    catch (PropertyVetoException pve) { }

  }

  public CCLBusiness_TypeDiagram(MNamespace m) {
    this();
    setNamespace(m);
  }

  protected MStereotype findStereotype(String name) {

    // just create a new one
    // needs-more-work
    // should check to see if the stereotype already exists

    MStereotype st = new MStereotypeImpl();
    st.setNamespace(getNamespace());
    st.setName(name);
    return st;
  }

  public void setNamespace(MNamespace m) {
    super.setNamespace(m);
    Business_TypeDiagramGraphModel gm = new Business_TypeDiagramGraphModel();
    gm.setNamespace(m);
    setGraphModel(gm);
    LayerPerspective lay = new LayerPerspectiveMutable(m.getName(), gm);
    setLayer(lay);
    Business_TypeDiagramRenderer rend = new Business_TypeDiagramRenderer(); // singleton
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
    _toolBar.add(_actionBusiness_Type);
    // ----- hyshosha@gmx.de -----
    // _toolBar.add(_actionContextP);
    // ---------------------------
    _toolBar.addSeparator();

    _toolBar.add(_actionAssoc);
    _toolBar.add(_actionDepend);
    _toolBar.add(_actionGeneralize);
    _toolBar.addSeparator();


    _toolBar.add(ActionAddAttribute.SINGLETON);

    _toolBar.addSeparator();
    _toolBar.add(ActionManageContextPropertyTags.SINGLETON);
    _toolBar.add(ActionInfoContextPropertyTags.SINGLETON);
    _toolBar.add(ActionIdentifyContextProperty.SINGLETON);
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

}
