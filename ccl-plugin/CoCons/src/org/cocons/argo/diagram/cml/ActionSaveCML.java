package org.cocons.argo.diagram.cml;


import java.lang.String;

import java.awt.event.*;

import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;


import org.argouml.uml.ui.*;
import org.argouml.kernel.*;
import org.argouml.uml.*;
import org.argouml.ui.*;

import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;


public class ActionSaveCML
   extends AbstractAction {

   ////////////////////////////////////////////////////////////////
   // static variables

   // order matters! ctor needs TITLE, so it must be declared first!

   public static String TITLE = "Save as ComponentML...";

   public static ActionSaveCML SINGLETON 
      = new ActionSaveCML();


   ////////////////////////////////////////////////////////////////
   // constructor

   public ActionSaveCML()
   {
      super( TITLE ); 
   }


   ////////////////////////////////////////////////////////////////
   // main method

   public void actionPerformed( ActionEvent ae )
   {
      MClass comp = getCurrentComponent();

      if( comp == null ) return;
		 
      String compname = comp.getName();
      if( compname == null )
	 compname = "component";

      String filename = getFileName( compname );

      if( filename != null )
	 saveToCML( comp, filename );
   }


   ////////////////////////////////////////////////////////////////
   // utility methods

   public void saveToCML( MClass compo,
			  String file )
   {
      try {
	 ComponentSpecWriter csw =
	    new ComponentSpecWriter( compo,
				     file );
	 csw.write();
      } catch ( Exception e ) {
	 JOptionPane.showMessageDialog(null,
				       file+":\n"+
				       e,
				       TITLE,
				       JOptionPane.ERROR_MESSAGE);
      }
   }

   public MClass getCurrentComponent()
   {
      Object obj = ProjectBrowser.TheInstance.getDetailsTarget();

      if( obj instanceof MClass )
	 {
	    MClass cls = (MClass)obj;
	    MStereotype stereo = cls.getStereotype();

	    if(stereo != null)
	       if( "comp spec".equals(stereo.getName()) )
		  return cls;
	 }

      JOptionPane.
	 showMessageDialog(null,
			   "Only single components can be saved as ComponentML",
			   TITLE,
			   JOptionPane.ERROR_MESSAGE);
      return null;
   }

   public String getFileName( String cname )
   {
      JFileChooser jfc = new JFileChooser();

      jfc.setDialogTitle( cname + ": " + TITLE );
      setCMLSuffix( jfc );

      if( jfc.showSaveDialog(null) == 
	  JFileChooser.APPROVE_OPTION )
	 return jfc.getSelectedFile().getAbsolutePath();
      else
	 return null;
   }

   public void setCMLSuffix( JFileChooser jfc )
   {
      // todo: stuff a file filter into jfc which
      //       enforces a suffix like ".cml"
   }

}
