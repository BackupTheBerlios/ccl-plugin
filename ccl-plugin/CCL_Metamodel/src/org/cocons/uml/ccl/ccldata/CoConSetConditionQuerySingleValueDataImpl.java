package org.cocons.uml.ccl.ccldata;

import java.lang.String;

/**
 * Implementation of CoConSetConditionQuerySingleValueData
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public class CoConSetConditionQuerySingleValueDataImpl
	extends    CoConSetConditionQueryDataImpl
	implements CoConSetConditionQuerySingleValueData
{

	//////////////////////
	//
	// Construction
	//
	//////////////////////

	public CoConSetConditionQuerySingleValueDataImpl()
	{
		super();
		setValue( null );
	}
	
	//////////////////////
	//
	// Value
	//
	//////////////////////

	private String _value = null;

	/**@return value of the attribute, e.g. "YES" */
	public String getValue()
	{
		return _value;
	}
	/** sets the value of this query to the given string. */
	public void setValue( String value )
	{
		if( value == null )
			_value = "";
		else
			_value = value;
	}


	public String toString()
	{
		String result = super.toString();
		String val = getValue();

		if( val==null )
			result += " ???";
		else
			result += " '" + val + "'";
		return result;
	}
}
