package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;
import java.lang.NoSuchFieldException;

/**
 * Interface to manage the data required to model a CoCon.
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public class CoConSetDataImpl
	implements CoConSetData
{

	//////////////////////
	//
	// Direct References
	//
	//////////////////////

	private Vector _directReferences = null;

	/**adds a direct reference to the collection of
	 * directly referenced elements. */
	public void addDirectReference( String element )
	{
		if( _directReferences == null )
			_directReferences = new Vector();
		_directReferences.add(element);
	}
	/**@return All directly referenced elements of this cocon
	 * as a Collection of Strings.
	 * Returned Collection must not be altered. */
	public Collection getDirectReferences()
	{
		if( _directReferences == null )
			_directReferences = new Vector();
		return (Collection)_directReferences.clone();
	}
	/** sets the directly referenced elements of this set to the
	 *  given Collection of Strings. */
	public void setDirectReferences( Collection strings )
	{
		_directReferences = new Vector(strings);
	}


	//////////////////////
	//
	// Conditions (indirect references)
	//
	//////////////////////

	private Vector _conditions = null;

	/**adds a condition to the collection of
	 * directly referenced elements. */
	public void addCondition( CoConSetConditionData cond )
	{
		if( _conditions == null )
			_conditions = new Vector();
		_conditions.add(cond);
	}
	/**@return All conditions of this cocon set
	 * as a Collection of CoConSetConditionData.
	 * Returned Collection must not be altered. */
	public Collection getConditions()
	{
		if( _conditions == null )
			_conditions = new Vector();
		return (Collection)_conditions.clone();
	}
	/** sets the conditions of this set to the
	 *  given Collection of CoConSetConditionData. */
	public void setConditions( Collection conds )
	{
		_conditions = new Vector( conds );
	}

	public String toString()
	{
		String result = new String("");
		boolean first = true;
		
		Collection direct = getDirectReferences();
		if( direct != null ) {
			Iterator it = direct.iterator();
			while( it.hasNext() )
				{ 
					if( !first ) result += " AND";
					result += it.next();
					first = false;
				};
		}
		Collection conds = getConditions();
		if( conds != null ) {
			Iterator it = conds.iterator();
			while( it.hasNext() )
				{ 
					if( !first ) result += " AND";
					result += it.next();
					first = false;
				};
		}
		
		if( first )
			result += "ALL COMPONENTS";
		return result;
	}
}
