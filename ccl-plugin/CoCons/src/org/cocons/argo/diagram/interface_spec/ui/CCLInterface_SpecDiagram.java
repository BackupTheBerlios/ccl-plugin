//Autor: shicathy

package org.cocons.argo.diagram.interface_spec.ui;

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
import org.cocons.argo.diagram.interface_spec.*;
import org.cocons.uml.ccl.*;

public class CCLInterface_SpecDiagram extends CCLDiagram {


  ////////////////
  // actions for toolbar

  protected static Action _actionInterface_Spec;
  //protected static Action _actionType;
  protected static Action _actionInfo_Type;
  protected static Action _actionAssoc;

  /*protected static Action _actionContextP =
	new CmdCreateNodeStereotype(MTaggedValueImpl.class, "ContextProperty",new MStereotypeImpl());*/


  ////////////////////////////////////////////////////////////////
  // contructors
  protected static int _ClassDiagramSerial = 1;


  public CCLInterface_SpecDiagram() {
    try { setName("Interface_Spec diagram " + _ClassDiagramSerial++); }
    catch (PropertyVetoException pve) { }

  }

  public CCLInterface_SpecDiagram(MNamespace m) {
    this();
    setNamespace(m);
  }

  public void setNamespace(MNamespace m) {
    super.setNamespace(m);
    Interface_SpecDiagramGraphModel gm = new Interface_SpecDiagramGraphModel();
    gm.setNamespace(m);
    setGraphModel(gm);
    LayerPerspective lay = new LayerPerspectiveMutable(m.getName(), gm);
    setLayer(lay);
    Interface_SpecDiagramRenderer rend = new Interface_SpecDiagramRenderer(); // singleton
    lay.setGraphNodeRenderer(rend);
    lay.setGraphEdgeRenderer(rend);
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

    _actionInterface_Spec = new ActionAddInterfaceSpec(_toolBar,getNamespace());

    //	new CmdCreateNodeStereotype(MInterfaceImpl.class, "interface spec", findStereotype("interface spec") );

/*    _actionType = new CmdCreateNodeStereotype(MClassImpl.class,
        "type", findStereotype("type") );
*/
    _actionInfo_Type = new CmdCreateNodeStereotype(MClassImpl.class,
        "info type",findStereotype("info type"));

    _toolBar.add(_actionInterface_Spec);
//    _toolBar.add(_actionType);
    _toolBar.add(_actionInfo_Type);
    //_toolBar.add(_actionContextP);
    _toolBar.addSeparator();

    /*
    _actionAssoc = new CmdSetMode(ModeCreateEdgeStereotype.class,
					   "edgeClass", MAssociationImpl.class,
        			   "Association");
                       */

	_actionAssoc =
		new CmdSetMode(ModeCreatePolyEdge.class,
					   "edgeClass", MAssociationImpl.class,
					   "Association");


    _toolBar.add(_actionAssoc);
    //????????????? compare _toolBar.add(_actionContextP);
     _toolBar.add(new ActionAddContextProperty());
    _toolBar.addSeparator();


    _toolBar.add(ActionAddAttribute.SINGLETON);
    //_toolBar.add(ActionAddOperation.SINGLETON);
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

}
