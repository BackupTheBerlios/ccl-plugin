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

import org.cocons.argo.util.ModelReplicator;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;

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



	////////////////
	// persistence-related stuff

	/** Searches for MContextbasedConstraints which were loaded as
	 *  MConstraint instances and converts them */
	public void postLoad()
	{
		convertLoadedConstraints();
		super.postLoad();
	}

	/** Ensures all MContextbasedConstraints have their XML-Body
	 *  in sync */
	public void preSave()
	{
		syncCoConBodies();
		super.preSave();
	}



	protected void convertLoadedConstraints()
	{
		//System.out.println("CCLConstraintDiagram.postLoad() -- 1");
 		//org.cocons.uml.xmi.PostLoadProjectUpdate.SINGLETON.dumpDiagrams();

		Iterator it = collectBadFigs().iterator();
		while( it.hasNext() )
			{
				Fig f = (Fig)it.next();
				fixBadConstraint( (MConstraint)f.getOwner(), f );
			}
	}

	protected Collection collectBadFigs()
	{
		Collection figs  = new Vector();
		Enumeration elems = elements();

		while( elems.hasMoreElements() )
		 	{
				Object f = elems.nextElement();
				if( f instanceof Fig )
					{
						Object mel = ((Fig)f).getOwner();
						if( mel != null )
							if( mel instanceof MConstraint )
								if( MContextbasedConstraintImpl.BODY_LANGUAGE.
									 equals(((MConstraint)mel).getBody().getLanguage()) )
									figs.add(f);
					}
			}
		return figs;
	}

	protected void fixBadConstraint( MConstraint cons,
													Fig fig )
	{
		MContextbasedConstraint newCoCon = 
			new MContextbasedConstraintImpl();

		ModelReplicator.SINGLETON.
			replicateMConstraintToMContextbasedConstraint( cons, newCoCon );

		fig.setOwner( newCoCon );
	}

	protected void syncCoConBodies()
	{
		//System.out.println("CCLConstraintDiagram.preSave()");
 		//org.cocons.uml.xmi.PostLoadProjectUpdate.SINGLETON.dumpDiagrams();
		Enumeration elems = elements();
		while( elems.hasMoreElements() )
		 	{
				Object f = elems.nextElement();
				if( f instanceof Fig )
					{
						Object mel = ((Fig)f).getOwner();
						if( mel != null )
							{
								if( mel instanceof MContextbasedConstraint )
									((MContextbasedConstraint)mel).syncBody();
							};
					}
			}
	}

	

} /* end class UMLUseCaseDiagram */

