package org.cocons.uml.ccl.ccldata;

import java.lang.String;

/**
 * Implementation of CoConSetConditionQueryPropertyData
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public class CoConSetConditionQueryPropertyDataImpl
	extends    CoConSetConditionQueryDataImpl
	implements CoConSetConditionQueryPropertyData
{

	//////////////////////
	//
	// Construction
	//
	//////////////////////

	public CoConSetConditionQueryPropertyDataImpl()
	{
		super();
		setRHSProperty( null );
	}
	
	//////////////////////
	//
	// Property
	//
	//////////////////////

	private String _rhs_property = null;

	/**@return rhs_property of the attribute, e.g. "Action" */
	public String getRHSProperty()
	{
		return _rhs_property;
	}
	/** sets the rhs_property of this attribute to the given string. */
	public void setRHSProperty( String rhs_property )
	{
		if( rhs_property == null )
			_rhs_property = "";
		else
			_rhs_property = rhs_property;
	}


	public String toString()
	{
		String prop   = getRHSProperty();

		if( prop == null )
			return super.toString() + " ???";
		else
			return super.toString() + " '" + prop + "'";
	}
}
