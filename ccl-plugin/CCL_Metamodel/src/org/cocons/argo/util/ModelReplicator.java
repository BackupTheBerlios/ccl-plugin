package org.cocons.argo.util;

import org.argouml.kernel.Project;
import ru.novosoft.uml.foundation.core.*;

import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

import javax.swing.JOptionPane;

import org.argouml.ui.ProjectBrowser;
import org.argouml.ui.ArgoDiagram;

import java.util.Enumeration;

import ru.novosoft.uml.MBase;
import ru.novosoft.uml.model_management.MModel;
import ru.novosoft.uml.foundation.data_types.MBooleanExpression;

import org.argouml.uml.diagram.ProjectMemberDiagram;
import org.argouml.uml.diagram.static_structure.ui.FigClass;

import org.cocons.uml.ccl.context_property1_3.*;

import org.cocons.argo.diagram.ui.CCLDiagram;
import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.MContextbasedConstraintImpl;

import org.cocons.argo.diagram.business_type.ui.CCLBusiness_TypeDiagram;
import org.cocons.argo.diagram.interface_spec.ui.CCLInterface_SpecDiagram;
import org.cocons.argo.diagram.component_spec.ui.CCLComponent_SpecDiagram;

import org.cocons.uml.ccl.ccldata.CoCon;
import org.cocons.uml.ccl.ccldata.CoConList;

import org.cocons.uml.ccl.xml.CoConXMLReader;

public class ModelReplicator
{
	
	private Collection _reflectiveReplicatableMBase                    = null;
	private Collection _reflectiveReplicatableMElement                 = null;
	private Collection _reflectiveReplicatableMModelElement            = null;
	private Collection _reflectiveReplicatableMConstraint              = null;
	private Collection _reflectiveReplicatableMContextbasedConstrained = null;

	public static ModelReplicator SINGLETON 
		= new ModelReplicator();


	protected ModelReplicator()
	{
		_reflectiveReplicatableMBase                    
			= getReflectiveReplicatableMBase();
		_reflectiveReplicatableMElement                 
			= getReflectiveReplicatableMElement();                 
		_reflectiveReplicatableMModelElement            
			= getReflectiveReplicatableMModelElement();            
		_reflectiveReplicatableMConstraint              
			= getReflectiveReplicatableMConstraint();              
		_reflectiveReplicatableMContextbasedConstrained 
			= getReflectiveReplicatableMContextbasedConstrained(); 
	}


	protected Collection getReflectiveReplicatableMBase()
	{
		Collection c = new Vector();
		c.add("extension");
		return c;
	}

	protected Collection getReflectiveReplicatableMElement()
	{
		return new Vector();
	}

	protected Collection getReflectiveReplicatableMModelElement()
	{
		Collection c = new Vector();
		c.add("isSpecification");
		c.add("visibility");
		c.add("name");
		c.add("elementImport2");
		c.add("classifierRole1");
		c.add("collaboration1");
		c.add("partition1");
		c.add("behavior");
		c.add("stereotype");
		c.add("templateParameter2");
		c.add("elementResidence");
		c.add("comment");
		c.add("binding");
		c.add("templateParameter3");
		c.add("sourceFlow");
		c.add("targetFlow");
		c.add("templateParameter");
		c.add("presentation");
		c.add("supplierDependency");
		c.add("constraint");
		c.add("taggedValue");
		c.add("clientDependency");
		c.add("namespace");
		// todo: c.add("referenceTag");
		return c;
	}

	protected Collection getReflectiveReplicatableMConstraint()
	{
		Collection c = new Vector();
		c.add("body");
		// todo: c.add("constrainedStereotype");
		c.add("constrainedElement");
		// todo: c.add("contextPropertyTag");
		return c;
	}

	protected Collection getReflectiveReplicatableMContextbasedConstrained()
	{
		return new Vector();
	}


	protected void replicateReflective( MBase oldd,
													MBase neww,
													Collection keys )
	{
		System.out.println("replicateReflective\n oldd = " + oldd.getClass() +"\n neww = "+neww.getClass());
		Iterator it = keys.iterator();
		while( it.hasNext() )
			{
				String key = (String)it.next();
				System.out.println(":: " + key);
				neww.reflectiveSetValue( key,
												 oldd.reflectiveGetValue(key) );
			};
	}



	public void replicateMBase( MBase oldd,
										 MBase neww )
	{
		replicateReflective( oldd, neww,
									_reflectiveReplicatableMBase );
		String uuid = oldd.getUUID();
		//oldd.setUUID( uuid + "[off]" );
		neww.setUUID( uuid );
	}

	public void replicateMElement( MElement oldd,
											 MElement neww )
	{
		replicateMBase( oldd, neww );
		replicateReflective( oldd, neww,
									_reflectiveReplicatableMElement );
	}

	public void replicateMModelElement( MModelElement oldd,
													MModelElement neww )
	{
		replicateMElement( oldd, neww );
		replicateReflective( oldd, neww,
									_reflectiveReplicatableMModelElement );
	}

	public void replicateMConstraint( MConstraint oldd,
												 MConstraint neww )
	{
		replicateMModelElement( oldd, neww );
		replicateReflective( oldd, neww,
									_reflectiveReplicatableMConstraint );
	}
		

	public void
		replicateMConstraintToMContextbasedConstraint( MConstraint cons,
																	  MContextbasedConstraint cocon )
	{
		replicateMConstraint(cons,cocon);
		replicateReflective( cons, cocon,
									_reflectiveReplicatableMContextbasedConstrained );

		MBooleanExpression mb = cocon.getBody();
		if( MContextbasedConstraintImpl.BODY_LANGUAGE.equals(mb.getLanguage()) )
			{
				try {
					CoConList ccl = CoConXMLReader.SINGLETON.readString(mb.getBody());
					cocon.initializeFromIMClass( ccl.getCoCon( 0 ) );
				} catch ( Exception e ) {
					System.err.println(e);
				}
			}
	}

}
