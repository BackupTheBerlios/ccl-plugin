// File: CCLTestDiagram.java

// Classes: CCLTestDiagram

// Original Author: mskinner@cs.tu-berlin.de



package org.cocons.argo.diagram.constraint.ui;



import java.util.*;

import java.awt.*;

import java.beans.*;

import javax.swing.*;



import ru.novosoft.uml.model_management.*;

import ru.novosoft.uml.foundation.core.*;

import ru.novosoft.uml.foundation.extension_mechanisms.*;

import ru.novosoft.uml.behavior.use_cases.*;



import org.cocons.uml.ccl.*;

import org.tigris.gef.base.*;

import org.tigris.gef.ui.*;



import org.argouml.ui.*;

import org.argouml.uml.diagram.ui.*;



import org.cocons.argo.diagram.constraint.*;

import org.cocons.argo.diagram.ui.*;

import org.tigris.gef.presentation.Fig;

public class CCLConstraintDiagram extends CCLDiagram {



  ////////////////

  // actions for toolbar





  protected static Action _actionContextbasedConstraint =

    new CmdCreateNode(MContextbasedConstraintImpl.class, "ContextbasedConstraint");



  protected static Action _actionTest;



  ////////////////////////////////////////////////////////////////

  // contructors

  protected static int _ConstraintDiagramSerial = 1;





  public CCLConstraintDiagram() {

    try { setName("ccl constraint diagram " + _ConstraintDiagramSerial++); }

    catch (PropertyVetoException pve) { }

  }



  public CCLConstraintDiagram(MNamespace m) {

    this();

    setNamespace(m);

  }



  public void setNamespace(MNamespace m) {

    super.setNamespace(m);

    ConstraintDiagramGraphModel gm = new ConstraintDiagramGraphModel();

    gm.setNamespace(m);

    setGraphModel(gm);

    LayerPerspective lay = new LayerPerspective(m.getName(), gm);

    setLayer(lay);

    ConstraintDiagramRenderer rend = new ConstraintDiagramRenderer();

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

    _toolBar.add(_actionSelect);

    _toolBar.add(_actionBroom);

    _toolBar.addSeparator();



    _toolBar.add(_actionContextbasedConstraint);

    _actionTest = new CmdCreateNodeStereotype(MClassImpl.class, "Class", findStereotype("test"));

    _toolBar.add(_actionTest);



    // other actions

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



	public void postLoad()
	{
		//ali-to-do: convert MConstraint to MContextbasedConstraint
		System.out.println("CCLConstraintDiagram.postLoad()");
	}

	public void postSave()
	{
		//ali-to-do: nothing
		System.out.println("CCLConstraintDiagram.postSave()");
	}

	public void syncCoConBodies()
	{
		Enumeration elems = elements();
		while( elems.hasMoreElements() )
		 	{
				Object f = elems.nextElement();
				if( f instanceof Fig )
					{
						Object mel = ((Fig)f).getOwner();
						if( mel != null )
							if( mel instanceof MContextbasedConstraint )
								((MContextbasedConstraint)mel).syncBody();
					}
			}
	}

	public void preSave()
	{
		syncCoConBodies();



		//ali-to-do: ensure all cocons write their contents *now* to the body
		System.out.println("CCLConstraintDiagram.preSave()");
		org.cocons.uml.xmi.PostLoadProjectUpdate.SINGLETON.dumpDiagrams();

		System.out.println("MY ELEMENTS:");
		java.util.Enumeration enum = elements();
		while( enum.hasMoreElements() )
		 	{
				Object o = enum.nextElement();
				System.out.println("  " + o.getClass() + ": " + o );
				if( o instanceof Fig )
					{ 
						Object o2 = ((Fig)o).getOwner();
						if( o2 == null )
							System.out.println("  Owner: null");
						else
							System.out.println("  Owner:" + o2.getClass() );
					}
				
			}
	}
	

} /* end class UMLUseCaseDiagram */

