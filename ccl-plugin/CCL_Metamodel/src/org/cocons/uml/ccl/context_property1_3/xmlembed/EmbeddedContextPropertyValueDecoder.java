package org.cocons.uml.ccl.context_property1_3.xmlembed;

import java.util.Iterator;
import java.util.Enumeration;

import java.io.StringReader;

import org.exolab.castor.xml.Unmarshaller;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyValueImpl;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyTag;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.*;
import org.cocons.argo.util.ModelIterator;


public class EmbeddedContextPropertyValueDecoder
{

	static public EmbeddedContextPropertyValueDecoder SINGLETON
		= new EmbeddedContextPropertyValueDecoder();

	public EmbeddedContextPropertyValueDecoder()
	{}


	public MContextPropertyValue decode( String xml )
	{
		EmbeddedContextPropertyValue xmlval = null;

		try {
			StringReader sr = new StringReader( xml );
			Unmarshaller unmarshaller = 
				new Unmarshaller( Class.forName("org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyValue") );
			xmlval = (EmbeddedContextPropertyValue)unmarshaller.unmarshal( sr );
		} catch( Exception e ) {
			System.err.println(e);
			return null;
		}

		System.out.println("EMBEDDEDCONTEXTPROPERTYVALUE 1");
		if( xmlval == null )
			return null;
		System.out.println("EMBEDDEDCONTEXTPROPERTYVALUE 2");

		return decodeval( xmlval );
	}


	protected MContextPropertyValue decodeval( EmbeddedContextPropertyValue xmlval )
	{
		MContextPropertyValueImpl res =
			new MContextPropertyValueImpl();

		MContextPropertyTag tag =
			ModelIterator.SINGLETON.getContextPropertyTag( xmlval.getTag() );

		System.out.println("EMBEDDEDCONTEXTPROPERTYVALUE 3");
		if( tag==null )
			return null;
		System.out.println("EMBEDDEDCONTEXTPROPERTYVALUE 4");

		if( ! res.initializeFromEmbeddedXML( tag,
														 xmlval.getType(),
														 xmlval.enumerateECPVEntry(),
														 xmlval.getStereotype() ) )
{		System.out.println("EMBEDDEDCONTEXTPROPERTYVALUE 5");
			return null;
}
		return res;
	}

}

