package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;
import java.lang.NoSuchFieldException;


public interface CoConSetConditionQueryPropertyData
	extends CoConSetConditionQueryData
{

	//////////////////////
	//
	// RHS-Property
	//
	//////////////////////

	/**@return rhs-property of the query, e.g. "workflow" */
	String getRHSProperty();
	/** sets the rhs-property of this attribute to the given string. */
	void setRHSProperty( String rhsproperty );


}
