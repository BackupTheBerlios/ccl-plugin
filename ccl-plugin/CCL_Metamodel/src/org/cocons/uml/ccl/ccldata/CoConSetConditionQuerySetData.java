package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;


public interface CoConSetConditionQuerySetData
	extends CoConSetConditionQueryData
{


	//////////////////////
	//
	// Values
	//
	//////////////////////

	/**@return values of the query, e.g. {"YES","PERHAPS"}.
	 * Result must not be written to. */
	Collection getValues();
	/** adds a value of this query to the given string. */
	void addValue( String value );
	/** sets the values to the given Collection of Strings */
	void setValues( Collection values );

}
