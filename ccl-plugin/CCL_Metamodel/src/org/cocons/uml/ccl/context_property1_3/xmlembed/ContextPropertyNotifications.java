package org.cocons.uml.ccl.context_property1_3.xmlembed;

import java.util.Iterator;
import java.util.Enumeration;
import java.util.Vector;
import java.util.Collection;
import org.tigris.gef.base.Diagram;
import org.cocons.uml.ccl.context_property1_3.MContextPropertyValue;
import org.tigris.gef.presentation.Fig;
import org.cocons.argo.diagram.ui.FigContextProperty;
import ru.novosoft.uml.foundation.extension_mechanisms.MTaggedValue;
import ru.novosoft.uml.foundation.core.MModelElement;
import org.cocons.argo.util.ModelIterator;


public class ContextPropertyNotifications
{
	static public ContextPropertyNotifications SINGLETON =
		new ContextPropertyNotifications();

	public ContextPropertyNotifications()
	{}

	public void preSave( Diagram caller )
	{
		ModelIterator.SINGLETON.ensureTagsAreModelled();
		Iterator todo = propsInDiagram( caller );
		while( todo.hasNext() )
			{
				Fig f = (Fig)(todo.next());
				MContextPropertyValue val = (MContextPropertyValue)(f.getOwner());
				val.preSave();
			}
	}

	public void postSave( Diagram caller )
	{
		ModelIterator.SINGLETON.ensureTagsAreNotModelled();
		Iterator todo = propsInDiagram( caller );
		while( todo.hasNext() )
			{
				Fig f = (Fig)(todo.next());
				MContextPropertyValue val = (MContextPropertyValue)(f.getOwner());
				val.postSave();
			}
	}

	public void postLoad( Diagram caller )
	{
		System.out.println("postLoad()");
		ModelIterator.SINGLETON.restoreSmuggledTags();
		Enumeration elems = caller.elements();

		while( elems.hasMoreElements() )
		 	{
				Object f = elems.nextElement();
				if( f instanceof FigContextProperty )
					if( ((FigContextProperty)f).getBadLoadedOwner() != null )
						{
							fixBadLoadedTaggedValue( ((FigContextProperty)f),
															 ((FigContextProperty)f).getBadLoadedOwner() );
							System.out.println("FOUND A BADLOADEDOWNER: " + ((FigContextProperty)f).getBadLoadedOwner());

						}
			}
	}

	protected void fixBadLoadedTaggedValue( FigContextProperty fig,
														 MTaggedValue taggedv )
	{
		MModelElement elem = taggedv.getModelElement();
		String content = taggedv.getValue();
		elem.removeTaggedValue( taggedv );

		// ali-todo: create MContextPropertyValue, initiate from content,
		// put into fig.
		MContextPropertyValue newprop = 
			EmbeddedContextPropertyValueDecoder.SINGLETON.decode( content );
		
		System.out.println("DECODED " + content + "    AND GOT " + newprop);
		System.out.println("DECODED " + content + "    AND GOT " + newprop.getClass());
		if( newprop != null )
			{ 
				fig.setOwner( newprop );
				fig.actualizeEntries();
			}
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
								res.add( f );
					}
			}

		return res.iterator();
	}

}
