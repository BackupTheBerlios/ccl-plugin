package org.cocons.uml.ccl.ccldata;

import java.lang.String;

/**
 * Implemenation of CoConAttributeData
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public class CoConAttributeDataImpl
	implements CoConAttributeData
{

	//////////////////////
	//
	// Construction
	//
	//////////////////////

	public CoConAttributeDataImpl()
	{
		setName ( null );
		setValue( null );
	}
	
	public CoConAttributeDataImpl( String name, String value )
	{
		setName ( name  );
		setValue( value );
	}

	//////////////////////
	//
	// Name
	//
	//////////////////////

	private String _name = null;

	/**@return name of the attribute, e.g. "Action" */
	public String getName()
	{
		return _name;
	}
	/** sets the name of this attribute to the given string. */
	public void setName( String name )
	{
		if( name == null )
			_name = "";
		else
			_name = name;
	}


	//////////////////////
	//
	// Value
	//
	//////////////////////

	private String _value = null;

	/**@return value of the attribute, e.g. "WarnDialog" */
	public String getValue()
	{
		return _value;
	}
	/** sets the value of this attribute to the given string. */
	public void setValue( String value )
	{
		if( value == null )
			_value = "";
		else
			_value = value;
	}
	

	public String toString()
	{
		String name  = getName();
		String value = getValue();
		if( name  == null ) name  = "???";
		if( value == null ) value = "???";
		
		return "'" + name + "' = '" + value + "'";
	}
}
