package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;
import java.lang.NoSuchFieldException;

/**
 * Interface to manage the data required to model a CoCon.
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public interface CoConSetData
{

	//////////////////////
	//
	// Direct References
	//
	//////////////////////

	/**adds a direct reference to the collection of
	 * directly referenced elements. */
	void addDirectReference( String element );
	/**@return All directly referenced elements of this cocon
	 * as a Collection of Strings.
	 * Returned Collection must not be altered. */
	Collection getDirectReferences();
	/** sets the directly referenced elements of this set to the
	 *  given Collection of Strings. */
	void setDirectReferences( Collection strings );


	//////////////////////
	//
	// Conditions (indirect references)
	//
	//////////////////////

	/**adds a condition to the collection of
	 * directly referenced elements. */
	void addCondition( CoConSetConditionData cond );
	/**@return All conditions of this cocon set
	 * as a Collection of CoConSetConditionData.
	 * Returned Collection must not be altered. */
	Collection getConditions();
	/** sets the conditions of this set to the
	 *  given Collection of CoConSetConditionData. */
	void setConditions( Collection conds );

}
