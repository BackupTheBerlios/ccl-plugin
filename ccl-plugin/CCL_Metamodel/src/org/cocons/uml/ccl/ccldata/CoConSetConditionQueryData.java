package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;
import java.lang.NoSuchFieldException;


public interface CoConSetConditionQueryData
{
	//////////////////////
	//
	// Property
	//
	//////////////////////

	/**@return property of the query, e.g. "workflow" */
	String getProperty();
	/** sets the property of this query to the given string. */
	void setProperty( String property );


	//////////////////////
	//
	// Operator
	//
	//////////////////////

	/**@return operator of the query, e.g. "equal" */
	String getOperator();
	/** sets the operator of this query to the given string. */
	void setOperator( String operator );

}
