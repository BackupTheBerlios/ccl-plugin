package org.cocons.argo.diagram.cml;

import java.lang.String;
import java.io.*;
import ru.novosoft.uml.foundation.core.*;
import ru.novosoft.uml.foundation.extension_mechanisms.*;
import ru.novosoft.uml.foundation.data_types.*;
import ru.novosoft.uml.model_management.*;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import org.exolab.castor.xml.*;
import org.cocons.uml.ccl.context_property1_3.*;
//use the XML pretty-printing classes from Apache's SAX implementation.
//see below for further comments
import org.apache.xml.serialize.XMLSerializer;
import org.apache.xml.serialize.OutputFormat;

import de.fhg.isst.ComponentML.*;

public class ComponentSpecWriter
{


	static public String CONTEXT_PROPERTY_DESCRIPTION
		= "ContextPropertyTag";

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
		Properties props = new Properties();
		cs.setProperties( props );
		//		System.out.println("TV");
		Iterator it = _component.getTaggedValues().iterator();
		while( it.hasNext() )
			{
				Object o = it.next();
				//				System.out.println("  " + o.getClass() );

				if( o instanceof MContextPropertyValue )
					{
						MContextPropertyValue pv = (MContextPropertyValue)o;

						Property prop=new Property();
						props.addProperty( prop );

						prop.setDescription( CONTEXT_PROPERTY_DESCRIPTION );
						prop.setKey( pv.getTag() );
						prop.addValue( pv.getValue() );
// 						MContextPropertyValue pv = (MContextPropertyValue)o;
// 						MContextPropertyTag t = pv.getContextPropertyTag();
// 						System.out.println("  ++ " + t.getTag() );
// 						System.out.println("  -- " + pv.getTag() );
// 						System.out.println("     " + pv.getValue() );
					}
			}
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

               //find exported types for this facade

               TypeExport typeExport = null;
               for (Iterator it2=mint.getAssociationEnds().iterator();
                    it2.hasNext();) {
                   MClassifier mc2 = (MClassifier)((MAssociationEnd)it2.next()).getOppositeEnd().getType();
                   if (mc2 instanceof MClass && mc2.getStereotype().getName().equals("info type")) {
                       MClass mtype = (MClass)mc2;

                       if (typeExport == null) {
                           typeExport = new TypeExport();
                           f.setTypeExport(typeExport);
                       }

                       typeExport.addType(mTypeToCMLType(mtype));
                   }
               }
           }
       }
   }

  protected void buildImports( ComponentSpec cs ){
      ImportSection is = null;
      BusinessImport bi = null;

      Set importedTypes = null;
      for (Iterator it=_component.getClientDependencies().iterator();
           it.hasNext();){
          MDependency md = (MDependency) it.next();

          for(Iterator it2 = md.getSuppliers().iterator(); it2.hasNext();){
              MModelElement mc = (MModelElement)it2.next();

              if (mc instanceof MInterface && mc.getStereotype().getName().equals("interface spec")) {
                  if (is == null) {
                      is = new ImportSection();
                      cs.setImportSection(is);
                      bi = new BusinessImport();
                      is.setBusinessImport(bi);
                  }

                  MInterface mint = (MInterface)mc;
                  for (Iterator it3 = mint.getFeatures().iterator(); it3.hasNext(); ) {
                      Object o = it3.next();
                      if (o instanceof MOperation) {
                          MOperation op = (MOperation)o;
                          bi.addMethod(operationToMethod(op));
                      }
                  }


                  //add all info types associated with mint to importedTypes
                  for (Iterator it4=mint.getAssociationEnds().iterator();
                       it4.hasNext();) {
                      MClassifier mc2 = (MClassifier)((MAssociationEnd)it4.next()).getOppositeEnd().getType();
                      if (mc2 instanceof MClass && mc2.getStereotype().getName().equals("info type")) {
                          if (importedTypes == null) {
                              importedTypes = new HashSet();
                          }
                          System.err.println("Found imported type: "+mc2);
                          importedTypes.add(mc2);
                      }
                  }

              }
          }
      }

      System.err.println("writing imported types?");
      //write importedTypes
      if (importedTypes != null) {
          System.err.println("writing imported types!");
          TypeImport typeImport = new TypeImport();
          is.setTypeImport(typeImport);
          for (Iterator it2=importedTypes.iterator(); it2.hasNext();) {
              MClass mtype = (MClass)it2.next();
              System.err.println("writing imported type: "+mtype);
              Type cmlType = mTypeToCMLType(mtype);
              TypeImportItem tii = new TypeImportItem();
              tii.setType(cmlType);
              typeImport.addTypeImportItem(tii);
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


    /*
    private static TypeAttr mAttrToCMLAttr(MAttribute mattr) {
        TypeAttr result = new TypeAttr();
        result.setAttrName(mattr.getName());
        result.setAttrTypeRef(mattr.getType().getName());
        return result;
    }
    */

    private static Type mTypeToCMLType(MClass mtype) {
        Type type = new Type();
        TypeName typeName = new TypeName();
        typeName.setContent(mtype.getName());
        type.setTypeName(typeName);
        
        TypeAttrs typeAttrs = new TypeAttrs();
        type.setTypeAttrs(typeAttrs);
        for (Iterator it3 = mtype.getFeatures().iterator(); it3.hasNext(); ) {
            Object o = it3.next();
            if (o instanceof MAttribute) {
                MAttribute mattr = (MAttribute)o;

                TypeAttr typeAttr = new TypeAttr();
                typeAttr.setAttrName(mattr.getName());
                typeAttr.setAttrTypeRef(mattr.getType().getName());

                typeAttrs.addTypeAttr(typeAttr);
            }
        }
        return type;
    }


}
