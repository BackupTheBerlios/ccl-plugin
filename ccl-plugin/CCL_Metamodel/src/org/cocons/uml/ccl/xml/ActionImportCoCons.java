package org.cocons.uml.ccl.xml;

import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;
import java.util.Enumeration;

import java.awt.Rectangle;
import java.awt.event.*;

import java.io.File;

import javax.swing.*;

import org.argouml.uml.ui.UMLAction;

import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;
import org.cocons.uml.ccl.xml.CoConXMLReader;

import org.cocons.uml.ccl.ccldata.*;


import java.beans.PropertyVetoException;
import ru.novosoft.uml.model_management.*;
import ru.novosoft.uml.foundation.core.*;

import org.argouml.kernel.*;
import org.argouml.ui.*;
import org.argouml.uml.ui.*;
import org.cocons.argo.diagram.constraint.ui.*;

import org.tigris.gef.graph.*;


public class ActionImportCoCons 
	extends UMLAction
{
	public static int PAD_HORIZONTAL = 20;
	public static int PAD_VERTICAL   = 20;

   public static String TITLE = "Import CoCons from file...";	

	public static ActionImportCoCons SINGLETON = new ActionImportCoCons();



  ////////////////////////////////////////////////////////////////
  // constructors
  
  public ActionImportCoCons() { super(TITLE); }
  
  ////////////////////////////////////////////////////////////////
  // main method
  
  public void actionPerformed (ActionEvent ae) {
	  File file = getFileName();

	  if( file == null )
		  return;

	  CoConList cocons;

	  try {
		  cocons = CoConXMLReader.SINGLETON.readFile(file.getAbsolutePath());
	  } catch( Exception e ) {
		  JOptionPane.showMessageDialog(null,
												  "Could not import "+file.getAbsolutePath()+":\n"+
												  e,
												  TITLE,
												  JOptionPane.ERROR_MESSAGE);
		  return;
	  }

	  CCLConstraintDiagram diag = createDiagram( file );
	  Rectangle placeHint = new Rectangle( PAD_HORIZONTAL, 0,0,0 );
	  
	  Enumeration cocenum = cocons.enumerateCoCon();
	  while( cocenum.hasMoreElements() )
		  addCoConToDiagram( (CoCon)( cocenum.nextElement() ),
									diag, 
									placeHint );
  }

  ////////////////////////////////////////////////////////////////
  // utility stuff

	protected void addCoConToDiagram( CoCon cocon,
												 CCLConstraintDiagram diag,
												 Rectangle place )
	{
		GraphModel gm = diag.getGraphModel();

		MContextbasedConstraintImpl mcocon = new MContextbasedConstraintImpl();
		mcocon.initializeFromIMClass( cocon );

		FigContextbasedConstraint fig = new FigContextbasedConstraint( gm, mcocon );
		diag.getLayer().add( fig );

		//mcocon.update();
		fig.updateVisState();

		Rectangle bound = fig.getBounds();
		
		findNewPlace( bound,
						  place );
		fig.setBounds( place.x, place.y,
							place.width, place.height );
	}

	protected void findNewPlace( Rectangle old,
										  Rectangle place )
	{
		place.x = PAD_HORIZONTAL;
		place.y = place.y + place.height + PAD_VERTICAL;

		place.width  = old.width;
		place.height = old.height;
	}

	protected File getFileName()
	{
		JFileChooser jfc = new JFileChooser();

      jfc.setDialogTitle( TITLE );

		jfc.addChoosableFileFilter( CoConXMLFileFilters.ANY_XML_FILTER );
		jfc.addChoosableFileFilter( CoConXMLFileFilters.COCON_XML_FILTER );

		jfc.setFileFilter( CoConXMLFileFilters.COCON_XML_FILTER );

      if( jfc.showOpenDialog(null) == 
          JFileChooser.APPROVE_OPTION )
         return jfc.getSelectedFile();//.getAbsolutePath();
      else
         return null;
	}

	protected CCLConstraintDiagram createDiagram( File file )
	{
		Project p = ProjectBrowser.TheInstance.getProject();
		CCLConstraintDiagram d = null;

		try {
			Object target = ProjectBrowser.TheInstance.getDetailsTarget();
			MNamespace ns = p.getCurrentNamespace();
			if (target instanceof MPackage) ns = (MNamespace) target;
			d  = new CCLConstraintDiagram(ns);
			d.setName( createDiagramTitle( d.getName(), file ) );
			p.addMember(d);
			ProjectBrowser.TheInstance.getNavPane().addToHistory(d);
			ProjectBrowser.TheInstance.setTarget(d);
		}
		catch (PropertyVetoException pve) { }
		markNeedsSave();
		Actions.updateAllEnabled();
		return d;
	}
	

	protected String createDiagramTitle( String defTitle,
													 File   file )
	{
		return defTitle + ": " + file.getName();
	}



}
