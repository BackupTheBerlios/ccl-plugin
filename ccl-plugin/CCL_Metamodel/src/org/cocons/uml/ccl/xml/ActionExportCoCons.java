package org.cocons.uml.ccl.xml;

import java.util.Vector;
import java.util.Collection;
import java.util.Iterator;


import java.awt.event.*;

import javax.swing.*;

import org.argouml.uml.ui.UMLAction;

import org.cocons.argo.util.ModelIterator;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.xml.CoConXMLWriter;

public class ActionExportCoCons 
	extends UMLAction
{

   public static String TITLE = "Export CoCons to file...";	

	public static ActionExportCoCons SINGLETON = new ActionExportCoCons();






  ////////////////////////////////////////////////////////////////
  // constructors
  
  public ActionExportCoCons() { super(TITLE); }
  
  ////////////////////////////////////////////////////////////////
  // main methods
  
  public void actionPerformed (ActionEvent e) {
	  Collection allCoCons = getExportableCoCons();

	  if( (allCoCons==null) || (allCoCons.isEmpty()) )
		  {
			  JOptionPane.
				  showMessageDialog(null,
										  "There are no CoCons to export.",
										  TITLE,
										  JOptionPane.ERROR_MESSAGE);
			  return;
		  };

      String filename = getFileName();

      if( filename != null )
         saveCoCons( allCoCons, filename );
  }


	public Collection getExportableCoCons()
	{
		Vector result = new Vector();
		Iterator elems = ModelIterator.SINGLETON.getAllModelElements().iterator();
		
		while( elems.hasNext() )
			{
				Object o = elems.next();
				if( o instanceof MContextbasedConstraint )
					result.add( o );
			}

		return result;
	}

	public String getFileName()
	{
		JFileChooser jfc = new JFileChooser();

      jfc.setDialogTitle( TITLE );

		jfc.addChoosableFileFilter( CoConXMLFileFilters.ANY_XML_FILTER );
		jfc.addChoosableFileFilter( CoConXMLFileFilters.COCON_XML_FILTER );

		jfc.setFileFilter( CoConXMLFileFilters.COCON_XML_FILTER );

      if( jfc.showSaveDialog(null) == 
          JFileChooser.APPROVE_OPTION )
         return jfc.getSelectedFile().getAbsolutePath();
      else
         return null;
	}

	public void saveCoCons( Collection cocons,
									String file )
	{
		CoConXMLWriter.SINGLETON.manyCoConsToFile( cocons, file );
	}


}
