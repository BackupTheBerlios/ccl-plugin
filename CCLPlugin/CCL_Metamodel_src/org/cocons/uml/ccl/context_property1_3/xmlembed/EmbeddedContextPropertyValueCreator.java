package org.cocons.uml.ccl.context_property1_3.xmlembed;

import java.util.Iterator;

import java.io.StringWriter;

import org.exolab.castor.xml.Marshaller;

import org.cocons.uml.ccl.context_property1_3.MContextPropertyTag;
import org.cocons.uml.ccl.context_property1_3.xmlembed.castor.*;



public class EmbeddedContextPropertyValueCreator
{

	private Iterator _values         = null;
	private Iterator _selection      = null;
	private Iterator _dependencies   = null;
	private MContextPropertyTag _tag = null;
	private String _type = null;
	private String _stereo = null;

	public EmbeddedContextPropertyValueCreator()
	{}

	public void setTag( MContextPropertyTag tag )
	{ _tag = tag; }

	public void setType( String type )
	{ _type = type; }

	public void setStereotype( String s )
	{ _stereo = s; }

	public void setContent( Iterator v,
									Iterator s,
									Iterator d )
	{
		_values       = v;
		_selection    = s;
		_dependencies = d;
	}

	public String create()
	{
		EmbeddedContextPropertyValue prop =
			new EmbeddedContextPropertyValue();

		prop.setTag( _tag.getName() );
		prop.setStereotype( _stereo );

		if( "Integer Number".equals(_type ) )
			prop.setType( org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType.INTEGERS );
		else if( "List Of Strings".equals(_type) )
			prop.setType( org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType.STRINGS );
		else if( "Float Number".equals(_type) )
			prop.setType( org.cocons.uml.ccl.context_property1_3.xmlembed.castor.types.TypeType.FLOATS );
		else
			{ System.out.println("_type == "+_type); }


		while( _values.hasNext() )
			{
				ECPVEntry ent = new ECPVEntry();
				
				ent.setValue( (String)(_values.next()) );
				ent.setSelected( ((Boolean)(_selection.next())).booleanValue() );
				ent.setDependency( (String)(_dependencies.next()) );

				prop.addECPVEntry( ent );
			};
		return buildXMLString( prop );
	}

	protected String buildXMLString( EmbeddedContextPropertyValue prop )
	{
		try {
			StringWriter sw = new StringWriter();
			Marshaller marshaller = 
				new Marshaller(sw);
			marshaller.marshal( prop );
			return sw.toString();
		} catch ( Exception e ) {
			System.err.println(e);
		}
		return "";
	}

}

