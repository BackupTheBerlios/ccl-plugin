package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;


public interface CoConSetConditionData
{

	//////////////////////
	//
	// Range
	//
	//////////////////////

	/**@return range of the condition, e.g. "ALL". */
	String getRange();
	/** sets range of the condition */
	void setRange( String range );


	//////////////////////
	//
	// Restriction
	//
	//////////////////////

	/**@return restrictions of the query, e.g. {"Components","Computers"}.
	 * Result must not be written to. */
	Collection getRestrictions();
	/** adds a restriction to this condition */
	void addRestriction( String restriction );
	/** sets the restrictions to the given Collection of Strings */
	void setRestrictions( Collection restrictions );


	//////////////////////
	//
	// Query
	//
	//////////////////////

	/**@return queries of the query, e.g. {"personal data=yes"}.
	 * Result must not be written to. */
	Collection getQueries();
	/** adds a query to this condition */
	void addQuery( CoConSetConditionQueryData query );
	/** sets the queries to the given Collection of CoConSetConditionQueryData */
	void setQueries( Collection queries );

}
