package org.cocons.uml.ccl.ccldata;

import java.lang.String;

public interface CoConSetConditionQuerySingleValueData
	extends CoConSetConditionQueryData
{

	//////////////////////
	//
	// Value
	//
	//////////////////////

	/**@return value of the query, e.g. "YES" */
	String getValue();
	/** sets the value of this query to the given string. */
	void setValue( String value );

}
