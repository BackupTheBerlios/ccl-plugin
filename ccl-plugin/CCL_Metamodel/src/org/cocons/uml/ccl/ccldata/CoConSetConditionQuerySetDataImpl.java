package org.cocons.uml.ccl.ccldata;

import java.util.Vector;
import java.lang.String;
import java.util.Collection;
import java.util.Iterator;

/**
 * Implementation of CoConSetConditionQuerySetData
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public class CoConSetConditionQuerySetDataImpl
	extends    CoConSetConditionQueryDataImpl
	implements CoConSetConditionQuerySetData
{

	//////////////////////
	//
	// Construction
	//
	//////////////////////

	public CoConSetConditionQuerySetDataImpl()
	{
		super();
		setValues( null );
	}
	
	//////////////////////
	//
	// Values
	//
	//////////////////////

	private Vector _values = null;

	/**@return value of the attribute, e.g. "YES" */
	public Collection getValues()
	{
		return (Collection)_values.clone();
	}
	/** sets the value of this query to the given string. */
	public void addValue( String value )
	{
		_values.add( value );
	}
	/** sets the values to the given Collection of Strings */
	public void setValues( Collection values )
	{
		if( values == null )
			_values = new Vector();
		else
			_values=new Vector( values );
	}


	public String toString()
	{
		Iterator it = getValues().iterator();
		String result = super.toString();
		boolean first = true;

		result += " {";
		while( it.hasNext() )
			{
				if( !first )
					result += ", ";
				result += "'"+it.next()+"'";
				first = false;
			};
		result += "}";

		return result;
	}

}
