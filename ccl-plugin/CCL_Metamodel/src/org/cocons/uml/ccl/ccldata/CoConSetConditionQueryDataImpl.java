package org.cocons.uml.ccl.ccldata;

import java.lang.String;

/**
 * Implementation of CoConSetConditionQueryData
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
abstract /*not-public*/ class CoConSetConditionQueryDataImpl
	implements CoConSetConditionQueryData
{

	//////////////////////
	//
	// Construction
	//
	//////////////////////

	public CoConSetConditionQueryDataImpl()
	{
		setProperty ( null );
		setOperator ( null );
	}
	
	//////////////////////
	//
	// Property
	//
	//////////////////////

	private String _property = null;

	/**@return property of the attribute, e.g. "Action" */
	public String getProperty()
	{
		return _property;
	}
	/** sets the property of this attribute to the given string. */
	public void setProperty( String property )
	{
		if( property == null )
			_property = "";
		else
			_property = property;
	}


	//////////////////////
	//
	// Operator
	//
	//////////////////////

	private String _operator = null;

	/**@return operator of the attribute, e.g. "WarnDialog" */
	public String getOperator()
	{
		return _operator;
	}
	/** sets the operator of this attribute to the given string. */
	public void setOperator( String operator )
	{
		if( operator == null )
			_operator = "";
		else
			_operator = operator;
	}


	public String toString()
	{
		String prop = getProperty();
		String op   = getOperator();
		String result = new String("");

		if( prop == null )
			result += "??? ";
		else
			result += "'" + prop + "' ";

		if( op == null )
			result += "???";
		else
			result += op;
		return result;
	}
}
