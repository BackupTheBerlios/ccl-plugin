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
public interface CoConData
{

	//////////////////////
	//
	// CoCon Type
	//
	//////////////////////

	/**@return type of the cocon, e.g. "UnreadableBy" */
	String getType();
	/** sets the type of this cocon to the given string. */
	void setType( String typename );


	//////////////////////
	//
	// CoConSets
	//
	//////////////////////

	/**@return the scope set of the cocon */
	CoConSetData getScopeSet();
	/**sets the scope set of the cocon */
	void setScopeSet( CoConSetData scope_set );

	/**@return the target set of the cocon */
	CoConSetData getTargetSet();
	/**sets the target set of the cocon */
	void setTargetSet( CoConSetData target_set );
	
	/**@return the set of the cocon specified by
	 * the given.
	 * @throws NoSuchFieldException Iff the id is invalid.
	 */
	CoConSetData getSetByID( String id )
		throws NoSuchFieldException;
	/**sets the set specified by the given id
	 * to the given CoConSetData.
	 * @throws NoSuchFieldException Iff the id is invalid.
	 */
	void setSetByID( CoConSetData set, String id )
		throws NoSuchFieldException;





	//////////////////////
	//
	// (CCL-) Attributes
	//
	//////////////////////

	/**adds an attribute to the collection of
	 * CoConAttributeDatas. */
	void addAttribute( CoConAttributeData attribute  );
	/**@return All CoConAttributeData items of this cocon.
	 * Returned Collection must not be altered. */
	Collection getAttributes();
	/**sets the attributes of this cocon to the passed
	 * Collection, which must contain CoConAttributeData
	 * instances only. */
	void setAttributes( Collection attributes );

}
