package org.cocons.uml.ccl.context_property1_3.xmlembed;

import java.util.Iterator;
import java.util.Enumeration;
import java.util.Collection;
import java.util.Vector;

import java.io.StringReader;

import ru.novosoft.uml.foundation.data_types.MBooleanExpression;
import ru.novosoft.uml.foundation.core.MConstraint;
import ru.novosoft.uml.foundation.core.MConstraintImpl;

import org.exolab.castor.xml.Unmarshaller;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyTag;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyTagImpl;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.*;



public class EmbeddedContextPropertyTagDecoder
{

	static public EmbeddedContextPropertyTagDecoder SINGLETON
		= new EmbeddedContextPropertyTagDecoder();

	public EmbeddedContextPropertyTagDecoder()
	{}

	public Iterator decode( String xmlstring )
	{
		EmbeddedContextPropertyTags xmltags = null;

		try {
			StringReader sr = new StringReader( xmlstring );
			Unmarshaller unmarshaller = 
				new Unmarshaller( Class.forName("org.cocons.uml.ccl.context_property1_3.xmlembed.castor.EmbeddedContextPropertyTags") );
			xmltags = (EmbeddedContextPropertyTags)unmarshaller.unmarshal( sr );
		} catch( Exception e ) {
			return null;
		}
		if( xmltags == null )
			return null;

		return decodetags( xmltags.enumerateECPTEntry() );
	}

	protected Iterator decodetags( Enumeration xmltags )
	{
		Collection ctags = new Vector();

		while( xmltags.hasMoreElements() )
			{
				ECPTEntry ent = (ECPTEntry)xmltags.nextElement();
				
				MContextPropertyTag tag =
					new MContextPropertyTagImpl();

				tag.setName( ent.getName() );

				MConstraint cons = new MConstraintImpl();
				cons.setBody( new MBooleanExpression( null,
																  ent.getVcpl() ) );
				tag.addConstraint(cons);

				ctags.add(tag);
			}

		return ctags.iterator();
	}

}

