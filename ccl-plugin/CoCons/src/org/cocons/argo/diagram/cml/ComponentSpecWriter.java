package org.cocons.argo.diagram.cml;

import java.lang.String;
import java.io.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;

import org.exolab.castor.xml.*;
import de.fhg.isst.ComponentML.*;

public class ComponentSpecWriter
{

   ////////////////////////////////////////////////////////////////
   // Variables

   Writer _output;
   MClass _component;


   ////////////////////////////////////////////////////////////////
   // Constructor

   public ComponentSpecWriter( MClass comp,
			       String filename )
      throws IOException
   {
      _output = new FileWriter(filename);
      _component = comp;
   }



   ////////////////////////////////////////////////////////////////
   // Main method

   public void write()
      throws Exception
   {
        ComponentSpec cs = new ComponentSpec();

	// construct it
	buildGlobalSection(cs);
	buildProperties(cs);
	buildExports(cs);
	buildImports(cs);

	// and out...
        Marshaller marshaller = new Marshaller(_output);
        marshaller.marshal(cs);
   }


   ////////////////////////////////////////////////////////////////
   // Utilities

   protected void buildGlobalSection( ComponentSpec cs )
   {
      GlobalSection gs = new GlobalSection();
      cs.setGlobalSection(gs);

      ComponentName cn = new ComponentName();
      cn.setName(_component.getName());
      cn.setNamespace(_component.getNamespace().getName());
      gs.setComponentName(cn);

      ComponentCategory cg = new ComponentCategory();
      cg.setServiceOriented(new ServiceOriented());
      gs.setComponentCategory(cg);
   }


   protected void buildProperties( ComponentSpec cs )
   {  
      // example stuff - active because they're required fields

       Properties ps = new Properties();
       cs.setProperties(ps);
       Property p = new Property();
       ps.addProperty(p);
       p.setKey("age");
       p.addValue("42");
   }

   protected void buildExports( ComponentSpec cs )
   {
      /* TODO: Find all MInterfaces exported by _component,
       * let the (not yet existing) CMLFacadeBuilder build
       * an according Facade, and include it.
       */

      // example stuff - active because they're required fields
      ExportSection es = new ExportSection();
      cs.setExportSection(es);
      
      ExportSectionChoice esc = new ExportSectionChoice();
      es.setExportSectionChoice(esc);
      Facade f = new Facade();
      esc.addFacade(f);
      //es.addFacade(f);
      f.setFacadeName("mainFacade");
      BusinessExport be = new BusinessExport();
      f.addBusinessExport(be);
      Method m = new Method();
      be.addMethod(m);
      MethodName mn = new MethodName();
      mn.setContent("method1");
      m.setMethodName(mn);
   }



   protected void buildImports( ComponentSpec cs )
   {
      /* TODO: Find all MInterfaces imported by _component,
       * let the (not yet existing) CMLFacadeBuilder build
       * an according Facade, and include it.
       */
   }


}
