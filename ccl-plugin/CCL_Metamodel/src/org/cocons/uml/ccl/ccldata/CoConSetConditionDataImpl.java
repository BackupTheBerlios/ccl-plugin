package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;


public class CoConSetConditionDataImpl
	implements CoConSetConditionData
{

	//////////////////////
	//
	// Static constants
	//
	//////////////////////

	static private final Vector DEFAULT_RESTRICTION = new Vector();
	static private final String DEFAULT_RANGE       = "ALL";

	//////////////////////
	//
	// Construction
	//
	//////////////////////

	public CoConSetConditionDataImpl()
	{
		if( DEFAULT_RESTRICTION.isEmpty() )
			DEFAULT_RESTRICTION.add("ELEMENTS");

		setRange       ( null );
		setRestrictions( null );
		setQueries     ( null );
	}


	//////////////////////
	//
	// Range
	//
	//////////////////////

	private String _range = null;

	/**@return range of the condition, e.g. "ALL". */
	public String getRange()
	{
		return _range;
	}

	/** sets range of the condition */
	public void setRange( String range )
	{
		if( range==null )
			_range = DEFAULT_RANGE;
		else if( "".equals(range) )
			_range = DEFAULT_RANGE;
		else
			_range = range;
	}


	//////////////////////
	//
	// Restriction
	//
	//////////////////////

	private Vector _restriction = null;

	/**@return restrictions of the query, e.g. {"Components","Computers"}.
	 * Result must not be written to. */
	public Collection getRestrictions()
	{
		if( _restriction == null )
			return (Collection)DEFAULT_RESTRICTION.clone();
		else
			return (Collection)_restriction.clone();
	}
	/** adds a restriction to this condition */
	public void addRestriction( String restriction )
	{
		if( _restriction == null )
			_restriction = new Vector();

		_restriction.add( restriction );
	}
	/** sets the restrictions to the given Collection of Strings */
	public void setRestrictions( Collection restrictions )
	{
		if( restrictions==null )
			_restriction = null;
		else if( restrictions.isEmpty() )
			_restriction = null;
		else
			_restriction = new Vector(restrictions);
	}


	//////////////////////
	//
	// Query
	//
	//////////////////////

	private Vector _queries = null;

	/**@return queries of the query, e.g. {"personal data=yes"}.
	 * Result must not be written to. */
	public Collection getQueries()
	{
		return (Collection)_queries.clone();
	}
	/** adds a query to this condition */
	public void addQuery( CoConSetConditionQueryData query )
	{
		_queries.add( query );
	}
	/** sets the queries to the given Collection of CoConSetConditionQueryData */
	public void setQueries( Collection queries )
	{
		if( _queries == null )
			_queries = new Vector();
		else
			_queries=new Vector( queries );
	}


	public String toString()
	{
		String result = new String(getRange());
		boolean first = true;

		Iterator it =getRestrictions().iterator();
		while(it.hasNext())
			result += " " + it.next();

		Collection qs = getQueries();
		if( !qs.isEmpty() )
			{
				it=qs.iterator();
				while( it.hasNext() )
					{
						if( first )
							result += " WHERE ";
						else
							result += " AND ";
						result += it.next();
					};
			};
		return result;
	}
}

