package org.cocons.argo.diagram.cml;

import java.lang.String;
import java.io.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;
import java.util.Iterator;
import org.exolab.castor.xml.*;

//use the XML pretty-printing classes from Apache's SAX implementation.
//see below for further comments
import org.apache.xml.serialize.XMLSerializer;
import org.apache.xml.serialize.OutputFormat;

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

        //We use the XML pretty-printing classes from Apache's SAX implementation.
        //at *compile time*, this code depends the presence of apache's SAX implementation,
        //which contains the package org.apache.xml.serialize.
        //*at runtime*, a check is performed to see whether the package is actually available
        //If it isn't, the code will still work, but pretty-printing will be deactivated.
        //
        //TODO: the compile-time dependency should be removed. There are two ways to do this:
        //
        // 1. manually re-implement pretty-printing here by
        //    implementing org.apache.xml.serialize.DocumentHandler
        //
        // 2. load and instantiate all Apache-specific classes dynamically (using reflection).
        //    Cumbersome, but not really hard to do.

        Marshaller marshaller;
        try {
            Class.forName("org.apache.xml.serialize.XMLSerializer");
            OutputFormat format = new OutputFormat("xml","utf-8",true);
            XMLSerializer prettyPrinter = new XMLSerializer(_output, format);
            marshaller = new Marshaller(prettyPrinter);
        }
        catch (ClassNotFoundException e) {
            System.err.println("class org.apache.xml.serialize.XMLSerializer is not available.");
            System.err.println("XML pretty-printing will be deactivated");
            marshaller = new Marshaller(_output);
        }

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

      for (Iterator it=_component.getAssociationEnds().iterator();
           it.hasNext();) {
        MAssociationEnd end = (MAssociationEnd)it.next();
        MClassifier mc = (MClassifier)end.getOppositeEnd().getType();
        if (mc instanceof MInterface && mc.getStereotype().getName().equals("interface spec")) {
           Facade f = new Facade();
           esc.addFacade(f);
           //es.addFacade(f);
           f.setFacadeName(mc.getName());
           BusinessExport be = new BusinessExport();
           f.addBusinessExport(be);
           MInterface mint = (MInterface)mc;
           for (Iterator it2 = mint.getFeatures().iterator(); it2.hasNext(); ) {
            Object o = it2.next();
            if (o instanceof MOperation) {
              MOperation op = (MOperation)o;
              be.addMethod(operationToMethod(op));
            }
           }

        }
      }
   }

  protected void buildImports( ComponentSpec cs ){
    ImportSection is = new ImportSection();
    cs.setImportSection(is);
    BusinessImport bi = new BusinessImport();
    is.setBusinessImport(bi);
    for (Iterator it=_component.getClientDependencies().iterator();
           it.hasNext();){
      MDependency md = (MDependency) it.next();

      for(Iterator it2 = md.getSuppliers().iterator(); it2.hasNext();){
        MModelElement mc = (MModelElement)it2.next();

        if (mc instanceof MInterface && mc.getStereotype().getName().equals("interface spec")) {
          MInterface mint = (MInterface)mc;
          for (Iterator it3 = mint.getFeatures().iterator(); it3.hasNext(); ) {
            Object o = it3.next();
            if (o instanceof MOperation) {
              MOperation op = (MOperation)o;
              bi.addMethod(operationToMethod(op));
            }
          }
        }
      }
    }
   }

   private Method operationToMethod(MOperation op) {
      Method m = new Method();
      MethodName mn = new MethodName();
      mn.setContent(op.getName());
      m.setMethodName(mn);

      MethodParameters pars = new MethodParameters();
      for (Iterator it=op.getParameters().iterator(); it.hasNext();) {
        MParameter mpar = (MParameter)it.next();
        if (mpar.getName().equals("return")) {
          MethodReturnTypeRef ret = new MethodReturnTypeRef();
          ret.setContent(mpar.getType().getName());
          m.setMethodReturnTypeRef(ret);
        }
        else {
          MethodParameter par = new MethodParameter();
          par.setParameterName(mpar.getName());
          par.setParameterTypeRef(mpar.getType().getName());
          pars.addMethodParameter(par);
        }
      }
      m.setMethodParameters(pars);
      return m;
   }



}
