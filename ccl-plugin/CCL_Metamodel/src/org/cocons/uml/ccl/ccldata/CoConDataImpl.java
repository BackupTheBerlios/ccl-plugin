package org.cocons.uml.ccl.ccldata;

import java.lang.String;
import java.util.Collection;
import java.util.Vector;
import java.util.Iterator;
import java.lang.NoSuchFieldException;

/**
 * Interface to manage the data required to model a CoCon.
 *
 * @author Alexander Kroeller
 * @version $Revision 1.1$
 */
public class CoConDataImpl
	implements CoConData
{
	//////////////////////
	//
	// Constants
	//
	//////////////////////

	public static String SCOPE_SET_ID  = "scope";
	public static String TARGET_SET_ID = "target";


	//////////////////////
	//
	// Construction
	//
	//////////////////////
	
	public CoConDataImpl()
	{
		setType      ( "" );
		setScopeSet  ( null );
		setTargetSet ( null );
		setAttributes( null );
	}


	//////////////////////
	//
	// CoCon Type
	//
	//////////////////////

	private String _type = null;

	/**@return type of the cocon, e.g. "UnreadableBy" */
	public String getType()
	{
		return _type;
	}
	/** sets the type of this cocon to the given string. */
	public void setType( String typename )
	{
		if( typename == null )
			_type = "";
		else
			_type = typename;
	}


	//////////////////////
	//
	// CoConSets
	//
	//////////////////////

	private CoConSetData _scopeSet  = null;
	private CoConSetData _targetSet = null;

	/**@return the scope set of the cocon */
	public CoConSetData getScopeSet()
	{
		return _scopeSet;
	}

	/**sets the scope set of the cocon */
	public void setScopeSet( CoConSetData scope_set )
	{
		if( scope_set == null )
			_scopeSet = new CoConSetDataImpl();
		else
			_scopeSet = scope_set;
	}

	/**@return the target set of the cocon */
	public CoConSetData getTargetSet()
	{
		return _targetSet;
	}

	/**sets the target set of the cocon */
	public void setTargetSet( CoConSetData target_set )
	{
		if( target_set == null )
			_targetSet = new CoConSetDataImpl();
		else
			_targetSet = target_set;
	}

	/**@return the set of the cocon specified by
	 * the given.
	 * @throws NoSuchFieldException Iff the id is invalid.
	 */
	public CoConSetData getSetByID( String id )
		throws NoSuchFieldException
	{
		if( SCOPE_SET_ID.equalsIgnoreCase(id) )
			return getScopeSet();
		else if( TARGET_SET_ID.equalsIgnoreCase(id) )
			return getTargetSet();
		else
			throw new NoSuchFieldException("No such set '"+id+"'");
	}

	/**sets the set specified by the given id
	 * to the given CoConSetData.
	 * @throws NoSuchFieldException Iff the id is invalid.
	 */
	public void setSetByID( CoConSetData set, String id )
		throws NoSuchFieldException
	{
		if( SCOPE_SET_ID.equalsIgnoreCase(id) )
			setScopeSet(set);
		else if( TARGET_SET_ID.equalsIgnoreCase(id) )
			setTargetSet(set);
		else
			throw new NoSuchFieldException("No such set '"+id+"'");
	}





	//////////////////////
	//
	// (CCL-) Attributes
	//
	//////////////////////

	private Vector _attributes = null;

	/**adds an attribute to the collection of
	 * CoConAttributeDatas. */
	public void addAttribute( CoConAttributeData attribute  )
	{
		if( _attributes == null )
			_attributes = new Vector();
		_attributes.add( attribute );
	}
	/**@return All CoConAttributeData items of this cocon.
	 * Returned Collection must not be altered. */
	public Collection getAttributes()
	{
		if( _attributes == null )
			_attributes = new Vector();
		return (Collection)_attributes.clone();
	}
	/**sets the attributes of this cocon to the passed
	 * Collection, which must contain CoConAttributeData
	 * instances only. */
	public void setAttributes( Collection attributes )
	{
		if( _attributes == null )
			_attributes = new Vector();
		else
			_attributes = new Vector( attributes );
	}


	public String toString()
	{
		String result = new String("");

		CoConSetData ccs = getTargetSet();
		if( ccs == null )
			result += "ALL COMPONENTS";
		else
			result += ccs;

		result += "\nMUST BE ";
		if( getType() == null )
			result += "(???)";
		else
			result += getType();

		result += "\n";

		ccs=getScopeSet();
		if( ccs == null )
			result += "ALL COMPONENTS";
		else
			result += ccs;

		result += "\n";
		Collection attribs = getAttributes();
		if( !attribs.isEmpty() )
			{
				Iterator it    = attribs.iterator();
				boolean  first = true;
				while( it.hasNext() )
					{
						if( first )
							result += "WITH ";
						else
							result += "AND ";
						result += it.next() + "\n";
						first = false;
					};
			};
		return result;
	}

}
