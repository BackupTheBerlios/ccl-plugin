package org.cocons.uml.ccl.xml;


import java.util.Vector;
import java.util.Iterator;
import java.util.Collection;

import java.io.*;

import javax.swing.JOptionPane;

import org.cocons.uml.ccl.MContextbasedConstraint;
import org.cocons.uml.ccl.ccldata.*;
import org.exolab.castor.xml.*;
import org.apache.xml.serialize.XMLSerializer;
import org.apache.xml.serialize.OutputFormat;

import org.cocons.uml.ccl.util.Parser;



public class CoConXMLWriter
{

	public static CoConXMLWriter SINGLETON = new CoConXMLWriter();

	public CoConXMLWriter()
	{}



	public String singleCoConToString( CoCon cocon )
	{
		CoConList clist = new CoConList();
		clist.addCoCon( cocon );

		StringWriter sw = new StringWriter();
		performWriting( clist, sw );

		return sw.toString();
	}

	public CoConList manyCoConsToCoConList( Collection cocons )
	{
		CoConList clist = new CoConList();
		Iterator it = cocons.iterator();
		
		while( it.hasNext() )
			{
				Object o = it.next();
				if( o instanceof MContextbasedConstraint )
					clist.addCoCon( Parser.MCoCon2CoCon((MContextbasedConstraint)o) );
				//.getIMClassRepresentation() );
			}
		
		return clist;
	}

	public void manyCoConsToFile( Collection cocons,
											String file )
	{
		boolean okay = true;
		CoConList clist = manyCoConsToCoConList( cocons );
		FileWriter wr = null;

		try 
			{ wr = new FileWriter( file ); }
		catch( Exception e )
			{ okay = false; }

		if( okay )
			okay=performWriting( clist, wr );

		if( !okay )
			JOptionPane.
				showMessageDialog(null,
										"Save failed.",
										"Save",
										JOptionPane.ERROR_MESSAGE);
	}

	protected boolean performWriting( CoConList ccl,
												 Writer out )
	{
		try {
			Marshaller marshaller;

			try {
				Class.forName("org.apache.xml.serialize.XMLSerializer");
				OutputFormat format = new OutputFormat("xml","utf-8",true);
				XMLSerializer prettyPrinter = new XMLSerializer(out, format);
				marshaller = new Marshaller(prettyPrinter);
			}
			catch (ClassNotFoundException e) {
				marshaller = new Marshaller(out);
			}

			marshaller.setMarshalAsDocument( true );
			marshaller.marshal(ccl);
		}
		catch( Exception e )
			{
				System.err.println("Catched " + e);
				return false;
			}
		return true;
	}


}
