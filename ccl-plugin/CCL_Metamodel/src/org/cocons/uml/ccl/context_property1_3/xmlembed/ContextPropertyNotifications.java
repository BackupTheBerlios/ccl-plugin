package org.cocons.uml.ccl.context_property1_3.xmlembed;

import java.util.Iterator;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Collection;
import org.tigris.gef.base.Diagram;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;
import org.tigris.gef.presentation.Fig;


public class ContextPropertyNotifications
{
	static public ContextPropertyNotifications SINGLETON =
		new ContextPropertyNotifications();

	public ContextPropertyNotifications()
	{}

	public void preSave( Diagram caller )
	{
		Iterator todo = propsInDiagram( caller );
		while( todo.hasNext() )
			((MContextPropertyValue)(todo.next())).preSave();
	}

	public void postSave( Diagram caller )
	{
		Iterator todo = propsInDiagram( caller );
		while( todo.hasNext() )
			((MContextPropertyValue)(todo.next())).postSave();
	}

	protected Iterator propsInDiagram( Diagram diag )
	{
		Enumeration elems = diag.elements();
		Collection res = new Vector();

		while( elems.hasMoreElements() )
		 	{
				Object f = elems.nextElement();
				if( f instanceof Fig )
					{
						Object mel = ((Fig)f).getOwner();
						if( mel != null )
							if( mel instanceof MContextPropertyValue )
								res.add( mel );
					}
			}

		return res.iterator();
	}

}
