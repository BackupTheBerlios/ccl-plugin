package org.cocons.uml.ccl.ccldata;

import java.lang.String;

/**
 * Interface to manage the data required to model a CoCon.
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public interface CoConAttributeData
{
	
	//////////////////////
	//
	// Name
	//
	//////////////////////

	/**@return name of the attribute, e.g. "Action" */
	String getName();
	/** sets the name of this attribute to the given string. */
	void setName( String name );


	//////////////////////
	//
	// Value
	//
	//////////////////////

	/**@return value of the attribute, e.g. "WarnDialog" */
	String getValue();
	/** sets the value of this attribute to the given string. */
	void setValue( String value );
	

}
