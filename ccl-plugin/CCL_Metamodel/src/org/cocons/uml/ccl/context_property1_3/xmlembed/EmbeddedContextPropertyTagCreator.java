package org.cocons.uml.ccl.context_property1_3.xmlembed;

import java.util.Iterator;

import java.io.StringWriter;

import org.exolab.castor.xml.Marshaller;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyTag;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.*;



public class EmbeddedContextPropertyTagCreator
{

	static public EmbeddedContextPropertyTagCreator SINGLETON
		= new EmbeddedContextPropertyTagCreator();

	public EmbeddedContextPropertyTagCreator()
	{}

	public String create( Iterator alltags )
	{
		EmbeddedContextPropertyTags cont =
			new EmbeddedContextPropertyTags();

		while( alltags.hasNext() )
			{
				MContextPropertyTag tag = (MContextPropertyTag)alltags.next();
				ECPTEntry ent = new ECPTEntry();
				cont.addECPTEntry( ent );

				ent.setName( tag.getName() );
				ent.setVcpl( tag.getConstraintBody() );
			}
		return buildXMLString( cont );
	}

	protected String buildXMLString( EmbeddedContextPropertyTags tags )
	{
		try {
			StringWriter sw = new StringWriter();
			Marshaller marshaller = 
				new Marshaller(sw);
			marshaller.marshal( tags );
			return sw.toString();
		} catch ( Exception e ) {
			System.err.println(e);
		}
		return "";
	}

}

